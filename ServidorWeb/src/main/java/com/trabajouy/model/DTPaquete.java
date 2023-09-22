package com.trabajouy.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DTPaquete {
	private String nombre;
	private String descripcion;
    private double descuento;
    private Date fecha;
    private double costo;
    private int PeriodoValidez;
	private Map<String, DTAgrupa> tiposPublicacion;
	
	public DTPaquete(PaqueteTipoPublicacion paquete) {
		this.nombre = paquete.getNombre();
		this.descripcion = paquete.getDescripcion();
		this.descuento = paquete.getDescuento();
		this.fecha = paquete.getFecha();
		this.costo = paquete.getCosto();
		this.PeriodoValidez = paquete.getPeriodoValidez();
		this.tiposPublicacion = new HashMap<String, DTAgrupa>();
		Map<String, Agrupa> tipos = paquete.getTiposPublicacion();
		for (Entry<String, Agrupa> agrupaTipo : tipos.entrySet()) {
			DTAgrupa dataAgrupa = new DTAgrupa(agrupaTipo.getValue().getCant(), agrupaTipo.getValue().getTipo());
			tiposPublicacion.put(dataAgrupa.getNombreTipo(), dataAgrupa);
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Map<String, DTAgrupa> getTipos(){
		return tiposPublicacion;
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
}