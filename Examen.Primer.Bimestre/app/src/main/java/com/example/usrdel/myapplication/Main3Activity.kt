package com.example.usrdel.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        cancelar3.setOnClickListener {
            pantallaAtraz()
        }
    }


    fun pantallaAtraz() {
        // INTENT
        val intentRespuesta = Intent(this, Main2Activity  ::class.java)
        this.startActivity(intentRespuesta)
    }
}
