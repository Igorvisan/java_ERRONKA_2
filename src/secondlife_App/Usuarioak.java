/**
 * 
 */
package secondlife_App;

import java.util.Objects;

/**
 * 
 */
public abstract class Usuarioak {
	
	private String izena;
	private String emaila;
	private String abizena;
	private int telefonoa;
	private char nan;
	
	public Usuarioak(){
		
	}

	public Usuarioak(String izena, String emaila, String abizena, int telefonoa, char nan) {
		this.izena = izena;
		this.emaila = emaila;
		this.abizena = abizena;
		this.telefonoa = telefonoa;
		this.nan = nan;
	}

	@Override
	public String toString() {
		return "Usuarioak [izena=" + izena + ", emaila=" + emaila + ", abizena=" + abizena + ", telefonoa=" + telefonoa
				+ ", nan=" + nan + "]";
	}
	
	public abstract void añadirNuevoUsuario();
}
