package Logica;
import java.util.Date;
import java.util.Set;

public class DTPostulante extends DTUsuario {
	
	String nacionalidad;
	Date fechaNacimiento;
	Set<String> nombreOfertas;
	
	public DTPostulante(String nickname,String mail,String nombre,String apellido,String nacionalidad, Date fechaNacimiento, Set<String> nombreOfertas) {
		super(nickname,mail,nombre,apellido);
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreOfertas=nombreOfertas;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public Set<String> getNombreOfertas(){
		return nombreOfertas;
	}
}
