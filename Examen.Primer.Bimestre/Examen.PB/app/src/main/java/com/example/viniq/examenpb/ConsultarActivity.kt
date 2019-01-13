package com.example.viniq.examenpb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_consultar.*

class ConsultarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        val adapter = ArrayAdapter<Disquera>(
                this,android.R.layout.simple_list_item_1,
                BDdisquera.mostrarDisquera()
        )

        lstView.adapter = adapter;
        lstView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val disqueraSeleccionada = parent.getItemAtPosition(position) as Disquera
            val intentDisqueraSeleccionada = Intent(this, ActualizarActivity::class.java)
            intentDisqueraSeleccionada.putExtra("Disquera", disqueraSeleccionada)
            startActivity(intentDisqueraSeleccionada)
        }

    }


}
