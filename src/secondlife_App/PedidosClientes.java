package secondlife_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class PedidosClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jTablePedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PedidosClientes frame = new PedidosClientes("0");
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
	public PedidosClientes(String id_cesta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jTablePedidos = new JTable();
		jTablePedidos.setBounds(21, 328, 967, 360);
		contentPane.add(jTablePedidos);
		
		cargarDetallesPedido(id_cesta);
		
		JButton btnNewButton = new JButton("CREAR FACTURA");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(787, 42, 201, 48);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane(jTablePedidos);
		scrollPane.setBounds(21, 328, 967, 360);
		contentPane.add(scrollPane);
	}
	
	private void cargarDetallesPedido(String id_cesta) {
	    // Aquí realizamos la consulta SQL que involucra múltiples tablas
	    
	        ConnectionDB connectionDB = new ConnectionDB();   
	        Connection conexion = connectionDB.obtenerConexion();
	        
	        String orden = "SELECT cesta.id_cesta, biltegia.id_biltegia, biltegia.Produktua, pedidos.precio, pedidos.cant " +
                    "FROM second_life.cesta, second_life.biltegia, second_life.pedidos " +
                    "WHERE biltegia.id_biltegia = pedidos.id_biltegia AND cesta.id_cesta = ?";
	        
	        
	        // Crear el modelo de tabla
	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("id_cesta");
	        model.addColumn("id_biltegia");
	        model.addColumn("Produktua");
	        model.addColumn("Precio");
	        model.addColumn("Cantidad");
	        
	        jTablePedidos.setModel(model);
	        String [] array = new String[5];
	        
	        try {
	        	PreparedStatement statement = conexion.prepareStatement(orden);
	 	        statement.setString(1, id_cesta);
	 	        ResultSet resultado = statement.executeQuery();
	 	        
	 	       while (resultado.next()) {
	 	            for (int i = 0; i < 5; i++) {
	 	                array[i] = resultado.getString(i + 1);
	 	            }
	 	            model.addRow(array);
	 	        }
	 	       
	        }catch(Exception error) {
	        	JOptionPane.showMessageDialog(null, error);
	        }
	        }
}
	
