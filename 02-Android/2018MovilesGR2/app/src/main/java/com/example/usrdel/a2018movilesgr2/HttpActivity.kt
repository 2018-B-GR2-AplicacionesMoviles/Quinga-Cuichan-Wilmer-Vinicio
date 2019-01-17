package com.example.usrdel.a2018movilesgr2


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import java.util.*

class HttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        val url = "http://172.29.55.149:1337/MateriaEstudiante"

        val parametros = listOf("nombre" to "Vinicio", "apellido" to "Quinga", "altura" to 12, "fechaNaciento" to Date().time


        )

        url.httpPost(parametros).responseString { request, response, result ->

            when (result) {
                is Result.Failure -> {
                    val exepcion = result.getException()
                    Log.i("http", "Error: ${exepcion}")

                }
                is Result.Success -> {
                    val data = result.get()
                    Log.i("http", "Datos: ${data}")
                }
            }
        }


    }
}

class UsuarioHttp(val nombre: String, var apellido: String) {


}