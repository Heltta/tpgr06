package Logica;

import java.util.Date;

import Excepciones.nombreTipoPublicacionRepetido;

public interface ITipos {

	void ingresarDatosTipoPublicacion(String nombreT, String descripcionT, int exposicionT, Date fechaT, double costoT, double duracionT) 
			throws nombreTipoPublicacionRepetido;

}
