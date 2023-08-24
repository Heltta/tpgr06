package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ManejadorUsuario {
	
	Map<String,Usuario> usuarios;
	private static ManejadorUsuario instance;
	
	public static ManejadorUsuario getInstance() {
		if(instance==null) {
			instance=new ManejadorUsuario();
		}
		return instance;
	}
	
	public ManejadorUsuario() {
		usuarios= new HashMap<String,Usuario>();
	}
	
	public ArrayList<String> getNicknames(){
		ArrayList<String> nicknames = new ArrayList<String>();
		usuarios.forEach((nickname, usuario)->{
			nicknames.add(nickname);
			} 
		);
		return nicknames;
	}
	public Usuario getUsuario(String nickname) {
		
		Usuario u=null;
		if(usuarios.containsKey(nickname)) {
			u=usuarios.get(nickname);
		}
		return u;
	}
}
