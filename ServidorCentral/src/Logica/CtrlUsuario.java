package Logica;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

public class CtrlUsuario implements IUsuario{
	
	public ArrayList<String> listarUsuarios(){
		ManejadorUsuario manejador=ManejadorUsuario.getInstance();
		return manejador.getNicknames();
	}
	public DTUsuario mostrarDatosUsuario(String nickname) {
		ManejadorUsuario manejador=ManejadorUsuario.getInstance();
		Usuario u= manejador.getUsuario(nickname);
		DTUsuario datosUsuario;
		if(u instanceof Empresa) {
			Empresa e= (Empresa)u;
			datosUsuario=new DTEmpresa(e.getNickname(), e.getMail(), e.getNombre(), e.getApellido(), e.getNombreEmpresa(), e.getDescripcion(), e.getLink());
		}
		else {
			Postulante p= (Postulante)u;
			datosUsuario=new DTPostulante(p.getNickname(), p.getMail(), p.getNombre(), p.getApellido(), p.getNacionalidad(), p.getFechaNacimiento());
		}
		return datosUsuario;
	}
	public DTOfertaLaboral seleccionarOfertaLaboral(String nombre) {
		ManejadorOferta mo= ManejadorOferta.getInstancia();
		OfertaLaboral o = mo.obtenerOferta(nombre);
		String nombreTipo=o.getTipo().getNombre();
		Map<String,Postulante> postulantes= o.getPostulantes();
		Set<DTPostulacion> postulaciones = new TreeSet<>();
		postulantes.forEach((String nombrePostulante, Postulante postulante) -> {
			if(postulante.Postulaciones.containsKey(nombre)) {
				Postulacion postulacion= postulante.Postulaciones.get(nombre);
				DTPostulacion dataPostulacion= new DTPostulacion(postulacion.getFechaPostulacion(), postulacion.getResumenCV(), postulacion.getDescripcion(), nombre);
				postulaciones.add(dataPostulacion);
			}
		});
		DTOfertaLaboral dataOferta= new DTOfertaLaboral(o.getNombre() ,o.getDescripcion(), o.getCiudad(), o.getDepartamento(), o.getHorario(), o.getRemuneracion(), o.getFecha(), nombreTipo, o.getKeywords(), postulaciones);
		return dataOferta;
	}
	public Set<String> listarEmpresas(){
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
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
			ManejadorUsuario mu = ManejadorUsuario.getInstance();
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