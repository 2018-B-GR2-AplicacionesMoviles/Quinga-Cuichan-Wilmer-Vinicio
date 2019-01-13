package com.example.usrdel.a2018movilesgr2


//base de datos se crea la varianle BDD

class BaseDeDatosServicio {
    companion object {
         var BDD: SqliteHelper = SqliteHelper(null)
    }
}