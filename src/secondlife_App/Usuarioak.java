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
	private String telefonoa;
	private String NAN;
	
	public String getEmaila() {
		return emaila;
	}

	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(String telefonoZenbakia) {
		this.telefonoa = telefonoZenbakia;
	}

	public Usuarioak(){
		
	}

	public Usuarioak(String izena, String emaila, String abizena, String telefonoa, String NAN) {
		this.setIzena(izena);
		this.emaila = emaila;
		this.abizena = abizena;
		this.telefonoa = telefonoa;
		this.NAN = NAN;
	}

	public String getNAN() {
		return NAN;
	}

	public void setNAN(String nAN) {
		NAN = nAN;
	}

	@Override
	public String toString() {
		return "Usuarioak [izena=" + getIzena() + ", emaila=" + emaila + ", abizena=" + abizena + ", telefonoa=" + telefonoa
				+ ", nan=" + NAN + "]";
	}

	protected String getIzena() {
		return izena;
	}

	protected void setIzena(String izena) {
		this.izena = izena;
	}
	
}
