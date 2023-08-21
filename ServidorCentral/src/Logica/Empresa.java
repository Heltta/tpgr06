package Logica;

import java.util.Map;

public class Empresa extends Usuario {
	String nombreEmpresa;
	String descripcion;
	String link;
	Map.Entry<String, OfertaLaboral> Ofertas;
	Map.Entry<String,Compra> Compras;
	

	public Empresa(String nickname, String mail, String nombre, String apellido, String nombreEmpresa,
			String descripcion, String link) {
		super(nickname, mail, nombre, apellido);
		this.nombreEmpresa = nombreEmpresa;
		this.descripcion = descripcion;
		this.link = link;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Map.Entry<String, OfertaLaboral> getOfertas() {
		return Ofertas;
	}
	public void setOfertas(Map.Entry<String, OfertaLaboral> ofertas) {
		Ofertas = ofertas;
	}
	public Map.Entry<String, Compra> getCompras() {
		return Compras;
	}
	public void setCompras(Map.Entry<String, Compra> compras) {
		Compras = compras;
	}
	
}