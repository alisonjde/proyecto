package logica;

public class Producto {

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
		
		public Producto(int numerodeeleccion, String nombrep, int precioVenta) {
			this.numerodeeleccion = numerodeeleccion;
			this.nombrep = nombrep;
			this.precioVenta = precioVenta;

		}
	}



	//public void modificarpedido()
	//recibe numerodeelccion y numerodeespecialidad
	//if numeroespecialidad == 10 -> imprima combo -> seleccione el producto a modificar y mande entero




	//else if (numerodeeleccion >= 21 && <=26 -> entonces mande string y entero



