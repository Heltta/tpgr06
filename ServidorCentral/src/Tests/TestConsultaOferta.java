package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
		OfertaLaboral oferta = new OfertaLaboral("Desarrollador", "trabajo junior", "Ciudad", "Mdeo", horario, 3000, fecha, tipo, null);
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
}