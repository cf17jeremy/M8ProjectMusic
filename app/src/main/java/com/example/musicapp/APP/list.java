package com.example.musicapp.APP;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.musicapp.BDD.DBDCreation;
import com.example.musicapp.R;
import com.example.musicapp.RecyclerViewAdapter;


public class list extends Fragment {
    //Creacion instancia
    private DBDCreation DBCreation;

    public list() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DBCreation = new DBDCreation(getContext());
        // Inflate the layout for this fragment
        View listIncidencia = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = listIncidencia.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(listIncidencia.getContext()));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, DBCreation.LMusica());

        recyclerView.setAdapter(adapter);

        return listIncidencia;
    }
}