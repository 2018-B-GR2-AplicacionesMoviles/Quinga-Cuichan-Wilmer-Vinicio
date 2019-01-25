package com.example.viniq.disquera

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_Artista.setOnClickListener {
            this.irVentanaArtista()
        }

        button_disquera.setOnClickListener {
            this.irVentanaDisquera()
        }

        button_Cancion.setOnClickListener {
            this.irVentanaCancion()
        }





    }

    fun irVentanaArtista() {
        val intentArtista = Intent(this, ArtistaActivity::class.java)
        startActivity(intentArtista)

    }


    fun irVentanaDisquera() {
        val intentDisquera = Intent(this, DisqueraActivity::class.java)
        startActivity(intentDisquera)

    }


    fun irVentanaCancion() {
        val intentCancion = Intent(this, CancionActivity::class.java)
        startActivity(intentCancion)

    }


}
