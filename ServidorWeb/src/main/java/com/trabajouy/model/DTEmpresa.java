package com.trabajouy.model;

import java.util.Set;

public class DTEmpresa extends DTUsuario {

		String nombreEmpresa;
		String descripcion;
		String link;
		Set<String> nombreOfertas;
		
		public DTEmpresa(String nickname, String mail, String nombre, String apellido, String nombreEmpresa,
				String descripcion, String link, Set<String> nombreOfertas) {
			super(nickname, mail, nombre, apellido);
			this.nombreEmpresa = nombreEmpresa;
			this.descripcion = descripcion;
			this.link = link;
			this.nombreOfertas=nombreOfertas;
		}
		public String getNombreEmpresa() {
			return nombreEmpresa;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public String getLink() {
			return link;
		}
		public Set<String> getNombreOfertas(){
			return nombreOfertas;
		}
}

