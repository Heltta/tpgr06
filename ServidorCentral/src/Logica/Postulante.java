package Logica;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Postulante extends Usuario {
	String nacionalidad;
	Date fechaNacimiento;
	Map<String, Postulacion> Postulaciones;
	
	void postularAOferta(OfertaLaboral oferta, Date fecha, String cv, String descripcion) {
		if(!Postulaciones.containsKey(oferta.getNombre())) {
			Postulacion post = new Postulacion(fecha, cv, descripcion, oferta);
			Postulaciones.put(oferta.getNombre(), post);
		}
		oferta.agregarPostulante(this);
	}
	
	public Postulante(String nickname,String mail,String nombre,String apellido,String nacionalidad, Date fechaNacimiento) {
		super(nickname,mail,nombre,apellido);
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.Postulaciones= new HashMap<String, Postulacion>();
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Map<String, Postulacion> getPostulaciones() {
		return Postulaciones;
	}
	public void setPostulaciones(Map<String, Postulacion> postulaciones) {
		Postulaciones = postulaciones;
	}
}
