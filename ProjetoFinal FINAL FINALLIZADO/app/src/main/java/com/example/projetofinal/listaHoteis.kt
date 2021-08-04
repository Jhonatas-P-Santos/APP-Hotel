package com.example.projetofinal

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_custom_list.*
import kotlinx.android.synthetic.main.activity_hotel_selecionado.*
import kotlinx.android.synthetic.main.activity_lista_hoteis.*
import kotlinx.android.synthetic.main.activity_main.*

class listaHoteis : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_hoteis)



        //carregar imagens no array
        val imageId = arrayOf(
            R.drawable.bambu,
            R.drawable.belavista,
            R.drawable.bemecologico,
            R.drawable.lakeside,
            R.drawable.cullivan
        )

        //carregar nome dos hoteis no array
        val nome = arrayOf(
            "Espaço Bambu Eventos",
            "Chalés Bela Vista",
            "Fazenda Bem Ecológico",
            "Condomínio Lake Side",
            "Cullinan Hplus Premium"
        )

        //carregar o valor da diaria dos hoteis no array
        val diaria = arrayOf(
            "R$: 345,00",
            "R$: 120,00",
            "R$: 540,00",
            "R$: 198,00",
            "R$: 223,00"
        )

        //carregar a avaliação dos hoteis no array
        val critica = arrayOf(
            "4.5/5",
            "4.8/5",
            "5/5",
            "4.5/5",
            "4.6/5"
        )


        val adapter = meuAdap(this, nome, imageId, diaria, critica)
        list_view_hoteis.adapter = adapter




        btnRetorno.setOnClickListener{
            Intent(this, MainActivity::class.java).also { startActivity(it) }
        }




        list_view_hoteis.onItemClickListener =
            AdapterView.OnItemClickListener() { parent, view, position, id ->

                var itemClicado = parent.getItemAtPosition(position)



                if (itemClicado.toString() == "Espaço Bambu Eventos") {
                    Intent(this, hotelSelecionado::class.java)
                        .putExtra("idHotel", itemClicado.toString())
                        .also { startActivity(it) }

                } else if (itemClicado.toString() == "Chalés Bela Vista") {
                    Intent(this, hotelSelecionado::class.java)
                        .putExtra("idHotel", itemClicado.toString())
                        .also { startActivity(it) }

                } else if (itemClicado.toString() == "Fazenda Bem Ecológico") {
                    Intent(this, hotelSelecionado::class.java)
                        .putExtra("idHotel", itemClicado.toString())
                        .also { startActivity(it) }
                } else if (itemClicado.toString() == "Condomínio Lake Side") {
                    Intent(this, hotelSelecionado::class.java)
                        .putExtra("idHotel", itemClicado.toString())
                        .also { startActivity(it) }
                } else if (itemClicado.toString() == "Cullinan Hplus Premium") {
                    Intent(this, hotelSelecionado::class.java)
                        .putExtra("idHotel", itemClicado.toString())
                        .also { startActivity(it) }

                }


            }
    }
}