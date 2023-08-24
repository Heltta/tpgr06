package Logica;

import java.util.Date;

import Excepciones.nombreTipoPublicacionRepetido;

public class CtrlTipos implements ITipos {
	public void ingresarDatosTipoPublicacion(String nombreT, String descripcionT, int exposicionT, Date fechaT,
			double costoT, double duracionT) throws nombreTipoPublicacionRepetido {
		ManejadorTipo muTipo = ManejadorTipo.getInstance();
		boolean existeNombre = muTipo.obtenerTipoPublicacion(nombreT);
		if (existeNombre) {
			throw new nombreTipoPublicacionRepetido("Ya existe un tipo de publicacion de nombre" + nombreT);
		}
			TipoPublicacion nuevoTipo = new TipoPublicacion(nombreT, descripcionT, exposicionT, fechaT, costoT, duracionT);
			muTipo.agregar(nuevoTipo);
	}
}


