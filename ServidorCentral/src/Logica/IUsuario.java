package Logica;

import Excepciones.PostulanteRepetido;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public interface IUsuario {
	public abstract Boolean ingresarOferta(String nickname,String nombreTipo, String nombre, String descripcion, DTHorario horario,int remuneracion,Date fecha,String ciudad,String departamento,Set<String> keyword);
	public abstract Set<String> listarTiposDePublicacion();
	public abstract Set<String> listarEmpresas();
	public abstract Set<String> listarKeywords();
	public abstract ArrayList<String> listarUsuarios();
	public abstract DTUsuario mostrarDatosUsuario(String nickname);
	public abstract DTOfertaLaboral seleccionarOfertaLaboral(String nombre);
	public abstract void ingresarDatosPostulacion(String postulante, String cv, String motivacion, String empresa, String oferta, Date fecha)throws PostulanteRepetido;
	public abstract Set<String> obtenerOfertasDeEmpresa(String empresa);
}
