package Logica;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class OfertaLaboral {
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private DTHorario horario;
	private int remuneracion;
	private Date fecha;
	private double costo;
	private Map<String,Postulante> Postulantes;
	private TipoPublicacion tipo;
	private Set<String> Keywords;
	private Compra compra;
	
	public OfertaLaboral(String nombre,String descripcion, String ciudad, String departamento, DTHorario horario, int remuneracion,
			Date fecha, TipoPublicacion tipo, Set<String> keywords) {
		super();
		this.nombre = nombre;
		this.descripcion=descripcion;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.horario = horario;
		this.remuneracion = remuneracion;
		this.fecha = fecha;
		this.tipo = tipo;
		Keywords = keywords;
		Postulantes=null;
		compra=null;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public int getRemuneracion() {
		return remuneracion;
	}
	public void setRemuneracion(int remuneracion) {
		this.remuneracion = remuneracion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto() {
		if (this.compra==null) {
			this.costo=this.tipo.getCosto();
		}
		//Faltaria el tema costo con compra de paquete pero todavia no hay caso de uso
	}
	public Map<String, Postulante> getPostulantes() {
		return Postulantes;
	}
	public void setPostulantes(Map<String, Postulante> postulantes) {
		Postulantes = postulantes;
	}
	public TipoPublicacion getTipo() {
		return tipo;
	}
	public void setTipo(TipoPublicacion tipo) {
		this.tipo = tipo;
	}
	public Set<String> getKeywords() {
		return Keywords;
	}
	public void setKeywords(Set<String> keywords) {
		Keywords = keywords;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public DTHorario getHorario() {
		return horario;
	}
}