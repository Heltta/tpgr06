package com.trabajouy.model;

import java.util.Date;

import com.trabajouy.exceptions.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class CtrlTipos implements ITipos {

	public void ingresarDatosTipoPublicacion(String nombreT, String descripcionT, int exposicionT, Date fechaT,
			double costoT, double duracionT) throws nombreTipoPublicacionRepetido {
		ManejadorTipo muTipo = ManejadorTipo.getInstance();
		boolean existeNombre = muTipo.existeTipoPublicacion(nombreT);
		if (existeNombre) {
			throw new nombreTipoPublicacionRepetido("Ya existe un tipo de publicacion de nombre " + nombreT);
		}
			TipoPublicacion nuevoTipo = new TipoPublicacion(nombreT, descripcionT, exposicionT, fechaT, costoT, duracionT);
			muTipo.agregar(nuevoTipo);
	}
	
	public Set<String> listarPaquetes(){
		ManejadorPaquete muPaquete = ManejadorPaquete.getInstance();
		return muPaquete.obtenerPaquetes();
	}
	
	public Map<String, DTTipoPublicacion> obtenerDataTipos() {
		ManejadorTipo muTipo = ManejadorTipo.getInstance();
		return muTipo.obtenerDataTipos();
	}
	
	public Map<String, DTPaquete> obtenerDataPaquetes(){
		ManejadorPaquete muPaquete = ManejadorPaquete.getInstance();
		return muPaquete.obtenerDataPaquetes();
	}
	
	public void borrarTipos() {
		ManejadorTipo muTipo = ManejadorTipo.getInstance();
		muTipo.clear();
	}
	
	public void borrarPaquetes() {
		ManejadorPaquete muPaquete = ManejadorPaquete.getInstance();
		muPaquete.clear();
	}
	
	public Boolean ingresarKeyword (String keyword) {
		ManejadorKeywords mk = ManejadorKeywords.getInstance();
		Boolean res = !mk.existeKeyword(keyword);
		if (res) {
			mk.agregarKeyword(keyword);
		}
		return res;
	}

	@Override
	public Set<String> listarTiposPublicacion() {
		ManejadorTipo muTipos = ManejadorTipo.getInstance();
		return muTipos.obtenerTipos();
	}
	
	public void agregarTipoPublicacion(String nombrePaquete, String nombreTipo, int cant) {
		ManejadorTipo muTipos = ManejadorTipo.getInstance();
		ManejadorPaquete muPaquete = ManejadorPaquete.getInstance();
		TipoPublicacion tipo = muTipos.obtenerTipo(nombreTipo);
		PaqueteTipoPublicacion paquete = muPaquete.obtenerPaquete(nombrePaquete);
		paquete.agregarTipo(tipo, cant);
	}
	
	public void ingresarDatosPaquete(String nombre, String descripcion, int validez, double descuento, Date fechaAlta)throws nombrePaqueteRepetido {
		ManejadorPaquete muPaquete = ManejadorPaquete.getInstance();
		boolean existe = muPaquete.existePaquete(nombre);
		if (existe) {
			throw new nombrePaqueteRepetido("Ya existe un Paquete de nombre " + nombre);
		} else {
			PaqueteTipoPublicacion nuevoPaquete = new PaqueteTipoPublicacion(nombre, descripcion, descuento, fechaAlta, validez);
			muPaquete.agregarPaquete(nuevoPaquete);
		}
	}
}


