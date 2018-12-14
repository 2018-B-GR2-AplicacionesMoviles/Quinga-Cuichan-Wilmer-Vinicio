

package com.example.viniq.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_segunda_pantalla.*

class SegundaPantalla : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pantalla)


        botonSegundaPantalla.setOnClickListener{

            this.irOtraPantalla()

        }
    }

    fun irOtraPantalla() {

        val intentOtraPantalla = Intent(this, CuartaPantalla::class.java) //ButtonActivity nombre de la otra actividad

        //intentOtraPantalla.putExtra("nombre", nombre.text)
        //intentOtraPantalla.putExtra("apellido",apellido.text) //datos explicito 2 parametros


        this.startActivity(intentOtraPantalla)
    }
}
