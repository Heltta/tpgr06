package Logica;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PaqueteTipoPublicacion {
	private String nombre;
    private String descripcion;
    private double descuento;
    private Date fecha;
    private double costo;
    private int PeriodoValidez;
    private Map<String, Agrupa> TiposPublicacion;
    
    public PaqueteTipoPublicacion(String nombre, String descripcion, double descuento, Date fecha, double costo, int PeriodoValidez) {
    	this.nombre = nombre;
    	this.descripcion = descripcion;
    	this.descuento = descuento;
    	this.fecha = fecha;
    	this.costo = costo;
    	this.PeriodoValidez = PeriodoValidez;
    	TiposPublicacion = new HashMap<String, Agrupa>();
    }
    
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
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
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
	
	public void agregarTipo(TipoPublicacion tipo, int cant) {
		if (TiposPublicacion.containsKey(tipo.getNombre())) {
			Agrupa tipoExistente = TiposPublicacion.get(tipo.getNombre());
			tipoExistente.setCant(tipoExistente.getCant() + cant);
		} else {
			Agrupa tipoAgregado = new Agrupa(tipo, cant);
			TiposPublicacion.put(tipo.getNombre(), tipoAgregado);
		}
	}
}
