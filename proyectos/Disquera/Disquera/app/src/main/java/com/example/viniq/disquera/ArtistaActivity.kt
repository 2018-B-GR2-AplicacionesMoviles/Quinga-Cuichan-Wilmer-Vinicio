package com.example.viniq.disquera

import android.content.Intent
import android.database.DatabaseErrorHandler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_artista.*

class ArtistaActivity : AppCompatActivity() {

    lateinit var opcion: Spinner
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artista)





        this.spinner()



        button_guardarArtista.setOnClickListener({
            this.guardarArtista()
        })

        button_buscaArtista.setOnClickListener({
            this.buscarArtista()
        })


    }




    fun spinner() {

        opcion = findViewById(R.id.spinner_DisqueraArtista) as Spinner
        resultado = findViewById(R.id.Text_DisqueraArtista) as TextView

        val options = arrayOf("Opcion", "O2")
        opcion.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        opcion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

                resultado.text = "Seleciona un Disquera"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                resultado.text = options.get(position)

            }


        }


    }


    fun guardarArtista() {
        val context = this
        val db = SqliteHelper(context)

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




    fun buscarArtista() {
        val context = this
        val db = SqliteHelper(context)
        var data = db.buscarArtista()
        tvResult.text = ""
        for (i in 0..(data.size - 1)) {
            tvResult.append(data.get(i).idArtista.toString() + " " + data.get(i).nombreArtista + " " + data.get(i).nacionalidadArtista + "\n")

        }
    }



}
