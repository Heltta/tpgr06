package Logica;

import java.util.Date;

public class TipoPublicacion {
	private String nombre;
	private String descripcion;
	private int exposicion;
	private double duracion;
	private double costo;
	private Date fecha;
	
	public TipoPublicacion(String nombre, String descripcion, int exposicion, Date fecha, double costo, double duracion){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.exposicion = exposicion;
		this.fecha = fecha;
		this.costo = costo;
		this.duracion = duracion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getExposicion() {
		return exposicion;
	}
	
	public double getDuracion() {
		return duracion;
	}
	
	public double getCosto() {
		return costo;
	}

	public Date getFecha() {
		return fecha;
	}
}

