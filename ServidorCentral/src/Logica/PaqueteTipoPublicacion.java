package Logica;

import java.time.LocalDate;
import java.util.Map;

public class PaqueteTipoPublicacion {
	String nombre;
    String descripcion;
    double descuento;
    LocalDate fecha;
    double costo;
    int PeriodoValidez;
    Map<String, Agrupa> TiposPublicacion;
    
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
	
	public double getDescuento() {
		return descuento;
	}
	
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public double getCosto() {
		return costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public int getPeriodoValidez() {
		return PeriodoValidez;
	}
	
	public void setPeriodoValidez(int periodoValidez) {
		PeriodoValidez = periodoValidez;
	}
	
	public Map<String, Agrupa> getTiposPublicacion() {
		return TiposPublicacion;
	}
	
	public void setTiposPublicacion(Map<String, Agrupa> tiposPublicacion) {
		TiposPublicacion = tiposPublicacion;
	}
}
