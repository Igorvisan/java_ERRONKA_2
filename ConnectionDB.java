package secondlife_App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDB {
	private static final String url = "jdbc:mysql://localhost:3306/secondLife";
	private static final String controlador = "com.mysql.cj.jdbc.Driver";
	private static final String usuario = "root";
	private static final String password = "1WMG2023";

	public static Connection obtenerConexion() {
		Connection conexion = null;
		try {
			Class.forName(controlador);
			conexion = DriverManager.getConnection(url, usuario, password);

			if (conexion != null) {
				System.out.println("Conexión realizada con éxito");
			} else {
				System.out.println("La conexión es nula");
			}
		} catch (Exception e) {
			System.out.println("Error al conectar a la base de datos:");
			e.printStackTrace();
		}
		return conexion;
	}
}
