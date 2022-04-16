package Models;

import java.util.LinkedList;

import Models.Class.TiposServicio;

public class TiposServicioModel {
	
	private LinkedList<TiposServicio> list;
	
	public TiposServicioModel() {
		this.list = new LinkedList<TiposServicio>();
	}
	
	public LinkedList<TiposServicio> createServicesTypeDB() {
		this.list.add(new TiposServicio("LAVADO BASICO", "Incluye lavado exterior, lavado interior y aspirada.", 0));
		this.list.add(new TiposServicio("LAVADO ESPECIAL", "Incluye lavado basico mas polichado con maquina y las mejores ceras de calidad.", 0));
		this.list.add(new TiposServicio("DESINFECCION BASICA", "Con maquina generadora de ozono.", 0));
		this.list.add(new TiposServicio("DESINFECCION AVANZADA", "Ademas de la desinfección basica, Limpieza interior con maquina de vapor.", 0));
		
		return this.list;
	}

}