package secondlife_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LangileenPantaila2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public LangileenPantaila2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProcesatu = new JButton("ESKAERAK PROCESATU");
		btnProcesatu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnProcesatu.setBounds(110, 309, 297, 106);
		contentPane.add(btnProcesatu);
		
		JButton btnAgregarProducto = new JButton("AGREGAR PRODUCTO");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarProducto addProduct = new AgregarProducto();
				
				addProduct.setVisible(true);
				
				dispose();
			}
		});
		btnAgregarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAgregarProducto.setBounds(560, 309, 297, 106);
		contentPane.add(btnAgregarProducto);
		
		JButton btnGoBack = new JButton("VOLVER");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InicioSesion inicio = new InicioSesion();
				
				inicio.setVisible(true);
				
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack.setBounds(775, 646, 196, 48);
		contentPane.add(btnGoBack);
	}
}
