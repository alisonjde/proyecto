package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

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
			this.ingresarCombo(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]),(datos[3]),(datos[4]),(datos[5]));
		}
		lineas = Archivo.leerArchivo("ingrediente");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarIngrediente(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]));
		
		}
		
	}

	private void ingresarIngrediente(int numeroingrediente, String nombreingrediente, int precioingrediente) {
		Ingrediente ingrediente = new Ingrediente(numeroingrediente,nombreingrediente, precioingrediente);
		this.ingredientes.add(ingrediente);
	}
	
	private Ingrediente buscarIngrediente(int numeroIngrediente) {
	    for (Ingrediente ingrediente : this.ingredientes) {
	        if (ingrediente.getNumeroingrediente()  == numeroIngrediente) {
	            return ingrediente; // Ingrediente encontrado
	        }
	    }
	    return null; // Ingrediente no encontrado
	}
	
	
	private void ingresarCombo(int numeroCombo, String nombreCombo, int precioCombo, String producto1, String producto2, String producto3) {
	    Combo combo = new Combo(numeroCombo, nombreCombo, precioCombo, producto1, producto2, producto3);
	    this.combos.add(combo);
	}
	
	private Combo buscarCombo(int idCombo) {
	    for (Combo combo : this.combos) {
	        if (combo.getNumerocombo() == idCombo) {
	            return combo; // Producto encontrado
	        }
	    }
	    return null; // Producto no encontrado
	}

	private void ingresarProducto(int numerodeelccion, String nombrep, int precioVenta) {
	
		Producto producto = new Producto(numerodeelccion,nombrep,precioVenta);
		this.productos.add(producto);	
	}
	
	public Producto buscarProducto(int idProducto) {
	    for (Producto producto : this.productos) {
	        if (producto.getNumeroDeEleccion() == idProducto) {
	            return producto; // Producto encontrado
	        }
	    }
	    return null; // Producto no encontrado
	}

	public void ingresarCajero(int id, String nombre, String apellido) {
		Cajero cajero = new Cajero(id, nombre, apellido);
		this.cajeros.add(cajero);
	}
	
	private Cajero buscarCajero(int idCajero) {
		for(Cajero cajero : this.cajeros) {
			if(cajero.getId() == idCajero) {
				return cajero;
			}
		}
		return null;
	}
	public void ingresarFactura(int idCajero, Date fecha, ArrayList<int[]> productosComprados) {
	    Cajero cajero = this.buscarCajero(idCajero);
	    int numero = this.facturas.size() + 1;
	    Factura factura = new Factura(numero, fecha, cajero);
	    
	    for (int[] datos : productosComprados) {
	        int productoId = datos[0];
	        int cantidad = datos[1];
	        
	        Producto producto = buscarProducto(productoId);
	        Combo combo = buscarCombo(productoId); // Buscar combo por el mismo ID
	        
	        if (producto != null) {
	            factura.adicionarProducto(producto, null, cantidad); // Añadir producto a la factura
	        } else if (combo != null) {
	            factura.adicionarProducto(null, combo, cantidad); // Añadir combo a la factura
	        } else {
	            // Manejar el caso en el que ni el producto ni el combo sean encontrados
	            System.out.println("Producto o combo no encontrado para el ID: " + productoId);
	        }
	    }
	    
	    factura.calcularTotal();
	    this.facturas.add(factura);
	}		

	public void imprimirFacturas() {
		for(Factura factura : this.facturas) {
			System.out.println("-------");
			System.out.println( "#"+factura.getNumero() + "\n" + " FECHA: " + factura.getFecha()+ "\n" +  " VALOR TOTAL: "+ factura.getValorTotal() + "\n" + " NOMBRE CAJERO: "+ factura.getCajero().getNombre()+ " " + factura.getCajero().getApellido());
			for(FacturaProducto facturaProducto : factura.getFacturaProductos()) {
				System.out.println(" PEDIDO: " +facturaProducto.getProducto().getNombrep()+ "\n"  + " CANTIDAD: " + facturaProducto.getPrecio() + "\n" + " PRECIO UND: " + facturaProducto.getCantidad());
			}
		}

	}
	public void modificarProducto() {
	    try (Scanner sc = new Scanner(System.in)) {
	        int opi;
	        System.out.println("¿Desea modificar el producto? (1. Si /2. No): ");
	        String respuesta = sc.nextLine().toLowerCase();

	        if (respuesta.equals("1")) {
	            int numeroEleccion;
	            System.out.println("Por favor, ingrese el número de elección del producto que desea modificar: ");

	            if (sc.hasNextInt()) { // Comprobar si se ingresó un número
	                numeroEleccion = sc.nextInt();

	                if (numeroEleccion == 12 || numeroEleccion == 11 || numeroEleccion == 24 || numeroEleccion == 25 || numeroEleccion == 26 || numeroEleccion == 27 || numeroEleccion == 28 || numeroEleccion == 29 || numeroEleccion == 30) {
	                    System.out.println("No se puede modificar este producto");
	                    return;
	                }

	                Producto productoAModificar = buscarProducto(numeroEleccion);

	                if (productoAModificar != null) {
	                    System.out.println("Producto actual: " + productoAModificar.getNombrep());
	                    System.out.println("¿Desea agregar o quitar ingredientes? (1. Agregar / 2. Quitar): ");
	                    int accion;

	                    if (sc.hasNextInt()) { // Comprobar si se ingresó un número
	                        accion = sc.nextInt();

	                        if (accion == 1) {
	                            System.out.println("Qué ingrediente desea agregar: ");
	                            menuAgregarIngredientes();
	                            int numeroIngrediente = sc.nextInt();

	                            Ingrediente ingrediente = buscarIngrediente(numeroIngrediente);

	                            if (ingrediente != null) {
	                                System.out.println("Ingrediente agregado: " + ingrediente.getNombreingrediente());
	                                System.out.println("Precio adicional: + " + ingrediente.getPrecioingrediente());
	                            }
	                        } else if (accion == 2) {
	                            System.out.println("Qué ingrediente desea eliminar: ");
	                            menuQuitarIngredientes();
	                            int numeroIngrediente = sc.nextInt();

	                            Ingrediente ingrediente = buscarIngrediente(numeroIngrediente);

	                            if (ingrediente != null) {
	                                System.out.println("Ingrediente eliminado: " + ingrediente.getNombreingrediente());
	                            }
	                        }
	                    } else {
	                        System.out.println("Entrada no válida. Debe ingresar 1 para agregar ingredientes o 2 para quitar ingredientes.");
	                    }
	                }
	            } else {
	                System.out.println("Entrada no válida. Debe ingresar el número de elección del producto.");
	            }
	        }
	    }
	}
	
	
	
public void modificarCombo() {
		
		try (Scanner sc = new Scanner(System.in)) {
			int opcc;
			System.out.println("¿Desea modificar el Combo? (1. Si /2. No): ");
			String respuesta = sc.nextLine().toLowerCase();

			if (respuesta.equals("1")) {
			    System.out.println("Por favor, ingrese el número de combo que desea modificar: ");
			    int numeroEleccion = sc.nextInt();
	
			    int numerocombo = sc.nextInt();
			    if(numeroEleccion == 21 ||numeroEleccion == 22 ||numeroEleccion == 23 ||numeroEleccion == 24 || numeroEleccion == 25 || numeroEleccion == 26 || numeroEleccion == 27 || numeroEleccion == 28 || numeroEleccion == 29 || numeroEleccion == 30 ) {
			    	System.out.println("No se pueden productos, solo combos");
			    	return;
			    }			    
			    
			}	    
		}
}
			    
			    
			    
	
	public void imprimirMenu() {
		for(Producto producto : this.productos) {
				System.out.println("Nombre: " + producto.getNombrep());
				System.out.println("Precio Venta: " + producto.getPrecioVenta());
				System.out.println("-----------");
			}
		}
    public void imprimirCombos() {
    	for(Combo combo : this.combos) {
    		System.out.println("Nombre: " + combo.getNombrecombo());
    		System.out.println("Contiene: " + combo.getProducto1()+ " + " + combo.getProducto2()+ " + " +combo.getProducto3());
			System.out.println("Precio Venta: " + combo.getPreciocombo());
			System.out.println("-----------");
    	}
    }
    
	public void menuAgregarIngredientes() {
		for(Ingrediente ingrediente : this.ingredientes) {
			    System.out.println("Opcion: "+ ingrediente.getNumeroingrediente());
				System.out.println("Ingrediente: " + ingrediente.getNombreingrediente());
				System.out.println("Precio Venta: " + ingrediente.getPrecioingrediente());
				System.out.println("-----------");
			}
		}
		
	public void menuQuitarIngredientes() {
		for(Ingrediente ingrediente : this.ingredientes) {
			    System.out.println("Opcion: "+ ingrediente.getNumeroingrediente());
				System.out.println("Ingrediente: " + ingrediente.getNombreingrediente());
				System.out.println("-----------");
			}
		}
		
	}
