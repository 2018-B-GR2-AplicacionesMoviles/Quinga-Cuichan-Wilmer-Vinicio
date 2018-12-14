package com.example.viniq.examenpb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ingresar.*

class IngresarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar)

        cancelarIngreso.setOnClickListener {
            this.irPantallaPrincipal()
        }
    }


    fun irPantallaPrincipal() {
        //intent
        //val imnutable no puede ser reasignada
        val intentIrPrincipal = Intent(this, MainActivity::class.java) //ButtonActivity nombre de la otra actividad
        this.startActivity(intentIrPrincipal)


    }

}
