package com.trabajouy.model;

import com.trabajouy.exceptions.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public interface IUsuario {
	public abstract Boolean ingresarOferta(String nickname,String nombreTipo, String nombre, String descripcion, DTHorario horario,int remuneracion,Date fecha,String ciudad,String departamento,Set<String> keyword) throws Exception;
	public abstract Set<String> listarTiposDePublicacion();
	public abstract Set<String> listarEmpresas();
	public abstract Set<String> listarPostulantes();
	public abstract Set<String> listarKeywords();
	public abstract ArrayList<String> listarUsuarios();
	public abstract DTUsuario mostrarDatosUsuario(String nickname);
	public abstract DTOfertaLaboral seleccionarOfertaLaboral(String nombre) throws Exception;
	public abstract Set<DTOfertaLaboral> listarOfertasLaborales();
	public abstract void ingresarDatosPostulacion(String postulante, String cv, String motivacion, String oferta, Date fecha)throws Exception;
	public abstract Set<String> obtenerOfertasDeEmpresa(String empresa);
	public DTEmpresa getDataEmpresa(String nombre);
	public DTPostulante getDataPostulante(String nombre);
	public abstract void ingresarPostulante(String nickName,String nombre,String apellido,
			String correoElectronico,Date fechaNacimiento,String nacionalidad) throws Exception;
	
	public abstract void ingresarEmpresa(String nickName,String nombre,String apellido,
			String correoElectronico,String nombreEmpresa,String descripcion,String link) throws Exception;
	public void editarDatosBasicos(String nickname, String email, String nombre, String apellido, String nacionalidad, Date fecha, String descripcion, String link);
}
