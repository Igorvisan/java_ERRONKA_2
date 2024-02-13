package secondlife_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LangileenPantaila3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LangileenPantaila3 frame = new LangileenPantaila3();
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
	public LangileenPantaila3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoBack = new JButton("VOLVER");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion logIn = new InicioSesion();
				
				logIn.setVisible(true);
				
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack.setBounds(836, 576, 173, 44);
		contentPane.add(btnGoBack);
		
		JButton btnModificarEmpleado = new JButton("MODIFICAR EMPLEADO");
		btnModificarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProducto mProducto = new ModificarProducto();
				
				mProducto.setVisible(true);
				
				dispose();
			}
		});
		btnModificarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModificarEmpleado.setBounds(716, 262, 239, 79);
		contentPane.add(btnModificarEmpleado);
		
		JButton btnAgregarProducto = new JButton("AGREGAR PRODUCTO");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarProducto aProducto = new AgregarProducto();
				
				aProducto.setVisible(true);
				
				dispose();
			}
		});
		btnAgregarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAgregarProducto.setBounds(371, 262, 239, 79);
		contentPane.add(btnAgregarProducto);
		
		JButton btnEskaeraProcesatu = new JButton("ESKAERA PROCESATU");
		btnEskaeraProcesatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EskaerakProcesatu eProcesatu = new EskaerakProcesatu();
				
				eProcesatu.setVisible(true);
				
				dispose();
			}
		});
		btnEskaeraProcesatu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEskaeraProcesatu.setBounds(42, 262, 239, 79);
		contentPane.add(btnEskaeraProcesatu);
		
		JButton btnModificarProducto = new JButton("MODIFICAR PRODUCTO");
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProducto mProducto = new ModificarProducto();
				
				mProducto.setVisible(true);
				
				dispose();
			}
		});
		btnModificarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModificarProducto.setBounds(565, 387, 239, 79);
		contentPane.add(btnModificarProducto);
		
		JButton btnNewButton = new JButton("HORNITZAILEAK KENDU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProveedor e1 = new EliminarProveedor();
				
				e1.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(196, 387, 239, 79);
		contentPane.add(btnNewButton);
	}
}
