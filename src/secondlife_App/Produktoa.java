package secondlife_App;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Produktoa {
	
	private int id;
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
	private static ConnectionDB connectionDB;
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public Produktoa() {
		
	}
	

	public Produktoa(int id, String produktua, double prezioa, String marca, boolean stock, int stockKantitatea,
			double produktuaren_KG, double iritzia, String deskribapena, String irudiak, boolean tendentziak) {
		super();
		this.id = id;
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
	
	public void guardarProducto() {
        Connection conexion = connectionDB.obtenerConexion();
        System.out.println("Inserte los datos para añadir un nuevo producto ");

        String orden = "INSERT INTO second_life.biltegia (Produktua, Prezioa, Marca, Stock, Stock_kantitatea, Produktuaren_KG, Iritzia, Deskribapena, imagenes, tendencia) " +
                "VALUES (?, ?, ?, true, ?, ?, ?, ?, ?, false)";

        try (PreparedStatement statement = conexion.prepareStatement(orden)) {
            statement.setString(1, this.getProduktua());
            statement.setDouble(2, this.getPrezioa());
            statement.setString(3, this.getMarca());
            statement.setInt(4, this.getStockKantitatea());
            statement.setDouble(5, this.getProduktuaren_KG());
            statement.setDouble(6, this.getIritzia());
            statement.setString(7, this.getDeskribapena());
            statement.setString(8, this.getIrudiak());

            if (statement.execute() == false) {
                JOptionPane.showMessageDialog(null, "Se han insertado los datos correctamente");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	public void guardarCambioProducto() {
		Connection conexion = connectionDB.obtenerConexion();
		
		String orden = "UPDATE second_life.biltegia SET Produktua=?, Prezioa=?, Marca=?, Stock=?, Stock_kantitatea=?, Produktuaren_KG=?, Iritzia=?, Deskribapena=?, imagenes=?, tendencia=? WHERE id= '"+this.getId()+"'";
		
		try(PreparedStatement statement = conexion.prepareStatement(orden)){
			
		    statement.setString(1, this.getProduktua());
		    statement.setDouble(2, this.getPrezioa());
		    statement.setString(3, this.getMarca());
		    statement.setBoolean(4, this.isStock());
		    statement.setInt(5, this.getStockKantitatea());
		    statement.setDouble(6, this.getProduktuaren_KG());
		    statement.setDouble(7, this.getIritzia());
		    statement.setString(8, this.getDeskribapena());
		    statement.setString(9, this.getIrudiak());
		    statement.setBoolean(10, this.isTendentziak());
			
			if(statement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Se han insertado los datos correctamente");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}finally {
			try {
				conexion.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

