package Logica;

import java.util.HashMap;
import java.util.Map;

public class ManejadorOferta {
	
	static ManejadorOferta instancia=null;
	 Map<String,OfertaLaboral> Ofertas;
	 
	 public ManejadorOferta() {
		 Ofertas = new HashMap<String,OfertaLaboral>();
	 }
	 static ManejadorOferta getInstancia() {
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
}
