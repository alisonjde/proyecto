package logica;

import java.util.ArrayList;
import java.util.List;

public class Producto {
	
    private ArrayList<Ingrediente> ingredientes;
		private int numerodeeleccion;
		private String nombrep;
		private int precioVenta;
		
		 public int getNumeroDeEleccion() {
			return numerodeeleccion;
		}
		public void setNumeroDeEleccion(int numerodeeleccion) {
			this.numerodeeleccion = numerodeeleccion;
		}
		
		public String getNombrep() {
			return nombrep;
		}
		
		public void setNombrep(String nombrep) {
			this.nombrep = nombrep;
		}
		
		public int getPrecioVenta() {
			return precioVenta;
		}
		
		public void setPrecioVenta(int precioVenta) {
			this.precioVenta = precioVenta;
		}
		
//se inicializa el atributo ingredientes como una nueva lista de ingredientes (un ArrayList<Ingrediente>). 
//Esto se hace para asegurarse de que el producto tenga una lista de ingredientes a
		//la que se le pueden agregar ingredientes posteriormente.
		
		public Producto(int numerodeeleccion, String nombrep, int precioVenta) {
			this.numerodeeleccion = numerodeeleccion;
			this.nombrep = nombrep;
			this.precioVenta = precioVenta;
			  ingredientes = new ArrayList<Ingrediente>();
		}
	
	public List<Ingrediente> getIngredientes() {
	    return ingredientes;
	}
	
	public void agregarIngrediente(Ingrediente ingrediente) {
	    if (ingredientes == null) {
	        ingredientes = new ArrayList<>();
	    }
	    ingredientes.add(ingrediente);
	}
	public void quitarIngrediente(Ingrediente ingrediente) {
	    if (ingredientes != null) {
	        ingredientes.remove(ingrediente);
	    }
	}

}





