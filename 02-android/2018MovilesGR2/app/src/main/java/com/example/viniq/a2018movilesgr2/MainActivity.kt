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
    }

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


        this.startActivity(intentIrABotones)


    }
}
