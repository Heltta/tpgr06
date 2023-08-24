package Logica;

import java.time.LocalDate;

public class DTPostulacion {

	LocalDate fechaPostulacion;
	String resumenCV;
	String descripcion;
	String nombreOferta;
	
	public DTPostulacion(LocalDate fechaPostulacion, String resumenCV, String descripcion, String nombreOferta) {
		super();
		this.fechaPostulacion = fechaPostulacion;
		this.resumenCV = resumenCV;
		this.descripcion = descripcion;
		this.nombreOferta= nombreOferta;
	}
	public LocalDate getFechaPostulacion() {
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
