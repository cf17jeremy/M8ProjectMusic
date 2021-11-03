package com.example.musicapp.BDD;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.musicapp.APP.musica;

import java.util.ArrayList;

import static com.example.musicapp.BDD.DBDeclaration.IncidenciaDBD.Artista;
import static com.example.musicapp.BDD.DBDeclaration.IncidenciaDBD.Titulo;
import static com.example.musicapp.BDD.DBDeclaration.IncidenciaDBD.Nombre_Tabla;
import static com.example.musicapp.BDD.DBDeclaration.IncidenciaDBD.ID;

public class DBDCreation extends SQLiteOpenHelper {
    public static final int DBD_Version = 1;
    public static final String DBD_Nom = "musica.db";

    private static final String Creacion_Entradas_SQL = "CREATE TABLE " + Nombre_Tabla + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Titulo + " TEXT," + Artista + " TEXT)";


    public DBDCreation(Context context) {
        super(context, DBD_Nom, null, DBD_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Creacion_Entradas_SQL);
        Log.d("Jertox ANOUNCE","Database created!!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static void insertMusica(SQLiteDatabase db, musica i){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(Titulo, i.gettitulo());
            values.put(Artista, i.getartista());

            db.insert(Nombre_Tabla, null, values);
        }else{
            Log.d("sql","BDD cerrada");
        }
    }

    public ArrayList<musica> LMusica(){
        String sql = "select * from " + Nombre_Tabla;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<musica> inc = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                String titulo = cursor.getString(1);
                String artista = cursor.getString(2);
                inc.add(new musica(titulo, artista));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return inc;
    }
    //delete all
    public void eliminar(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(Nombre_Tabla,null,null);
        //db.execSQL("delete from "+ TABLE_NAME);
        db.close();
    }

    //delete an specific item
    public void delinc(int incid){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("DELETE FROM "+Nombre_Tabla+" WHERE id="+incid);
        db.close();
    }
}