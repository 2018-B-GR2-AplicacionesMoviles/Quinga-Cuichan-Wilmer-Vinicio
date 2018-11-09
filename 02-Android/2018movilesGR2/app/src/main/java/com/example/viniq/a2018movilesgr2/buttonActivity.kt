package com.example.viniq.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_button.*

class buttonActivity : AppCompatActivity() {


    var nombre: String = ""
    var apellido: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        this.capturarDatosDelIntent()
        acti_nombre_apellido.text = "${nombre} ${apellido}"


        button_enviar_Correo.setOnClickListener{
            enviarIntentCorreo()

        }


    }

    fun capturarDatosDelIntent() {

        this.nombre = intent.getStringExtra("nombre")
        this.apellido = intent.getStringExtra("apellido")

    }


    fun enviarIntentCorreo() {
        val correo = textCorreo.text
        val subject = textsubject.text
        val texto = textTexto.text

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/html"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(correo,"vi_@h.com") )
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, texto)

        startActivity(intent)


    }

}
