package Logica;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ManejadorKeywords {
	private static ManejadorKeywords instance = null;
	private Map<String, Keyword> keywords;
	
	public ManejadorKeywords() {
		keywords = new HashMap<String, Keyword>();
	}
	
	public static ManejadorKeywords getInstance() {
		if (instance == null) {
			instance = new ManejadorKeywords();
		}
		return instance;
	}
	public Set<String> obtenerKeywords(){
		return this.keywords.keySet();
	}
}
