package logica;

public class Combo {

	private int numerocombo;
	private String nombrecombo;
	private int preciocombo;
	private String producto1;
	private String producto2;
	private String producto3;

	
	
	
	public int getNumerocombo() {
		return numerocombo;
	}
	public void setNumerocombo(int numerocombo) {
		this.numerocombo = numerocombo;
	}
	public String getNombrecombo() {
		return nombrecombo;
	}
	public void setNombrecombo(String nombrecombo) {
		this.nombrecombo = nombrecombo;
	}
	public int getPreciocombo() {
		return preciocombo;
	}
	public void setPreciocombo(int preciocombo) {
		this.preciocombo = preciocombo;
	}
	public String getProducto1() {
		return producto1;
	}
	public void setProducto1(String producto1) {
		this.producto1 = producto1;
	}
	public String getProducto2() {
		return producto2;
	}
	public void setProducto2(String producto2) {
		this.producto2 = producto2;
	}
	public String getProducto3() {
		return producto3;
	}
	public void setProducto3(String producto3) {
		this.producto3 = producto3;
	}
	
	public Combo(int numerocombo, String nombrecombo, int preciocombo, String producto1, String producto2,String producto3) {
		this.numerocombo = numerocombo;
		this.nombrecombo = nombrecombo;
		this.preciocombo = preciocombo;
		this.producto1 = producto1;
		this.producto2 = producto2;
		this.producto3 = producto3;
	}
	
	
}
	

