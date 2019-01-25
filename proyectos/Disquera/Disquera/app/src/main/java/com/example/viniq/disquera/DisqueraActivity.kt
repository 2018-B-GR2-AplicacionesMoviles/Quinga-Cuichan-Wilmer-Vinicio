package com.example.viniq.disquera

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_artista.*
import kotlinx.android.synthetic.main.activity_disquera.*

class DisqueraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disquera)

        button_guardarDisqera.setOnClickListener {
            this.guardarDisquera()
        }


    }


    fun guardarDisquera() {
        val context = this
        val db = SqliteHelper(context)

        if (Text_nombreDisquera.text.toString().length > 0 && Text_direccionDisquera.text.toString().length > 0 && Text_TelefonoDisquera.text.toString().length > 0) {
            var respuestaDisquera =
                RespuestaDisquera(
                    Text_nombreDisquera.text.toString(),
                    Text_direccionDisquera.text.toString(),
                    Text_TelefonoDisquera.text.toString().toInt()
                )

            db.insertarDatosDisquera(respuestaDisquera)
        } else {
            Toast.makeText(context, "Por favor llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }


}





