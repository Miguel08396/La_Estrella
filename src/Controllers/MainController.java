package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.LavadoView;
import Views.LoginView;
import Views.MainView;

public class MainController implements ActionListener {
	
	private MainView mainView;
	
	public MainController(MainView mainView) {
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.mainView.ItemSalida) {
			this.mainView.setVisible(false);
		} else if (e.getSource() == this.mainView.ItemLavado) {
			(new LoginView()).setVisible(true);
			this.mainView.setVisible(false);
		}
	}

}