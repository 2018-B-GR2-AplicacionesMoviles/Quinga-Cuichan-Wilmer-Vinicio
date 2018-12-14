package com.example.viniq.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //evento para ir a otra pantalla
        boton_ingreso.setOnClickListener {
            this.irAPantallaBotones() //se llama al metodo

        }

        //boton para ir a otra pantalla
        Boton_intent_respuesta.setOnClickListener {
            this.irPantallaIntentRespuesta()

        }
    }
//intent para abrir actividades dentreo de mi aplicacion
    //para abrir actividades desntro de otra aplicacion


    //metodo para ir a otra pantalla

    fun irAPantallaBotones() {
        //intent
        //val imnutable no puede ser reasignada
        val intentIrABotones = Intent(this, ButtonActivity::class.java) //ButtonActivity nombre de la otra actividad
        //metodo para enviar string a otra pagina,
        //intent para abrir actividad dentro de mi aplicacion y otras aplicaciones
        //serealizar y desarializar los datos, parcelabel
        //cuando no sea un dato comun parcelabel.
        //parcelabel se puede enviar entre actividades
        intentIrABotones.putExtra("nombre", "Vinicio")
        intentIrABotones.putExtra("apellido", "Quinga") //datos explicito 2 parametros

//intent explicito nombre de la clase q se abra  enviar datos
        this.startActivity(intentIrABotones)
    }


    //ir a otra pantalla
    fun irPantallaIntentRespuesta() {
        //contexto y la clase se envia
        //intent explicito
        val intentRespuesta = Intent(this, IntentRespuestaActivity::class.java) //ButtonActivity nombre de la otra actividad
        this.startActivity(intentRespuesta)
    }

    fun irPantallaCicloVida() {
        //contexto y la clase se envia
        //intent explicito
        val intentRespuesta = Intent(this, CicloVidaActivity::class.java) //ButtonActivity nombre de la otra actividad
        this.startActivity(intentRespuesta)
    }

}
