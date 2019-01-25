package com.example.viniq.disquera

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_artista.*
import kotlinx.android.synthetic.main.activity_disquera.*

class ArtistaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artista)


        button_guardarArtista.setOnClickListener {
            this.guardarArtista()
        }
    }


    fun guardarArtista() {
        val context = this
        val db = SqliteHelpe(context)

        if (Text_nombreArtista.text.toString().length > 0 && Text_nacionalidad.text.toString().length > 0 && Text_DisqueraArtista.text.toString().length > 0) {
            var respuestaArtista =
                RespuestaArtista(
                    Text_nombreArtista.text.toString(),
                    Text_nacionalidad.text.toString(),
                    Text_DisqueraArtista.text.toString()
                )

            db.insertarDatosArtista(respuestaArtista)
        } else {
            Toast.makeText(context, "Por favor llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }


}
