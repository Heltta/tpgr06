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

	public void setNickname(String newNick) {
		this.nickname = newNick;
	}
	public void setMail(String newMail) {
		this.nickname = newMail;
	}
	public void setNombre(String newNombre) {
		this.nickname = newNombre;
	}
	public void setApellido(String newApellido) {
		this.nickname = newApellido;
	}
}
