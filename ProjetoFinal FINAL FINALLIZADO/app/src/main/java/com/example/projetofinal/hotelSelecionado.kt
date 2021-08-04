package com.example.projetofinal

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_hotel_selecionado.*
import android.Manifest
import android.media.MediaPlayer
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*

class hotelSelecionado : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_selecionado)

        var idHotel = intent.getStringExtra("idHotel")

        val btn =findViewById<Button>(R.id.btnAgendar)


        // API moeda
        val textView = findViewById<TextView>(R.id.text)
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://economia.awesomeapi.com.br/json/USD-BRL"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->

                    val gson = GsonBuilder().create()

                    val result = gson.fromJson(response.toString(),Array<Moeda>::class.java).toList()

                    //tvNomeMoeda.text = result.firstOrNull()?.name.toString()//Pega o nome do dolar
                    tvCotacaoMoeda.text = result.firstOrNull()?.high.toString()//Pega o valor do dolar

                },
                Response.ErrorListener { textView.text = "Ta funcionando não" } )

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

        // -------- FIM API MOEDA -------------------

        //SHAREDPREFERENCE

        val sharedPreference = sharedPreference(this)

        //SHAREDPREFERENCE


        //

        //INPUT SHAREDPREFERENCE
        //Apresenta os dados salvos no SharedPreference
        nomeUsuario.text = sharedPreference.getValueNome("nome")
        emailUsuario.text = sharedPreference.getValueEmail("email")
        telefoneUsuario.text = sharedPreference.getValueTelefone("telefone")


        //INPUT SHAREDPREFERENCE


        if(idHotel.toString() == "Espaço Bambu Eventos"){
            fotoHotel.setImageResource(R.drawable.bambu)
                nomeHotel.text = idHotel.toString()
                listaDiaria.text = "R$: 345,00"
                listaCritica.text ="4.5/5"
                listaTelefone.text = "(61) 99972-5595"
                endHotel.text = "SMLN MI 3 Conjunto 4 Casa 31 - Lago Norte, Brasília - DF"

                //site
                btn.setOnClickListener{
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://www.espacobambueventos.com.br/")).also { startActivity(it) }
                }
                //site


            } else if(idHotel.toString() == "Chalés Bela Vista"){
                fotoHotel.setImageResource(R.drawable.belavista)
                nomeHotel.text = idHotel.toString()
                listaDiaria.text = "R$: 120,00"
                listaCritica.text ="4.8/5"
                listaTelefone.text = "(62) 98293-8919"
                endHotel.text = "Rua Brasília Quadra A Lote 2, Pirenópolis - GO"

            //site
            btn.setOnClickListener{
                Intent(Intent.ACTION_VIEW, Uri.parse("https://chales-bela-vista-bed-and-breakfast.business.site/")).also { startActivity(it) }
            }
            //site

            } else if(idHotel.toString() == "Fazenda Bem Ecológico"){
                fotoHotel.setImageResource(R.drawable.bemecologico)
                nomeHotel.text = idHotel.toString()
                listaDiaria.text = "R$: 540,00"
                listaCritica.text ="5/5"
                listaTelefone.text = "(61) 99997-0314"
                endHotel.text = "DF 205 KM 44,5, Núcleo Rural Monjolo - Planaltina, Brasília - DF"

            //site
            btn.setOnClickListener{
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/FazendaBemEcologico")).also { startActivity(it) }
            }
            //site

            } else if(idHotel.toString() == "Condomínio Lake Side"){
                fotoHotel.setImageResource(R.drawable.lakeside)
                nomeHotel.text = idHotel.toString()
                listaDiaria.text = "R$: 198,00"
                listaCritica.text ="4.5/5"
                listaTelefone.text = "(61) 3251-5109"
                endHotel.text = "SHTN Trecho 1 Conjunto 2 - Asa Norte, Brasília - DF"

            //site
            btn.setOnClickListener{
                Intent(Intent.ACTION_VIEW, Uri.parse("https://lakeside.com.br/")).also { startActivity(it) }
            }
            //site

            } else if(idHotel.toString() == "Cullinan Hplus Premium"){
                fotoHotel.setImageResource(R.drawable.cullivan)
                nomeHotel.text = idHotel.toString()
                listaDiaria.text = "R$: 223,00"
                listaCritica.text ="4.6/5"
                listaTelefone.text = "(61) 3426-5000"
                endHotel.text = "SHN Q. 4 - Brasília, DF"

            //site
            btn.setOnClickListener{
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hplus.com.br/hoteis/cullinan-hplus-premium/")).also { startActivity(it) }
            }
            //site

            }

        btnRetornar.setOnClickListener{
            Intent(this, listaHoteis::class.java).also { startActivity(it) }
        }



    }

    //permissão

    private fun hasPermission (): Boolean{
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission(){

        var permission = mutableListOf<String>()

        if(!hasPermission()){

            permission.add(Manifest.permission.INTERNET)
        }

        if(permission.isNotEmpty()){
            ActivityCompat.requestPermissions(this, permission.toTypedArray(), 0)
        }
    }



    /*
    private fun checkForPermissions(permission: String, name: String, requestCode: Int){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            when{
                ContextCompat.checkSelfPermission(applicationContext, permission) == PackageManager.PERMISSION_GRANTED ->{
                    Toast.makeText(applicationContext, "$name permission granted", Toast.LENGTH_LONG).show()
                }
                shouldShowRequestPermissionRationale(permission) -> showDialog(permission, name, requestCode)
                else -> ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
            }

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        fun innerCheck(name: String){
            if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext, "fudeubahia", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(applicationContext, "não fudeubahia", Toast.LENGTH_SHORT).show()

            }
        }

        when (requestCode){
            INTERNET_RQ -> innerCheck( "location")
        }
    }

    private fun showDialog(permission: String, name: String, requestCode: Int){
        val builder = AlertDialog.Builder(this)

        builder.apply {
            setMessage("PERMISS~ÇAO NOEM SHAZAM")
            setTitle("TITULO PORRA")
            setPositiveButton("OK") {dialog, which ->
                ActivityCompat.requestPermissions(this@hotelSelecionado, arrayOf(permission), requestCode)
            }
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }


    */
}