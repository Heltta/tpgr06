package com.trabajouy.model;

public class DTUsuario {
	private String nickname;
	private String mail;
	private String nombre;
	private String apellido;
	private String imagen = null;
	
	
	public String getApellido() {
		return apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public String getMail() {
		return mail;
	}
	public String getNickname() {
		return nickname;
	}
	
	public String getImagen() {
		if (imagen == null)
			return "";
		else
			return imagen;
	}
	
	public DTUsuario(String nickname, String mail, String nombre, String apellido, String imagen) {
		this.nickname = nickname;
		this.mail = mail;
		this.nombre = nombre;
		this.apellido = apellido;
		this.imagen = imagen;
	}
	
	public DTUsuario(String nickname, String mail, String nombre, String apellido) {
		this.nickname = nickname;
		this.mail = mail;
		this.nombre = nombre;
		this.apellido = apellido;
	}
}