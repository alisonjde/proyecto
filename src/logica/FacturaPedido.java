package logica;

public class FacturaPedido {
	private int cantidad;
	private int precioventa;
	
	private Pedido pedido;
	
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
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public FacturaPedido(int cantidad, int precioventa, Pedido pedido) {
		super();
		this.cantidad = cantidad;
		this.precioventa = precioventa;
		this.pedido = pedido;
	}

}
