package com.example.musicapp.APP;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.musicapp.BDD.DBDCreation;
import com.example.musicapp.R;


public class form extends Fragment {
    //Creacion instancia
    private DBDCreation DBCreation;
    private SQLiteDatabase db;

    public form() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DBCreation = new DBDCreation(getContext());
        db = DBCreation.getWritableDatabase();

        // Inflate the layout for this fragment
        final View form = inflater.inflate(R.layout.fragment_form, container, false);
        final Button btnins = form.findViewById(R.id.btninsert);
        btnins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText txttitulo = form.findViewById(R.id.titulo);
                EditText txtartista = form.findViewById(R.id.artista);
                String titulo = txttitulo.getText().toString();
                String artista = txtartista.getText().toString();

                if(titulo.length() == 0 || artista.length() == 0){
                    Toast toast = Toast.makeText(getActivity(),getResources().getString(R.string.toast_voidins),Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    musica musica = new musica(titulo, artista);
                    DBDCreation.insertMusica(db, musica);
                    Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.toast_correctadd), Toast.LENGTH_SHORT);
                    toast.show();
                    txttitulo.setText("");
                    txtartista.setText("");
                }
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false);
    }
}