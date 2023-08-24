package Tests;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Logica.DTHorario;
import Logica.Empresa;
import Logica.Fabrica;
import Logica.ITipos;
import Logica.IUsuario;
import Logica.ManejadorKeywords;
import Logica.ManejadorOferta;
import Logica.ManejadorTipo;
import Logica.ManejadorUsuario;
import Logica.OfertaLaboral;
import Logica.TipoPublicacion;

public class TestAltaOferta {
	private static Fabrica fab;
	private static IUsuario cu;
	
	public TestAltaOferta(){
		fab = Fabrica.getInstance();
		cu = fab.getIUsuario();
	}
	@SuppressWarnings("deprecation")
	@Test
	//Test funcionamiento normal
	void AltaOfertaTest1() {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorTipo mt = ManejadorTipo.getInstance();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		
		TipoPublicacion tipo1 = new TipoPublicacion("Tipo Prueba", "Este tipo es bueno", 2, new Date(2023,8,5), 500, 5);
		mt.agregar(tipo1);
		Empresa emp1 = new Empresa("emPrueba", "prueba@fing.com", "Roberto", "Bedelias", "Empresa Prueba", "Una empresa bien loca", null);
		mu.agregarUsuario(emp1);
		Set<String> setk = new HashSet<>(Arrays.asList("K1", "K2", "K3"));
		Boolean exito = cu.ingresarOferta("emPrueba", "Tipo Prueba", "Oferta Test", "Tremenda oferta", new DTHorario("10:30","16:15"), 0, new Date (2023,8,8), "La Paloma", "Rocha", setk);
		Assertions.assertTrue(exito);
		Assertions.assertTrue(mo.existeOferta("Oferta Test"));
		OfertaLaboral of = mo.obtenerOferta("Oferta Test");
		Assertions.assertEquals(of.getKeywords(),setk);
		Assertions.assertEquals(of.getTipo(),tipo1);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	//Test Oferta Repetida
	void AltaOfertaTest2() {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorTipo mt = ManejadorTipo.getInstance();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		
		TipoPublicacion tipo1 = new TipoPublicacion("Tipo Prueba2", "Este tipo es bueno", 2, new Date(2023,8,5), 500, 5);
		mt.agregar(tipo1);
		Empresa emp1 = new Empresa("emPrueba2", "prueba@fing.com", "Roberto", "Bedelias", "Empresa Prueba", "Una empresa bien loca", null);
		mu.agregarUsuario(emp1);
		Set<String> setk = new HashSet<>(Arrays.asList("K4", "K5", "K6"));
		cu.ingresarOferta("emPrueba2", "Tipo Prueba2", "Oferta Test", "Tremenda oferta", new DTHorario("10:30","16:15"), 0, new Date (2023,8,8), "La Paloma", "Rocha", setk);
		Boolean exito = cu.ingresarOferta("emPrueba2", "Tipo Prueba2", "Oferta Test", "Tremenda oferta", new DTHorario("10:30","16:15"), 0, new Date (2023,8,8), "La Paloma", "Rocha", setk);
		Assertions.assertFalse(exito);
	}
	@SuppressWarnings("deprecation")
	@Test
	//Test listados
	void AltaOfertaTest3() {
		ManejadorTipo mt = ManejadorTipo.getInstance();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		ManejadorKeywords mk = ManejadorKeywords.getInstance();
		mt.clear();
		mu.clear();
		
		TipoPublicacion tipo1 = new TipoPublicacion("Tipo Prueba1", "Este tipo es bueno", 2, new Date(2023,8,5), 500, 5);
		TipoPublicacion tipo2 = new TipoPublicacion("Tipo Prueba2", "Este tipo es bueno", 2, new Date(2023,8,5), 500, 5);
		mt.agregar(tipo1);
		mt.agregar(tipo2);
		Empresa emp1 = new Empresa("emPrueba1", "prueba@fing.com", "Roberto", "Bedelias", "Empresa Prueba", "Una empresa bien loca", null);
		Empresa emp2 = new Empresa("emPrueba2", "prueba@fing.com", "Roberto", "Bedelias", "Empresa Prueba", "Una empresa bien loca", null);
		mu.agregarUsuario(emp1);
		mu.agregarUsuario(emp2);
		mk.agregarKeyword("K1");
		mk.agregarKeyword("K2");
		
		Set<String> tipos = cu.listarTiposDePublicacion();
		Set<String> empresas = cu.listarEmpresas();
		Set<String> keywords = cu.listarKeywords();
		
		Assertions.assertEquals(empresas.size(), 2);
		Assertions.assertEquals(tipos.size(), 2);
		Assertions.assertEquals(keywords.size(), 2);
		Assertions.assertTrue(empresas.contains("emPrueba1"));
		Assertions.assertTrue(empresas.contains("emPrueba2"));
		Assertions.assertTrue(tipos.contains("Tipo Prueba1"));
		Assertions.assertTrue(tipos.contains("Tipo Prueba2"));
		Assertions.assertTrue(keywords.contains("K1"));
		Assertions.assertTrue(keywords.contains("K2"));
		
	}
	@Test
	//Listar con sets vacios
	void AltaOfertaTest4() {
		ManejadorTipo mt = ManejadorTipo.getInstance();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		ManejadorKeywords mk = ManejadorKeywords.getInstance();
		mt.clear();
		mu.clear();
		mk.clear();
		
		Set<String> tipos = cu.listarTiposDePublicacion();
		Set<String> empresas = cu.listarEmpresas();
		Set<String> keywords = cu.listarKeywords();
		
		Assertions.assertTrue(tipos.isEmpty());
		Assertions.assertTrue(empresas.isEmpty());
		Assertions.assertTrue(keywords.isEmpty());
}
}
