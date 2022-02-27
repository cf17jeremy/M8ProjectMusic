package com.example.musicapp.APP;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.musicapp.BDD.DBDCreation;
import com.example.musicapp.R;
import com.example.musicapp.RecyclerViewAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class list extends Fragment {
    //Creacion instancia
    //private DBDCreation DBCreation;
    private DatabaseReference dbfire;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<musica> mMusica = new ArrayList<>();

    public list() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //DBCreation = new DBDCreation(getContext());
        dbfire = FirebaseDatabase.getInstance().getReference();
        getMusicas();
        // Inflate the layout for this fragment
        View listIncidencia = inflater.inflate(R.layout.fragment_list, container, false);

        mRecyclerView = listIncidencia.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, DBCreation.LMusica());
        return listIncidencia;
    }

    private void getMusicas(){
        dbfire.child("Cancion").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){

                    mMusica.clear();

                    for(DataSnapshot ds : snapshot.getChildren()){
                        String Titulo = ds.child("Titulo").getValue().toString();
                        String Artista = ds.child("Artista").getValue().toString();
                        mMusica.add(new musica(Titulo,Artista));
                    }
                    mAdapter = new RecyclerViewAdapter(R.layout.item_list, mMusica);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}