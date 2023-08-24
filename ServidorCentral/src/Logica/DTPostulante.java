package Logica;
import java.time.LocalDate;

public class DTPostulante extends DTUsuario {
	
	String nacionalidad;
	LocalDate fechaNacimiento;
	
	public DTPostulante(String nickname,String mail,String nombre,String apellido,String nacionalidad, LocalDate fechaNacimiento) {
		super(nickname,mail,nombre,apellido);
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

}
