package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;

import Logica.Fabrica;
import Logica.IUsuario;
import Logica.Postulante;
import Logica.DTEmpresa;
import Logica.DTPostulante;
import Logica.Empresa;

public class TestAltaUsuario {
	
	 @Test
	 void constructorPostulanteCasoValido() {
		 @SuppressWarnings("deprecation")
		DTPostulante datosValidos = new DTPostulante(
				 "peprulo",
				 "pepe_rulos34@gmail.com",
				 "Pepe",
				 "Rulo",
				 "Argentina",
				 new Date(5,12,1956),
				 new HashSet<String>());
		 
		 Postulante postulanteValido = new Postulante(
				 datosValidos.getNickname(),
				 datosValidos.getMail(),
				 datosValidos.getNombre(),
				 datosValidos.getApellido(),
				 datosValidos.getNacionalidad(),
				 datosValidos.getFechaNacimiento());
		 
		 assertEquals(datosValidos.getNickname(), postulanteValido.getNickname());
		 assertEquals(datosValidos.getMail(), postulanteValido.getMail());
		 assertEquals(datosValidos.getNombre(), postulanteValido.getNombre());
		 assertEquals(datosValidos.getApellido(), postulanteValido.getApellido());
		 assertEquals(datosValidos.getNacionalidad(), postulanteValido.getNacionalidad());
		 assertEquals(datosValidos.getFechaNacimiento(), postulanteValido.getFechaNacimiento());
	 }
	 
	 @Test
	 void constructorEmpresaCasoValido() {
		 DTEmpresa datosValidos = new DTEmpresa(
				 "mcrulo",
				 "pepe_rulos34@gmail.com",
				 "Mc'Pepe",
				 "Rulo Herrara",
				 "Rulería MC'Peperulo",
				 "Empresa de manufactura de rulos de diversos materiales, tamaños y funcionalidades.",
				 "https://www.google.com.uy",
				 new HashSet<String>());
		 
		 Empresa empresaValido = new Empresa(
				 datosValidos.getNickname(),
				 datosValidos.getMail(),
				 datosValidos.getNombre(),
				 datosValidos.getApellido(),
				 datosValidos.getNombreEmpresa(),
				 datosValidos.getDescripcion(),
				 datosValidos.getLink());

		 
		 assertEquals(datosValidos.getNickname(), empresaValido.getNickname());
		 assertEquals(datosValidos.getMail(), empresaValido.getMail());
		 assertEquals(datosValidos.getNombre(), empresaValido.getNombre());
		 assertEquals(datosValidos.getApellido(), empresaValido.getApellido());
		 assertEquals(datosValidos.getNombreEmpresa(), empresaValido.getNombreEmpresa());
		 assertEquals(datosValidos.getDescripcion(), empresaValido.getDescripcion());
		 assertEquals(datosValidos.getLink(), empresaValido.getLink());
	 }
	 
	 @Test
	 void ingresarPostulanteCasoValido() {
		 DTPostulante datosValidos = new DTPostulante(
			 "peprulo",
			 "pepe_rulos34@gmail.com",
			 "Pepe",
			 "Rulo",
			 "Argentina",
			 new Date(5,12,1956),
			 new HashSet<String>());
		
		Fabrica fab = Fabrica.getInstance();
		IUsuario ctrlUsuario = fab.getIUsuario();
		
		try {
			ctrlUsuario.ingresarPostulante(
					 datosValidos.getNickname(),
					 datosValidos.getNombre(),
					 datosValidos.getApellido(),
					 datosValidos.getMail(),
					 datosValidos.getFechaNacimiento(),
					 datosValidos.getNacionalidad());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	
		DTPostulante datosPostulanteCreado = (DTPostulante) ctrlUsuario.mostrarDatosUsuario(datosValidos.getNickname());

		 assertEquals(datosValidos.getNickname(), datosPostulanteCreado.getNickname());
		 assertEquals(datosValidos.getMail(), datosPostulanteCreado.getMail());
		 assertEquals(datosValidos.getNombre(), datosPostulanteCreado.getNombre());
		 assertEquals(datosValidos.getApellido(), datosPostulanteCreado.getApellido());
		 assertEquals(datosValidos.getNacionalidad(), datosPostulanteCreado.getNacionalidad());
		 assertEquals(datosValidos.getFechaNacimiento(), datosPostulanteCreado.getFechaNacimiento());
	 }
	 
	 @Test
	 void ingresarEmpresaCasoValido() {
		 DTEmpresa datosValidos = new DTEmpresa(
				 "mcrulo",
				 "ruleria-herrera-hnos@gmail.com",
				 "Mc'Pepe",
				 "Rulo Herrara",
				 "Rulería MC'Peperulo",
				 "Empresa de manufactura de rulos de diversos materiales, tamaños y funcionalidades.",
				 "https://www.google.com.uy",
				 new HashSet<String>());
		
		Fabrica fab = Fabrica.getInstance();
		IUsuario ctrlUsuario = fab.getIUsuario();
		
		try {
			ctrlUsuario.ingresarEmpresa(
					 datosValidos.getNickname(),
					 datosValidos.getNombre(),
					 datosValidos.getApellido(),
					 datosValidos.getMail(),
					 datosValidos.getNombreEmpresa(),
					 datosValidos.getDescripcion(),
					 datosValidos.getLink());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	
		DTEmpresa datosEmpresaCreado = (DTEmpresa) ctrlUsuario.mostrarDatosUsuario(datosValidos.getNickname());

		 assertEquals(datosValidos.getNickname(), datosEmpresaCreado.getNickname());
		 assertEquals(datosValidos.getMail(), datosEmpresaCreado.getMail());
		 assertEquals(datosValidos.getNombre(), datosEmpresaCreado.getNombre());
		 assertEquals(datosValidos.getApellido(), datosEmpresaCreado.getApellido());
		 assertEquals(datosValidos.getNombreEmpresa(), datosEmpresaCreado.getNombreEmpresa());
		 assertEquals(datosValidos.getDescripcion(), datosEmpresaCreado.getDescripcion());
		 assertEquals(datosValidos.getLink(), datosEmpresaCreado.getLink());
	 }
}
