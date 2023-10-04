package logica;

public class Pedido {
	private int numerodeeleccion;
	private String nombrep;
	private int precioVenta;
	public int getNumeroDeEleccion() {
		return numerodeeleccion;
	}
	public void setNumeroDeEleccion(int numerodeeleccion) {
		this.numerodeeleccion = numerodeeleccion;
	}
	
	public String getNombrep() {
		return nombrep;
	}
	
	public void setNombrep(String nombrep) {
		this.nombrep = nombrep;
	}
	
	public int getPrecioVenta() {
		return precioVenta;
	}
	
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	public Pedido(int numerodeeleccion, String nombrep, int precioVenta) {
		this.numerodeeleccion = numerodeeleccion;
		this.nombrep = nombrep;
		this.precioVenta = precioVenta;

	}
}
