package Logica;
import java.time.LocalDate;
import java.util.Set;

public class DTPostulante extends DTUsuario {
	
	String nacionalidad;
	LocalDate fechaNacimiento;
	Set<String> nombreOfertas;
	
	public DTPostulante(String nickname,String mail,String nombre,String apellido,String nacionalidad, LocalDate fechaNacimiento, Set<String> nombreOfertas) {
		super(nickname,mail,nombre,apellido);
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreOfertas=nombreOfertas;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public Set<String> getNombreOfertas(){
		return nombreOfertas;
	}
}
