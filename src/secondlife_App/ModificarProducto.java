package secondlife_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnShowTable;
	private JTable jTableBiltegia;
	private JScrollPane scrollPane;
	private JTextField txtProduktua;
	private JTextField txtPrezioa;
	private JTextField txtMarca;
	private JTextField txtKantitatea;
	private JTextField txtPisua;
	private JTextField txtIritzia;
	private JTextField txtDeskribapena;
	private JTextField txtLinkImagenes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProducto frame = new ModificarProducto();
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
	public ModificarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1027, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoBack = new JButton("VOLVER");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LangileenPantaila2 langile2 = new LangileenPantaila2();
				
				langile2.setVisible(true);
				
				dispose();
			}
		});
		btnGoBack.setBounds(793, 476, 167, 34);
		contentPane.add(btnGoBack);
		
		btnShowTable = new JButton("DISPLAY");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        ConnectionDB connectionDB = new ConnectionDB();
		        // Obtener la conexión a la base de datos
		        Connection conexion = connectionDB.obtenerConexion();

		        // Consulta SQL para seleccionar todos los registros de la tabla "biltegia"
		        String orden = "SELECT * FROM second_life.biltegia";

		        // Crear un modelo de tabla por defecto para almacenar los datos
		        DefaultTableModel model = new DefaultTableModel();

		        // Agregar columnas al modelo
		        model.addColumn("Id");
		        model.addColumn("Produktua");
		        model.addColumn("Prezioa");
		        model.addColumn("Marca");
		        model.addColumn("Stock");
		        model.addColumn("Stock_kantitatea");
		        model.addColumn("Produktuaren_KG");
		        model.addColumn("Iritzia");
		        model.addColumn("Deskribapena");
		        model.addColumn("imagenes");
		        model.addColumn("tendencia");

		        // Establecer el modelo en la jTableBiltegia
		        jTableBiltegia.setModel(model);

		        // Arreglo para almacenar los datos de cada columna
		        String[] array = new String[11];

		        try {
		            // Preparar y ejecutar la consulta SQL
		            PreparedStatement statement = conexion.prepareStatement(orden);
		            ResultSet result = statement.executeQuery(orden);

		            // Procesar los resultados de la consulta
		            while (result.next()) {
		                // Llenar el arreglo con los datos de cada columna
		                for (int i = 0; i < 11; i++) {
		                    array[i] = result.getString(i + 1); // El índice comienza desde 1 en ResultSet
		                }

		                // Agregar una nueva fila al modelo con los datos del arreglo
		                model.addRow(array);
		            }
		        } catch (Exception error) {
		            error.printStackTrace();
		        }
			}
		});
		btnShowTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShowTable.setBounds(793, 184, 167, 34);
		contentPane.add(btnShowTable);
		
		JCheckBox chckbxTendentziak = new JCheckBox("Tendentziak");
		chckbxTendentziak.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxTendentziak.setBounds(650, 81, 147, 28);
		contentPane.add(chckbxTendentziak);
		
		JCheckBox chckbxStock = new JCheckBox("Hay Stock?");
		chckbxStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxStock.setBounds(650, 31, 147, 28);
		contentPane.add(chckbxStock);
		
		jTableBiltegia = new JTable();
		jTableBiltegia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        ConnectionDB connectionDB = new ConnectionDB();				
		        Connection conexion = connectionDB.obtenerConexion();
				
				
				try {
					
					int row = jTableBiltegia.getSelectedRow();
					String tableClick = (jTableBiltegia.getModel().getValueAt(row, 0).toString());
					
					String orden = "SELECT * FROM second_life.biltegia WHERE id ='"+tableClick+"' ";
					
					PreparedStatement statement = conexion.prepareStatement(orden);
					ResultSet resultado = statement.executeQuery();
					
					if(resultado.next()) {
						String add1 = resultado.getString("Produktua");
						txtProduktua.setText(add1);
						String add2 = resultado.getString("Prezioa");
						txtPrezioa.setText(add2);
						String add3 = resultado.getString("Marca");
						txtMarca.setText(add3);
						String add4 = resultado.getString("Stock_kantitatea");
						txtKantitatea.setText(add4);
						String add5 = resultado.getString("Produktuaren_KG");
						txtPisua.setText(add5);
						String add6 = resultado.getString("Iritzia");
						txtIritzia.setText(add6);
						String add7 = resultado.getString("Deskribapena");
						txtDeskribapena.setText(add7);
						String add8 = resultado.getString("imagenes");
						txtLinkImagenes.setText(add8);
						boolean check1value = resultado.getBoolean("Stock");
						chckbxStock.setSelected(check1value);
						boolean check2value = resultado.getBoolean("tendencia");
						chckbxTendentziak.setSelected(check2value);
						
						
					}
					
					
				}catch (Exception error) {
					JOptionPane.showMessageDialog(null, error);
				}
				
				
				
			}
		});
		jTableBiltegia.setBounds(54, 228, 906, 238);
		contentPane.add(jTableBiltegia);
		
		scrollPane = new JScrollPane(jTableBiltegia);
		scrollPane.setBounds(54, 228, 906, 238);
		contentPane.add(scrollPane);
		
		txtProduktua = new JTextField();
		txtProduktua.setColumns(10);
		txtProduktua.setBounds(122, 32, 147, 28);
		contentPane.add(txtProduktua);
		
		txtPrezioa = new JTextField();
		txtPrezioa.setColumns(10);
		txtPrezioa.setBounds(122, 78, 147, 28);
		contentPane.add(txtPrezioa);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(122, 128, 147, 28);
		contentPane.add(txtMarca);
		
		txtKantitatea = new JTextField();
		txtKantitatea.setColumns(10);
		txtKantitatea.setBounds(122, 174, 147, 28);
		contentPane.add(txtKantitatea);
		
		txtPisua = new JTextField();
		txtPisua.setColumns(10);
		txtPisua.setBounds(430, 32, 147, 28);
		contentPane.add(txtPisua);
		
		txtIritzia = new JTextField();
		txtIritzia.setColumns(10);
		txtIritzia.setBounds(430, 78, 147, 28);
		contentPane.add(txtIritzia);
		
		txtDeskribapena = new JTextField();
		txtDeskribapena.setColumns(10);
		txtDeskribapena.setBounds(430, 128, 147, 28);
		contentPane.add(txtDeskribapena);
		
		txtLinkImagenes = new JTextField();
		txtLinkImagenes.setColumns(10);
		txtLinkImagenes.setBounds(430, 174, 147, 28);
		contentPane.add(txtLinkImagenes);
		
		JButton btnNewButton = new JButton("MODIFICAR");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(606, 168, 137, 34);
		contentPane.add(btnNewButton);
	}
}
