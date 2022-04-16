package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Models.Class.TiposServicio;
import Views.LavadoView;

public class LavadoController implements ActionListener, ItemListener {
	
	private LavadoView lavadoView;
	private TiposServicioController tiposServicioController;
	
	public LavadoController(LavadoView lavadoView) {
		this.lavadoView = lavadoView;
		this.tiposServicioController = new TiposServicioController();
		// 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.lavadoView.BtnLavar) {
			this.generateInvoice();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			this.setInformation(String.valueOf(e.getItem()));
		}
	}
	
	public void setListServicesType() {
		LinkedList<TiposServicio> list = this.tiposServicioController.readServicesType();
		
		this.lavadoView.ListTiposServicio.addItem("SELECCIONE");
		
		for(TiposServicio tipos: list) {
			this.lavadoView.ListTiposServicio.addItem(tipos.getTiposServicio().toUpperCase());
		}
	}
	
	public void setInformation(String item) {
		LinkedList<TiposServicio> list = this.tiposServicioController.readServicesType();
		
		for(TiposServicio tipos: list) {
			if (item.equals("SELECCIONE")) {
				this.lavadoView.TxtDescription.setText("");
			}
			
			if (item.equals(tipos.getTiposServicio())) {
				this.lavadoView.TxtDescription.setText(tipos.getDescripcionTiposServicio().toUpperCase());
			}
		}
	}
	
	public void generateInvoice() {
		String tipoVehiculo = this.lavadoView.ListVehiculo.getSelectedItem().toString();
		if (tipoVehiculo.equals("SELECCIONE")) {
			JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN TIPO DE VEHICULO.");
		}
		
		String tipoServicio = this.lavadoView.ListTiposServicio.getSelectedItem().toString();
		int optionTipoServicio = this.lavadoView.ListTiposServicio.getSelectedIndex();
		optionTipoServicio = optionTipoServicio == 0 ? 1 : optionTipoServicio;
		if (tipoServicio.equals("SELECCIONE")) {
			JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN TIPO DE SERVICIO.");
		}
		
		int precio = 0;
		if (tipoVehiculo.equals("CARRO")) {
			precio = 40000;
		} else if (tipoVehiculo.equals("CAMIONETA")) {
			precio = 60000;
		} else {
			precio = 0;
		}
		
		TiposServicio tipos = this.tiposServicioController.createServicesType(optionTipoServicio, precio);
		this.viewResponse(tipoServicio, tipoVehiculo, tipos);
	}
	
	private void viewResponse(String tipoServicio, String tipoVehiculo, TiposServicio tipos) {
		String funcionario = "";
		if (tipoServicio.equals("DESINFECCION BASICA")) {
			funcionario = "ADMINISTRADOR";
		} else if (tipoServicio.equals("DESINFECCION AVANZADA")) {
			funcionario = "ADMINISTRADOR";
		} else {
			funcionario = "EMPLEADO";
		}
		
		tipoServicio = tipoServicio.equals("SELECCIONE") ? "SELECCIONE" : tipos.getTiposServicio();
		
		this.lavadoView.LblFuncionario.setText(funcionario);
		this.lavadoView.TxtTipoVehiculo.setText(tipoVehiculo);
		this.lavadoView.TxtTipoServicio.setText(tipoServicio);
		this.lavadoView.TxtTotal.setText(String.valueOf(tipos.getPreciotiposServicio()));
	}

}
