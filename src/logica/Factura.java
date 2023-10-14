package logica;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	
	private int numero;
	private Date hora;
	private Date fecha;
	private int valorTotal;
	private Cajero cajero;
	private ArrayList<FacturaProducto> facturaProductos;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public int getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Cajero getCajero() {
		return cajero;
	}
	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}
	public ArrayList<FacturaProducto> getFacturaProductos() {
		return facturaProductos;
	}
	public void setFacturaProductos(ArrayList<FacturaProducto> facturaProductos) {
		this.facturaProductos = facturaProductos;
	}
	public Factura(int numero, Date fecha, Cajero cajero) {
		super();
		this.fecha = fecha;
		this.cajero = cajero;
		this.facturaProductos = new ArrayList<FacturaProducto>();
	}
	public void calcularTotal() {
		int total = 0;
		for(FacturaProducto facturaPedido : this.facturaProductos) {
			total += facturaPedido.getPrecio() * facturaPedido.getCantidad();
		}
		this.valorTotal = total;
		 // + modificar pedido
	}
	public void adicionarPedido(Producto producto, int cantidad) {
		FacturaProducto facturaPedido = new FacturaProducto(cantidad, producto.getPrecioVenta(), producto);
		this.facturaProductos.add(facturaPedido);		
	}

}


