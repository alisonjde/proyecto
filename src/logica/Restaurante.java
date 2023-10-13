package logica;

import java.util.ArrayList;
import java.util.Date;
import persistencia.Archivo;

import java.util.Scanner;

@SuppressWarnings("unused")
public class Restaurante {

	private ArrayList<Cajero> cajeros;
	private ArrayList<Factura> facturas;
	private ArrayList<Ingrediente> ingredientes;
	
	public Restaurante() {
		this.cajeros = new ArrayList<Cajero>();
		this.facturas = new ArrayList<Factura>();
	}


		
	
	
	
	


		

	
	public void leerArchivos() {
		ArrayList<String> lineas;
		lineas = Archivo.leerArchivo("cajero.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarCajero(Integer.parseInt(datos[0]), datos[1], datos[2]);
		}		
		lineas = Archivo.leerArchivo("pedido.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarProducto(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]));
		}

		
		
		
	}

	public void ingresarCajero(int id, String nombre, String apellido) {
		Cajero cajero = new Cajero(id, nombre, apellido);
		this.cajeros.add(cajero);
	}
	public void ingresarFactura(int idCajero, Date fecha, ArrayList<int[]> productosComprados) {
		Cajero cajero = this.buscarCajero(idCajero);
		int numero = this.facturas.size() + 1;
		Factura factura = new Factura(numero, fecha, cajero);
		for(int[] datos : productosComprados) {
			Producto producto = this.buscarPedido(datos[0]);
			factura.adicionarPedido(producto, datos[1]);
		}
		factura.calcularTotal();
		this.facturas.add(factura);
	}
	

	private Cajero buscarCajero(int idCajero) {
		for(Cajero cajero : this.cajeros) {
			if(cajero.getId() == idCajero) {
				return cajero;
			}
		}
		return null;
	}

	public void imprimirFacturas() {
		for(Factura factura : this.facturas) {
			System.out.println("-------");
			System.out.println(factura.getNumero() + " FECHA: " + factura.getFecha()+ " VALOR TOTAL: "+ factura.getValorTotal() + "\n" + " NOMBRE CAJERO: "+ factura.getCajero().getNombre());
			for(FacturaPedido facturaPedido : factura.getFacturaPedidos()) {
				System.out.println(" PEDIDO: " +facturaPedido.getPedido().getNombrep()+ "\n"  + " CANTIDAD: " + facturaPedido.getCantidad() + "\n" + " PRECIO UND: " + facturaPedido.getPrecio());
			}
		}
		// a setprecio vamos a pasarle el entero que sacamos de modificar pedido 
	}
	

	public void modificarPedido(int numeroespecialidad, int numerodeleccion,int precioVenta) {
		if (numeroespecialidad == 10) {
			System.out.println("No se pueden modificar combos, (solo hamburguesas");
		}
		else if(numerodeleccion == 21 || numerodeleccion == 22 || numerodeleccion == 23) {
}

	}
}
