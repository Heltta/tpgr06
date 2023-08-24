package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import Excepciones.nombreTipoPublicacionRepetido;

public interface ITipos {

	void ingresarDatosTipoPublicacion(String nombreT, String descripcionT, int exposicionT, Date fechaT, double costoT, double duracionT) 
			throws nombreTipoPublicacionRepetido;
	
	public Map<String, DTTipoPublicacion> obtenerDataTipos();
	
	public void borrarTipos();
}
