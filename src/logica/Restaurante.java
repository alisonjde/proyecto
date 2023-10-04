package logica;

import java.util.ArrayList;
import java.util.Date;
import persistencia.Archivo;

import java.util.Scanner;

@SuppressWarnings("unused")
public class Restaurante {
	private ArrayList<TipoPedido> tipoPedidos;
	private ArrayList<Cajero> cajeros;
	private ArrayList<Factura> facturas;
	
	
	public Restaurante() {
		this.tipoPedidos = new ArrayList<TipoPedido>();
		this.cajeros = new ArrayList<Cajero>();
		this.facturas = new ArrayList<Factura>();
	}

	public void ingresarTipopedido(int numeroespecialidad, String nombre) {
		TipoPedido tipoPedido = new TipoPedido(numeroespecialidad, nombre);		
		this.tipoPedidos.add(tipoPedido);
	}

	public void ingresarPedido(int numeroespecialidadTipoPedido, int numerodeeleccion, String nombre,int precioVenta) {
		TipoPedido tipoPedido = this.buscarTipoPedido(numeroespecialidadTipoPedido);
		if(tipoPedido != null) {
			tipoPedido.ingresarPedido(numerodeeleccion, nombre,precioVenta);
		}
		
	}

	private TipoPedido buscarTipoPedido(int numeroespecialidadTipoPedido) {
		for(TipoPedido tipoPedido : this.tipoPedidos) {
			if(tipoPedido.getId() == numeroespecialidadTipoPedido) {
				return tipoPedido;
			}
		}
		return null;
	}
	public void leerArchivos() {
		ArrayList<String> lineas;
		lineas = Archivo.leerArchivo("tipoPedido.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarTipopedido(Integer.parseInt(datos[0]), datos[1]);
		}
		lineas = Archivo.leerArchivo("cajero.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarCajero(Integer.parseInt(datos[0]), datos[1], datos[2]);
		}		
		lineas = Archivo.leerArchivo("pedido.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarPedido(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]));
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
			Pedido pedido = this.buscarPedido(datos[0]);
			factura.adicionarPedido(pedido, datos[1]);
		}
		factura.calcularTotal();
		this.facturas.add(factura);
	}
	
	private Pedido buscarPedido(int numeroespecialidadPedido) {
		for(TipoPedido tipoPedido : this.tipoPedidos) {
			for(Pedido pedido : tipoPedido.getPedidos()) {
				if(pedido.getNumeroDeEleccion() == numeroespecialidadPedido) {
					return pedido;
				}
			}
		}
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
			for(FacturaPedido facturaPedido : factura.getFacturaPedidos()) {
				System.out.println(" PEDIDO: " +facturaPedido.getPedido().getNombrep()+ "\n"  + " CANTIDAD: " + facturaPedido.getCantidad() + "\n" + " PRECIO UND: " + facturaPedido.getPrecio());
			}
		}
		
	}
	
	public void imprimirPedidos() {
		for(TipoPedido tipoPedido : this.tipoPedidos) {
			for(Pedido pedido : tipoPedido.getPedidos()) {
				System.out.println("Tipo: " + tipoPedido.getNombrec());
				System.out.println("Numero De Eleccion: " + pedido.getNumeroDeEleccion());
				System.out.println("Nombre: " + pedido.getNombrep());
				System.out.println("Precio Venta: " + pedido.getPrecioVenta());
				System.out.println("-----------");
			}
		}
		
	}

	public void ingresarTipoPedido(int numeroespecialidad, String nombre) {
		TipoPedido tipoPedido = new TipoPedido(numeroespecialidad, nombre);		
		this.tipoPedidos.add(tipoPedido);
	}
	public void modificarPedido(int numeroespecialidad, int numerodeleccion,int precioVenta) {
		if (numeroespecialidad == 10) {
			System.out.println("No se pueden modificar combos, (solo hamburguesas");
		}
		else if(numerodeleccion == 21 || numerodeleccion == 22 || numerodeleccion == 23) {
}

	}
}
