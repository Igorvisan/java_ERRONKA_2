package secondlife_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EliminarProveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable JTableHornitzaileak;
	private JButton btnDisplay;
	private JTextField txtEmpresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarProveedor frame = new EliminarProveedor();
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
	public EliminarProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTableHornitzaileak = new JTable();
		JTableHornitzaileak.setBounds(206, 258, 623, 340);
		contentPane.add(JTableHornitzaileak);
		
		JButton btnGoBack = new JButton("VOLVER");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LangileenPantaila3 langile3 = new LangileenPantaila3();
				
				langile3.setVisible(true);
				
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack.setBounds(802, 687, 172, 41);
		contentPane.add(btnGoBack);
		
		JScrollPane scrollPane = new JScrollPane(JTableHornitzaileak);
		scrollPane.setBounds(206, 258, 623, 340);
		contentPane.add(scrollPane);
		
		btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ConnectionDB connectionDB = new ConnectionDB();	
				Connection conexion = connectionDB.obtenerConexion();
				
				String orden = "SELECT * FROM second_life.hornitzaileak";
				
				DefaultTableModel model =new DefaultTableModel();
				
				model.addColumn("Id");
				model.addColumn("Enpresa");
				model.addColumn("Korreoa");
				model.addColumn("Telefono Zenbakia");
				model.addColumn("Kontu zenbakia");
				model.addColumn("Gehigarriak");
				
				JTableHornitzaileak.setModel(model);
				String [] array = new String[6];
				
				try {
					PreparedStatement statement = conexion.prepareStatement(orden);
					ResultSet resultado = statement.executeQuery(orden);
					
					while(resultado.next()) {
						for(int i = 0; i < 6; i++) {
							array[i] = resultado.getString(i+1);
						}
						
						model.addRow(array);
					}
					
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, error);
				}
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDisplay.setBounds(691, 204, 138, 44);
		contentPane.add(btnDisplay);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(217, 204, 172, 44);
		contentPane.add(txtEmpresa);
		txtEmpresa.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hornitzaileak hornitzaile = new Hornitzaileak();
				
				String empresa = txtEmpresa.getText();
				
				hornitzaile.eliminarHornitzaile(empresa);
				
				btnDisplay.doClick();
				
				txtEmpresa.setText("");
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(399, 204, 138, 44);
		contentPane.add(btnDelete);
	}
}
