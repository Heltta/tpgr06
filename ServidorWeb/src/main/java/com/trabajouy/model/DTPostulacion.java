package com.trabajouy.model;

import java.util.Date;

public class DTPostulacion {

	private Date fechaPostulacion;
	private String resumenCV;
	private String descripcion;
	private String nombreOferta;
	private String postulante;
	
	public DTPostulacion(Date fechaPostulacion, String resumenCV, String descripcion, String nombreOferta, String post) {
		super();
		this.fechaPostulacion = fechaPostulacion;
		this.resumenCV = resumenCV;
		this.descripcion = descripcion;
		this.nombreOferta= nombreOferta;
		this.postulante = post;
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
	public String getPostulante() {
		return postulante;
	}
}
