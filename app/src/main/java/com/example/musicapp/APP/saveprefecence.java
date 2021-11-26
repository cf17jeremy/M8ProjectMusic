package com.example.musicapp.APP;

import android.content.Context;
import android.content.SharedPreferences;

public class saveprefecence {
    Context context;

    public saveprefecence(Context context) {
        this.context = context;
    }

    public void saveLoginDetails(String user, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("User", user);
        editor.putString("Password", password);
        editor.commit();
    }
    public void savidet(String idioma) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("IDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("idioma", idioma);
        editor.commit();
    }
    public String getidioma() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("IDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("idioma", "");
    }

    public boolean noidioma() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("IDetails", Context.MODE_PRIVATE);
        boolean langnull = sharedPreferences.getString("idioma", "").isEmpty();
        return langnull;
    }
    public String getUser() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("User", "");
    }
    public String getPass() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Password", "");
    }

    public boolean isUserLogedOut() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        boolean isUserEmpty = sharedPreferences.getString("User", "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("Password", "").isEmpty();
        return isUserEmpty || isPasswordEmpty;
    }
    public void reset() {
        SharedPreferences login = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences lang = context.getSharedPreferences("IDetails", Context.MODE_PRIVATE);
        login.edit().clear().commit();
        lang.edit().clear().commit();
    }
}
