package com.example.viniq.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cuarta_pantalla.*

class CuartaPantalla : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuarta_pantalla)

        botonCuartaPantalla.setOnClickListener {
            this.irOtraPantalla()

        }
    }

    fun irOtraPantalla() {

        val intentOtraPantalla = Intent(this, TerceraPantalla::class.java) //ButtonActivity nombre de la otra actividad
        this.startActivity(intentOtraPantalla)
    }
}
