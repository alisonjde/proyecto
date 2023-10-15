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

	public void agregarCombo(Combo combo) {
        combos.add(combo);
	}

	 public ArrayList<Combo> getCombos() {
	        return combos;
	    }

	 public static void main(String[] args) {
	        Restaurante restaurante = new Restaurante();

	        // Agrega algunos combos de ejemplo
	        Combo combo1 = new Combo(1, "Combo Golden", 30000, 23, 26, 29);
	        Combo combo2 = new Combo(2, "Combo Silver", 22000, 25, 28, 25);
	        restaurante.agregarCombo(combo1);
	        restaurante.agregarCombo(combo2);

	        // Muestra la lista de combos al usuario
	        ArrayList<Combo> listaCombos = restaurante.getCombos();

	        System.out.println("Lista de Combos Disponibles:");
	        for (Combo combo : listaCombos) {
	            System.out.println("Número: " + combo.getNumerocombo());
	            System.out.println("Nombre: " + combo.getNombrecombo());
	            System.out.println("Contiene");
	            
	            System.out.println("Precio: " + combo.getPreciocombo());
	            System.out.println("--------------");
	        }

	        // Aquí puedes continuar con otras partes de tu aplicación
	    }
	




	
	

	private void ingresarProducto(int numerodeelccion, String nombrep, int precioVenta) {
	
		Producto producto = new Producto(numerodeelccion,nombrep,precioVenta);
		this.productos.add(producto);	
	}

	










	
	
	private Ingrediente buscarIngrediente(int numeroIngrediente) {
	    for (Ingrediente ingrediente : this.ingredientes) {
	        if (ingrediente.getNumeroingrediente()  == numeroIngrediente) {
	            return ingrediente; // Ingrediente encontrado
	        }
	    }
	    return null; // Ingrediente no encontrado
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
	
//////////////////////
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



////////////////////////////////







	
	
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


	
	public void modificarProducto() {
	
		Scanner sc = new Scanner(System.in);
		int opi;
	    System.out.println("¿Desea modificar el producto? (1. Si /2. No): ");
	    String respuesta = sc.nextLine().toLowerCase();

	    if (respuesta.equals("1")) {
	        System.out.println("Por favor, ingrese el número de elección del producto que desea modificar: ");
	        int numeroEleccion = sc.nextInt();
	        if(numeroEleccion == 12 ||numeroEleccion == 11 ||numeroEleccion == 24 || numeroEleccion == 25 || numeroEleccion == 26 || numeroEleccion == 27 || numeroEleccion == 28 || numeroEleccion == 29 || numeroEleccion == 30 ) {
	        	System.out.println("No se pueden modificar este producto");
	        	return;
	        }
	        Producto productoAModificar = buscarProducto(numeroEleccion);

	        if (productoAModificar != null) {
	            System.out.println("Producto actual: " + productoAModificar.getNombrep());
	            System.out.println("¿Desea agregar o quitar ingredientes? (1. Agregrar / 2. Quitar): ");
	            String accion = sc.next().toLowerCase();

	            if (accion.equals("1")) {
	                // Lógica para agregar ingredientes al producto
	                System.out.println("Ingrese el número del ingrediente que desea agregar:\n "
	    					+ "1. Carne -- Precio 1000 \n"
	    					+ "2. Queso -- Precio 1000\n"
	    					+ "3. Tocineta -- Precio 1000\n"
	    					+ "4. Cebolla -- Precio 500\n"
	    			        + "5. Lechuga -- Precio 800\n"
	    			        + "6. Huevo -- Precio 1000\n");
	                opi = sc.nextInt();
	                if(opi == 1) {
	                	System.out.println("Ingrediente Agregado");
	                	System.out.println("Precio extra = +1000");
	                }else if(opi == 2) {
	                	System.out.println("Ingrediente Agregado");
	                	System.out.println("Precio extra = +1000");
	                }else if(opi == 3) {
	                	System.out.println("Ingrediente Agregado");
	                	System.out.println("Precio extra = +1000");
	                }else if(opi == 4) {
	                	System.out.println("Ingrediente Agregado");
	                	System.out.println("Precio extra = +500");
	                }else if(opi == 5) {
	                	System.out.println("Ingrediente Agregado");
	                	System.out.println("Precio extra = +800");
	                }else if(opi == 6) {
	                	System.out.println("Ingrediente Agregado");
	                	System.out.println("Precio extra = +1000");
	                }
	                }
	}
	}
	}
	
	public void mostrarListaCombos() {
		// TODO Auto-generated method stub
		
	}

	
}
