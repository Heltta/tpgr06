package com.trabajouy.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PaqueteTipoPublicacion {
	private String nombre;
    private String descripcion;
    private double descuento;
    private Date fecha;
    private double costo;
    private int PeriodoValidez;
    private Map<String, Agrupa> TiposPublicacion;
    
    public PaqueteTipoPublicacion(String nombre, String descripcion, double descuento, Date fecha, int PeriodoValidez) {
    	this.nombre = nombre;
    	this.descripcion = descripcion;
    	this.descuento = descuento;
    	this.fecha = fecha;
    	this.costo = 0;
    	this.PeriodoValidez = PeriodoValidez;
    	TiposPublicacion = new HashMap<String, Agrupa>();
    }
    
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public double getDescuento() {
		return descuento;
	}

	
	public Date getFecha() {
		return fecha;
	}

	
	public double getCosto() {
		return costo;
	}

	
	public int getPeriodoValidez() {
		return PeriodoValidez;
	}

	
	public Map<String, Agrupa> getTiposPublicacion() {
		return TiposPublicacion;
	}

	
	public void agregarTipo(TipoPublicacion tipo, int cant) {
		if (TiposPublicacion.containsKey(tipo.getNombre())) {
			Agrupa tipoExistente = TiposPublicacion.get(tipo.getNombre());
			tipoExistente.setCant(tipoExistente.getCant() + cant);
		} else {
			Agrupa tipoAgregado = new Agrupa(tipo, cant);
			TiposPublicacion.put(tipo.getNombre(), tipoAgregado);
		}
		costo = costo + tipo.getCosto()*cant*(1-descuento/100);
	}
}
