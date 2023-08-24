package Logica;

import java.util.Date;

import Excepciones.PostulanteRepetido;

public interface IUsuario {

	void ingresarDatosPostulacion(String postulante, String cv, String motivacion, String empresa, String oferta, Date fecha)throws PostulanteRepetido;
}
