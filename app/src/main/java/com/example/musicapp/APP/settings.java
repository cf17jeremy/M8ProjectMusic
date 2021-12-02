package com.example.musicapp.APP;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicapp.BDD.DBDCreation;
import com.example.musicapp.R;

import java.util.ArrayList;
import java.util.Locale;


public class settings extends Fragment {
    private saveprefecence savpref;
    private DBDCreation dbCreation;
    private SQLiteDatabase db;
    private static Locale loc;

    public settings() {
        // Required empty public constructor
    }

    public void reseteo() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        // set title
        alertDialogBuilder.setTitle(getString(R.string.dialog_info));

        // set dialog message
        alertDialogBuilder
                .setMessage(getString(R.string.dialog_Advetencia2))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.dialog_aceptar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        savpref.reset();
                        System.exit(2);
                    }
                })
                .setNegativeButton(getString(R.string.dialog_cancelar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getContext(), getString(R.string.dialog_respuesta),
                                Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }

    public void changeLocale(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        loc = new Locale(lang);//Set Selected Locale
        savelangDetails(lang);//Save the selected locale
        Locale.setDefault(loc);//set new locale as default
        Configuration config = new Configuration();//get Configuration
        config.locale = loc;//set config locale as selected locale
        getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());//Update the config
    }

    private void savelangDetails(String lang) {
        new saveprefecence(getContext()).savidet(lang);
    }

    public void refresh (){
        onCreateView(null,null,null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View settings = inflater.inflate(R.layout.fragment_settings, container, false);

        /*Spinner con errores en desarrollo
        Spinner idioma = config.findViewById(R.id.spinner);
        String[] idiomas = getResources().getStringArray(R.array.idiomas);
        // Initializing an ArrayAdapter
        final ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(getContext(),android.R.layout.simple_spinner_item,idiomas){
            @Override
            public boolean isEnabled(int p){
                if(p == 0){
                    //hacemos que el primer item no sea seleccionable
                    return false;
                }
                else{
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView i = (TextView) view;
                if(position == 0){
                    i.setTextColor(Color.GRAY);
                }
                else {
                    i.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        idioma.setAdapter(adapter);

        //Spinner
        idioma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString() == idiomas[1]){
                    changeLocale("es");
                    refresh();
                } else if (parent.getItemAtPosition(position) == idiomas[2]){
                    changeLocale("en");
                    refresh();
                } else if (parent.getItemAtPosition(position) == idiomas[3]) {
                    changeLocale("cat");
                    refresh();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });*/

        //shared prefrerences
        savpref = new saveprefecence(getContext());

        //Creation of the dbHelper
        dbCreation = new DBDCreation(getContext());
        db = dbCreation.getWritableDatabase();

        //Button delete save preferences
        final Button btndelsavpref = settings.findViewById(R.id.btnsavpref);
        btndelsavpref.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reseteo();
            }
        });

        //Buttons Languages
        final Button btnesp = settings.findViewById(R.id.btnesp);
        btnesp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeLocale("es");
                refresh();
            }
        });
        final Button btneng = settings.findViewById(R.id.btneng);
        btneng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeLocale("en");
                refresh();
            }
        });
        final Button btncat = settings.findViewById(R.id.btncat);
        btncat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeLocale("cat");
                refresh();
            }
        });
        return settings;
    }
}