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
	private ArrayList<Producto> productos;
	
	public Restaurante() {
		this.cajeros = new ArrayList<Cajero>();
		this.facturas = new ArrayList<Factura>();
		 this.combos = new ArrayList<Combo>();
		    this.ingredientes = new ArrayList<Ingrediente>();
		    this.productos = new ArrayList<Producto>();
	}

	public void leerArchivos() {
		ArrayList<String> lineas;
		lineas = Archivo.leerArchivo("cajero.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarCajero(Integer.parseInt(datos[0]), datos[1], datos[2]);
		}		
		lineas = Archivo.leerArchivo("producto");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarProducto(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]));
		}
		lineas = Archivo.leerArchivo("combo");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarCombo(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]),Integer.parseInt (datos[3]),Integer.parseInt(datos[4]),Integer.parseInt (datos[5]));
		}
		lineas = Archivo.leerArchivo("ingrediente");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarIngrediente(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]));
		
		}
		
	}

	private void ingresarIngrediente(int numeroingrediente, String nombreingrediente, int precioingrediente) {
		// TODO Auto-generated method stub
		Ingrediente ingrediente = new Ingrediente(numeroingrediente,nombreingrediente, precioingrediente);
		this.ingredientes.add(ingrediente);
	}
	












	private void ingresarCombo(int numerocombo , String nombrecombo , int preciocombo, int producto1, int producto2,int producto3){
		
		Combo combo = new Combo(numerocombo,nombrecombo,preciocombo,producto1,producto2,producto3);
		this.combos.add(combo);	
	}











	
	

	private void ingresarProducto(int numerodeelccion, String nombrep, int precioVenta) {
	
		Producto producto = new Producto(numerodeelccion,nombrep,precioVenta);
		this.productos.add(producto);	
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
			Combo combo = this.buscarCombo(datos[0]);
			factura.adicionarProducto(producto,combo, datos[1]);
		
		}
		factura.calcularTotal();
		this.facturas.add(factura);
	}
	

	private Producto buscarProducto(int idProducto) {
	    for (Producto producto : this.productos) {
	        if (producto.getNumeroDeEleccion() == idProducto) {
	            return producto; // Producto encontrado
	        }
	    }
	    return null; // Producto no encontrado
	}
	private Combo buscarCombo(int idCombo) {
	    for (Combo combo : this.combos) {
	        if (combo.getNumerocombo() == idCombo) {
	            return combo; // Producto encontrado
	        }
	    }
	    return null; // Producto no encontrado
	}











	
	
	private Cajero buscarCajero(int idCajero) {
		for(Cajero cajero : this.cajeros) {
			if(cajero.getId() == idCajero) {
				return cajero;
			}
		}
		return null;
	}

	public void imprimirFacturas(ArrayList<int[]> productosPedidos, ArrayList<int[]> combosPedidos) {
	    for (Factura factura : this.facturas) {
	        System.out.println("-------");
	        System.out.println(factura.getNumero() + " FECHA: " + factura.getFecha() + "\n" + " VALOR TOTAL: " + factura.getValorTotal() + "\n" + " NOMBRE CAJERO: " + factura.getCajero().getNombre());
	        for (FacturaProducto facturaProducto : factura.getFacturaProductos()) {
	            System.out.println(" PEDIDO: " + facturaProducto.getProducto().getNombrep() + "\n" + " CANTIDAD: " + facturaProducto.getCantidad() + "\n" + " PRECIO UND: " + facturaProducto.getPrecio());
	        }
	    }
	}

	public void modificarProducto(int numeroespecialidad, int numerodeleccion,int precioVenta) {
		if (numeroespecialidad == 10) {
			System.out.println("No se pueden modificar combos, (solo hamburguesas");
		}
		else if(numerodeleccion == 21 || numerodeleccion == 22 || numerodeleccion == 23) {
}

	}

	
}
