package com.example.musicapp.APP;

public class musica {
    protected String Titulo;
    protected String Artista;

    public musica(String Titulo, String Artista){
        this.Titulo = Titulo;
        this.Artista = Artista;
    }

    public String gettitulo(){
        return Titulo;
    }

    public String getartista(){
        return Artista;
    }

    public void setNom(String newtitulo){
        this.Titulo = newtitulo;
    }

    public void setArtista(String newartista){
        this.Artista = newartista;

    }
}
