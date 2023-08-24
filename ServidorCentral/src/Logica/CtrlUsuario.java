package Logica;

import java.util.Date;
import java.util.Set;

public class CtrlUsuario implements IUsuario {
	public Set<String> listarEmpresas(){
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		return mu.obtenerEmpresas();
	}
	public Set<String> listarTiposDePublicacion(){
		ManejadorTipo mt = ManejadorTipo.getInstance();
		return mt.obtenerTipos();
	}
	
	public Boolean ingresarOferta(String nickname,String nombreTipo, String nombre, String descripcion, DTHorario horario,int remuneracion,Date fecha,String ciudad,String departamento,Set<String> keyword) {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		Boolean res = !mo.existeOferta(nombre);
		
		if (res) {
			ManejadorTipo mt = ManejadorTipo.getInstance();
			TipoPublicacion tipo = mt.obtenerTipo(nombreTipo);
			ManejadorUsuario mu = ManejadorUsuario.getInstancia();
			Empresa e = (Empresa) mu.obtenerUsuario(nickname);
			OfertaLaboral o = new OfertaLaboral(nombre,descripcion,ciudad,departamento,horario,remuneracion,fecha,tipo,keyword);
			o.setCosto();
			e.agregarOferta(o);
			mo.agregarOferta(o);
		}
		return res;
	}
	public Set<String> listarKeywords(){
		ManejadorKeywords mk = ManejadorKeywords.getInstance();
		return mk.obtenerKeywords();
	}
}