import java.awt.Color
import java.awt.EventQueue
import java.awt.Menu
import java.awt.event.ActionEvent
import javax.swing.*

class Pantalla(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        val menu = Menu("jj")

        val b = JButton("LOGIN")
         createLayout(b)
        b.background = Color.lightGray
        b.setBounds(250, 400, 100, 40)
        b.isVisible = true
        b.addActionListener {JOptionPane.showInternalMessageDialog(null  , "Bienvenidos") }
        b.addActionListener { e: ActionEvent? ->menu.isEnabled  }

         isResizable = false
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 600)
        setLocationRelativeTo(null)
        add(b)
    }


       private fun createLayout(vararg arg: JComponent) {

           val gl = GroupLayout(contentPane)
           contentPane.layout = gl

       }
}

private fun createAndShowGUI() {

    val frame = Pantalla("Moviles 2018-B")
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}
