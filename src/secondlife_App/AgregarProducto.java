package secondlife_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class AgregarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jTableBiltegia;
	private JScrollPane scrollPane;
	private JTextField txtProduktua;
	private JTextField txtPrezioa;
	private JTextField txtMarca;
	private JTextField txtKatitatea;
	private JTextField txtPisua;
	private JTextField txtIritzia;
	private JTextField txtLinkImagenes;
	private JButton btnAddProduct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarProducto frame = new AgregarProducto();
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
	public AgregarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 758);
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
		btnGoBack.setBounds(819, 657, 180, 54);
		contentPane.add(btnGoBack);
		
		JButton btnNewButton = new JButton("DISPLAY");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Crear una instancia de ConnectionDB para manejar la conexión a la base de datos
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(740, 269, 147, 41);
		contentPane.add(btnNewButton);
		
		jTableBiltegia = new JTable();
		jTableBiltegia.setBounds(56, 318, 926, 317);
		contentPane.add(jTableBiltegia);
		
		scrollPane = new JScrollPane(jTableBiltegia);
		scrollPane.setBounds(46, 320, 926, 317);
		contentPane.add(scrollPane);
		
		txtProduktua = new JTextField();
		txtProduktua.setBounds(114, 51, 147, 28);
		contentPane.add(txtProduktua);
		txtProduktua.setColumns(10);
		
		txtPrezioa = new JTextField();
		txtPrezioa.setColumns(10);
		txtPrezioa.setBounds(114, 105, 147, 28);
		contentPane.add(txtPrezioa);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(114, 154, 147, 28);
		contentPane.add(txtMarca);
		
		txtKatitatea = new JTextField();
		txtKatitatea.setColumns(10);
		txtKatitatea.setBounds(114, 206, 147, 28);
		contentPane.add(txtKatitatea);
		
		txtPisua = new JTextField();
		txtPisua.setColumns(10);
		txtPisua.setBounds(114, 256, 147, 28);
		contentPane.add(txtPisua);
		
		txtIritzia = new JTextField();
		txtIritzia.setColumns(10);
		txtIritzia.setBounds(457, 55, 147, 28);
		contentPane.add(txtIritzia);
		
		txtLinkImagenes = new JTextField();
		txtLinkImagenes.setColumns(10);
		txtLinkImagenes.setBounds(457, 105, 147, 28);
		contentPane.add(txtLinkImagenes);
		
		JTextArea txtDeskribapena = new JTextArea();
		txtDeskribapena.setBounds(666, 52, 318, 171);
		contentPane.add(txtDeskribapena);
		
		btnAddProduct = new JButton("AÑADIR PRODUCTO");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Langileak langileProduct = new Langileak();
				
				langileProduct.añadirProducto(, , , , , , , , , );
			}
		});
		btnAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddProduct.setBounds(457, 157, 147, 35);
		contentPane.add(btnAddProduct);
	}
}
