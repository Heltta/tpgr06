package com.trabajouy.model;
import java.time.LocalDate;
import java.util.Map;

public class Compra {
	private Empresa comprador;
	private PaqueteTipoPublicacion producto;
	private LocalDate fechaCompra;
	private Map<String, Agrupa> tiposNoCanjeados;
	private double costo;
	private LocalDate fechaVencimiento;
	
	public Compra(Empresa comprador, PaqueteTipoPublicacion producto){
		this.producto=producto;
		this.comprador=comprador;
		fechaCompra= LocalDate.now();
		this.costo=producto.getCosto();
		this.fechaVencimiento= fechaCompra.plusDays(producto.getPeriodoValidez());
		this.tiposNoCanjeados=producto.getTiposPublicacion();
	}

	public Empresa getComprador() {
		return comprador;
	}
	public PaqueteTipoPublicacion getProducto() {
		return producto;
	}
	
	public void canjearTipo(String nombreTipo) {
		Agrupa a =tiposNoCanjeados.get(nombreTipo);
		if(a!=null) {
			int nuevaCantidad=a.getCant()-1;
			if(nuevaCantidad==0) {
				tiposNoCanjeados.remove(nombreTipo);
			}else {
				a.setCant(nuevaCantidad);
			}
		}
	}
	public Map<String,Agrupa> getTiposNoCanjeados(){
		return tiposNoCanjeados;
	}
}