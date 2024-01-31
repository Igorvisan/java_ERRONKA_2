package secondlife_App;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class AgregarEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNan;
	private JTextField txtAbizena;
	private JTextField txtIzena;
	private JTextField txtEmaila;
	private JTextField txtJaiotzeData;
	private JTable tableLangileak;
	private JTextField txtTelefonoa;
	private Connection connectionDB;
	private JTextField txtPasswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEmpleado frame = new AgregarEmpleado();
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
	public AgregarEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNan = new JTextField();
		txtNan.setBounds(51, 88, 134, 19);
		contentPane.add(txtNan);
		txtNan.setColumns(10);
		
		txtAbizena = new JTextField();
		txtAbizena.setColumns(10);
		txtAbizena.setBounds(51, 168, 134, 19);
		contentPane.add(txtAbizena);
		
		txtIzena = new JTextField();
		txtIzena.setColumns(10);
		txtIzena.setBounds(51, 129, 134, 19);
		contentPane.add(txtIzena);
		
		txtEmaila = new JTextField();
		txtEmaila.setColumns(10);
		txtEmaila.setBounds(51, 216, 134, 19);
		contentPane.add(txtEmaila);
		
		txtJaiotzeData = new JTextField();
		txtJaiotzeData.setColumns(10);
		txtJaiotzeData.setBounds(51, 257, 134, 19);
		contentPane.add(txtJaiotzeData);
		
		JButton btnGoBack = new JButton("Volver");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LangileenPantaila1 langile = new LangileenPantaila1();
				
				langile.setVisible(true);
				
				dispose();
				
			}
		});
		btnGoBack.setBounds(561, 426, 116, 39);
		contentPane.add(btnGoBack);
		
		JCheckBox chckbxLangileNormala = new JCheckBox("Langile Normala?");
		chckbxLangileNormala.setBounds(51, 468, 121, 21);
		contentPane.add(chckbxLangileNormala);
		
		JCheckBox chckbxLangileArduraduna = new JCheckBox("Langile Aruraduna?");
		chckbxLangileArduraduna.setBounds(51, 404, 134, 21);
		chckbxLangileArduraduna.isSelected();
		contentPane.add(chckbxLangileArduraduna);
		
		JCheckBox chckbxAdministratzailea = new JCheckBox("Administratzailea?");
		chckbxAdministratzailea.setBounds(51, 437, 134, 21);
		contentPane.add(chckbxAdministratzailea);
		
		JButton btnShowTable = new JButton("Display Data");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ConnectionDB connectionDB = new ConnectionDB();	
				Connection conexion = connectionDB.obtenerConexion();
				
				String orden = "SELECT * FROM second_life.langileak";
				
				DefaultTableModel model =new DefaultTableModel();
				
				model.addColumn("Id_Langilea");
				model.addColumn("NAN");
				model.addColumn("Izena");
				model.addColumn("Abizena");
				model.addColumn("Korreoa");
				model.addColumn("Jaiotze data");
				model.addColumn("Telofono Zenbakia");
				model.addColumn("Langile arduraduna");
				model.addColumn("Administratzailea");
				model.addColumn("langile_normala");
				model.addColumn("password");

				
				tableLangileak.setModel(model);
				String[] array = new String[11];
				
				try {
					
					PreparedStatement statement = conexion.prepareStatement(orden);
					ResultSet resultado = statement.executeQuery(orden);
					
					while(resultado.next()) {
						for (int i = 0; i<11; i++) {
							array[i] = resultado.getString(i+1); // No existe la posicion 0
						}
						model.addRow(array);						
					}
					
				}catch(Exception error) {
					error.printStackTrace();
				}
			}
		});
		
		JButton btnAddWorker = new JButton("AGREGAR");
		btnAddWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionDB connectionDB = new ConnectionDB();	
				Connection conexion = connectionDB.obtenerConexion();
				
				Langileak addWorker = new Langileak();
				
				
				addWorker.añadirNuevoTrabajador(txtNan.getText(), txtIzena.getText(), txtAbizena.getText(),
						txtEmaila.getText(), txtJaiotzeData.getText(),chckbxLangileArduraduna.isSelected(),chckbxAdministratzailea.isSelected(), txtTelefonoa.getText(), txtPasswd.getText(), chckbxLangileNormala.isSelected());
				addWorker.guardar();
				
				btnShowTable.doClick();
				txtNan.setText("");
				txtIzena.setText("");
				txtAbizena.setText("");
				txtEmaila.setText("");
				txtJaiotzeData.setText("");
				txtTelefonoa.setText("");
				txtPasswd.setText("");				
				
			}
		});
		btnAddWorker.setBounds(67, 29, 105, 30);
		contentPane.add(btnAddWorker);
		
		txtTelefonoa = new JTextField();
		txtTelefonoa.setColumns(10);
		txtTelefonoa.setBounds(51, 302, 134, 19);
		contentPane.add(txtTelefonoa);
		
		JLabel lblNAN = new JLabel("NAN");
		lblNAN.setHorizontalAlignment(SwingConstants.CENTER);
		lblNAN.setBounds(94, 67, 45, 13);
		contentPane.add(lblNAN);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setBounds(94, 117, 45, 13);
		contentPane.add(lblIzena);
		
		JLabel lblAbizena = new JLabel("Abizena");
		lblAbizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbizena.setBounds(94, 155, 45, 13);
		contentPane.add(lblAbizena);
		
		JLabel lblKorreoa = new JLabel("Korreoa");
		lblKorreoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorreoa.setBounds(94, 197, 45, 13);
		contentPane.add(lblKorreoa);
		
		JLabel lblJaiotzeData = new JLabel("Jaiotze Data");
		lblJaiotzeData.setHorizontalAlignment(SwingConstants.CENTER);
		lblJaiotzeData.setBounds(81, 245, 78, 13);
		contentPane.add(lblJaiotzeData);
		
		JLabel lblTelefonoZenbakia = new JLabel("Telefono Zenbaki");
		lblTelefonoZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefonoZenbakia.setBounds(81, 286, 91, 13);
		contentPane.add(lblTelefonoZenbakia);
		
		
		btnShowTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowTable.setBounds(412, 16, 134, 40);
		contentPane.add(btnShowTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(391, 196, 2, 2);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(218, 89, 479, 301);
		contentPane.add(scrollPane_1);
		
		tableLangileak = new JTable();
		scrollPane_1.setViewportView(tableLangileak);
		
		txtPasswd = new JTextField();
		txtPasswd.setColumns(10);
		txtPasswd.setBounds(51, 350, 134, 19);
		contentPane.add(txtPasswd);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(81, 331, 78, 13);
		contentPane.add(lblPassword);
		

		

	}
}
