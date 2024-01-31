/**
 * 
 */
package secondlife_App;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Langileak extends Usuarioak {

	private String departamentua;
	private String kontuKorrontea;
	private boolean balidazionAdministrazioa;
	private boolean langileArduradunak;
	private static ConnectionDB connectionDB;
	private static Biltegia biltegia;
	public static final Scanner sc = new Scanner(System.in);
	private String jaiotzeData;
	private String contraseña;
	private boolean langileNormala;

    public Langileak() {
        // Inicialización de la instancia de ConnectionDB
        this.connectionDB = new ConnectionDB();

        // Creación de una nueva instancia de la clase Biltegia y asignación a la variable "biltegia"
        this.biltegia = new Biltegia();
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
	
	public void añadirProducto(String produktoa, double prezioa, String marca, boolean stock, int stockKantitatea, double produktuaren_KG, double iritzia, String deskribapena
			, String irudiak, boolean tendentziak) {
		
		biltegia.getProduktua();
		biltegia.getPrezioa();
		biltegia.getMarca();
		biltegia.isStock();
		biltegia.getStockKantitatea();
		biltegia.getProduktuaren_KG();
		biltegia.getIritzia();
		biltegia.getDeskribapena();
		biltegia.getIrudiak();
		biltegia.isTendentziak();
		
	}
	
	public void guardarProducto() {
		Connection conexion = connectionDB.obtenerConexion();
		System.out.println("Inserte los datos para añadir un nuevo producto ");
		
		String orden = "INSERT INTO second_life.biltegia (Produktua, Prezioa, Marca, Stock, Stock_kantitatea, Produktuaren_KG, Iritzia, Deskribapena, imagenes, tendencia) " +
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement statement = conexion.prepareStatement(orden)){
			
			
			statement.setString(1, biltegia.getProduktua());
			statement.setDouble(2, biltegia.getPrezioa());
			statement.setString(3, biltegia.getMarca());
			statement.setBoolean(4, biltegia.isStock());
			statement.setInt(5, biltegia.getStockKantitatea());
			statement.setDouble(6, biltegia.getProduktuaren_KG());
			statement.setDouble(7, biltegia.getIritzia());
			statement.setString(8, biltegia.getDeskribapena());
			statement.setString(9, biltegia.getIrudiak());
			statement.setBoolean(10, biltegia.isTendentziak());
			
			if(statement.execute() == false) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error a la hora de insertar");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
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
	


	
	public Langileak(String departamentua, String kontuKorrontea, boolean balidazionAdministrazioa,
			boolean langileArduradunak, String jaiotzeData, String contraseña, boolean langileNormala) {
		super();
		this.departamentua = departamentua;
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
