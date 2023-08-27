package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Excepciones.PostulanteRepetido;
import Logica.DTEmpresa;
import Logica.DTPostulante;
import Logica.DTUsuario;
import Logica.DTHorario;
import Logica.DTOfertaLaboral;
import Logica.Empresa;
import Logica.Fabrica;
import Logica.IUsuario;
import Logica.ManejadorOferta;
import Logica.ManejadorUsuario;
import Logica.OfertaLaboral;
import Logica.Postulante;
import Logica.TipoPublicacion;

public class TestConsultaUsuario {
	private static IUsuario ctrlUsuario;
	
	@BeforeAll
	public static void Iniciar(){
		Fabrica fab = Fabrica.getInstance();
		ctrlUsuario = fab.getIUsuario();
		
	}
	@SuppressWarnings("deprecation")

	@Test
	void checkConsultaPostulante() {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		Date fecha = new Date(2023,3,4);
		LocalDate fecha2= LocalDate.of(2132, 1, 3); 
		Postulante post = new Postulante("Juan123", "hola@mail.com", "Juan", "Perez", "Uruguayo", fecha );
		DTHorario horario = new DTHorario("08:00", "17:00");
		TipoPublicacion tipo = new TipoPublicacion("Oro", "descrip", 1, new Date(2023,5,1), 1000, 5);
		OfertaLaboral oferta = new OfertaLaboral("Desarrollador", "trabajo junior", "Ciudad", "Mdeo", horario, 3000, fecha, tipo, null);
		mo.agregarOferta(oferta);
		mu.agregarUsuario(post);
		try {
			ctrlUsuario.ingresarDatosPostulacion("Juan123", "CV", "motivacion", "Desarrollador", fecha);
		} catch (PostulanteRepetido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DTPostulante datos = (DTPostulante) ctrlUsuario.mostrarDatosUsuario("Juan123");
		assertEquals(datos.getNombre(), "Juan");
		assertEquals(datos.getApellido(), "Perez");
		assertEquals(datos.getFechaNacimiento(), fecha);
		assertEquals(datos.getMail(), "hola@mail.com");
		assertEquals(datos.getNacionalidad(), "Uruguayo");
		assertEquals(datos.getNickname(), "Juan123");
		Set<String> nombreOfertas= datos.getNombreOfertas();
		HashSet<String> nombres = new HashSet<String>();
		nombres.add("Desarrollador");
		assertEquals(nombreOfertas.containsAll(nombres), true);
		assertEquals(nombres.containsAll(nombreOfertas), true);
	}
	@Test
	void checkConsultaEmpresa() {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		Empresa emp = new Empresa("Artech123", "artech@mail.com", "Rodrigo", "Rodriguez", "Artech SA", "Empresa de tecnologia", "asd");
		DTHorario horario = new DTHorario("08:00", "17:00");
		Date fecha = new Date(2023,3,4);
		TipoPublicacion tipo = new TipoPublicacion("Oro", "descrip", 1, new Date(2023,5,1), 1000, 5);
		OfertaLaboral oferta = new OfertaLaboral("Desarrollador", "trabajo junior", "Ciudad", "Mdeo", horario, 3000, fecha, tipo, null);
		emp.agregarOferta(oferta);
		mu.agregarUsuario(emp);
		mo.agregarOferta(oferta);
		DTEmpresa datos = (DTEmpresa) ctrlUsuario.mostrarDatosUsuario("Artech123");
		assertEquals(datos.getNombre(), "Rodrigo");
		assertEquals(datos.getApellido(), "Rodriguez");
		assertEquals(datos.getDescripcion(), "Empresa de tecnologia");
		assertEquals(datos.getMail(), "artech@mail.com");
		assertEquals(datos.getLink(), "asd");
		assertEquals(datos.getNickname(), "Artech123");
		Set<String> nombreOfertas= datos.getNombreOfertas();
		assertEquals(nombreOfertas.size(),1);
		HashSet<String> nombres = new HashSet<String>();
		nombres.add("Desarrollador");
		assertEquals(nombreOfertas.containsAll(nombres), true);
		assertEquals(nombres.containsAll(nombreOfertas), true);

	}
}