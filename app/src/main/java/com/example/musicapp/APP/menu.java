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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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

                case R.id.nav_settings:
                    selectedFragment = new settings();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        });
    }
}