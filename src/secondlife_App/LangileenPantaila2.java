package secondlife_App;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// Interfaz para acciones de botones
interface ButtonAction {
    void performAction();
}

public class LangileenPantaila2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        // Método principal para iniciar la aplicación
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LangileenPantaila2 frame = new LangileenPantaila2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor de la clase
    public LangileenPantaila2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 995, 741);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Botón 2
        JButton btnAgregarProducto = new JButton("AGREGAR PRODUCTO");
        btnAgregarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAgregarProducto.setBounds(586, 230, 297, 106);
        btnAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón 2
                performButtonAction("Botón 2 presionado");
                
                AgregarProducto addProduct = new AgregarProducto();
                
                addProduct.setVisible(true);
                
                dispose();
            }
        });
        contentPane.add(btnAgregarProducto);

        // Botón 3
        JButton btnGoBack = new JButton("VOLVER");
        btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnGoBack.setBounds(775, 646, 196, 48);
        btnGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón 3
                performButtonAction("Botón 3 presionado");
                                                
                InicioSesion logIn = new InicioSesion();
                
                logIn.setVisible(true);
                
                dispose();
            }
        });
        contentPane.add(btnGoBack);

        // Botón 4
        JButton btnModificatu = new JButton("PRODUKTUAK MODIFICATU");
        btnModificatu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnModificatu.setBounds(357, 377, 297, 106);
        btnModificatu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón 4
                performButtonAction("Botón 4 presionado");
                
                ModificarProducto modifyProduct = new ModificarProducto();
                
                modifyProduct.setVisible(true);
                
                dispose();
                
            }
        });
        contentPane.add(btnModificatu);
        
        JButton btnEskaerakProcesatu = new JButton("ESKAERAK PROCESATU");
        btnEskaerakProcesatu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EskaerakProcesatu eskaerak1 = new EskaerakProcesatu();
        		
        		eskaerak1.setVisible(true);
        		
        		dispose();
        		
        	}
        });
        btnEskaerakProcesatu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnEskaerakProcesatu.setBounds(131, 230, 297, 106);
        contentPane.add(btnEskaerakProcesatu);
    }

    // Método para realizar la acción del botón y mostrar un mensaje
    private void performButtonAction(String message) {
        JOptionPane.showMessageDialog(contentPane, message);
    }
}