package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Excepciones.PostulanteRepetido;
import Logica.DTEmpresa;
import Logica.DTHorario;
import Logica.DTPostulante;
import Logica.Fabrica;
import Logica.IUsuario;
import Logica.ManejadorOferta;
import Logica.ManejadorUsuario;
import Logica.OfertaLaboral;
import Logica.Postulante;
import Logica.Empresa;
import Logica.TipoPublicacion;

public class TestModificarUsuario {
	private static IUsuario ctrlUsuario;
	
	@BeforeAll
	public static void Iniciar(){
		Fabrica fab = Fabrica.getInstance();
		ctrlUsuario = fab.getIUsuario();
		
	}
	
	@Test
	void checkModUser1() {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		Date fecha = new Date(2023,3,4);
		LocalDate fecha2= LocalDate.of(2132, 1, 3); 
		Postulante post = new Postulante("Juan123", "hola@mail.com", "Juan", "Perez", "Uruguayo", fecha );
		DTHorario horario = new DTHorario("08:00", "17:00");
		TipoPublicacion tipo = new TipoPublicacion("Oro", "descrip", 1, new Date(2023,5,1), 1000, 5);
		OfertaLaboral oferta = new OfertaLaboral("Desarrollador", "trabajo junior", "Ciudad", "Mdeo", horario, 3000, fecha, tipo, new HashSet<String>());
		mo.agregarOferta(oferta);
		mu.agregarUsuario(post);
		try {
			ctrlUsuario.ingresarDatosPostulacion("Juan123", "CV", "motivacion", "Desarrollador", fecha);
		} catch (PostulanteRepetido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			ctrlUsuario.editarDatosBasicos("Juan123", "hola@mail.com", "Guillermo", "Gutierrez", "Ghana", new Date(1999, 7, 1), "Programador experimentado", "");
		DTPostulante datos = (DTPostulante) ctrlUsuario.mostrarDatosUsuario("Juan123");
		Date fechaaux = new Date(1999, 7, 1);
		assertEquals(datos.getNombre(), "Guillermo");
		assertEquals(datos.getApellido(), "Gutierrez");
		assertEquals(datos.getFechaNacimiento(), fechaaux);
		assertEquals(datos.getMail(), "hola@mail.com");
		assertEquals(datos.getNacionalidad(), "Ghana");
		assertEquals(datos.getNickname(), "Juan123");
		Set<String> nombreOfertas= datos.getNombreOfertas();
		HashSet<String> nombres = new HashSet<String>();
		nombres.add("Desarrollador");
		assertEquals(nombreOfertas.containsAll(nombres), true);
		assertEquals(nombres.containsAll(nombreOfertas), true);
	}
	
	@Test
	void checkModUser2() {
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		Empresa post = new Empresa("Juan123", "hola@mail.com", "Juan", "Perez", "ANTEL", "Empresa de telecomunicaciones", "antel.com.uy" );
		mu.agregarUsuario(post);
		ctrlUsuario.editarDatosBasicos("Juan123", "hola@mail.com", "Guillermo", "Gutierrez", "", null, "Chofer experimentado", "copsa.com.uy");
		DTEmpresa datos = (DTEmpresa) ctrlUsuario.mostrarDatosUsuario("Juan123");
		assertEquals(datos.getNombre(), "Guillermo");
		assertEquals(datos.getApellido(), "Gutierrez");
		assertEquals(datos.getMail(), "hola@mail.com");
		assertEquals(datos.getNickname(), "Juan123");
		assertEquals(datos.getDescripcion(), "Chofer experimentado");
		assertEquals(datos.getLink(), "copsa.com.uy");
	}
}
