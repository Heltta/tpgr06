package Logica;

import java.util.Date;

import Excepciones.PostulanteRepetido;

public class CtrlUsuario implements IUsuario {

	public void ingresarDatosPostulacion(String postulante, String cv, String motivacion, String empresa, String oferta, Date fecha) throws PostulanteRepetido {
		throw new PostulanteRepetido("El usuario " + postulante + " ya se encuentra postulado a la oferta laboral seleccionada");
	}
}
