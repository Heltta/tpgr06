package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class ManejadorUsuario {
	
	Map<String,Usuario> usuarios;
	Map<String,Usuario> usuariosByEmail; // map usando al email como key
	private static ManejadorUsuario instance;
	
	public static ManejadorUsuario getInstance() {
		if(instance==null) {
			instance=new ManejadorUsuario();
		}
		return instance;
	}
	
	private ManejadorUsuario() {
		usuarios= new HashMap<String,Usuario>();
		usuariosByEmail= new HashMap<String,Usuario>();
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
 
 public Set<String> obtenerUsuarios(){
	 return this.usuarios.keySet();
 }
 
 public Set<String> obtenerPostulantes(){
	 Set<String> res = new HashSet<String>();
	 for (Iterator<Map.Entry<String, Usuario>> entries = this.usuarios.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Usuario> entry = entries.next();
		    if (entry.getValue() instanceof Postulante) {		  
		    	res.add(entry.getKey());
		    }
	 }
	 return res;
 }
 public Set<String> obtenerEmpresas(){
	 
	 Set<String> res = new HashSet<String>();
	 for (Iterator<Map.Entry<String, Usuario>> entries = this.usuarios.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Usuario> entry = entries.next();
		    if (entry.getValue() instanceof Empresa) {
		    	res.add(entry.getKey());
		    }
	 }
	 return res;
 }
 
public void agregarUsuario(Usuario u) {
	this.usuarios.put(u.getNickname(),u);
	this.usuariosByEmail.put(u.getMail(),u);
}
public Boolean existeUsuario(String nickUsuario) {
	return this.usuarios.containsKey(nickUsuario);
}

	public Boolean existeEmailDeUsuario(String emailUsuario) {
		return this.usuariosByEmail.containsKey(emailUsuario);
	}

public void clear() {
	this.usuarios.clear();
	this.usuariosByEmail.clear();
}
}
