package com.example.musicapp.APP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.musicapp.APP.form;
import com.example.musicapp.APP.home;
import com.example.musicapp.APP.list;
import com.example.musicapp.BDD.DBDCreation;
import com.example.musicapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class menu extends AppCompatActivity {
    //Creacion de la instancia
    private DBDCreation DBCreation;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.main_menu);

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new home();
                    break;

                case R.id.nav_llistat:
                    selectedFragment = new list();
                    break;

                case R.id.nav_formulari:
                    selectedFragment = new form();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        });
    }

    /*public void confirmacion() {
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
    }*/
}