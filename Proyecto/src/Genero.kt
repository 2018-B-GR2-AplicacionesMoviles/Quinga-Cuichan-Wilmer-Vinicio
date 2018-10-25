import java.awt.EventQueue
import java.awt.event.KeyEvent
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem

class PantallaGenero(string: String) : JFrame() {


    public fun createUIGenero(title: String) {

        setTitle(title)
        createMenuGenero()
        isResizable = false
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 600)
        setLocationRelativeTo(null)
        isVisible = true

    }


    //crear menu
    public fun createMenuGenero() {

        var menu = PantallaMenu("Menu")

        val menuRegresar = JMenuBar()
        //val icon = ImageIcon("src/main/resources/exit.png")

        val exit = JMenu("Regresar")
        exit.mnemonic = KeyEvent.VK_F

        //evento salir
        val deseaSalir = JMenuItem("¿Desea Regresar al Menú?")
        deseaSalir.mnemonic = KeyEvent.VK_E
        deseaSalir.toolTipText = "Exit application"
        deseaSalir.addActionListener { menu.createUIMenu("Menu") }
        deseaSalir.addActionListener { this.dispose() }

        exit.add(deseaSalir)
        menuRegresar.add(exit)

        jMenuBar = menuRegresar
    }


}

private fun createGenero() {

    val frame = PantallaDisquera("Disquera")
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createGenero)
}