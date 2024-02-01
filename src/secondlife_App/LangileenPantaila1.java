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

    public LangileenPantaila1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 697, 521);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
