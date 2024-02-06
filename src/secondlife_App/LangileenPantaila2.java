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
        
        JButton btnGoBack = new JButton("CERRAR SESION");
        btnGoBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		InicioSesion logIn = new InicioSesion();
        		
        		logIn.setVisible(true);
        		
        		dispose();
        	}
        });
        btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnGoBack.setBounds(775, 648, 196, 46);
        contentPane.add(btnGoBack);
        
        JButton btnAgregarProducto = new JButton("AGREGAR PRODUCTO");
        btnAgregarProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AgregarProducto a1 = new AgregarProducto();
        		
        		a1.setVisible(true);
        		
        		dispose();
        	}
        });
        btnAgregarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAgregarProducto.setBounds(595, 230, 297, 106);
        contentPane.add(btnAgregarProducto);
        
        JButton btnModificarProducto = new JButton("MODIFICAR PRODUCTO");
        btnModificarProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ModificarProducto m1 = new ModificarProducto();
        		
        		m1.setVisible(true);
        		
        		dispose();
        	}
        });
        btnModificarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnModificarProducto.setBounds(357, 367, 297, 106);
        contentPane.add(btnModificarProducto);
    }

    // Método para realizar la acción del botón y mostrar un mensaje
    private void performButtonAction(String message) {
        JOptionPane.showMessageDialog(contentPane, message);
    }
}