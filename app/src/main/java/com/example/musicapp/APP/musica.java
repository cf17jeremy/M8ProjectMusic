package com.example.musicapp.APP;

public class musica {
    protected String titulo;
    protected String artista;

    public musica(String titulo, String artista){
        this.titulo = titulo;
        this.artista = artista;
    }

    public String gettitulo(){
        return titulo;
    }

    public String getartista(){
        return artista;
    }

    public void setNom(String newtitulo){
        this.titulo = newtitulo;
    }

    public void setPrioritat(String newartista){
        this.artista = newartista;

    }
}
