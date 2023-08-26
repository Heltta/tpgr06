package Logica;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ManejadorOferta {
	
	static ManejadorOferta instancia=null;
	 private Map<String,OfertaLaboral> Ofertas;
	 
	 private ManejadorOferta() {
		 Ofertas = new HashMap<String,OfertaLaboral>();
	 }
	 public static ManejadorOferta getInstancia() {
		 if (instancia==null) {
			 instancia=new ManejadorOferta();
		 }
		 return instancia;
	 }
	 public OfertaLaboral obtenerOferta(String nomOferta) {
		 return this.Ofertas.get(nomOferta);
	 }
	 public void agregarOferta(OfertaLaboral o) {
		 this.Ofertas.put(o.getNombre(), o);
	 }
	 public Boolean existeOferta(String nomOferta) {
		 return this.Ofertas.containsKey(nomOferta);
	 }
	 public Map<String,OfertaLaboral> getOfertas(){
		 return Ofertas;
	 }
}
