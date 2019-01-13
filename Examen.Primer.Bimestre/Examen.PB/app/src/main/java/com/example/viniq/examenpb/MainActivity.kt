package com.example.viniq.examenpb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ingresar.setOnClickListener {
            this.irPantallaIngresar()

        }

        button_consultar.setOnClickListener {
            this.irPantallaConsultar()
        }


    }

    fun irPantallaConsultar(){
        //intent
        //val imnutable no puede ser reasignada
        val intentIrConsultar = Intent(this, ConsultarActivity::class.java) //ButtonActivity nombre de la otra actividad
        this.startActivity(intentIrConsultar)


    }



    fun irPantallaIngresar() {
        //intent
        //val imnutable no puede ser reasignada
        val intentIrIngresar = Intent(this, IngresarActivity::class.java) //ButtonActivity nombre de la otra actividad
        this.startActivity(intentIrIngresar)


    }
}