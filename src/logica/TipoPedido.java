package logica;

import java.util.ArrayList;

public class TipoPedido {

	private int numeroespecialidad;
	private String nombrec;
	private ArrayList<Pedido> pedidos;
	
	public int getId() {
		return numeroespecialidad;
	}
	public void setId(int numeroespecialidad) {
		this.numeroespecialidad = numeroespecialidad;
	}
	
	public int getNumeroespecialidad() {
		return numeroespecialidad;
	}
	public void setNumeroespecialidad(int numeroespecialidad) {
		this.numeroespecialidad = numeroespecialidad;
	}

	public String getNombrec() {
		return nombrec;
	}
	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public TipoPedido(int numeroespecialidad, String nombrec) {
		this.numeroespecialidad = numeroespecialidad;
		this.nombrec = nombrec;
		this.pedidos = new ArrayList<Pedido>();
	}
	public void ingresarPedido(int numerodeeleccion, String nombrec, int precioVenta) {
		Pedido pedido = new Pedido(numerodeeleccion, nombrec,precioVenta);
		this.pedidos.add(pedido);		
	}	
	
}
