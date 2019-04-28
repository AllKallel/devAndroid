package br.com.appchamada;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SecurityPreferences {

    public static final String NULO = "Nulo";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    //CONSTRUTOR
    public SecurityPreferences(Context context){
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.editor = preferences.edit();
    }

    //GUARDA VALORES DE STRING
    public void guardaString(String key, String value){
        editor.putString(key, value).commit();
    }

    //RECUPERA VALORES DE STRING
    public String recuperaString(String chave){
        return preferences.getString(chave, NULO);
    }

    //GUARDA VALORES DE BOOLEAN
    public void guardaBoolean(String key, String value){
        editor.putString(key, value).commit();
    }

    //RECUPERA VALORES DE BOOLEAN
    public boolean recuperaBoolean(String key){
        return preferences.getBoolean(key, Boolean.FALSE);
    }

}

