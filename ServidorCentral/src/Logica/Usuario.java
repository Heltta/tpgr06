package Logica;

public class Usuario {
	private String nickname;
	private String mail;
	private String nombre;
	private String apellido;
	
	
	public Usuario(String nickname, String mail, String nombre, String apellido) {
		super();
		this.nickname = nickname;
		this.mail = mail;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getNickname() {
		return nickname;
	}
	public String getMail() {
		return mail;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}

}
