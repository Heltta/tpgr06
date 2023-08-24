package Tests;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Excepciones.nombreTipoPublicacionRepetido;
import Logica.Fabrica;
import Logica.ITipos;

public class TestAltaTipoPublicacion {
	
	@Test
	void AltaTipoPublicacion1(){
		Fabrica fab = Fabrica.getInstance();
		ITipos ctrlTipos = fab.getITipos();
		@SuppressWarnings("deprecation")
		nombreTipoPublicacionRepetido thrown = Assertions.assertThrows(nombreTipoPublicacionRepetido.class, () -> {
			ctrlTipos.ingresarDatosTipoPublicacion("Deluxe", "Paquete economico para pequeñas empresas", 0, new Date(2023,4,12), 0, 0);
			ctrlTipos.ingresarDatosTipoPublicacion("Deluxe", "Paquete economico para medianas empresas", 0, new Date(2023,8,9), 1, 2);
		});
		Assertions.assertEquals("Ya existe un tipo de publicacion de nombre Deluxe", thrown.getMessage());
	}
}


