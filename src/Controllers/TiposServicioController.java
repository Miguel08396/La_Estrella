package Controllers;

import java.util.LinkedList;

import Models.TiposServicioModel;
import Models.Class.TiposServicio;

public class TiposServicioController {

	private TiposServicioModel tiposServicioModel;

	public TiposServicioController() {
		this.tiposServicioModel = new TiposServicioModel();
	}

	public TiposServicio createServicesType(int opcion, int precio) {
		LinkedList<TiposServicio> list = this.tiposServicioModel.createServicesTypeDB();
		TiposServicio tipos = null;
		
		switch (opcion) {
		case 1:
		case 2:
		case 3:
		case 4:
			tipos = list.get(opcion - 1);
			tipos.setPreciotiposServicio(precio);
			break;

		default:
			tipos = list.get(opcion - 1);
			tipos.setPreciotiposServicio(precio);
			break;
		}
		
		return tipos;
	}
	
	public LinkedList<TiposServicio> readServicesType() {
		return this.tiposServicioModel.createServicesTypeDB();
	}

}