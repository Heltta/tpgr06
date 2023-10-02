package com.trabajouy.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		this.Ofertas=new HashMap<String,OfertaLaboral>();
		this.Compras=null;
	}
	
	public Empresa(String nickname, String mail, String nombre, String apellido, String nombreEmpresa,
			String descripcion, String link, String imagen, String pass) {
			super(nickname, mail, nombre, apellido, imagen, pass);
			this.nombreEmpresa = nombreEmpresa;
			this.descripcion = descripcion;
			this.link = link;
			this.Ofertas=new HashMap<String,OfertaLaboral>();
			this.Compras=null;
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
	public Set<String> getNombreOfertas(){
		Set<String> lista = null;
		if(Ofertas != null) {
			lista = Ofertas.keySet();
		}
		return lista;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setOfertas(Map<String, OfertaLaboral> ofertas) {
		Ofertas = ofertas;
	}
	public void comprarPaquete(String nombrePaquete) {
		ManejadorPaquete manejadorPaquete= ManejadorPaquete.getInstance();
		PaqueteTipoPublicacion paquete= manejadorPaquete.obtenerPaquete(nombrePaquete);
		Compra compraPaquete= new Compra(this, paquete);
		Compras.put(nombrePaquete, compraPaquete);
	}
	public void canjearTipoDeCompra(String nombreTipo, String nombrePaquete) {
		Compra compraPaquete= Compras.get(nombrePaquete);
		compraPaquete.canjearTipo(nombreTipo);
	}
	public Map<String,Set<String>> listarPaquetesCompradosConTipoSinCanjear() {
		Map<String,Set<String>> mapaTipoPublicacionPaquete= new HashMap<String,Set<String>>();
		if(Compras!=null) {
			Collection<Compra> paquetes= Compras.values();
			for(Compra compraPaquete: paquetes) {
				Set<String> tiposDelPaquete= compraPaquete.getTiposNoCanjeados().keySet();
				for(String nombreTipo: tiposDelPaquete) {
					if(mapaTipoPublicacionPaquete.containsKey(nombreTipo)) {
						mapaTipoPublicacionPaquete.get(nombreTipo).add(compraPaquete.getProducto().getNombre());
					}
					else {
						Set<String> paquetesConTipo= new HashSet<String>();
						paquetesConTipo.add(compraPaquete.getProducto().getNombre());
						mapaTipoPublicacionPaquete.put(nombreTipo, paquetesConTipo);
					}
				}
			}
		}
		return mapaTipoPublicacionPaquete;
	}
}
