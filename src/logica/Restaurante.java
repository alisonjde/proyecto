package logica;

import java.util.ArrayList;
import java.util.Date;
import persistencia.Archivo;

import java.util.Scanner;

@SuppressWarnings("unused")
public class Restaurante {

	private ArrayList<Combo> combos;
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
		lineas = Archivo.leerArchivo("producto.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarProducto(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]));
		}
		lineas = Archivo.leerArchivo("combo.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarCombo(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]),datos[3],datos[4],datos[5]);
		}
	
	}

	private void ingresarCombo(int numerocombo , String nombrecombo , int preciocombo, String producto1, String producto2,String producto3){
		// TODO Auto-generated method stub
		
		
		
	}











	
	

	private void ingresarProducto(int numerodeelccion, String nombrep, int precioVenta) {
		// TODO Auto-generated method stub
		
		
		
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
			Producto producto = this.buscarProducto(datos[0]);
			factura.adicionarPedido(producto, datos[1]);
		}
		factura.calcularTotal();
		this.facturas.add(factura);
	}
	

	private Producto buscarProducto(int i) {
		// TODO Auto-generated method stub
		return null;
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
			for(FacturaProducto facturaPedido : factura.getFacturaProductos()) {
				System.out.println(" PEDIDO: " +facturaPedido.getPedido().getNombrep()+ "\n"  + " CANTIDAD: " + facturaPedido.getCantidad() + "\n" + " PRECIO UND: " + facturaPedido.getPrecio());
			}
		}
		// a setprecio vamos a pasarle el entero que sacamos de modificar pedido 
	}
	

	public void modificarProducto(int numeroespecialidad, int numerodeleccion,int precioVenta) {
		if (numeroespecialidad == 10) {
			System.out.println("No se pueden modificar combos, (solo hamburguesas");
		}
		else if(numerodeleccion == 21 || numerodeleccion == 22 || numerodeleccion == 23) {
}

	}
}
