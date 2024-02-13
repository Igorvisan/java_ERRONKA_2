package secondlife_App;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Cesta {
	
	private int idCesta;
	private String nanBezeroa;
	private String egoera;
	private static ConnectionDB connectionDB;
	
	public Cesta() {
		
	}
	
	
	public int getIdCesta() {
		return idCesta;
	}
	public void setIdCesta(int idCesta) {
		this.idCesta = idCesta;
	}
	public String getNanBezeroa() {
		return nanBezeroa;
	}
	public void setNanBezeroa(String nanBezeroa) {
		this.nanBezeroa = nanBezeroa;
	}
	public String getEgoera() {
		return egoera;
	}
	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}
	public Cesta(int idCesta, String nanBezeroa, String egoera) {
		
		this.idCesta = idCesta;
		this.nanBezeroa = nanBezeroa;
		this.egoera = egoera;
	}
	@Override
	public String toString() {
		return "Cesta [idCesta=" + idCesta + ", nanBezeroa=" + nanBezeroa + ", egoera=" + egoera + "]";
	}
	
	public void changeState(String newState) {
		Connection conexion = connectionDB.obtenerConexion();	
		
		String orden = "UPDATE second_life.cesta SET Estado = ? WHERE id_cesta = ?";
		
		try(PreparedStatement statement = conexion.prepareStatement(orden)){
			
			statement.setString(1, newState);
			statement.setInt(2, this.getIdCesta());
			
			 int rowsUpdated = statement.executeUpdate();
			 
			 if(rowsUpdated > 0) {
				 JOptionPane.showMessageDialog(null, "Los datos se han acutualizado correctamente");
			 }else {
				 JOptionPane.showMessageDialog(null, "No se pudo actualizar el estado.");
			 }
			
		}catch(Exception error) {
			JOptionPane.showMessageDialog(null, error);
		}
		
		
	}	

}
