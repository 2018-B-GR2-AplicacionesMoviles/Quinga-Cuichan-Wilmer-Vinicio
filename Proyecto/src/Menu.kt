import java.awt.EventQueue
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import javax.swing.*


class PantallaMenu(title: String) : JFrame() {


    public fun createUIMenu(title: String) {

        createMenuBar()
        setTitle(title)


        isResizable = false
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 600)
        setLocationRelativeTo(null)
        isVisible = true

    }


    //crear menu
    fun createMenuBar() {
        var disqueraP = PantallaDisquera("Disquera")
        var artistaP = PantallaArtista("Artista")
        var tipocancionP = PantallaTipoCancion("Tipo Canción")
        var generoP = PantallaGenero("Genero")


        val menuPrincipal = JMenuBar() //variable JMenuBar

        //crear opciones del menu
        val cancionM = JMenu("CANCION")
        val artista = JMenuItem("Artistas")
       // val tipoCancion = JMenuItem("Tipo Canción")
        //val diquera = JMenuItem("Disquera")
        ///val genero = JMenuItem("Genero")
        cancionM.add(artista)
        //evento para ingresar a otra pantalla
        artista.addActionListener { artistaP.createUIArtista("Artista") }
        artista.addActionListener { this.dispose() }




       /* cancionM.add(tipoCancion)
        tipoCancion.addActionListener { tipocancionP.createUITipoCancion("Tipo Canción") }
        tipoCancion.addActionListener { this.dispose() }

        cancionM.add(diquera)
        diquera.addActionListener { disqueraP.createUIDisquera("Disquera") }
        diquera.addActionListener { this.dispose() }

        cancionM.add(genero)
        genero.addActionListener{generoP.createUIGenero("Genero")}
        genero.addActionListener { this.dispose() }*/

        menuPrincipal.add(cancionM) //agregar


        //----------------------

    /*    val usuariosM = JMenu("USUARIOS")
        val a = JMenuItem("A ")
        val b = JMenuItem("B")

        usuariosM.add(a)
        usuariosM.add(b)
        menuPrincipal.add(usuariosM)
*/
        //----------------------

        val salir = JMenu("SALIR")
        val deseaSalir = JMenuItem("¿Desea Salir? ")
        //evento para salir de la pantalla
        deseaSalir.mnemonic = KeyEvent.VK_E
        deseaSalir.toolTipText = "Exit application"
        deseaSalir.addActionListener { _: ActionEvent -> System.exit(0) }
        deseaSalir.addActionListener{ JOptionPane.showInternalMessageDialog(null, "Gracias Por Su Visita")}

        salir.add(deseaSalir)
        menuPrincipal.add(salir)


        jMenuBar = menuPrincipal


    }


}

private fun createMenu() {

    val frameMenu = PantallaMenu("Menu")
    frameMenu.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createMenu)
}
