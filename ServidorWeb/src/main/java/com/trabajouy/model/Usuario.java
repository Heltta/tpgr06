package com.trabajouy.model;

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

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
