package logica;

public class FacturaProducto {

	
		private int cantidad;
		private int precioventa;
		
		private Producto producto;
		
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		public int getPrecio() {
			return precioventa;
		}
		public void setPrecioVenta(int precioVenta) {
			this.precioventa = precioVenta;
		}
		public Producto getProducto() {
			return producto;
		}
		public void setProducto(Producto producto) {
			this.producto = producto;
		}
		public FacturaProducto(int cantidad,int precioVenta,Producto producto) {
			super();
			this.cantidad = cantidad;
			this.precioventa = precioVenta;
			this.producto = producto;
		}

	}

