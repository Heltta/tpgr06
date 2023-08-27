package Logica;

import java.util.Date;

public class DTTipoPublicacion {
	private String nombre;
	private String descripcion;
	private int exposicion;
	private double duracion;
	private double costo;
	private Date fecha;
	
	public DTTipoPublicacion(String nombre, String descripcion, int exposicion, double duracion, double costo, Date fecha) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.exposicion = exposicion;
		this.duracion = duracion;
		this.costo = costo;
		this.fecha = fecha;
	}

	public boolean compare(DTTipoPublicacion tipoIn) {
		return nombre == tipoIn.nombre && descripcion == tipoIn.descripcion && exposicion == tipoIn.exposicion && duracion == tipoIn.duracion
				&& costo == tipoIn.costo && fecha.compareTo(tipoIn.fecha) == 0;
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


