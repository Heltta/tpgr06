package Logica;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
	
	public boolean existeTipoPublicacion(String nombre) {
		return tiposPublicacion.containsKey(nombre);
	}
	
	public void agregar(TipoPublicacion tp) {
		tiposPublicacion.put(tp.getNombre(), tp);
	}
	public Set<String> obtenerTipos(){
		return this.tiposPublicacion.keySet();
	}
	public TipoPublicacion obtenerTipo(String nomTipo) {
		return this.tiposPublicacion.get(nomTipo);
	}
}
