/**
 * 
 */
package secondlife_App;

import java.io.File;
import java.sql.Connection;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Langileak extends Usuarioak {

	private String departamentua;
	private int idLangilea;
	private String kontuKorrontea;
	private boolean balidazionAdministrazioa;
	private boolean langileArduradunak;
	private static ConnectionDB connectionDB;
	private static Produktoa biltegia;
	public static final Scanner sc = new Scanner(System.in);
	private String jaiotzeData;
	private String contraseña;
	private boolean langileNormala;

    public Langileak() {
        // Inicialización de la instancia de ConnectionDB
        this.connectionDB = new ConnectionDB();

        // Creación de una nueva instancia de la clase Biltegia y asignación a la variable "biltegia"
        this.biltegia = new Produktoa();
    }

	public String getJaiotzeData() {
		return jaiotzeData;
	}

	public void setJaiotzeData(String jaiotzeData) {
		this.jaiotzeData = jaiotzeData;
	}

	public String getDepartamentua() {
		return departamentua;
	}

	public void setDepartamentua(String departamentua) {
		this.departamentua = departamentua;
	}

	public String getKontuKorrontea() {
		return kontuKorrontea;
	}

	public void setKontuKorrontea(String kontuKorrontea) {
		this.kontuKorrontea = kontuKorrontea;
	}

	public boolean isBalidazionAdministrazioa() {
		return balidazionAdministrazioa;
	}

	public void setBalidazionAdministrazioa(boolean balidazionAdministrazioa) {
		this.balidazionAdministrazioa = balidazionAdministrazioa;
	}

	public boolean isLangileArduradunak() {
		return langileArduradunak;
	}

	public void setLangileArduradunak(boolean langileArduradunak) {
		this.langileArduradunak = langileArduradunak;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public boolean isLangileNormala() {
		return langileNormala;
	}

	public void setLangileNormala(boolean langileNormala) {
		this.langileNormala = langileNormala;
	}
	
	public int getIdLangilea() {
		return idLangilea;
	}

	public void setIdLangilea(int idLangilea) {
		this.idLangilea = idLangilea;
	}
	
	
	public void factura(DefaultTableModel tableModel) {
		try {
			PDDocument faktura = new PDDocument();
			//Creamos una nueva hoja
			PDPage hoja1 = new PDPage(PDRectangle.A4);
			faktura.addPage(hoja1);
			//Le decimos que contenido tendra el PDF
			PDPageContentStream contenido = new PDPageContentStream(faktura, hoja1);
			
			contenido.beginText();
			contenido.setFont(PDType1Font.COURIER_BOLD, 20);
			contenido.newLineAtOffset(245, hoja1.getMediaBox().getHeight()-(60));
			contenido.showText("FACTURA");
			contenido.endText();
			
			float margin = 30;
			
			//Se calcula la posición vertical inicial para comenzar a escribir en la página. Esto se hace restando siete veces el margen desde la altura total de la página.
			float y = hoja1.getMediaBox().getHeight() - (7 * margin);
			
			//Se calcula el ancho disponible para la tabla restando dos veces el margen desde el ancho total de la página.
			float tableAnchura = hoja1.getMediaBox().getWidth();
			
			//Se almacena la posición vertical actual.
			float yPosition = y;
			
			//Se define el margen entre las celdas de la tabla.
			float margenCeldas = 1f;
			
			// Se obtiene el número de filas en el modelo de tabla pasado como parámetro.
			int lineas = tableModel.getRowCount();
			
			//Se obtiene el número de columnas en el modelo de tabla.
			int columnas = tableModel.getColumnCount();
			
			//Se define la altura de las filas de la tabla en 35 puntos.
			float lineasAltura = 35f;
			
			//Se calcula la altura total de la tabla sumando una fila adicional (para los encabezados).
			float tableAltura = lineasAltura * (lineas + 1);
			
			//Se calcula el ancho de cada columna dividiendo el ancho total de la tabla entre el número de columnas.
			float colAnchura = tableAnchura / (float) columnas;
			
			//Se inicializan las posiciones de escritura en la primera celda de la tabla.
			 float siguienteX = margin;
			 float seguienteY = yPosition;
			 
			 // Comienza un bucle para iterar sobre las columnas de la tabla.
			 for(int i = 0; i < columnas; i++) {
				 //Obtiene el nombre de la columna en la posición i del modelo de tabla.
				String cabezal = tableModel.getColumnName(i);
				//: Inicia un nuevo bloque de texto en el flujo de contenido.
				contenido.beginText();
				contenido.setFont(PDType1Font.COURIER_BOLD, 10);
				// Establece la posición de inicio del texto en las coordenadas (siguienteX, seguienteY).
				contenido.newLineAtOffset(siguienteX, seguienteY);
				contenido.showText(cabezal);
				contenido.endText();
				//Actualiza la posición siguienteX para la siguiente columna. Se está desplazando la posición actual hacia la derecha en una cantidad igual al ancho de una columna.
				siguienteX += colAnchura;
			 }
			// Dibuja las filas
		        for (int i = 0; i < lineas; i++) {
		        	//Decrementa la posición seguienteY para comenzar en la siguiente fila.
		        	seguienteY -= lineasAltura;
		        	siguienteX = margin;
		        	//Comienza un bucle anidado para iterar sobre las columnas de cada fila.
		            for (int j = 0; j < columnas; j++) {
		            	//Obtiene el valor de la celda en la fila i y columna j del modelo de tabla y lo convierte en una cadena.
		                String cellValue = tableModel.getValueAt(i, j).toString();
		                contenido.beginText();
		                contenido.setFont(PDType1Font.HELVETICA, 8);
		                contenido.newLineAtOffset(siguienteX, seguienteY);
		                //Muestra el texto de la celda en la posición actual.
		                contenido.showText(cellValue);
		                contenido.endText();
		                siguienteX += colAnchura;
		            }
		        }
		        contenido.close();
		        String directorioDescargas = System.getProperty("user.home") + File.separator + "Downloads";
	            String rutaArchivoPDF = directorioDescargas + File.separator + "factura.pdf";
	            faktura.save(rutaArchivoPDF);
		        faktura.close();
		}
		catch(Exception x) {
			System.out.println("Erron: " + x.getMessage().toString());
		}
	}

	public void modificarEmpleado(String NAN, String izena, String abizena, String emaila,
			String jaiotzeData,boolean langileArduraduna, boolean administratzailea, String telefonoZenbakia, String contraseña, boolean langileNormala, int id) {
		
		Langileak mlangileak = new Langileak();
		
		this.idLangilea = id;
		super.setNAN(NAN);
		super.setIzena(izena);
		super.setAbizena(abizena);
		super.setEmaila(emaila);
		this.jaiotzeData = jaiotzeData;
		super.setTelefonoa(telefonoZenbakia);
		this.langileArduradunak = langileArduraduna;
		this.balidazionAdministrazioa = administratzailea;				
		this.contraseña = contraseña;
		this.langileNormala = langileNormala;
		
		mlangileak.guardarModificacion();
	}
	
	public void guardarModificacion() {
		Connection conexion = connectionDB.obtenerConexion();
		
		String orden = "UPDATE second_life.langileak SET NAN=?, Izena=?, Abizena=?, Korreoa=?, Jaiotze_Data=?, Telefono_Zenbakia=?, Langile_arduraduna=?, Administratzailea=?, langile_normala=?, password=? WHERE Id_langilea= '"+this.idLangilea+"'";
		
		 try (PreparedStatement statement = conexion.prepareStatement(orden)) {
			 
		    	statement.setString(1, this.getNAN());
		    	statement.setString(2, this.getIzena());
		    	statement.setString(3, this.getAbizena());
		    	statement.setString(4, this.getEmaila());
		    	statement.setString(5, this.getJaiotzeData());
		    	statement.setString(6, this.getTelefonoa());
		    	statement.setBoolean(7, this.isLangileArduradunak());
		    	statement.setBoolean(8, this.isBalidazionAdministrazioa());
		    	statement.setBoolean(9, this.isLangileNormala());
		    	statement.setString(10, this.getContraseña());
		    	
		    	if(statement.executeUpdate() > 0) {
		    		JOptionPane.showMessageDialog(null, "Se han insertado los datos correctamente");
		    	}
		
	}catch(Exception error) {
		JOptionPane.showMessageDialog(null, error);
	}finally {
		try {
			conexion.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
	
	public void modificarProducto(String produktoa, double prezioa, String marca, int stockKantitatea, double produktuaren_KG, double iritzia, String deskribapena, String irudiak, 
			boolean stock, boolean tendentzia, int id) {
		
		Produktoa modify = new Produktoa();
		
		modify.setId(id);
        modify.setProduktua(produktoa);
        modify.setPrezioa(prezioa);
        modify.setMarca(marca);
        modify.setStockKantitatea(stockKantitatea);
        modify.setProduktuaren_KG(produktuaren_KG);
        modify.setIritzia(iritzia);
        modify.setDeskribapena(deskribapena);
        modify.setIrudiak(irudiak);
        modify.setStock(stock);
        modify.setTendentziak(tendentzia);

        modify.guardarCambioProducto();
        
	}
	
    public void añadirProducto(String produktoa, double prezioa, String marca, int stockKantitatea, double produktuaren_KG, double iritzia, String deskribapena, String irudiak) {
        Produktoa newProduct = new Produktoa();

        newProduct.setProduktua(produktoa);
        newProduct.setPrezioa(prezioa);
        newProduct.setMarca(marca);
        newProduct.setStockKantitatea(stockKantitatea);
        newProduct.setProduktuaren_KG(produktuaren_KG);
        newProduct.setIritzia(iritzia);
        newProduct.setDeskribapena(deskribapena);
        newProduct.setIrudiak(irudiak);

        newProduct.guardarProducto();
    }
	

	public void guardar() {
		Connection conexion = connectionDB.obtenerConexion();
		System.out.println("Inserte los datos para añadir un nuevo empleado a la base de datos");

	    String orden = "INSERT INTO second_life.langileak (NAN, Izena, Abizena, Korreoa, Jaiotze_Data, Telefono_Zenbakia, Langile_arduraduna, Administratzailea, langile_normala, password) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try(PreparedStatement statement = conexion.prepareStatement(orden)){
	    
	    	statement.setString(1, this.getNAN());
	    	statement.setString(2, this.getIzena());
	    	statement.setString(3, this.getAbizena());
	    	statement.setString(4, this.getEmaila());
	    	statement.setString(5, this.getJaiotzeData());
	    	statement.setString(6, this.getTelefonoa());
	    	statement.setBoolean(7, this.isLangileArduradunak());
	    	statement.setBoolean(8, this.isBalidazionAdministrazioa());
	    	statement.setBoolean(9, this.isLangileNormala());
	    	statement.setString(10, this.getContraseña());
	    	
	    	
	    	if(statement.execute() == false) {
	    		JOptionPane.showMessageDialog(null, "Se ha añadido usuario correctamente");
	    	}
	    	
	    }catch (SQLException e) {
	        e.printStackTrace(); // Manejo adecuado de excepciones en la vida real
	    }finally {
	    	try {
	    		conexion.close();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	}

	public void añadirNuevoTrabajador(String NAN, String izena, String abizena, String emaila,
			String jaiotzeData,boolean langileArduraduna, boolean administratzailea, String telefonoZenbakia, String contraseña, boolean langileNormala) {

		
		
		System.out.println("Escribe todos los datos correspondientes");
		
		super.setNAN(NAN);
		super.setIzena(izena);
		super.setAbizena(abizena);
		super.setEmaila(emaila);
		this.jaiotzeData = jaiotzeData;
		super.setTelefonoa(telefonoZenbakia);
		this.langileArduradunak = langileArduraduna;
		this.balidazionAdministrazioa = administratzailea;				
		this.contraseña = contraseña;
		this.langileNormala = langileNormala;
			
		}

	
	public void delete(String izena) {
		Connection conexion = connectionDB.obtenerConexion();
		String orden = "DELETE FROM second_life.langileak WHERE Izena = '" + izena + "'";
		if(conexion != null) {
			try {
				
				PreparedStatement statement = conexion.prepareStatement(orden);
				
				if(statement.execute(orden)==false) {
					JOptionPane.showMessageDialog(null, "Se ha eliminado usuario correctamente");
			
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
				}
				
			}catch (Exception error) {
				error.printStackTrace();
			}
		}
	}
	



	public Langileak(String departamentua, int idLangilea, String kontuKorrontea, boolean balidazionAdministrazioa,
			boolean langileArduradunak, String jaiotzeData, String contraseña, boolean langileNormala) {
		super();
		this.departamentua = departamentua;
		this.idLangilea = idLangilea;
		this.kontuKorrontea = kontuKorrontea;
		this.balidazionAdministrazioa = balidazionAdministrazioa;
		this.langileArduradunak = langileArduradunak;
		this.jaiotzeData = jaiotzeData;
		this.contraseña = contraseña;
		this.langileNormala = langileNormala;
	}

	public static boolean confirmarAdmistrador(String username, String password) {
	    Connection conexion = connectionDB.obtenerConexion();
	    boolean validacion = false;

	    if (conexion != null) {
	        try {
	            String consulta = "SELECT NAN, password FROM second_life.langileak";
	            Statement statement = conexion.createStatement();
	            ResultSet resultado = statement.executeQuery(consulta);

	            while (resultado.next()) {
	                String nanCode = resultado.getString("NAN");
	                String contraseña = resultado.getString("password");

	                if (nanCode.equals(username) && contraseña.equals(password)) {
	                    validacion = true;
	                    System.out.println("El código es válido");
	                    break;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                conexion.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    System.out.println(validacion);
	    return validacion;
	}

	public static boolean confirmarLangileArduraduna(String username, String password) {
	    Connection conexion = connectionDB.obtenerConexion();
	    boolean validacion = false;

	    if (conexion != null) {
	        try {
	            String consulta = "SELECT NAN, password FROM second_life.langileak";
	            Statement statement = conexion.createStatement();
	            ResultSet resultado = statement.executeQuery(consulta);

	            while (resultado.next()) {
	                String nanCode = resultado.getString("NAN");
	                String contraseña = resultado.getString("password");

	                if (nanCode.equals(username) && contraseña.equals(password)) {
	                    validacion = true;
	                    System.out.println("El código es válido");
	                    break;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                conexion.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    System.out.println(validacion);
	    return validacion;
	}

	public static boolean confirmarEmpleadoNormal(String username, String password) {
	    Connection conexion = ConnectionDB.obtenerConexion();
	    boolean validacion = false;

	    if (conexion != null) {
	        try {
	            String consulta = "SELECT NAN, password FROM second_life.langileak";
	            Statement statement = conexion.createStatement();
	            ResultSet resultado = statement.executeQuery(consulta);

	            while (resultado.next()) {
	                String nanCode = resultado.getString("NAN");
	                String contraseña = resultado.getString("password");

	                if (nanCode.equals(username) && contraseña.equals(password)) {
	                    validacion = true;
	                    System.out.println("El código es válido");
	                    break;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                conexion.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    System.out.println(validacion);
	    return validacion;
	}

}
