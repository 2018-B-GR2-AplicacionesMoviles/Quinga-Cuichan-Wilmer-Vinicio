package com.example.viniq.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class FragmentosActivity : AppCompatActivity() {


    //inicializar el fragmento actual pero despues
    lateinit var fragmentoActual: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        //manager
        val fragmentManager = supportFragmentManager

        //transaccion
        val fragmentTransction = fragmentManager.beginTransaction()

        //crear instancia al fragmento
        val primerfragmento: PrimerFragment = PrimerFragment();
        var argumentos = Bundle()
        argumentos.putString("nombre", "Vinicio Quinga")
        argumentos.putInt("edad", 23)
        primerfragmento.arguments = argumentos


        //añadoir fragmento
        fragmentTransction.remove(fragmentoActual)
       // fragmentTransction.replace(R.id.fragment_primero, primerfragmento)
        fragmentoActual = primerfragmento

        //commit
        fragmentTransction.commit()

    }


}
