package Logica;

import java.util.Date;

public class DTPostulacion {

	Date fechaPostulacion;
	String resumenCV;
	String descripcion;
	String nombreOferta;
	
	public DTPostulacion(Date fechaPostulacion, String resumenCV, String descripcion, String nombreOferta) {
		super();
		this.fechaPostulacion = fechaPostulacion;
		this.resumenCV = resumenCV;
		this.descripcion = descripcion;
		this.nombreOferta= nombreOferta;
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
	public String getNombreOferta() {
		return nombreOferta;
	}
}
