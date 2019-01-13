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

        guardarIngreso.setOnClickListener {
            this.ingresarDatos()
        }
    }


    fun irPantallaPrincipal() {
        //intent
        //val imnutable no puede ser reasignada
        val intentIrPrincipal = Intent(this, MainActivity::class.java) //ButtonActivity nombre de la otra actividad
        this.startActivity(intentIrPrincipal)


    }


    fun ingresarDatos() {

        val nombreDisquera = editText2_nombreArtista.text.toString()
        val nombreArtista = editText2_nombreArtista.text.toString()
        val generoMusica = editText3_generoMusica.text.toString()
        val numeroTotalDiscos = editText4_numeroTotalDiscos.text.toString()
        val precioDiscos = editText5_precioDiscos.text.toString()

        val disquera = Disquera(
                nombreDisquera = nombreDisquera,
                nombreArtista = nombreArtista,
                generoMusica = generoMusica,
                numeroTotalDiscos = numeroTotalDiscos,
                precioDiscos = precioDiscos)

        val retorno = Intent(this, MainActivity::class.java)
        startActivity(retorno)
        BDdisquera.agregarDisquera(disquera)

    }

}
