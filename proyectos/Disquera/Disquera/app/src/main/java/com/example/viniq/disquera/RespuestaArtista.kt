package com.example.viniq.disquera

class RespuestaArtista {

    var nombreArtista: String = ""
    var nacionalidadArtista: String = ""
    var idArtista: Int = 0
    var disqueraArtista: String = ""




    constructor(nombreArtista: String, nacionalidadArtista: String, disqueraArtista: String) {
        this.nombreArtista = nombreArtista
        this.nacionalidadArtista = nacionalidadArtista
        this.disqueraArtista = disqueraArtista
    }

    constructor() {

    }


}
