package com.trabajouy.model;

public class DTUsuario {
	private String nickname;
	private String mail;
	private String nombre;
	private String apellido;
	
	
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
	
	public DTUsuario(String nickname, String mail, String nombre, String apellido) {
		this.nickname = nickname;
		this.mail = mail;
		this.nombre = nombre;
		this.apellido = apellido;
	}
}