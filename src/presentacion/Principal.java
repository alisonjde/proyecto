package presentacion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.List;

import logica.Combo;
import logica.Ingrediente;
import logica.Producto;
import logica.Restaurante;

@SuppressWarnings("unused")
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
    	   this.restaurante.leerArchivos();
        Scanner sc = new Scanner(System.in);
        int op;
        ArrayList<int[]> productosPedidos = new ArrayList<>();
        ArrayList<Integer> combosPedidos = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Combo> combos = new ArrayList<>();

        do {
            System.out.println("\n***HAMBURGUESERIA***\n");
            System.out.println("Digite una opción:\n"
                + "0. Salir\n"
                + "1. Ingresar Factura\n"
                + "2. Imprimir Facturas\n"
                + "3. Ver Menú\n"
                + "4. Ver Combos\n"
                + "5. Modificar Producto"
                
            );

            op = sc.nextInt();

            if (op == 1) {
                System.out.println("Digite id del Cajero: ");
                int idCajero = sc.nextInt();
                System.out.println("Digite la fecha (yyyy-MM-dd): ");
                String fechaTexto = sc.next();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = null;
                try {
                    fecha = dateFormat.parse(fechaTexto);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                ArrayList<int[]>productosModificados = new ArrayList<int[]>();
                ArrayList<int[]> productosComprados = new ArrayList<int[]>();
                do {
                    int datos[] = new int[2];
                    System.out.println("Digite id del pedido (Producto o Combo): ");
                    int numerodeeleccion = sc.nextInt();
                    System.out.println("Digite cantidad del pedido: ");
                    int cantidadPedido = sc.nextInt();
                    datos[0] = numerodeeleccion;
                    datos[1] = cantidadPedido;
                    
                    productosComprados.add(datos);

                    System.out.println("¿Desea ingresar otro producto?\n" + "1. Si\n" + "2. No\n");
                    op = sc.nextInt();

                }while (op == 1);
                    	this.restaurante.ingresarFactura(idCajero, fecha, productosComprados);
                
                    	
            } else if (op == 2) {
                this.restaurante.imprimirFacturas();
            } else if (op == 3) {
                this.restaurante.imprimirMenu();
            } else if (op == 4) {
               this.restaurante.imprimirCombos();
            } else if (op == 5) {
            	this.restaurante.modificarProducto();
            }
            else if(op == 6) {
            	this.restaurante.imprimirCombos();
            }
        } while (op != 0);

        sc.close();
    }

}


