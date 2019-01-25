package com.example.viniq.disquera

class RespuestaDisquera {

    var idDisquera: Int = 0
    var nombreDisquera: String = ""
    var direccionDisquera: String = ""
    var telefonoDisquera: Int = 0


    constructor(nombreDisquera: String, direccionDisquera: String, telefonoDisquera: Int) {
        this.nombreDisquera = nombreDisquera
        this.direccionDisquera = direccionDisquera
        this.telefonoDisquera = telefonoDisquera
    }

    constructor() {


    }


}