package com.example.musicapp.APP;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.musicapp.R;

import java.util.ArrayList;

public class conector extends AppCompatActivity {
    protected ArrayList<musica> arraymusica;

    protected Fragment[] menuFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        arraymusica = new ArrayList<musica>();
        Bundle bundle = new Bundle();
        bundle.putSerializable("arraymusica", arraymusica);

    }
}