package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Excepciones.PostulanteRepetido;
import Logica.DTHorario;
import Logica.DTOfertaLaboral;
import Logica.DTPostulacion;
import Logica.Empresa;
import Logica.Fabrica;
import Logica.IUsuario;
import Logica.ManejadorOferta;
import Logica.ManejadorUsuario;
import Logica.OfertaLaboral;
import Logica.Postulante;
import Logica.TipoPublicacion;

public class TestConsultaOferta {
	private static IUsuario ctrlUsuario;
	
	@BeforeAll
	public static void Iniciar(){
		Fabrica fab = Fabrica.getInstance();
		ctrlUsuario = fab.getIUsuario();
	}
	@SuppressWarnings("deprecation")
	@Test
	//Test funcionamiento normal
	void ConsultaOfertaOK()  {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		Postulante post = new Postulante("Juan123", "hola@mail.com", "Juan", "Perez", "Uruguayo", null);
		Empresa emp = new Empresa("Artech123", "artech@mail.com", "Rodrigo", "Rodriguez", "Artech SA", "Empresa de tecnologia", "asd");
		DTHorario horario = new DTHorario("08:00", "17:00");
		Date fecha = new Date(2023,3,4);
		TipoPublicacion tipo = new TipoPublicacion("Oro", "descrip", 1, new Date(2023,5,1), 1000, 5);
		OfertaLaboral oferta = new OfertaLaboral("Desarrollador", "trabajo junior", "Ciudad", "Mdeo", horario, 3000, fecha, tipo, new HashSet<String>());
		emp.agregarOferta(oferta);
		mu.agregarUsuario(post);
		mu.agregarUsuario(emp);
		mo.agregarOferta(oferta);
		DTOfertaLaboral datos = ctrlUsuario.seleccionarOfertaLaboral("Desarrollador");
		assertEquals(datos.getNombre(), "Desarrollador");
		assertEquals(datos.getDescripcion(), "trabajo junior");
		assertEquals(datos.getCiudad(), "Ciudad");
		assertEquals(datos.getDepartamento(), "Mdeo");
		assertEquals(datos.getHorario(), horario);
		assertEquals(datos.getRemuneracion(), 3000);
		assertEquals(datos.getFecha(), fecha);
		assertEquals(datos.getTipo(), tipo.getNombre());
	}
	@SuppressWarnings("deprecation")
	@Test
	void ConsultaOfertaListado() throws PostulanteRepetido  {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		Postulante post = new Postulante("Juan123", "hola@mail.com", "Juan", "Perez", "Uruguayo", null);
		Empresa emp = new Empresa("Artech123", "artech@mail.com", "Rodrigo", "Rodriguez", "Artech SA", "Empresa de tecnologia", "asd");
		DTHorario horario = new DTHorario("08:00", "17:00");
		Date fecha = new Date(2023,3,4);
		TipoPublicacion tipo = new TipoPublicacion("Oro", "descrip", 1, new Date(2023,5,1), 1000, 5);
		OfertaLaboral oferta = new OfertaLaboral("Desarrollador", "trabajo junior", "Ciudad", "Mdeo", horario, 3000, fecha, tipo, new HashSet<String>());
		emp.agregarOferta(oferta);
		mu.agregarUsuario(post);
		mu.agregarUsuario(emp);
		mo.agregarOferta(oferta);
		String postulante = "Juan123";
		String cv = "Juan, soy estudiante.";
		String motivacion = "ganas de trabajar";
		String ofertan = "Desarrollador";
		ctrlUsuario.ingresarDatosPostulacion(postulante, cv, motivacion, ofertan, fecha);
		DTOfertaLaboral dt= ctrlUsuario.seleccionarOfertaLaboral(ofertan);
		Set<DTPostulacion> postu = dt.getPostulaciones();
		Set<String> Ofertas = ctrlUsuario.obtenerOfertasDeEmpresa("Artech123");
		Assertions.assertEquals(postu.size(), 1);
		Assertions.assertEquals(Ofertas.size(), 1);
		Assertions.assertTrue(Ofertas.contains("Desarrollador"));
		
	}
}