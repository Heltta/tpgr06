package Logica;

import java.time.LocalDate;

public class TipoPublicacion {
	private String nombre;
	private String descripcion;
	private int exposicion;
	private double duracion;
	private double costo;
	private LocalDate fecha;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getExposicion() {
		return exposicion;
	}
	
	public void setExposicion(int exposicion) {
		this.exposicion = exposicion;
	}
	
	public double getDuracion() {
		return duracion;
	}
	
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	public double getCosto() {
		return costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}
