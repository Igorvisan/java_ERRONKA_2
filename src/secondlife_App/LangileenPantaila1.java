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

<<<<<<< HEAD
=======
    /**
     * Launch the application.
     */
>>>>>>> 8cd66031c3b216c543a722df0fc48f612bea4e35
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

<<<<<<< HEAD
=======
    /**
     * Create the frame.
     */
>>>>>>> 8cd66031c3b216c543a722df0fc48f612bea4e35
    public LangileenPantaila1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 697, 521);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
<<<<<<< HEAD

        setContentPane(contentPane);
        contentPane.setLayout(null);

        //   LO DE Extract Method
        addButton("AGREGAR EMPLEADO", 27, 27, 209, 79, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openWindow(new AgregarEmpleado());
            }
        });

        //   LO DE Extract Method
        addButton("Volver", 542, 436, 131, 38, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openWindow(new InicioSesion());
            }
        });

        //   LO DE Extract Method
        addButton("ELIMINAR EMPLEADO", 259, 27, 209, 79, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openWindow(new EliminarEmpleado());
            }
        });
    }

    // Método extraído
    private void addButton(String text, int x, int y, int width, int height, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setBounds(x, y, width, height);
        contentPane.add(button);
    }

    // Método extraído
    private void openWindow(JFrame newFrame) {
        newFrame.setVisible(true);
        dispose();
    }
}
=======
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
>>>>>>> 8cd66031c3b216c543a722df0fc48f612bea4e35
