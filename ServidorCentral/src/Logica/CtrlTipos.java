package Logica;

import java.util.Date;

import Excepciones.nombreTipoPublicacionRepetido;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import Excepciones.nombreTipoPublicacionRepetido;

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
	
	public Map<String, DTTipoPublicacion> obtenerDataTipos() {
		ManejadorTipo muTipo = ManejadorTipo.getInstance();
		return muTipo.obtenerDataTipos();
	}
	
	public void borrarTipos() {
		ManejadorTipo muTipo = ManejadorTipo.getInstance();
		muTipo.clear();
	}
	
	public Boolean ingresarKeyword (String keyword) {
		ManejadorKeywords mk = ManejadorKeywords.getInstance();
		Boolean res = !mk.existeKeyword(keyword);
		if (res) {
			mk.agregarKeyword(keyword);
		}
		return res;
	}
}


