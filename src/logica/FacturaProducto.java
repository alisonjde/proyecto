package logica;

public class FacturaProducto {

	 
		private int cantidad;
		private int precioventa;
		private Producto producto;
		private Combo combo;
		
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
		public FacturaProducto(int cantidad,int precioVenta,Combo combo,Producto producto) {
			super();
			this.cantidad = cantidad;
			this.precioventa = precioVenta;
			this.producto = producto;
			this.combo = combo;
			
		}
		public Combo getCombo() {
			return combo;
		}
		public void setCombo(Combo combo) {
			this.combo = combo;
		}
	

	}

