package secondlife_App;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EliminarEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIzena;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarEmpleado frame = new EliminarEmpleado();
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
	public EliminarEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoBack = new JButton("Volver");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LangileenPantaila1 lPantaila = new LangileenPantaila1();
				
				lPantaila.setVisible(true);
				
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGoBack.setBounds(578, 443, 117, 36);
		contentPane.add(btnGoBack);
		
		txtIzena = new JTextField();
		txtIzena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtIzena.setBounds(200, 444, 133, 36);
		contentPane.add(txtIzena);
		txtIzena.setColumns(10);
		
		JButton btnDisplay = new JButton("Display");
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
				model.addColumn("password");
				
				table.setModel(model);
				String[] array = new String[10];
				
				try {
					
					PreparedStatement statement = conexion.prepareStatement(orden);
					ResultSet resultado = statement.executeQuery(orden);
					
					while(resultado.next()) {
						for (int i = 0; i<10; i++) {
							array[i] = resultado.getString(i+1); // No existe la posicion 0
						}
						model.addRow(array);						
					}
					
				}catch(Exception error) {
					error.printStackTrace();
				}
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDisplay.setBounds(279, 10, 133, 43);
		contentPane.add(btnDisplay);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 63, 469, 352);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Langileak deleteWorker = new Langileak();
				
				deleteWorker.delete(txtIzena.getText());
				btnDisplay.doClick();
				txtIzena.setText("");
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(354, 443, 149, 36);
		contentPane.add(btnDelete);
		
		JLabel lblNombreDelete = new JLabel("Introduzca nombre");
		lblNombreDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDelete.setBounds(10, 443, 159, 36);
		contentPane.add(lblNombreDelete);
		}
}


