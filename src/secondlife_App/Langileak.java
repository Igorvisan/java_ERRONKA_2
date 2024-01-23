/**
 * 
 */
package secondlife_App;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
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
	public static final Scanner sc = new Scanner(System.in);
	private String jaiotzeData;
	private String contraseña;

	public Langileak() {
		this.connectionDB = new ConnectionDB();
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

	public void guardar() {
		Connection conexion = connectionDB.obtenerConexion();
		System.out.println("Inserte los datos para añadir un nuevo empleado a la base de datos");

	    String orden = "INSERT INTO second_life.langileak (NAN, Izena, Abizena, Korreoa, Jaiotze_Data, Telefono_Zenbakia, Langile_arduraduna, Administratzailea, password) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try(PreparedStatement statement = conexion.prepareStatement(orden)){;
	    
	    	statement.setString(1, this.getNAN());
	    	statement.setString(2, this.getIzena());
	    	statement.setString(3, this.getAbizena());
	    	statement.setString(4, this.getEmaila());
	    	statement.setString(5, this.getJaiotzeData());
	    	statement.setString(6, this.getTelefonoa());
	    	statement.setBoolean(7, this.isLangileArduradunak());
	    	statement.setBoolean(8, this.isBalidazionAdministrazioa());
	    	statement.setString(9, this.getContraseña());
	    	
	    	statement.execute();
	    	
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
			String jaiotzeData,boolean administratzailea, boolean langileArduraduna, String telefonoZenbakia, String contraseña) {

		
		
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
			
		}
	
	public void eleminiarTrabajador(int id) {
		
		
	}
	

	public Langileak(String departamentua, String kontuKorrontea, boolean balidazionAdministrazioa,
			boolean langileArduradunak, ConnectionDB connectionDB, String jaiotzeData, String contraseña) {
		super();
		this.departamentua = departamentua;
		this.kontuKorrontea = kontuKorrontea;
		this.balidazionAdministrazioa = balidazionAdministrazioa;
		this.langileArduradunak = langileArduradunak;
		this.connectionDB = connectionDB;
		this.jaiotzeData = jaiotzeData;
		this.contraseña = contraseña;
	}

	public static boolean confirmarAdmistrador(String username, String password) { // Le pasamo el un parametro para que luego pueda usarlo en
																// el main como dato para los metodos
		Connection conexion = connectionDB.obtenerConexion();
		boolean validacion = false;

		if (conexion != null) {
			try {
				String consulta = "SELECT NAN, password FROM second_life.langileak";
				try (Statement statement = conexion.createStatement()) {
					ResultSet resultado = statement.executeQuery(consulta);
					while (resultado.next()) {
						String nanCode = resultado.getString("NAN");
						String contraseña = resultado.getString("password");

						if (nanCode.equals(username) && contraseña.equals(password)) {
							validacion = true;
							System.out.println("El codigo es valido");
							break;
						}
						if (resultado.next() == false) {
							validacion = false;
							System.out.println("El codigo es invalido");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
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

				while (resultado.next()) {// Mientras que exista resultado es decir si el resultado es TRUE
					String nanCode = resultado.getString("NAN");
					String contraseña = resultado.getString("password");

					if (nanCode.equals(username) && contraseña.equals(password)) {
						validacion = true;
						System.out.println("El codigo es valido");
						break;
					}
				}
				if (resultado.next() == false) {
					validacion = false;
					System.out.println("El codigo es invalido");
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
				String consulta = "SELECT NAN, password FROM second_life.langileak WHERE NAN ='"+username+"'";
				Statement statement = conexion.createStatement();
				ResultSet resultado = statement.executeQuery(consulta);
				while (resultado.next()) {
					
					String nanCode = resultado.getString("NAN");
					String contraseña = resultado.getString("password");
					
					if (nanCode.equals(username) && contraseña.equals(password)) {
						validacion = true;
						System.out.println("El codigo es valido");
						break;
					}
				}
				if (resultado.next() == false) {
					System.out.println("El codigo no es valido");
					validacion = false;
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
		return validacion;
	}
}
