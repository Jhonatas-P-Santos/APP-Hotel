package com.example.projetofinal

import android.content.Context
import android.content.SharedPreferences

class sharedPreference (context: Context) {

    private val PREFERENCE_NAME = "BANCO"
    val shared_preference: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME,
            Context.MODE_PRIVATE)

    //Método responsável por salvar o nome digitado.

    fun saveNome(key_nome:String,valor:String){
        val editor: SharedPreferences.Editor = shared_preference.edit()
        editor.putString(key_nome,valor)
        editor.commit()
    }

    //Método responsável pra buscar o nome salvo.
    fun getValueNome(key_nome: String):String?{
        return shared_preference.getString(key_nome,null)
    }

    //Método responsável por salvar o email digitado.

    fun saveEmail(key_email:String,valor:String){
        val editor: SharedPreferences.Editor = shared_preference.edit()
        editor.putString(key_email,valor)
        editor.commit()
    }

    //Método responsável pra buscar o email salvo.

    fun getValueEmail(key_email: String):String?{
        return shared_preference.getString(key_email,null)
    }

    //Método responsável por salvar o telefone digitado.
    fun saveTelefone(key_telefone:String,valor:String){
        val editor:SharedPreferences.Editor = shared_preference.edit()
        editor.putString(key_telefone,valor)
        editor.commit()
    }
    //Método responsável pra buscar o telefone salvo.
    fun getValueTelefone(key_telefone: String):String?{
        return shared_preference.getString(key_telefone,null)
    }

}

