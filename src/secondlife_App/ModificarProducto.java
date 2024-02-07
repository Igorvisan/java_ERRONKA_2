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
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ModificarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String VOLVER_LABEL = "VOLVER";
	private static final String DISPLAY_LABEL = "DISPLAY";
	private static final String TENDENTZIAK_LABEL = "Tendentziak";
	private static final String HAY_STOCK_LABEL = "Hay Stock?";
	private static final String MODIFICAR_LABEL = "MODIFICAR";

	private JPanel contentPane;
	private JButton btnGoBack;
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
	private JCheckBox chckbxTendentziak;
	private JCheckBox chckbxStock;
	private JTextField txtId;

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

		btnGoBack = new JButton(VOLVER_LABEL);
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

		btnShowTable = new JButton(DISPLAY_LABEL);
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTable();
			}
		});
		btnShowTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShowTable.setBounds(793, 184, 167, 34);
		contentPane.add(btnShowTable);

		chckbxTendentziak = new JCheckBox(TENDENTZIAK_LABEL);
		chckbxTendentziak.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxTendentziak.setBounds(650, 81, 147, 28);
		contentPane.add(chckbxTendentziak);

		chckbxStock = new JCheckBox(HAY_STOCK_LABEL);
		chckbxStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxStock.setBounds(650, 31, 147, 28);
		contentPane.add(chckbxStock);

		jTableBiltegia = new JTable();
		jTableBiltegia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillDataFields();
			}
		});
		jTableBiltegia.setBounds(54, 228, 906, 238);
		contentPane.add(jTableBiltegia);

		scrollPane = new JScrollPane(jTableBiltegia);
		scrollPane.setBounds(54, 228, 906, 238);
		contentPane.add(scrollPane);

		initializeTextFields();
		initializeButtons();
	}

	private void displayTable() {
		ConnectionDB connectionDB = new ConnectionDB();
		Connection conexion = connectionDB.obtenerConexion();

		String orden = "SELECT * FROM second_life.biltegia";

		DefaultTableModel model = new DefaultTableModel();
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

		jTableBiltegia.setModel(model);

		String[] array = new String[11];

		try {
			PreparedStatement statement = conexion.prepareStatement(orden);
			ResultSet result = statement.executeQuery(orden);

			while (result.next()) {
				for (int i = 0; i < 11; i++) {
					array[i] = result.getString(i + 1);
				}
				model.addRow(array);
			}
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	private void fillDataFields() {
		ConnectionDB connectionDB = new ConnectionDB();
		Connection conexion = connectionDB.obtenerConexion();

		try {
			int row = jTableBiltegia.getSelectedRow();
			String tableClick = (jTableBiltegia.getModel().getValueAt(row, 0).toString());
			String orden = "SELECT * FROM second_life.biltegia WHERE id_biltegia ='" + tableClick + "' ";

			PreparedStatement statement = conexion.prepareStatement(orden);
			ResultSet resultado = statement.executeQuery();

			if (resultado.next()) {
				txtProduktua.setText(resultado.getString("Produktua"));
				txtPrezioa.setText(resultado.getString("Prezioa"));
				txtMarca.setText(resultado.getString("Marca"));
				txtKantitatea.setText(resultado.getString("Stock_kantitatea"));
				txtPisua.setText(resultado.getString("Produktuaren_KG"));
				txtIritzia.setText(resultado.getString("Iritzia"));
				txtDeskribapena.setText(resultado.getString("Deskribapena"));
				txtLinkImagenes.setText(resultado.getString("imagenes"));
				chckbxStock.setSelected(resultado.getBoolean("Stock"));
				chckbxTendentziak.setSelected(resultado.getBoolean("tendencia"));
				txtId.setText(resultado.getString("id_biltegia"));
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error);
		}
	}

	private void initializeTextFields() {
		txtProduktua = createTextField(122, 32, 147, 28);
		txtPrezioa = createTextField(122, 78, 147, 28);
		txtMarca = createTextField(122, 128, 147, 28);
		txtKantitatea = createTextField(122, 174, 147, 28);
		txtPisua = createTextField(430, 32, 147, 28);
		txtIritzia = createTextField(430, 78, 147, 28);
		txtDeskribapena = createTextField(430, 128, 147, 28);
		txtLinkImagenes = createTextField(430, 174, 147, 28);
	}

	private JTextField createTextField(int x, int y, int width, int height) {
		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(x, y, width, height);
		contentPane.add(textField);
		return textField;
	}

	private void initializeButtons() {
		JButton btnNewButton = new JButton("MODIFICAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                Langileak modifyProduct = new Langileak();

                double dPrezioa = Double.parseDouble(txtPrezioa.getText());
                int kantitatea = Integer.parseInt(txtKantitatea.getText());
                double dPisua = Double.parseDouble(txtPisua.getText());
                double dIritzia = Double.parseDouble(txtIritzia.getText());
                int id = Integer.parseInt(txtId.getText());
                
                modifyProduct.modificarProducto(txtProduktua.getText(), dPrezioa, txtMarca.getText(), kantitatea, dPisua, dIritzia, txtDeskribapena.getText(), txtLinkImagenes.getText(), chckbxStock.isSelected(), chckbxTendentziak.isSelected(), id);
                
                btnShowTable.doClick();
                txtProduktua.setText("");
                txtPrezioa.setText("");
                txtMarca.setText("");
                txtKantitatea.setText("");
                txtPisua.setText("");
                txtIritzia.setText("");
                txtDeskribapena.setText("");
                txtLinkImagenes.setText("");
                chckbxStock.setSelected(false);
                chckbxTendentziak.setSelected(false);
                txtId.setText("");
                
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(610, 184, 137, 34);
		contentPane.add(btnNewButton);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(826, 67, 147, 28);
		contentPane.add(txtId);
		
		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(844, 31, 116, 28);
		contentPane.add(lblID);

		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LangileenPantaila2 langile2 = new LangileenPantaila2();
				langile2.setVisible(true);
				dispose();
			}
		});

		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTable();
			}
		});
	}
}
