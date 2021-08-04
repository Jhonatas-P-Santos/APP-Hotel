package com.example.projetofinal

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //NOTIFICATION//

    //late init Notification Manager
    lateinit var notificationManager: NotificationManager
    //late initi no canal
    lateinit var notificationChannel: NotificationChannel
    //Configurar notificação
    lateinit var builder: Notification.Builder
    //identificar a notificação
    private val channelID = "projetofinal"
    //descrever o canal
    private val desc= "Notifications"


    //NOTIFICATION//


    //MUSICPLAYER

    private var mediaPlayer: MediaPlayer? =null

    //MUSICPLAYER




    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //SHAREDPREFERENCE

            val sharedPreference = sharedPreference(this)


        //SHAREDPREFERENCE



        //NOTIFICATION//

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val btn =findViewById<Button>(R.id.btnEnviar)

        val intent = Intent(this, listaHoteis::class.java)



        //NOTIFICATION//



        //MUSICPLAYER
        //tocar musiquinha
        mediaPlayer = MediaPlayer.create(this,R.raw.hotel)
        //music player começar/pausar/parar
        fabPlay.setOnClickListener{
            mediaPlayer?.start()
        }

        //pausar musiquinha

        fabPause.setOnClickListener{
            mediaPlayer?.pause()
        }

       /* fabPause.setOnClickListener{
            mediaPlayer?.stop()
        }*/
        //music player começar/pausar/parar
        //MUSICPLAYER


        //PEGAR STRINGS DA PASTA
        val ola:String = getString(R.string.notOla)
        val bemvindo:String = getString(R.string.notBemvindo)

        val erroNome:String = getString(R.string.erroNome)
        val erroFone:String = getString(R.string.erroFone)
        val erroEmail:String = getString(R.string.erroEmail)



         




        //botão principal
        btn.setOnClickListener {
            //função de validar
            fun validar(): Boolean {
                if (getNome.text.toString().isEmpty()) {
                    getNome.error = erroNome
                    return false
                } else if (getTelefone.text.toString().isEmpty()) {
                    getTelefone.error = erroFone
                    return false
                } else if (getEmail.text.toString().isEmpty()) {
                    getEmail.error = erroEmail
                    return false
                }
                return true
            }


            if (validar()) {
                btn.setOnClickListener {
            //Executa o método e salva o nome.
                     var nome = findViewById(R.id.getNome) as EditText
            sharedPreference.saveNome("nome", nome.text.toString())

                    //Executa o método e salva o email.
            var email = findViewById(R.id.getEmail) as EditText
            sharedPreference.saveEmail("email", email.text.toString())

                    //Executa o método e salva o telefone.
            var telefone = findViewById(R.id.getTelefone) as EditText
            sharedPreference.saveTelefone("telefone", telefone.text.toString())

                //função de notificação
                    val pendingIntent =
                        PendingIntent.getActivity(
                            this,
                            0,
                            intent,
                            PendingIntent.FLAG_CANCEL_CURRENT
                        )

                    notificationChannel =
                        NotificationChannel(channelID, desc, NotificationManager.IMPORTANCE_HIGH)

                    notificationChannel.lightColor = Color.GRAY
                    notificationChannel.enableVibration(false)
                    notificationManager.createNotificationChannel(notificationChannel)

                    builder = Notification.Builder(this)
                        .setContentTitle(ola)
                        .setContentText(bemvindo)
                        .setSmallIcon(R.drawable.ic_reloginhonot)
                        .setChannelId(channelID)
                        .setContentIntent(pendingIntent)

                    notificationManager.notify(1234, builder.build())

                    //intent proxima pagina
                    Intent(this, listaHoteis::class.java).also { startActivity(it) }
                }

            }
        }

        
    }


}