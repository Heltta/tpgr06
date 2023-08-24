package Logica;
import java.time.LocalTime;

public class DTHorario {
	private LocalTime horarioInicio;
	private LocalTime horarioFin;
	
	public DTHorario(String horIn,String horFin) {
		this.horarioInicio=LocalTime.parse(horIn);
		this.horarioFin=LocalTime.parse(horFin);
	}

}
