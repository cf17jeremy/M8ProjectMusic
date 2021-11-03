package com.example.musicapp.APP;

public class login {
    private String usuari = "admin";
    private String contrasenya = "admin";

    public void setuser(String usuari) {
        this.usuari = usuari;
    }

    public String getuser() {
        return usuari;
    }

    public void setpasswd(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getpasswd() {
        return contrasenya;
    }
}
