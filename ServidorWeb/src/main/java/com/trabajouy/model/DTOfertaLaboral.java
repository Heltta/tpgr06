package com.trabajouy.model;

import java.util.Date;
import java.util.Set;

public class DTOfertaLaboral {

	private String nombre;
	private String nombreEmpresa;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private DTHorario horario;
	private int remuneracion;
	private Date fecha;
	private double costo;
	private Set<DTPostulacion> postulaciones;
	private String tipo;
	private Set<String> Keywords;
	private String imagen;
	
	public DTOfertaLaboral(String nombre, String nombreEmpresa,String descripcion, String ciudad, String departamento, DTHorario horario, int remuneracion,
			Date fecha, String tipo, Set<String> keywords, Set<DTPostulacion> postulaciones, double costo) {
		super();
		this.nombre = nombre;
		this.nombreEmpresa=nombreEmpresa;
		this.descripcion=descripcion;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.horario = horario;
		this.remuneracion = remuneracion;
		this.fecha = fecha;
		this.tipo = tipo;
		this.costo=costo;
		Keywords = keywords;
		this.postulaciones=postulaciones;
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getDepartamento() {
		return departamento;
	}
	public int getRemuneracion() {
		return remuneracion;
	}
	public Date getFecha() {
		return fecha;
	}
	public double getCosto() {
		return costo;
	}
	public Set<DTPostulacion> getPostulaciones() {
		return postulaciones;
	}
	public String getTipo() {
		return tipo;
	}
	public Set<String> getKeywords() {
		return Keywords;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public DTHorario getHorario() {
		return horario;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public String getImagen() {
		if (imagen == null)
			return "";
		else
			return imagen;
	}
	public DTOfertaLaboral(String nombre, String nombreEmpresa,String descripcion, String ciudad, String departamento, DTHorario horario, int remuneracion,
			Date fecha, String tipo, Set<String> keywords, Set<DTPostulacion> postulaciones, double costo,String imagen) {
		super();
		this.nombre = nombre;
		this.nombreEmpresa=nombreEmpresa;
		this.descripcion=descripcion;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.horario = horario;
		this.remuneracion = remuneracion;
		this.fecha = fecha;
		this.tipo = tipo;
		this.costo=costo;
		Keywords = keywords;
		this.postulaciones=postulaciones;
		this.nombreEmpresa = nombreEmpresa;
		this.imagen = imagen;
	}
}
