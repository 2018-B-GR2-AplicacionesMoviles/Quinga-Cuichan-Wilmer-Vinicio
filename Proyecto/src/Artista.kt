import java.awt.EventQueue
import java.awt.Label
import java.awt.Menu
import java.awt.ScrollPane
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import javax.swing.*
import javax.swing.JScrollPane
import javax.swing.JScrollBar
import javax.swing.JComboBox


class PantallaArtista(string: String) : JFrame() {

    init {
        createUIArtista("Menú")
    }

    public fun createUIArtista(title: String) {
        val menuM = PantallaMenu("Menú")

        createMenuArtista()
        setTitle(title)
        datosIniciales()


        val b = JButton("Menú")
        createLayout(b)
        b.setBounds(250, 400, 100, 40)
        b.isVisible = true
        b.addActionListener { menuM.createUIMenu("Menú") }
        b.addActionListener { this.dispose() }


        val titulo = Label("ARTISTAS")
        titulo.isVisible = true
        titulo.setBounds(250, 20, 70, 40)


        val nuevoArtista = Label("Nuevo Artista:")
        nuevoArtista.isVisible = true
        nuevoArtista.setBounds(25, 80, 80, 40)

        val ingresarArtista = JTextPane()
        ingresarArtista.isVisible = true
        ingresarArtista.setBounds(110, 90, 250, 25)


        val guardarArtista = JButton("Guardar")
        guardarArtista.isVisible = true
        guardarArtista.setBounds(400, 90, 90, 25)
        guardarArtista.addActionListener {
            BaseDeDatosArtista.agregarArtista(ingresarArtista.getText())
            println(BaseDeDatosArtista.ArtistaB)
            val comboBox = JComboBox(BaseDeDatosArtista.ArtistaB.toArray())

            comboBox.isVisible = true

        }


        val seleccionarArtista = Label("Seleccionar Artistas:")
        seleccionarArtista.isVisible = true
        seleccionarArtista.setBounds(25, 150, 114, 40)


        val comboBox = JComboBox(BaseDeDatosArtista.ArtistaB.toArray())
        comboBox.isVisible = true
        comboBox.setBounds(150, 150, 190, 30)


        val artistasFavoritos = Label("Artistas Favoritos:")
        artistasFavoritos.isVisible = true
        artistasFavoritos.setBounds(25, 240, 100, 40)


        val textAreaArtista = JTextArea()
        textAreaArtista.setText(BaseDeDatosArtista.ArtistaB.toString())
        textAreaArtista.isVisible = true
        textAreaArtista.setBounds(30, 280, 510, 100)
        textAreaArtista.isEditable = false


        isResizable = false
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(600, 600)
        setLocationRelativeTo(null)
        add(textAreaArtista)
        add(titulo)
        add(b)
        add(artistasFavoritos)
        add(nuevoArtista)
        add(ingresarArtista)
        add(guardarArtista)
        add(seleccionarArtista)
        add(comboBox)
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


class BaseDeDatosArtista {
    companion object {
        val ArtistaB: ArrayList<String> = ArrayList()
        fun agregarArtista(nombre: String) {
            ArtistaB.add(nombre)
        }
    }
}


fun datosIniciales() {

    // var fechaNacimiento = Date()
    BaseDeDatosArtista.agregarArtista("The Beatles")
    BaseDeDatosArtista.agregarArtista("Michael Jackson")
    BaseDeDatosArtista.agregarArtista("Queen")
    BaseDeDatosArtista.agregarArtista("John Lennon")
    BaseDeDatosArtista.agregarArtista("Elvis Presley")
    BaseDeDatosArtista.agregarArtista("Bob Marley")
    BaseDeDatosArtista.agregarArtista("The Rolling Stones")
    //BaseDeDatosArtista.agregarArtista("Guns n' Roses")
    //BaseDeDatosArtista.agregarArtista("Led Zeppelin")
    //BaseDeDatosArtista.agregarArtista("Jimi Hendrix")


}


fun main(args: Array<String>) {
    EventQueue.invokeLater(::createArtista)

    datosIniciales()

    println(BaseDeDatosArtista.ArtistaB) // []

}