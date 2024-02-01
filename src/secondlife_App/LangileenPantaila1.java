package secondlife_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LangileenPantaila1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LangileenPantaila1 frame = new LangileenPantaila1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LangileenPantaila1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 697, 521);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Botón para agregar empleado
        JButton btnAgregarEmpleado = new JButton("AGREGAR EMPLEADO");
        btnAgregarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Extract Variable: Crear una instancia de AgregarEmpleado
                AgregarEmpleado newWorker = new AgregarEmpleado();
                // Extract Variable: Mostrar la ventana de AgregarEmpleado
                newWorker.setVisible(true);
                // Extract Variable: Cerrar la ventana actual
                dispose();
            }
        });
        btnAgregarEmpleado.setBounds(27, 27, 209, 79);
        btnAgregarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.add(btnAgregarEmpleado);

        // Botón para volver
        JButton btnGoBack = new JButton("Volver");
        btnGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Extract Variable: Crear una instancia de InicioSesion
                InicioSesion logIn = new InicioSesion();
                // Extract Variable: Mostrar la ventana de InicioSesion
                logIn.setVisible(true);
                // Extract Variable: Cerrar la ventana actual
                dispose();
            }
        });
        btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnGoBack.setBounds(542, 436, 131, 38);
        contentPane.add(btnGoBack);

        // Botón para eliminar empleado
        JButton btnBorrarEmpleado = new JButton("ELIMINAR EMPLEADO");
        btnBorrarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Extract Variable: Crear una instancia de EliminarEmpleado
                EliminarEmpleado deleteWorker = new EliminarEmpleado();
                // Extract Variable: Mostrar la ventana de EliminarEmpleado
                deleteWorker.setVisible(true);
                // Extract Variable: Cerrar la ventana actual
                dispose();
            }
        });
        btnBorrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBorrarEmpleado.setBounds(259, 27, 209, 79);
        contentPane.add(btnBorrarEmpleado);
    }
}