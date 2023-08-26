package Tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Excepciones.PostulanteRepetido;
import Logica.DTHorario;
import Logica.Fabrica;
import Logica.IUsuario;
import Logica.ManejadorOferta;
import Logica.ManejadorUsuario;
import Logica.OfertaLaboral;
import Logica.Postulante;
import Logica.TipoPublicacion;

public class TestPostulacionOferta {
	private static IUsuario ctrlUsuario;
	
	@BeforeAll
	public static void Iniciar(){
		Fabrica fab = Fabrica.getInstance();
		ctrlUsuario = fab.getIUsuario();
	}
	@SuppressWarnings("deprecation")
	@Test
	//Test funcionamiento normal
	void PostulacionOfertaOK() throws PostulanteRepetido {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		mu.agregarUsuario(new Postulante("Juan123", "hola@mail.com", "Juan", "Perez", "Uruguayo", null));
		mo.agregarOferta(new OfertaLaboral("Desarrollador", "trabajo junior", "Ciudad", "Mdeo", new DTHorario("08:00", "17:00"), 3000, new Date(2023,3,4), new TipoPublicacion("Oro", "descrip", 1, new Date(2023,5,1), 1000, 5), null));
		String postulante = "Juan123";
		String cv = "Juan, soy estudiante.";
		String motivacion = "ganas de trabajar";
		String oferta = "Desarrollador";
		Date fecha = new Date(2023,5,5);
		ctrlUsuario.ingresarDatosPostulacion(postulante, cv, motivacion, oferta, fecha);
	}
	@SuppressWarnings("deprecation")
	@Test
	//Test funcionamiento con postulante repetido
	void PostulacionOfertaRepetido() throws PostulanteRepetido {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		Postulante post = new Postulante("Juan123", "hola@mail.com", "Juan", "Perez", "Uruguayo", null);
		mu.agregarUsuario(post);
		OfertaLaboral oferta = new OfertaLaboral("Desarrollador", "trabajo junior", "Ciudad", "Mdeo", new DTHorario("08:00", "17:00"), 3000, new Date(2023,3,4), new TipoPublicacion("Oro", "descrip", 1, new Date(2023,5,1), 1000, 5), null);
		//oferta.agregarPostulante(post);
		mo.agregarOferta(oferta);
		
		String postulante = "Juan123";
		String cv = "Juan, soy estudiante.";
		String motivacion = "ganas de trabajar";
		String nomOferta = "Desarrollador";
		Date fecha = new Date(2023,5,5);
		ctrlUsuario.ingresarDatosPostulacion(postulante, cv, motivacion, nomOferta, fecha);

		assertThrows(PostulanteRepetido.class, ()->{ctrlUsuario.ingresarDatosPostulacion(postulante, cv, motivacion, nomOferta, fecha);});
	}
}