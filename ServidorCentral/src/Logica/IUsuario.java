package Logica;

import java.util.Date;
import java.util.Set;

public interface IUsuario {
	public abstract Boolean ingresarOferta(String nickname,String nombreTipo, String nombre, String descripcion, DTHorario horario,int remuneracion,Date fecha,String ciudad,String departamento,Set<String> keyword);
	public abstract Set<String> listarTiposDePublicacion();
	public abstract Set<String> listarEmpresas();
	public abstract Set<String> listarKeywords();
}
