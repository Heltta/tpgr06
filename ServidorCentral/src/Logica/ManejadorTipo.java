package Logica;

import java.util.HashMap;
import java.util.Map;

public class ManejadorTipo {
	private static ManejadorTipo instance = null;
	private Map<String, TipoPublicacion> tiposPublicacion;
	
	public ManejadorTipo() {
		tiposPublicacion = new HashMap<String, TipoPublicacion>();
	}
	
	public static ManejadorTipo getInstance() {
		if (instance == null) {
			instance = new ManejadorTipo();
		}
		return instance;
	}
	
	public boolean obtenerTipoPublicacion(String nombre) {
		return tiposPublicacion.containsKey(nombre);
	}
	
	public void agregar(TipoPublicacion tp) {
		tiposPublicacion.put(tp.getNombre(), tp);
	}
}
