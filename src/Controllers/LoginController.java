package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Views.LavadoView;
import Views.LoginView;

public class LoginController implements ActionListener {
	
	public LoginView loginView;
	
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.loginView.BtnIngresar) {
			this.auth();
		}
	}
	
	private void auth() {
		String email = this.loginView.TxtEmail.getText();
		String password = this.loginView.TxtPassword.getText();
		
		if (!email.equals("dailleth@gmail.com") || !password.equals("1212")) {
			this.loginView.LblResponse.setText("El correo/contraseña es incorrecto.".toUpperCase());
		} else {
			(new LavadoView()).setVisible(true);
			this.loginView.setVisible(false);
		}		
	}

}