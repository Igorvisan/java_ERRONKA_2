package secondlife_App;

import java.sql.Connection;

public class Bezeroak extends Usuarioak {
	
	private String hiria;
	private String probintzia;
	private String herrialdea;
	private int PK;
	private static ConnectionDB connectionDB;
	
	
	

	public String getHiria() {
		return hiria;
	}




	public void setHiria(String hiria) {
		this.hiria = hiria;
	}




	public String getProbintzia() {
		return probintzia;
	}




	public void setProbintzia(String probintzia) {
		this.probintzia = probintzia;
	}




	public String getHerrialdea() {
		return herrialdea;
	}




	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}




	public int getPK() {
		return PK;
	}




	public void setPK(int pK) {
		PK = pK;
	}




	public Bezeroak() {	
		
	}




	public Bezeroak(String hiria, String probintzia, String herrialdea, int pK) {
		super();
		this.hiria = hiria;
		this.probintzia = probintzia;
		this.herrialdea = herrialdea;
		this.PK = pK;
		
	}




	@Override
	public String toString() {
		return "Bezeroak [hiria=" + hiria + ", probintzia=" + probintzia + ", herrialdea=" + herrialdea + ", PK=" + PK
				+ "]";
	}
	
	
}
