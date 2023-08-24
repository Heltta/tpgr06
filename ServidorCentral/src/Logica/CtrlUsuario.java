package Logica;


import java.util.ArrayList;

public class CtrlUsuario implements IUsuario{
	
	public ArrayList<String> listarUsuarios(){
		ManejadorUsuario manejador=ManejadorUsuario.getInstance();
		return manejador.getNicknames();
	}
	public DTUsuario mostrarDatosUsuario(String nickname) {
		ManejadorUsuario manejador=ManejadorUsuario.getInstance();
		Usuario u= manejador.getUsuario(nickname);
		DTUsuario datosUsuario= new DTUsuario(u.getNickname(), u.getMail(), u.getNombre(), u.getApellido());
		return datosUsuario;
	}
}