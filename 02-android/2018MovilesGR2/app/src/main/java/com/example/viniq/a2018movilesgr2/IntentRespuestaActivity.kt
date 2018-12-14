package com.example.viniq.a2018movilesgr2

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_respuesta.*

class IntentRespuestaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_respuesta)

        button_enviar_intent_respuesta.setOnClickListener {
            this.enviarIntentRespuesta()
        }
    }


    fun enviarIntentRespuesta() {
        //enviar un intent con una nueva instancia
        //ACTION_PICK para seleccionar un intent tipo       el URI o el contacto
        //intent explicito

        //INTENT    con respuesta
        //intent que devuelva un resultado
        //la funcion q se ejeucta dentro de la actividad onActivityResult
        //llega requestCode resultCode data
        //  val intentRespuesta = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        val intentRespuesta = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)

        this.startActivityForResult(intentRespuesta, requestCodeContactos)
        //resultCode se envia

    }


    //2 parametros
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (resultCode) {

            requestCodeContactos -> {

                when (requestCode) {
                    Activity.RESULT_OK -> {
                        Log.e("contactos", "respuesta ${data}")

                        //capturar los datos
                        var cursor: Cursor? = null
                        try {
                            var numeroTelefono: String? = null
                            var nombre: String? = null
                            var tieneNumeroTelefono: String? = null
                            val url = data?.data

                            cursor = contentResolver.query(url, null, null, null, null)
                            cursor!!.moveToFirst() //mover

                            //definir los indices

                            val indiceTelefono = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                            val indiceNombre = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                            val indiceTieneNumeroTelefono = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER)


                            numeroTelefono = cursor!!.getString(indiceTelefono)
                            nombre = cursor!!.getString(indiceNombre)
                            tieneNumeroTelefono = cursor!!.getString(indiceTieneNumeroTelefono)
                            Log.i("contacto", "telefono: ${numeroTelefono}- nombre ${nombre}")
                            Log.i("contacto", "Tiene Numero de telefono: ${tieneNumeroTelefono} ")


                        } catch (e: Exception) {
                            Log.e("contactos", "error")

                        }

                    }
                    Activity.RESULT_CANCELED -> {
                        Log.e("contactos", "No se selecciono Contacto")
                    }
                }
            }
            else -> {
                Log.e("indefinido", "indefinido")
            }
        }

        /*Log.i("intent-respuesta", "${requestCode}$")
        Log.i("intent-respuesta", "${resultCode}$")
        Log.i("intent-respuesta", "${data}$")
*/

    }





    //companio object Base de datos
    //no importa la respuesta el companion object
    //siempre va ser siempre una unica instancia
    companion object {

        //
        val requestCodeContactos = 101
    }


}
