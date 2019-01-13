package com.example.usrdel.a2018movilesgr2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

//contexto es el this de cada lugar
class SqliteHelper(context: Context?) :
        SQLiteOpenHelper(context,
                "moviles", // Nombre de la base de datos
                null,
                1) {


    //recive la base de datos
    override fun onCreate(baseDeDatos: SQLiteDatabase?) {

        //se crea la tabla
        val crearTablaUsuario = "CREATE TABLE " +
                "usuario " +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre VARCHAR(50)," +
                "descripcion VARCHAR(50)" +
                ")"
        Log.i("bdd", "Creando la tabla de usuario \n$crearTablaUsuario")
        baseDeDatos?.execSQL(crearTablaUsuario) //tabla usuario
    }


    //recive la version antigua y la nueva version
    override fun onUpgrade(baseDeDatos: SQLiteDatabase?,
                           antiguaVersion: Int,
                           nuevaVersion: Int) {

    }

    //las 4 operaciones de una aplicacion

//lo primero que se hace es ver si existe el usuario


    fun existeUsuarioFormulario(): RespuestaUsuarioGuardado {

        val statement = "select * from usuario where id=1;" //buscar al usuario

        val dbReadable = readableDatabase //se lee la base de datos

        val resultado = dbReadable.rawQuery(statement, null)

            //RespuestaUsuarioGuardado otra clase
        val respuestaUsuario = RespuestaUsuarioGuardado(null, null)

        if (resultado.moveToFirst()) {
            do {
                respuestaUsuario.nombre = resultado.getString(1)//recupera los datos guarda los datos
                respuestaUsuario.descripcion = resultado.getString(2) //recupera los datos
            } while (resultado.moveToNext())
        }

        resultado.close()

        dbReadable.close()

        return respuestaUsuario //devulve la respuesta del usuario
    }



    //funcion para crear el usuario, recive los 2 datos
    fun crearUsuarioFormulario(nombre: String,
                               descripcion: String): Boolean {
        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()

        // Valores de los campos
        cv.put("nombre", nombre)
        cv.put("descripcion", descripcion)

        val resultado: Long = dbWriteable
                .insert(
                        "usuario", // Nombre de la tabla
                        null,
                        cv)

        dbWriteable.close()

        return if (resultado.toInt() == -1) false else true

    }

    fun actualizarUsuarioFormulario(nombre: String,
                                    descripcion: String): Boolean {
        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()

        // Valores de los campos

        cv.put("nombre", nombre)
        cv.put("descripcion", descripcion)

        val resultado = dbWriteable
                .update(
                        "usuario", // Nombre de la tabla
                        cv, // Valores a actualizarse
                        "id=?", // Where
                        arrayOf("1") // Parametros
                )

        dbWriteable.close()

        return if (resultado.toInt() == -1) false else true

    }

    fun eliminarUsuarioFormulario(): Boolean {
        val dbWriteable = writableDatabase //base de datos de escritura

        val nombreTabla = "usuario"//nombre de la tabla
        val clausulaWhere = "id = ?"//identificador se iguala
        val parametros = arrayOf("1")//el id del usuario
        val respuesta = dbWriteable.delete( //borrar un usario
                nombreTabla,
                clausulaWhere,
                parametros
        )
        return if (respuesta == -1) false else true //respuesta -1 nop pudo eliminar un usuario
    }


}






