package Logica;
import java.time.LocalDate;
import java.util.*;

public class OfertaLaboral {
	private String nombre;
	private String ciudad;
	private String departamento;
	private DTHorario horario;
	private double remuneracion;
	private LocalDate fecha;
	private double costo;
	
	private List<String> keywords;
	private Map<String,Postulante> postulantes;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public DTHorario getHorario() {
		return horario;
	}
	
	public List getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public void setHorario(DTHorario horario) {
		this.horario = horario;
	}
	
	public double getRemuneracion() {
		return remuneracion;
	}
	
	public void setRemuneracion(double remuneracion) {
		this.remuneracion = remuneracion;
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
	
	public OfertaLaboral() {
		super();
	}
}
