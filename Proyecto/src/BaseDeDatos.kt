import javax.swing.JOptionPane

class BaseDeDatosArtista {
    companion object {
        val ArtistaB: ArrayList<String> = ArrayList()
        fun agregarArtista(nombre: String) {
            ArtistaB.add(nombre)
        }
    }
}


fun datosInicialesArtista() {


  //  BaseDeDatosArtista.agregarArtista("The Beatles")

}

fun BuscarClase(nombre: String) {


    if(BaseDeDatosArtista.ArtistaB.contains(nombre))
    {
        JOptionPane.showInternalMessageDialog(null, "Artista Si Existe")


    }else
    {

        JOptionPane.showInternalMessageDialog(null, "Artista No Existe")


    }

}




fun BorrarClase(nombre: String) {


    if(BaseDeDatosArtista.ArtistaB.remove(nombre))
    {
        JOptionPane.showInternalMessageDialog(null, "Artista Borrado")


    }else
    {

        JOptionPane.showInternalMessageDialog(null, "Artista No existe")


    }

}

/*
if (Lista.contains("Azul")) {
    System.out.println("El color Azul Si está");
}else{
    System.err.println("El color Azul No está");
}*/