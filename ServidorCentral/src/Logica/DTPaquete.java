package Logica;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DTPaquete {
	private String nombre;
	private Map<String, DTAgrupa> tiposPublicacion;
	
	public DTPaquete(PaqueteTipoPublicacion paquete) {
		this.nombre = paquete.getNombre();
		this.tiposPublicacion = new HashMap<String, DTAgrupa>();
		Map<String, Agrupa> tipos = paquete.getTiposPublicacion();
		for (Entry<String, Agrupa> agrupaTipo : tipos.entrySet()) {
			DTAgrupa dataAgrupa = new DTAgrupa(agrupaTipo.getValue().getCant(), agrupaTipo.getValue().getTipo());
			tiposPublicacion.put(dataAgrupa.getNombreTipo(), dataAgrupa);
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Map<String, DTAgrupa> getTipos(){
		return tiposPublicacion;
	}
}
