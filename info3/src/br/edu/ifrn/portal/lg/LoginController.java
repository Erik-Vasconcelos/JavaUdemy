package br.edu.ifrn.portal.lg;

import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private TextField campoMatricula;
	
	@FXML
	private PasswordField campoSenha;
	
	public void entrar() {
		boolean validacao1 = campoMatricula.getText().equals("20201134010001");
		boolean validacao2 = campoSenha.getText().equals("1234");
		App.setInicio();
		
		/*if(validacao1 && validacao2) {
			
			Notifications.create()
				.text("Login efetuado com sucesso")
				.position(Pos.TOP_LEFT)
				.showInformation();;
		}else {
			Notifications.create()
				.text("Matricula ou senha inválidos")
				.position(Pos.TOP_RIGHT)
				.showError();
		}*/
	}
	
	
}
