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
	private ArrayList<Combo> facturaCombos;
	
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
		this.facturaCombos = new ArrayList<Combo>();
	}
	public void calcularTotal() {
		int total = 0;
		for(FacturaProducto facturaProducto : this.facturaProductos) {
			total += facturaProducto.getPrecio() * facturaProducto.getCantidad() ;
		}
		this.valorTotal = total;
		 // + modificar pedido
	}
	public void adicionarProducto(Producto producto, Combo combo, int cantidad) {
	    if (producto != null) {
	        FacturaProducto facturaProducto = new FacturaProducto(producto.getPrecioVenta(), cantidad, combo, producto);
	        this.facturaProductos.add(facturaProducto);
	    } else {
	        // Manejar el caso en el que el producto no se encontró
	        System.out.println("El producto no se encontró.");
	    }
	}

	public ArrayList<Combo> getFacturaCombos() {
		return facturaCombos;
	}
	public void setFacturaCombos(ArrayList<Combo> facturaCombos) {
		this.facturaCombos = facturaCombos;
	}

}
