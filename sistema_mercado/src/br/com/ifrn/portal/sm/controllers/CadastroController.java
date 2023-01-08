package br.com.ifrn.portal.sm.controllers;

import br.com.ifrn.portal.sm.views.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @version 1.0
 * @system CadastroController.java
 * @author erikv
 * @date 12:07:26 8 de jan. de 2023 2023
 */

public class CadastroController {

	@FXML
	private TextField campoNome;
	
	@FXML
	private Button botaoInicio;
	
	public void setCenaInicio() {
		App.setCenaInicio();
	}
	
	
	
}
