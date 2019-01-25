package com.example.viniq.disquera

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import kotlin.math.log


val DATABASE_NAME = "disquera"


val TABLE_NAME = "artista"
val COLUMNA_NOMBRE = "nombreArtista"
val COLUMNA_NACIONALIDAD = "nacionalidadArtista"
val COLUMNA_DISQUERA = "disqueraArtista"
val ID_ARTISTA = "idArtista"


val TABLE_NAMEDISQUERA = "disqueraTabla"
val COLUMNA_NOMBREDISQUERA = "nombreDisquera"
val COLUMNA_DIRRECCIONDISQUERA = "direccionDisquera"
val COLUMNA_TELEFONODISQUERA = "telefonoDisquera"
val ID_DISQUERA = "idDisquera"


class SqliteHelper(val context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    3
) {

    override fun onCreate(db: SQLiteDatabase?) {


        ///TABLAR ARTISTA
        val createTablaArtista = "CREATE TABLE " + TABLE_NAME + "(" +
                ID_ARTISTA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMNA_NOMBRE + " VARCHAR(256)," +
                COLUMNA_NACIONALIDAD + "VARCHAR(256)," +
                COLUMNA_DISQUERA + "VARCHAR(256))"
        db?.execSQL(createTablaArtista)


        ///TABLA DISQUERA
        val createTablaDisquera = "CREATE TABLE " + TABLE_NAMEDISQUERA + "(" +
                ID_DISQUERA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMNA_NOMBREDISQUERA + " VARCHAR(256)," +
                COLUMNA_DIRRECCIONDISQUERA + "VARCHAR(256)," +
                COLUMNA_TELEFONODISQUERA + "INTEGER)"
        db?.execSQL(createTablaDisquera)


    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {



    }


    //insertar datos en la base Sqlite
    fun insertarDatosArtista(respuestaArtista: RespuestaArtista) {

        val db = this.writableDatabase
        var cv = ContentValues()

        cv.put(COLUMNA_NOMBRE, respuestaArtista.nombreArtista)
        cv.put(COLUMNA_NACIONALIDAD, respuestaArtista.nacionalidadArtista)
        cv.put(COLUMNA_DISQUERA, respuestaArtista.disqueraArtista)

        var resultadoArtista = db.insert(
            TABLE_NAME,
            null,
            cv
        )


        if (resultadoArtista == -1.toLong()) {
            Toast.makeText(context, "Error Datos no Guardados", Toast.LENGTH_SHORT).show()


        } else {
            Toast.makeText(context, "Datos Guardados Correctamente", Toast.LENGTH_SHORT).show()

        }
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


    fun buscarArtista(): MutableList<RespuestaArtista> {
        var artistaLista: MutableList<RespuestaArtista> = ArrayList()

        val db = this.readableDatabase
        val queryArtista = "Select * from " + TABLE_NAME
        val resultadoArti = db.rawQuery(queryArtista, null)

        if (resultadoArti.moveToFirst()) {
            do {
                var respuestaArtista = RespuestaArtista()

                respuestaArtista.idArtista = resultadoArti.getString(
                    resultadoArti.getColumnIndex(ID_ARTISTA)
                ).toInt()

                respuestaArtista.nombreArtista = resultadoArti.getString(
                    resultadoArti.getColumnIndex(COLUMNA_NOMBRE)
                )

                respuestaArtista.nacionalidadArtista = resultadoArti.getString(
                    resultadoArti.getColumnIndex(COLUMNA_NACIONALIDAD)
                )

                respuestaArtista.disqueraArtista =
                        resultadoArti.getString(resultadoArti.getColumnIndex(COLUMNA_DISQUERA))

                artistaLista.add(respuestaArtista)

            } while (resultadoArti.moveToNext())
        }

        resultadoArti.close()
        db.close()
        return artistaLista
    }
}