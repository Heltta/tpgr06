package com.trabajouy.model;

public class DTAgrupa {
	private String tipo;
	private int cant;
	
	public DTAgrupa(int cant, TipoPublicacion tipo) {
		this.tipo = tipo.getNombre();
		this.cant = cant;
	}
	
	public String getNombreTipo() {
		return tipo;
	}
	
	public int getCant() {
		return cant;
	}
}
