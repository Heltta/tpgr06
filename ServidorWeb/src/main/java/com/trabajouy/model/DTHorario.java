package com.trabajouy.model;
import java.time.LocalTime;

public class DTHorario {
	private LocalTime horarioInicio;
	private LocalTime horarioFin;
	
	public DTHorario(String horIn,String horFin) {
		this.horarioInicio=LocalTime.parse(horIn);
		this.horarioFin=LocalTime.parse(horFin);
	}
	public LocalTime getInicio() {
		return this.horarioInicio;
	}
	public LocalTime getFin() {
		return this.horarioFin;
	}
}
