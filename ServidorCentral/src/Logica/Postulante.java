package Logica;

import java.time.LocalDate;
import java.util.Map;

public class Postulante extends Usuario {
	String nacionalidad;
	LocalDate fechaNacimiento;
	Map.Entry<String, Postulacion> Postulaciones;
	void postularAOferta(OfertaLaboral of) {
		
	}
	
	public Postulante(String nickname,String mail,String nombre,String apellido,String nacionalidad, LocalDate fechaNacimiento) {
		super(nickname,mail,nombre,apellido);
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.Postulaciones=null;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Map.Entry<String, Postulacion> getPostulaciones() {
		return Postulaciones;
	}
	public void setPostulaciones(Map.Entry<String, Postulacion> postulaciones) {
		Postulaciones = postulaciones;
	}
	
}
