package com.example.viniq.examenpb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actualizar.*

class ActualizarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)


        val diqueraRecibida = intent.getParcelableExtra<Disquera>("Disquera")
        text_NombreDisqueraActualizar.setText(diqueraRecibida.nombreDisquera.toString())
        textNombreArtistaActualizar.setText(diqueraRecibida.nombreArtista.toString())
        textGeneroMusicaActualizar.setText(diqueraRecibida.generoMusica.toString())
        textNumeroDiscosActualizar.setText(diqueraRecibida.numeroTotalDiscos.toString())
        textPrecioDiscosActualizar.setText(diqueraRecibida.precioDiscos.toString())


        button_Borrar.setOnClickListener {
            this.borrar()

        }

        button_Actualizar.setOnClickListener {
            this.actualizar()

        }


    }

    fun borrar() {

        BDdisquera.eliminarDisquera(text_NombreDisqueraActualizar.text.toString())
        val intentMenu = Intent(this, MainActivity::class.java)
        startActivity(intentMenu)

    }

    fun actualizar() {

        val nombreDisquera = text_NombreDisqueraActualizar.text.toString()
        val nombreArtista = textNombreArtistaActualizar.text.toString()
        val generoMusica = textGeneroMusicaActualizar.text.toString()
        val numeroTotalDiscos = textNumeroDiscosActualizar.text.toString()
        val precioDiscos = textPrecioDiscosActualizar.text.toString()


        val disquera = Disquera(
                nombreDisquera = nombreDisquera,
                nombreArtista = nombreArtista,
                generoMusica = generoMusica,
                numeroTotalDiscos = numeroTotalDiscos,
                precioDiscos = precioDiscos)

        BDdisquera.actualizarDisquera(disquera)
        val intentMenu = Intent(this, MainActivity::class.java)
        startActivity(intentMenu)

    }
}
