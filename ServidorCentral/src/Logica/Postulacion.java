package Logica;

import java.util.Date;

public class Postulacion {
	Date fechaPostulacion;
	String resumenCV;
	String descripcion;
	OfertaLaboral oferta;
	
	public Postulacion(Date fechaPostulacion, String resumenCV, String descripcion, OfertaLaboral oferta) {
		super();
		this.fechaPostulacion = fechaPostulacion;
		this.resumenCV = resumenCV;
		this.descripcion = descripcion;
		this.oferta = oferta;
	}
	public Date getFechaPostulacion() {
		return fechaPostulacion;
	}

	public String getResumenCV() {
		return resumenCV;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public OfertaLaboral getOferta() {
		return oferta;
	}

	
	
}
