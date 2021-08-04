package com.example.projetofinal

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class meuAdap(private val context: Activity,
              private val name:Array<String>,
              private val imagemId:Array<Int>,
              private val diaria: Array<String>,
              private val critica: Array<String>,
             ):
    ArrayAdapter<String>(context,R.layout.activity_custom_list,name)  {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        //return super.getView(position, convertView, parent)
        val inflar = context.layoutInflater
        val view = inflar.inflate(R.layout.activity_custom_list, null, true)

        val nomeHotel : TextView = view.findViewById(R.id.listaNome)
        val imageView : ImageView =  view.findViewById(R.id.listaImagem)
        val diariaHotel : TextView = view.findViewById(R.id.listaDiaria)
        val criticaHotel : TextView = view.findViewById(R.id.listaCritica)

        nomeHotel.text = name[position]
        diariaHotel.text = diaria[position]
        criticaHotel.text = critica[position]
        imageView.setImageResource(imagemId[position])

        return view;

    }
}