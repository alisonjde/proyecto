package presentacion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import logica.Restaurante;

public class Principal {
	

private Restaurante restaurante;
	
	public Principal() {
		this.restaurante = new Restaurante();

	}

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.iniciar();
	}
	private void iniciar() {
		Scanner sc = new Scanner(System.in);
		int op;
		 ArrayList<int[]> productosPedidos = new ArrayList<>();
		 ArrayList<int[]> combosPedidos = new ArrayList<>();
		do {
			System.out.println("***HAMBURGUESERIA***\n");
			System.out.println("Digite una opcion:\n"
					+ "0. Salir del menu\n"
					+ "1. Ingresar  Producto\n"
					+ "2. Ingresar Cajero\n"
					+ "3. Imprimir Facturas\n"
					+ "4. Ingresar Factura\n"
			        + "5. Imprimir Menu\n"
			        + "6. leer archivos\n"
			        + "7. modificar producto\n");
			op = sc.nextInt();
			if(op == 1) {
				System.out.println("Digite numero de eleccion: ");
				int numerodeeleccion = sc.nextInt();
				System.out.println("Digite nombre: ");
				String nombrep = sc.next();				
				System.out.println("Digite precio: ");
				String precioVenta = sc.next();								
				this.restaurante.ingresarCajero(numerodeeleccion, nombrep,precioVenta);
		     }else if(op == 2) {
				System.out.println("Digite id: ");
				int id = sc.nextInt();
				System.out.println("Digite nombre: ");
				String nombre = sc.next();				
				System.out.println("Digite apellido: ");
				String apellido = sc.next();								
				this.restaurante.ingresarCajero(id, nombre, apellido);	
			}else if(op == 3) {
				 this.restaurante.imprimirFacturas(productosPedidos, productosPedidos);
			}else if(op == 4) {
				System.out.println("Digite id del Cajero: ");
				int idCajero = sc.nextInt();
				System.out.println("Digite la fecha: ");
				String fechaTexto = sc.next();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = null;
				try {
					fecha = dateFormat.parse(fechaTexto);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
				int otroProducto;
				@SuppressWarnings("unused")
				ArrayList<int[]> productosComprados = new ArrayList<int[]>();
				do {
					
					int datos[] = new int[2];
					System.out.println("Digite id del pedido: ");
					int numerodeeleccion = sc.nextInt();
					System.out.println("Digite cantidad del pedido: ");
					int cantidadPedido = sc.nextInt();
					datos[0] = numerodeeleccion;
					datos[1] = cantidadPedido;
					productosComprados.add(datos);					
					System.out.println("Desea ingresar otro producto?\n"
							+ "1. Si\n"
							+ "2. No\n");
					otroProducto = sc.nextInt();
				}while(otroProducto == 1);
				this.restaurante.ingresarFactura(idCajero,fecha,productosComprados);
			}else if (op == 5) {
			        this.restaurante.mostrarListaCombos();
			    
			}else if(op== 6) {
				this.restaurante.leerArchivos();
			}else if(op == 7) {
				this.restaurante.modificarProducto();
			}
			}while(op != 0);
			sc.close();
			this.restaurante.imprimirFacturas(productosPedidos, combosPedidos);
  }


}