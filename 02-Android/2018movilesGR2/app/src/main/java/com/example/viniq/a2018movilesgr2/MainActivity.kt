package com.example.viniq.a2018movilesgr2


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_ingresar.setOnClickListener {
                    /*
                    Log.i("navegacion","Hola")
                    Log.w("navegacion","Hola")
                    Log.d("navegacion","Hola")
                    Log.e("navegacion","Hola")
                    Log.v("navegacion","Hola")
                    */
                    this.irAPantallaDeBotones()
                }


    }

     fun irAPantallaDeBotones() {
        // INTENT
        val intentIrABotones = Intent(this, buttonActivity::class.java)
         intentIrABotones.putExtra("nombre", "Vinicio")
         intentIrABotones.putExtra("apellido", "Quinga")

         this.startActivity(intentIrABotones)
    }



}

