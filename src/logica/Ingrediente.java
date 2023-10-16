package logica;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Ingrediente {
	
	private int numeroingrediente;
	private String nombreingrediente;
	private int precioingrediente;
	

	public int getNumeroingrediente() {
		return numeroingrediente;
	}
	public void setNumeroingrediente(int numeroingrediente) {
		this.numeroingrediente = numeroingrediente;
	}
	public String getNombreingrediente() {
		return nombreingrediente;
	}
	public void setNombreingrediente(String nombreingrediente) {
		this.nombreingrediente = nombreingrediente;
	}
	public int getPrecioingrediente() {
		return precioingrediente;
	}
	public void setPrecioingrediente(int precioingrediente) {
		this.precioingrediente = precioingrediente;
	}
	
	public Ingrediente(int numeroingrediente, String nombreingrediente, int precioingrediente) {
		this.numeroingrediente = numeroingrediente;
		this.nombreingrediente = nombreingrediente;
		this.precioingrediente = precioingrediente;
		
	}


	
}


