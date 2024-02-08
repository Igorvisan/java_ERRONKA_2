package secondlife_App;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Hornitzaileak extends Usuarioak {
	
	private int id;
	private String empresa;
	private String emaila;
	private int telefonoZenbakia;
	private String kontuZenbakia;
	private String gehigarriak;
	private static ConnectionDB connectionDB;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmpresa() {
		return empresa;
	}



	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}



	public String getEmaila() {
		return emaila;
	}



	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}



	public int getTelefonoZenbakia() {
		return telefonoZenbakia;
	}



	public void setTelefonoZenbakia(int telefonoZenbakia) {
		this.telefonoZenbakia = telefonoZenbakia;
	}



	public String getKontuZenbakia() {
		return kontuZenbakia;
	}



	public void setKontuZenbakia(String kontuZenbakia) {
		this.kontuZenbakia = kontuZenbakia;
	}



	public String getGehigarriak() {
		return gehigarriak;
	}



	public void setGehigarriak(String gehigarriak) {
		this.gehigarriak = gehigarriak;
	}
	
	
	
	public Hornitzaileak() {
		
	}



	public Hornitzaileak(int id, String empresa, String emaila, int telefonoZenbakia, String kontuZenbakia,
			String gehigarriak) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.emaila = emaila;
		this.telefonoZenbakia = telefonoZenbakia;
		this.kontuZenbakia = kontuZenbakia;
		this.gehigarriak = gehigarriak;
	}



	@Override
	public String toString() {
		return "Hornitzaileak [id=" + id + ", empresa=" + empresa + ", emaila=" + emaila + ", telefonoZenbakia="
				+ telefonoZenbakia + ", kontuZenbakia=" + kontuZenbakia + ", gehigarriak=" + gehigarriak + "]";
	}
	
	public void eliminarHornitzaile(String empresa) {
		Connection conexion = connectionDB.obtenerConexion();
		
		String orden = "DELETE FROM second_life.hornitzaileak WHERE Enpresa = '" + empresa + "'";
		
		try {
			PreparedStatement statement = conexion.prepareStatement(orden);
			if(statement.execute(orden) == false) {
				JOptionPane.showMessageDialog(null, "El Proveedor ha sido eliminado correctamente");
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
		
		
	}
}
