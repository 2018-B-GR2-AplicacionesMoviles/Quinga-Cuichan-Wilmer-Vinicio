import java.awt.Color
import java.awt.EventQueue
import java.awt.Menu
import java.awt.event.ActionEvent
import javax.swing.*

class PantallaMenu(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)




        isResizable = false
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 600)
        setLocationRelativeTo(null)
     }



}

private fun createAndShowGUIM() {

    val frame = PantallaMenu("Menu")
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUIM)
}
