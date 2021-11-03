package com.example.musicapp.BDD;

import android.provider.BaseColumns;

public class DBDeclaration {
    private DBDeclaration(){}
    public static class IncidenciaDBD implements BaseColumns {
        public static final String Nombre_Tabla ="Musica";
        public static final String ID = "id";
        public static final String Titulo = "Titulo";
        public static final String Artista = "Artista";
    }
}
