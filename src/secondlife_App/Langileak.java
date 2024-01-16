/**
 * 
 */
package secondlife_App;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 
 */
public class Langileak extends Usuarioak {
	
	private String departamentua;
	private int appKodea;
	private String kontuKorrontea;
	private boolean balidazionAdministrazioa;
	private boolean langileArduradunak;
	private ConnectionDB connectionDB;
	
	public Langileak() {
		this.connectionDB = new ConnectionDB();
	}

	public String getDepartamentua() {
		return departamentua;
	}

	public void setDepartamentua(String departamentua) {
		this.departamentua = departamentua;
	}

	public int getAppKodea() {
		return appKodea;
	}

	public void setAppKodea(int appKodea) {
		this.appKodea = appKodea;
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

	@Override
	public void añadirNuevoUsuario() {
		
	}
	
	public Langileak(String departamentua, int appKodea, String kontuKorrontea, boolean balidazionAdministrazioa,
			boolean langileArduradunak) {
		this.departamentua = departamentua;
		this.appKodea = appKodea;
		this.kontuKorrontea = kontuKorrontea;
		this.balidazionAdministrazioa = balidazionAdministrazioa;
		this.langileArduradunak = langileArduradunak;
	}
	
	public boolean confirmarAdmistrador(int contraseña) { //Le pasamo el un parametro para que luego pueda usarlo en el main como dato para los metodos
		contraseña = Inicio.empleadoIniciarSesion();//Con esta linea llamamos a la funcion empleadoIniciarSesion() que existe en la clase Inicio y podemos usar sus datos retorm
	    Connection conexion = connectionDB.obtenerConexion();
	    boolean validacion = true;

	    if (conexion != null) {
	        try {
	            String consulta = "SELECT app_kodea FROM secondLife.langileak";
	            try (Statement statement = conexion.createStatement()) {
	                ResultSet resultado = statement.executeQuery(consulta);
	                while (resultado.next()) {
	                	int codigoDeApp = resultado.getInt("app_kodea");
	                	
	                	if(codigoDeApp == contraseña) {
	                		validacion = true;
	                		System.out.println("El codigo es valido");
	                	}else {
	                		System.out.println("El codigo no coincide");
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
		return validacion;
	}
	public boolean confirmarLangileArduraduna(int contraseña) {
		contraseña = Inicio.empleadoIniciarSesion();
		Connection conexion = connectionDB.obtenerConexion();
		boolean validacion = false;
		
		if(conexion != null) {
			try {
				String consulta = "SELECT app_kodea FROM secondLife.langileak";
				Statement statement = conexion.createStatement();
				ResultSet resultado = statement.executeQuery(consulta);
				
				while(resultado.next()) {//Mientras que exista resultado es decir si el resultado es TRUE
					int codigoDeApp = resultado.getInt("app_kodea");
					
					if(codigoDeApp == contraseña) {
						validacion = true;
						System.out.println("El codigo es valido");
					}else {
						System.out.println("El codigo no es valido");
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conexion.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return validacion;		
	}
	public boolean confirmarEmpleadoNormal(int contraseña) {
		contraseña = Inicio.empleadoIniciarSesion();
		Connection conexion = ConnectionDB.obtenerConexion();
		boolean validacion = false;
		
		if(conexion != null) {
			try {
				String consulta = "SELECT app_kodea FROM secondLife.langileak";
				Statement statement = conexion.createStatement();
				ResultSet resultado = statement.executeQuery(consulta);
				
				while(resultado.next()) {
					int codigoDeApp = resultado.getInt("app_kodea");
					
					if(codigoDeApp == contraseña) {
						validacion = true;
						System.out.println("El codigo es valido");
					}else {
						System.out.println("El codigo no es valido");
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conexion.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return validacion;
	}
}
