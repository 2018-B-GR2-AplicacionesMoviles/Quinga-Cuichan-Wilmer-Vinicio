package com.example.viniq.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cuarta_pantalla.*
import kotlinx.android.synthetic.main.activity_pantalla_principal.*

class PantallaPrincipal : AppCompatActivity() {

    var nombre: String = ""
    var apellido: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        botonPantallaPrincipal.setOnClickListener {

            this.irOtraPantalla()
        }
       // capturarDatosDelIntent()


    }



    fun capturarDatosDelIntent() {
       // this.nombre = intent.getStringExtra("nombre")
        //this.apellido = intent.getStringExtra("apellido")

        //se insatancia textView desde activity_button-xmk
      //  recibeDatos.text = "${nombre} ${apellido}"
        //recibe los datos desde otra pantalla
    }

    fun irOtraPantalla() {

        val intentOtraPantalla = Intent(this, SegundaPantalla::class.java) //ButtonActivity nombre de la otra actividad
        this.startActivity(intentOtraPantalla)
    }
}
