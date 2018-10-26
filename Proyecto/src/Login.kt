import java.awt.Color
import java.awt.EventQueue
import java.awt.Label
import java.awt.Menu
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import javax.swing.*
import javax.swing.text.View
import java.awt.event.ActionListener
import com.sun.java.accessibility.util.AWTEventMonitor.addActionListener
import java.util.*
import com.sun.java.accessibility.util.AWTEventMonitor.addActionListener


class PantallaLogin(title: String) : JFrame() {


    //crea el frame
    public fun createUILogin(title: String) {


        val menu = PantallaMenu("Menu")

        setTitle(title)
        createMenu()


        //botton de ingreso
        val b = JButton("LOGIN")
        createLayout(b)
        b.setBounds(250, 300, 100, 40)
        b.isVisible = true


        val usuario = Label("USUARIO:")
        usuario.isVisible = true
        usuario.setBounds(200, 200, 70, 40)

        val contraseña = Label("CONTRASEÑA:")
        contraseña.isVisible = true
        contraseña.setBounds(170, 250, 90, 40)


        val ingreseUsuario = JTextPane()
        ingreseUsuario.background = Color.lightGray
        ingreseUsuario.isVisible = true
        ingreseUsuario.setBounds(270, 210, 180, 20)

        val ingreseContraseña = JTextPane()
        ingreseContraseña.background = Color.lightGray
        ingreseContraseña.isVisible = true
        ingreseContraseña.setBounds(270, 260, 180, 20)


        b.addActionListener {

            if (ingreseUsuario.getText() == "admin" && ingreseContraseña.getText() == "vini") {

                JOptionPane.showInternalMessageDialog(null, "BIENVENIDOS")

                menu.createUIMenu("Menú")
                this.dispose()

            } else if (ingreseUsuario.getText() == "" && ingreseContraseña.getText() == "") {

                JOptionPane.showInternalMessageDialog(null, "Error Datos vacios")

            } else {
                JOptionPane.showInternalMessageDialog(null, "Error Datos Incorrectos")

            }

        }



        isResizable = false
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 600)
        setLocationRelativeTo(null)
        add(b)
        add(usuario)
        add(contraseña)
        add(ingreseUsuario)
        add(ingreseContraseña)
        isVisible = true

    }


    //crear menu
    private fun createMenu() {

        val menuSalir = JMenuBar()

        val exit = JMenu("EXIT")
        exit.mnemonic = KeyEvent.VK_F

        //evento salir
        val deseaSalir = JMenuItem("¿Desea Salir?")
        deseaSalir.mnemonic = KeyEvent.VK_E
        deseaSalir.toolTipText = "Exit application"
        deseaSalir.addActionListener { _: ActionEvent -> System.exit(0) }

        exit.add(deseaSalir)
        menuSalir.add(exit)

        jMenuBar = menuSalir
    }


    //create botton
    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

    }
}

//funcion ejecucion del frame


private fun createLogin() {

    val framelogin = PantallaLogin("Moviles 2018-B")
    framelogin.isVisible = true
}

//funcion main
fun main(args: Array<String>) {
    val pantalla = PantallaLogin("Login")
    pantalla.createUILogin("Login")
}
