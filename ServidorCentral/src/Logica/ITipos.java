package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import Excepciones.nombreTipoPublicacionRepetido;

public interface ITipos {

	 public abstract void ingresarDatosTipoPublicacion(String nombreT, String descripcionT, int exposicionT, Date fechaT, double costoT, double duracionT)
			throws nombreTipoPublicacionRepetido;
	
	public abstract Map<String, DTTipoPublicacion> obtenerDataTipos();
	
	public abstract void borrarTipos();
	public abstract Boolean ingresarKeyword(String keyword);
	
}
