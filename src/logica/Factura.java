package logica;

import java.util.ArrayList;
import java.util.Date;

import logica.TipoPedido;
import logica.Ingredientes;
@SuppressWarnings("unused")
public class Factura {
	
	private int numero;
	private Date hora;
	private Date fecha;
	private int valorTotal;
	private Cajero cajero;
	private ArrayList<FacturaPedido> facturaPedidos;
	
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
	public ArrayList<FacturaPedido> getFacturaPedidos() {
		return facturaPedidos;
	}
	public void setFacturaProductos(ArrayList<FacturaPedido> facturaPedidos) {
		this.facturaPedidos = facturaPedidos;
	}
	public Factura(int numero, Date fecha, Cajero cajero) {
		super();
		this.fecha = fecha;
		this.cajero = cajero;
		this.facturaPedidos = new ArrayList<FacturaPedido>();
	}
	public void calcularTotal() {
		int total = 0;
		for(FacturaPedido facturaPedido : this.facturaPedidos) {
			total += facturaPedido.getPrecio() * facturaPedido.getCantidad();
		}
		this.valorTotal = total;

	}
	public void adicionarPedido(Pedido pedido, int cantidad) {
		FacturaPedido facturaPedido = new FacturaPedido(cantidad, pedido.getPrecioVenta(), pedido);
		this.facturaPedidos.add(facturaPedido);		
	}
	public void adicionarIngredientes (FacturaPedido ingrediente, int p, int c, int q) {
		Ingredientes ingredientes = new  Ingredientes ();
		this.facturaPedidos.add(ingrediente);
	}
}


