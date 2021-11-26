package com.example.musicapp.APP;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DBCreation = new DBDCreation(getContext());
        db = DBCreation.getWritableDatabase();

        // Inflate the layout for this fragment
        View form = inflater.inflate(R.layout.fragment_form, container, false);
        Button btnins = form.findViewById(R.id.btninsert);
        btnins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txttitulo = form.findViewById(R.id.titulo);
                EditText txtartista = form.findViewById(R.id.artista);
                String titulo = txttitulo.getText().toString();
                String artista = txtartista.getText().toString();

                Log.d("añadir",titulo + artista);

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
        Button btndelBDD = form.findViewById(R.id.btndeleteDB);
        btndelBDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

                // set title
                alertDialogBuilder.setTitle(getString(R.string.dialog_info));

                // set dialog message
                alertDialogBuilder.setMessage(getString(R.string.dialog_Advetencia));
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton(getString(R.string.dialog_aceptar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DBCreation.eliminar();
                        Toast toast = Toast.makeText((getActivity()).getApplicationContext(), getString(R.string.dialog_confirmacion), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                alertDialogBuilder.setNegativeButton(getString(R.string.dialog_cancelar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast toast = Toast.makeText((getActivity()).getApplicationContext(), getString(R.string.dialog_respuesta), Toast.LENGTH_SHORT);
                        toast.show();
                        dialog.cancel();
                    }
                });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
            }
        });

        // Inflate the layout for this fragment
        return form;
    }
}