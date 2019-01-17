package com.example.viniq.disquera

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


val DATABASE_NAME = "disquera"


val TABLE_NAMEDISQUERA = "disqueraTabla"
val COLUMNA_NOMBREDISQUERA = "nombreDisquera"
val COLUMNA_DIRRECCIONDISQUERA = "direccionDisquera"
val COLUMNA_TELEFONODISQUERA = "telefonoDisquera"
val ID_DISQUERA = "idDisquera"


val TABLE_NAMEARTISTA = "artista"
val COLUMNA_NOMBREARTISTA = "nombreArtista"
val COLUMNA_NACIONALIDADARTISTA = "nacionalidadArtista"
val COLUMNA_DISQUERAARTISTA = "disqueraArtista"
val ID_ARTISTA = "idArtista"





class SqliteHelpe(val context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {

        ///TABLA DISQUERA
        val createTablaDisquera = "CREATE TABLE " + TABLE_NAMEDISQUERA + "(" +
                ID_DISQUERA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMNA_NOMBREDISQUERA + " VARCHAR(256)," +
                COLUMNA_DIRRECCIONDISQUERA + " VARCHAR(256)," +
                COLUMNA_TELEFONODISQUERA + " INTEGER)"


        ///TABLAR ARTISTA
        val createTablaArtista = "CREATE TABLE " + TABLE_NAMEARTISTA + "(" +
                ID_ARTISTA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMNA_NOMBREARTISTA + " VARCHAR(256)," +
                COLUMNA_NACIONALIDADARTISTA + "VARCHAR(256)," +
                COLUMNA_DISQUERAARTISTA + "VARCHAR(256))"

        db?.execSQL(createTablaDisquera)
        db?.execSQL(createTablaArtista)



    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {




    }


    //insertar datos en la base Sqlite
    fun insertarDatosDisquera(respuestaDisquera: RespuestaDisquera) {

        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMNA_NOMBREDISQUERA, respuestaDisquera.nombreDisquera)
        cv.put(COLUMNA_DIRRECCIONDISQUERA, respuestaDisquera.direccionDisquera)
        cv.put(COLUMNA_TELEFONODISQUERA, respuestaDisquera.telefonoDisquera)

        val resultadoDisquera = db.insert(
            TABLE_NAMEDISQUERA,
            null,
            cv
        )

        if (resultadoDisquera == -1.toLong()) {
            Toast.makeText(context, "Error Datos no Guardados", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(context, "Datos Guardados Correctamente", Toast.LENGTH_SHORT).show()

        }
    }


    fun buscarDisquera(): MutableList<RespuestaDisquera> {
        var disqueraLista: MutableList<RespuestaDisquera> = ArrayList()

        val db = this.readableDatabase
        val queryDisquera = "Select * from " + TABLE_NAMEDISQUERA
        val resultadoDisquera = db.rawQuery(queryDisquera, null)

        if (resultadoDisquera.moveToFirst()) {
            do {
                var respuestaDisquera = RespuestaDisquera()

                respuestaDisquera.idDisquera = resultadoDisquera.getString(
                    resultadoDisquera.getColumnIndex(ID_DISQUERA)
                ).toInt()

                respuestaDisquera.nombreDisquera = resultadoDisquera.getString(
                    resultadoDisquera.getColumnIndex(COLUMNA_NOMBREDISQUERA)
                )

                respuestaDisquera.direccionDisquera = resultadoDisquera.getString(
                    resultadoDisquera.getColumnIndex(COLUMNA_DIRRECCIONDISQUERA)
                )

                respuestaDisquera.telefonoDisquera =
                        resultadoDisquera.getString(resultadoDisquera.getColumnIndex(COLUMNA_TELEFONODISQUERA)).toInt()

                disqueraLista.add(respuestaDisquera)

            } while (resultadoDisquera.moveToNext())
        }

        resultadoDisquera.close()
        db.close()
        return disqueraLista
    }





    //insertar datos en la base Sqlite
    fun insertarDatosArtista(respuestaArtista: RespuestaArtista) {

        val db = this.writableDatabase
        var cv = ContentValues()

        cv.put(COLUMNA_NOMBREARTISTA, respuestaArtista.nombreArtista)
        cv.put(COLUMNA_NACIONALIDADARTISTA, respuestaArtista.nacionalidadArtista)
        cv.put(COLUMNA_DISQUERAARTISTA, respuestaArtista.disqueraArtista)

        var resultadoArtista = db.insert(
            TABLE_NAMEARTISTA,
            null,
            cv
        )


        if (resultadoArtista == -1.toLong()) {
            Toast.makeText(context, "Error Datos no Guardados", Toast.LENGTH_SHORT).show()


        } else {
            Toast.makeText(context, "Datos Guardados Correctamente", Toast.LENGTH_SHORT).show()

        }
    }









}