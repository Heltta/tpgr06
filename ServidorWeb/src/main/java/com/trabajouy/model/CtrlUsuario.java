package com.trabajouy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import com.trabajouy.exceptions.*;

public class CtrlUsuario implements IUsuario {
	

	public void ingresarDatosPostulacion(String postulante, String cv, String motivacion, String oferta, Date fecha) throws PostulanteRepetido {
		ManejadorOferta mo = ManejadorOferta.getInstancia();
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		OfertaLaboral ofertaLab = mo.obtenerOferta(oferta);
		if (ofertaLab != null) {
			if (ofertaLab.existePostulante(postulante)) {
				throw new PostulanteRepetido("El usuario " + postulante + " ya se encuentra postulado a la oferta laboral seleccionada");
			}else {
				((Postulante) mu.getUsuario(postulante)).postularAOferta(ofertaLab, fecha, cv, motivacion);
			}
		}
	}

	public ArrayList<String> listarUsuarios(){
		ManejadorUsuario manejador=ManejadorUsuario.getInstance();
		return manejador.getNicknames();
	}
	
	public void editarDatosBasicos(String nickname, String email, String nombre, String apellido, String nacionalidad, Date fecha, String descripcion, String link) {
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		Usuario user = mu.getUsuario(nickname);
		user.setNombre(nombre);
		user.setApellido(apellido);
		if(user instanceof Postulante) {
			((Postulante) user).setNacionalidad(nacionalidad);
			((Postulante) user).setFechaNacimiento(fecha);
		} else if (user instanceof Empresa) {
			((Empresa) user).setDescripcion(descripcion);
			((Empresa) user).setLink(link);
		}
	}
	
	//Solo recibe nombre de postulante
	public DTPostulante getDataPostulante(String nombre) {
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		Postulante user = (Postulante) mu.getUsuario(nombre);
		DTPostulante dataPostulante = new DTPostulante(user.getNickname(), user.getMail(), user.getNombre(), user.getApellido(),
				user.getNacionalidad(), user.getFechaNacimiento(), user.getPostulaciones().keySet());
		return dataPostulante;
	}
	
	//Solo recibe nombre de empresa
	public DTEmpresa getDataEmpresa(String nombre) {
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		Empresa user = (Empresa) mu.getUsuario(nombre);
		DTEmpresa dataEmpresa = new DTEmpresa(user.getNickname(), user.getMail(), user.getNombre(), user.getApellido(),
				user.getNombreEmpresa(), user.getDescripcion(), user.getLink(), user.getOfertas().keySet());
		return dataEmpresa;
	}
	
	public DTUsuario mostrarDatosUsuario(String nickname) {
		ManejadorUsuario manejador=ManejadorUsuario.getInstance();
		Usuario u= manejador.getUsuario(nickname);
		DTUsuario datosUsuario;
		ManejadorOferta mo= ManejadorOferta.getInstancia();
		Map<String,OfertaLaboral> ofertasLaborales= mo.getOfertas();
		if(u instanceof Empresa) {
			Empresa e= (Empresa)u;
			Set<String> nombreOfertasEmpresa= e.getOfertas().keySet();
			datosUsuario=new DTEmpresa(e.getNickname(), e.getMail(), e.getNombre(), e.getApellido(), e.getNombreEmpresa(), e.getDescripcion(), e.getLink(), nombreOfertasEmpresa);
		}
		else {
			Postulante p= (Postulante)u;
			Set<String> nombreOfertasPostulante= p.getPostulaciones().keySet();
			datosUsuario=new DTPostulante(p.getNickname(), p.getMail(), p.getNombre(), p.getApellido(), p.getNacionalidad(), p.getFechaNacimiento(), nombreOfertasPostulante);
		}
		return datosUsuario;
	}

	public DTOfertaLaboral seleccionarOfertaLaboral(String nombre) {
		ManejadorOferta mo= ManejadorOferta.getInstancia();
		OfertaLaboral o = mo.obtenerOferta(nombre);
		String nombreTipo=o.getTipo().getNombre();
		Map<String,Postulante> postulantes= o.getPostulantes();
		Set<DTPostulacion> postulaciones = new HashSet<>();
		
		Iterator<String> it = postulantes.keySet().iterator();
		while(it.hasNext()){
		    String clave = it.next();
		    Postulante post = postulantes.get(clave);
		    if (post.Postulaciones.containsKey(nombre)) {
		    	Postulacion postulacion = post.Postulaciones.get(nombre);
		    	DTPostulacion dataPostulacion= new DTPostulacion(postulacion.getFechaPostulacion(), postulacion.getResumenCV(), postulacion.getDescripcion(), nombre, post.getNickname());
				postulaciones.add(dataPostulacion);
		    }
		}
		DTOfertaLaboral dataOferta= new DTOfertaLaboral(o.getNombre() ,o.getDescripcion(), o.getCiudad(), o.getDepartamento(), o.getHorario(), o.getRemuneracion(), o.getFecha(), nombreTipo, o.getKeywords(), postulaciones, o.getCosto());
		return dataOferta;
		

	}
	public Set<String> listarEmpresas(){
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		return mu.obtenerEmpresas();
	}
	public Set<String> listarPostulantes(){
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		return mu.obtenerPostulantes();
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
			Empresa e = (Empresa) mu.getUsuario(nickname);
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
	public Set<String> obtenerOfertasDeEmpresa(String empresa){
		ManejadorUsuario mu = ManejadorUsuario.getInstance();
		if(mu.existeUsuario(empresa)) {
			return ((Empresa) mu.getUsuario(empresa)).getNombreOfertas();
		}else {
			return new HashSet<String>();
		}
	}
	
	private void checkUnicidad(String email, String nick) throws Exception {
		ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstance();
		if(manejadorUsuario.existeEmailDeUsuario(email)) {
			throw new Exception("Correo electrónico ya existe");
		}
		if(manejadorUsuario.existeUsuario(nick)) {
			throw new Exception("Nickname ya existe");
		}
	}
	
	public void ingresarPostulante(
			String nickName,
			String nombre,
			String apellido,
			String correoElectronico,
			Date fechaNacimiento,
			String nacionalidad) throws Exception {
		
		ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstance();
		
		checkUnicidad(correoElectronico, nickName);
		manejadorUsuario.agregarUsuario(new Postulante(nickName, correoElectronico, nombre, apellido, nacionalidad, fechaNacimiento));
	}
	
	public void ingresarEmpresa(
			String nickName,
			String nombre,
			String apellido,
			String correoElectronico,
			String nombreEmpresa,
			String descripcion,
			String link) throws Exception {
		
		ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstance();
		
		checkUnicidad(correoElectronico, nickName);
		
		manejadorUsuario.agregarUsuario(new Empresa(nickName, correoElectronico, nombre, apellido, nombreEmpresa, descripcion, link));
	}
}
