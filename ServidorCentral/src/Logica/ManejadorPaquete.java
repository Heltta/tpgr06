package Logica;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ManejadorPaquete {
	private static ManejadorPaquete instance = null;
	private Map<String, PaqueteTipoPublicacion> paquetes;
	
	public ManejadorPaquete() {
		paquetes = new HashMap<String, PaqueteTipoPublicacion>();
	}
	
	public static ManejadorPaquete getInstance() {
		if (instance == null) {
			instance = new ManejadorPaquete();
		}
		return instance;
	}

	public Set<String> obtenerPaquetes() {
		return paquetes.keySet();
	}
	
	public PaqueteTipoPublicacion obtenerPaquete(String nombrePaquete) {
		return paquetes.get(nombrePaquete);
	}

}
