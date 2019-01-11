package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    lateinit var fragmentoActual: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)


        //lo importante
        fragmentoActual = PrimerFragment()


        crearFragmentoUno() //crear el fragmento uno
        //  primer boton
        button_crear_primer_fragmento
                .setOnClickListener {
                    crearFragmentoUno()
                }

        //segundo boton

        button_crear_segundo_fragmento
                .setOnClickListener {
                    crearFragmentoDos()
                }


    }




    fun crearFragmentoUno() {

        destruirFragmentoActual()

        // Manager
        val fragmentManager = supportFragmentManager

        // Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Crear instancia de fragmento
        val primerFragmento = PrimerFragment()

        val argumentos = Bundle()

        argumentos.putString("nombre", "Vinicio  Quinga")
        argumentos.putInt("edad", 24)

        primerFragmento.arguments = argumentos
        // Anadir fragmento

        fragmentTransaction.replace(R.id.relative_layout_fragmentos, primerFragmento)

        fragmentoActual = primerFragmento

        // Commit
        fragmentTransaction.commit()
    }




    fun crearFragmentoDos() {
        destruirFragmentoActual()
        // Manager
        val fragmentManager = supportFragmentManager
        // Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        // Crear instancia de fragmento
        val segundoFragmento = SegundoFragment()
        val argumentos = Bundle()
        segundoFragmento.arguments = argumentos
        // Anadir fragmento
        fragmentTransaction.replace(R.id.relative_layout_fragmentos, segundoFragmento)
        fragmentoActual = segundoFragmento
        // Commit
        fragmentTransaction.commit()
    }





    //destruir el fragmento actual
    fun destruirFragmentoActual() {
        val fragmentManager = supportFragmentManager
        // Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragmentoActual)
        fragmentTransaction.commit()
    }


}
