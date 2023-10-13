package logica;

public class FacturaPedido {
	private int cantidad;
	private int precioventa;
	
	private Producto producto;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precioventa;
	}
	public void setPrecio(int precio) {
		this.precioventa = precio;
	}
	public Producto getPedido() {
		return producto;
	}
	public void setPedido(Producto pedido) {
		this.producto = pedido;
	}
	public FacturaPedido(int cantidad, int precioventa, Producto pedido) {
		super();
		this.cantidad = cantidad;
		this.precioventa = precioventa;
		this.producto = pedido;
	}

}
