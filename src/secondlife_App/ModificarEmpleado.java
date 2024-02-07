package secondlife_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificarEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtNan;
	private JTextField txtIzena;
	private JTextField txtAbizena;
	private JTextField txtKorreoa;
	private JTextField txtJaiotzeData;
	private JTextField txtTelefonoZenbakia;
	private JTextField txtPassword;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarEmpleado frame = new ModificarEmpleado();
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
	public ModificarEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoBack = new JButton("VOLVER");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LangileenPantaila1 langile1 = new LangileenPantaila1();
				
				langile1.setVisible(true);
				
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack.setBounds(830, 676, 185, 48);
		contentPane.add(btnGoBack);
		

		JCheckBox chckbxAdministratzailea = new JCheckBox("Administratzailea");
		chckbxAdministratzailea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxAdministratzailea.setBounds(434, 228, 149, 28);
		contentPane.add(chckbxAdministratzailea);
		
		JCheckBox chckbxLangileArduraduna = new JCheckBox("Langile Arduraduna");
		chckbxLangileArduraduna.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxLangileArduraduna.setBounds(434, 258, 149, 28);
		contentPane.add(chckbxLangileArduraduna);
		
		JCheckBox chckbxLangileNormala = new JCheckBox("Langile Normala");
		chckbxLangileNormala.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxLangileNormala.setBounds(434, 286, 149, 28);
		contentPane.add(chckbxLangileNormala);
		
		table= new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConnectionDB connectionDB = new ConnectionDB();
				Connection conexion = connectionDB.obtenerConexion();
				
				try {
					int row = table.getSelectedRow();
					String tableClick = (table.getModel().getValueAt(row, 0).toString());
					String orden = "SELECT * FROM second_life.langileak WHERE Id_langilea ='" + tableClick + "' ";
					
					PreparedStatement statement = conexion.prepareStatement(orden);
					ResultSet resultado = statement.executeQuery();

					if (resultado.next()) {
						txtNan.setText(resultado.getString("NAN"));
						txtIzena.setText(resultado.getString("Izena"));
						txtAbizena.setText(resultado.getString("Abizena"));
						txtKorreoa.setText(resultado.getString("Korreoa"));
						txtJaiotzeData.setText(resultado.getString("Jaiotze_Data"));
						txtTelefonoZenbakia.setText(resultado.getString("Telefono_Zenbakia"));
						chckbxAdministratzailea.setSelected(resultado.getBoolean("Administratzailea"));
						chckbxLangileArduraduna.setSelected(resultado.getBoolean("Langile_arduraduna"));
						chckbxLangileNormala.setSelected(resultado.getBoolean("langile_normala"));
						txtPassword.setText(resultado.getString("password"));
						txtId.setText(resultado.getString("Id_langilea"));
						
					}
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, error);
				}
			}
		});
		table.setBounds(49, 324, 908, 325);
		contentPane.add(table);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
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

				
				table.setModel(model);
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
		
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDisplay.setBounds(802, 274, 155, 40);
		contentPane.add(btnDisplay);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(49, 324, 908, 325);
		contentPane.add(scrollPane);
		
		txtNan = new JTextField();
		txtNan.setBounds(92, 44, 149, 40);
		contentPane.add(txtNan);
		txtNan.setColumns(10);
		
		txtIzena = new JTextField();
		txtIzena.setColumns(10);
		txtIzena.setBounds(92, 111, 149, 40);
		contentPane.add(txtIzena);
		
		txtAbizena = new JTextField();
		txtAbizena.setColumns(10);
		txtAbizena.setBounds(92, 171, 149, 40);
		contentPane.add(txtAbizena);
		
		txtKorreoa = new JTextField();
		txtKorreoa.setColumns(10);
		txtKorreoa.setBounds(92, 236, 149, 40);
		contentPane.add(txtKorreoa);
		
		txtJaiotzeData = new JTextField();
		txtJaiotzeData.setColumns(10);
		txtJaiotzeData.setBounds(434, 44, 149, 40);
		contentPane.add(txtJaiotzeData);
		
		txtTelefonoZenbakia = new JTextField();
		txtTelefonoZenbakia.setColumns(10);
		txtTelefonoZenbakia.setBounds(434, 111, 149, 40);
		contentPane.add(txtTelefonoZenbakia);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(434, 171, 149, 40);
		contentPane.add(txtPassword);
		
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionDB connectionDB = new ConnectionDB();	
				Connection conexion = connectionDB.obtenerConexion();
				
				Langileak langileaModificar = new Langileak();
				
				int id = Integer.parseInt(txtId.getText());
				
				langileaModificar.modificarEmpleado(txtNan.getText(), txtIzena.getText(), txtAbizena.getText(),
						txtKorreoa.getText(), txtJaiotzeData.getText(),chckbxLangileArduraduna.isSelected(),chckbxAdministratzailea.isSelected(), txtTelefonoZenbakia.getText(), txtPassword.getText(), chckbxLangileNormala.isSelected(), id);
				langileaModificar.guardarModificacion();
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.setBounds(621, 274, 155, 40);
		contentPane.add(btnModificar);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(757, 111, 149, 40);
		contentPane.add(txtId);
	}
}
