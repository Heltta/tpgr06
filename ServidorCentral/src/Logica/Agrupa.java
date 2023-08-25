package Logica;

public class Agrupa {
	private TipoPublicacion tipo;
	private int cant;
	
	public Agrupa(TipoPublicacion tipo, int cant) {
		this.tipo = tipo;
		this.cant = cant;
	}
	
	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
}
