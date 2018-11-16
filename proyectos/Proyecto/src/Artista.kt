import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import javax.swing.*
import javax.swing.JScrollPane
import javax.swing.JScrollBar
import javax.swing.JComboBox


class PantallaArtista(string: String) : JFrame() {

   // init {
     //   createUIArtista("Menú")
    //}

    public fun createUIArtista(title: String) {
        val menuM = PantallaMenu("Menú")


        createMenuArtista()
        setTitle(title)
        datosInicialesArtista()


        val b = JButton("Menú")
        createLayout(b)
        b.setBounds(250, 450, 100, 40)
        b.isVisible = true
        b.addActionListener { menuM.createUIMenu("Menú") }
        b.addActionListener { this.dispose() }


        val panel = JTextArea(BaseDeDatosArtista.ArtistaB.toString())
        //panel.updateUI()
        panel.isVisible = true
        panel.setBounds(25, 360, 500, 80)


        val titulo = Label("ARTISTAS")
        titulo.isVisible = true
        titulo.setBounds(250, 20, 70, 40)


        val nuevoArtista = Label("Nuevo Artista:")
        nuevoArtista.isVisible = true
        nuevoArtista.setBounds(25, 80, 80, 40)

        val ingresarArtista = JTextPane()
        ingresarArtista.isVisible = true
        ingresarArtista.setBounds(150, 90, 190, 25)



//GUARDAR DATOS
        val guardarArtista = JButton("Guardar")
        guardarArtista.isVisible = true
        guardarArtista.setBounds(400, 90, 90, 25)
        guardarArtista.addActionListener {
            BaseDeDatosArtista.agregarArtista(ingresarArtista.getText())
            println(BaseDeDatosArtista.ArtistaB)
           // panel.update(graphics);

        }




        val refrescar = JButton("Actualizar")
        refrescar.isVisible = true
        refrescar.setBounds(400, 150, 100, 25)
        refrescar.addActionListener {


            val comboBox = JComboBox(BaseDeDatosArtista.ArtistaB.toArray())

            comboBox.isVisible = true
            comboBox.setBounds(150, 150, 190, 30)
            add(comboBox)
        }


        val seleccionarArtista = Label("Seleccionar Artistas:")
        seleccionarArtista.isVisible = true
        seleccionarArtista.setBounds(25, 150, 114, 40)


        val buscarArtistaL = Label("Buscar Artista:")
        buscarArtistaL.isVisible = true
        buscarArtistaL.setBounds(25, 240, 100, 40)

        val buscarArtista = JTextPane()
        buscarArtista.isVisible = true
        buscarArtista.setBounds(150, 250, 190, 25)



//BUSCAR
        val buscarArtistaB = JButton("Buscar")
        buscarArtistaB.isVisible = true
        buscarArtistaB.setBounds(400, 250, 100, 25)
        buscarArtistaB.addActionListener {
            BuscarClase(buscarArtista.getText())

        }


        val eliminarArtista = Label("Eliminar Artista:")
        eliminarArtista.isVisible = true
        eliminarArtista.setBounds(25, 310, 100, 40)


        val eliminarArtistaJT = JTextPane()
        eliminarArtistaJT.isVisible = true
        eliminarArtistaJT.setBounds(150, 310, 190, 25)



        //ELIMINAR

        val eliminarArtistaB = JButton("Eliminar")
        eliminarArtistaB.isVisible = true
        eliminarArtistaB.setBounds(400, 310, 100, 25)
        eliminarArtistaB.addActionListener {
            BorrarClase(eliminarArtistaJT.getText())
            println(BaseDeDatosArtista.ArtistaB)


        }




        isResizable = false
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(600, 600)
        setLocationRelativeTo(null)
        add(titulo)
        add(b)
        add(buscarArtistaL)
        add(nuevoArtista)
        add(ingresarArtista)
        add(guardarArtista)
        add(seleccionarArtista)
        add(refrescar)
        add(buscarArtista)
        add(buscarArtistaB)
        add(eliminarArtista)
        add(eliminarArtistaJT)
        add(eliminarArtistaB)
        add(panel)

        isVisible = true


    }

    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

    }


    //crear menu
    public fun createMenuArtista() {

        var menu = PantallaMenu("Menu")
        val menuRegresar = JMenuBar()
        val exit = JMenu("Salir")
        exit.mnemonic = KeyEvent.VK_F

        //evento salir
        val deseaSalir = JMenuItem("¿Desea Salir ?")
        deseaSalir.mnemonic = KeyEvent.VK_E
        deseaSalir.toolTipText = "Exit application"
        deseaSalir.addActionListener { _: ActionEvent -> System.exit(0) }
        deseaSalir.addActionListener { JOptionPane.showInternalMessageDialog(null, "Gracias Por Su Visita") }
        exit.add(deseaSalir)
        menuRegresar.add(exit)
        jMenuBar = menuRegresar
    }

}


private fun createArtista() {

    val frame = PantallaArtista("Disquera")
    frame.isVisible = true
}


fun main(args: Array<String>) {
    EventQueue.invokeLater(::createArtista)

    datosInicialesArtista()

}