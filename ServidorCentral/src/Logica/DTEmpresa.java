package Logica;

public class DTEmpresa extends DTUsuario {

		String nombreEmpresa;
		String descripcion;
		String link;
		
		public DTEmpresa(String nickname, String mail, String nombre, String apellido, String nombreEmpresa,
				String descripcion, String link) {
			super(nickname, mail, nombre, apellido);
			this.nombreEmpresa = nombreEmpresa;
			this.descripcion = descripcion;
			this.link = link;
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
}

