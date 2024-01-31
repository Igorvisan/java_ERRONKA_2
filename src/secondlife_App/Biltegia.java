package secondlife_App;

public class Biltegia {
	
	private String produktua;
	private double prezioa;
	private String marca;
	private boolean stock;
	private int stockKantitatea;
	private double produktuaren_KG;
	private double iritzia;
	private String deskribapena;
	private String irudiak;
	private boolean tendentziak;
	
	
	public String getProduktua() {
		return produktua;
	}
	public void setProduktua(String produktua) {
		this.produktua = produktua;
	}
	public double getPrezioa() {
		return prezioa;
	}
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public boolean isStock() {
		return stock;
	}
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	public int getStockKantitatea() {
		return stockKantitatea;
	}
	public void setStockKantitatea(int stockKantitatea) {
		this.stockKantitatea = stockKantitatea;
	}
	public double getProduktuaren_KG() {
		return produktuaren_KG;
	}
	public void setProduktuaren_KG(double produktuaren_KG) {
		this.produktuaren_KG = produktuaren_KG;
	}
	public double getIritzia() {
		return iritzia;
	}
	public void setIritzia(double iritzia) {
		this.iritzia = iritzia;
	}
	public String getDeskribapena() {
		return deskribapena;
	}
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	public String getIrudiak() {
		return irudiak;
	}
	public void setIrudiak(String irudiak) {
		this.irudiak = irudiak;
	}
	public boolean isTendentziak() {
		return tendentziak;
	}
	public void setTendentziak(boolean tendentziak) {
		this.tendentziak = tendentziak;
	}
	
	public Biltegia() {
		
	}
	
	public Biltegia(String produktua, double prezioa, String marca, boolean stock, int stockKantitatea,
			double produktuaren_KG, double iritzia, String deskribapena, String irudiak, boolean tendentziak) {
		super();
		this.produktua = produktua;
		this.prezioa = prezioa;
		this.marca = marca;
		this.stock = stock;
		this.stockKantitatea = stockKantitatea;
		this.produktuaren_KG = produktuaren_KG;
		this.iritzia = iritzia;
		this.deskribapena = deskribapena;
		this.irudiak = irudiak;
		this.tendentziak = tendentziak;
	}
	@Override
	public String toString() {
		return "Biltegia [produktua=" + produktua + ", prezioa=" + prezioa + ", marca=" + marca + ", stock=" + stock
				+ ", stockKantitatea=" + stockKantitatea + ", produktuaren_KG=" + produktuaren_KG + ", iritzia="
				+ iritzia + ", deskribapena=" + deskribapena + ", irudiak=" + irudiak + ", tendentziak=" + tendentziak
				+ "]";
	}
	
	

}
