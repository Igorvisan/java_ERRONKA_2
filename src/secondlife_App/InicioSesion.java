package secondlife_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
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
	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInicioSesion = new JLabel("INICIAR SESION");
		lblInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInicioSesion.setBounds(209, 112, 203, 53);
		contentPane.add(lblInicioSesion);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(193, 194, 235, 40);
		contentPane.add(txtUsuario);
		
		JButton btnIniciarSesion = new JButton("LOG IN");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LangileenPantaila langile = new LangileenPantaila();
				String usuario = txtUsuario.getText();
				@SuppressWarnings("deprecation")
				String contraseña = txtPassword.getText();
				Langileak.confirmarLangileArduraduna(usuario, contraseña);
				Langileak.confirmarAdmistrador(usuario, contraseña);
				Langileak.confirmarEmpleadoNormal(usuario, contraseña);
				
				if(Langileak.confirmarLangileArduraduna(usuario, contraseña)) {
					
					langile.setVisible(true);
					
					dispose();
					
				}
				
				else if(Langileak.confirmarLangileArduraduna(usuario, contraseña) == false) {
					JOptionPane.showMessageDialog(null, "Las creedenciales no son validas");
				}
				if(Langileak.confirmarAdmistrador(usuario, contraseña)) {
					
					langile.setVisible(true);
					
					dispose();
				}
				
				
			}
		});
		btnIniciarSesion.setBounds(237, 332, 156, 35);
		contentPane.add(btnIniciarSesion);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(193, 268, 235, 40);
		contentPane.add(txtPassword);
	}
}
