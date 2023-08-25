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
	public String getCiudad() {
		return ciudad;
	}
	public String getDepartamento() {
		return departamento;
	}
	public int getRemuneracion() {
		return remuneracion;
	}
	
	public Date getFecha() {
		return fecha;
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

	public TipoPublicacion getTipo() {
		return tipo;
	}

	public Set<String> getKeywords() {
		return Keywords;
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
	public Boolean existePostulante(String nombre) {
		return Postulantes.containsKey(nombre);
	}
	public void agregarPostulante(Postulante post) {
		if(!Postulantes.containsKey(post.getNickname())) {
			Postulantes.put(post.getNickname(), post);
		}
	}
}