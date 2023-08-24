package Logica;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ManejadorUsuario {
 static ManejadorUsuario instancia=null;
 Map<String,Usuario> Usuarios;
 
 public ManejadorUsuario() {
	 Usuarios = new HashMap<String,Usuario>();
 }
 static ManejadorUsuario getInstancia() {
	 if (instancia==null) {
		 instancia=new ManejadorUsuario();
	 }
	 return instancia;
 }
 
 public Usuario obtenerUsuario(String nickUsuario) {
	 return Usuarios.get(nickUsuario);
 }
 public Set<String> obtenerUsuarios(){
	 return this.Usuarios.keySet();
 }
 public Set<String> obtenerPostulantes(){
	 Set<String> res = Collections.emptySet();
	 for (Iterator<Map.Entry<String, Usuario>> entries = this.Usuarios.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Usuario> entry = entries.next();
		    if (entry.getValue() instanceof Postulante) {		  
		    	res.add(entry.getKey());
		    }
	 }
	 return res;
 }
 public Set<String> obtenerEmpresas(){
	 Set<String> res = Collections.emptySet();
	 for (Iterator<Map.Entry<String, Usuario>> entries = this.Usuarios.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Usuario> entry = entries.next();
		    if (entry.getValue() instanceof Empresa) {
		    	res.add(entry.getKey());
		    }
	 }
	 return res;
 }
 
public void agregarUsuario(Usuario u) {
	this.Usuarios.put(u.getNickname(),u);
}
public Boolean existeUsuario(String nickUsuario) {
	return this.Usuarios.containsKey(nickUsuario);
}
}
