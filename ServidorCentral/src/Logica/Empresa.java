package Logica;

import java.util.HashMap;
import java.util.Map;

public class Empresa extends Usuario {
	String nombreEmpresa;
	String descripcion;
	String link;
	Map<String, OfertaLaboral> Ofertas;
	Map<String,Compra> Compras;
	

	public Empresa(String nickname, String mail, String nombre, String apellido, String nombreEmpresa,
			String descripcion, String link) {
		super(nickname, mail, nombre, apellido);
		this.nombreEmpresa = nombreEmpresa;
		this.descripcion = descripcion;
		this.link = link;
		this.Ofertas=null;
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

	public Map<String, OfertaLaboral> getOfertas() {
		return Ofertas;
	}

	public void agregarOferta(OfertaLaboral o) {
		if (Ofertas==null) {
			Ofertas= new HashMap<String,OfertaLaboral>();
		}
		this.Ofertas.put(o.getNombre(), o);
	}
	
}