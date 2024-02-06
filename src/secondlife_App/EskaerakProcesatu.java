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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EskaerakProcesatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jTableEskaerak;
	private JButton btnEnProceso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EskaerakProcesatu frame = new EskaerakProcesatu();
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
	public EskaerakProcesatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoBack = new JButton("VOLVER");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LangileenPantaila2 langile2 = new LangileenPantaila2();
				
				langile2.setVisible(true);
				
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack.setBounds(808, 586, 171, 44);
		contentPane.add(btnGoBack);
		
		jTableEskaerak = new JTable();
		jTableEskaerak.setBounds(54, 368, 925, 289);
		contentPane.add(jTableEskaerak);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionDB connectionDB = new ConnectionDB();	
				Connection conexion = connectionDB.obtenerConexion();
				
				String orden = "SELECT * FROM second_life.cesta";
				
				DefaultTableModel model =new DefaultTableModel();
				
				model.addColumn("id_cesta");
				model.addColumn("NAN");
				model.addColumn("Estado");

				
				jTableEskaerak.setModel(model);
				String[] array = new String[3];
				
				try {
					
					PreparedStatement statement = conexion.prepareStatement(orden);
					ResultSet resultado = statement.executeQuery(orden);
					
					while(resultado.next()) {
						for (int i = 0; i<3; i++) {
							array[i] = resultado.getString(i+1); // No existe la posicion 0
						}
						model.addRow(array);						
					}
					
				}catch(Exception error) {
					error.printStackTrace();
				}
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDisplay.setBounds(828, 212, 151, 39);
		contentPane.add(btnDisplay);
		
		JScrollPane scrollPane = new JScrollPane(jTableEskaerak);
		scrollPane.setBounds(54, 271, 925, 289);
		contentPane.add(scrollPane);
		
		JButton btnEnCamino = new JButton("EN CAMINO");
		btnEnCamino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Las funciones de getSelectedRow() se pueden usarfuera de mouseEventListener mouse clicked
					int row = jTableEskaerak.getSelectedRow();
		            String tableClick = jTableEskaerak.getModel().getValueAt(row, 0).toString();
		            
		            Cesta c1 = new Cesta(Integer.parseInt(tableClick), "", ""); // Crear una instancia de Cesta
		            c1.changeState("En Camino");
		            btnDisplay.doClick();
		            
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, error);
				}
			}
		});
		btnEnCamino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEnCamino.setBounds(54, 211, 181, 39);
		contentPane.add(btnEnCamino);
		
		btnEnProceso = new JButton("EN PROCESO");
		btnEnProceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Las funciones de getSelectedRow() se pueden usarfuera de mouseEventListener mouse clicked
					int row = jTableEskaerak.getSelectedRow();
		            String tableClick = jTableEskaerak.getModel().getValueAt(row, 0).toString();
		            
		            Cesta c1 = new Cesta(Integer.parseInt(tableClick), "", ""); // Crear una instancia de Cesta
		            c1.changeState("En Proceso");
		            btnDisplay.doClick();
		            
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, error);
				}
			}
		});
		btnEnProceso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEnProceso.setBounds(350, 211, 181, 39);
		contentPane.add(btnEnProceso);
	}
}
