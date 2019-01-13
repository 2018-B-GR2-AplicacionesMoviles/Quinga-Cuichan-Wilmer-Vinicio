package com.example.viniq.examenpb

class BDdisquera {
    companion object {
        val lstDisquera: ArrayList<Disquera> = ArrayList()

        fun agregarDisquera(disquera: Disquera) {

            lstDisquera.add(disquera)//añadir a las diquera
        }


        fun mostrarDisquera(): ArrayList<Disquera> {
            return lstDisquera;
        }

        fun eliminarDisquera(nombre: String) {

            for (i in lstDisquera.indices) {

                if (lstDisquera[i].nombreDisquera.equals(nombre))
                    lstDisquera.removeAt(i)
            }

        }

        fun actualizarDisquera(disquera: Disquera) {
            lstDisquera.forEach {
                if (it.nombreDisquera.equals(disquera.nombreDisquera)) {
                    it.nombreDisquera = disquera.nombreDisquera
                    it.generoMusica = disquera.generoMusica
                    it.numeroTotalDiscos = disquera.numeroTotalDiscos
                    it.precioDiscos = disquera.precioDiscos
                }

            }
        }


    }


}