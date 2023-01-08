package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.infra.DAOServidor;
import br.com.marttech.sg.model.memoria.ServidorMemory;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
	
	@FXML
	private TextField campoMatricula;

	private static DAOServidor dao = new DAOServidor();

	public static boolean autenticar(Long matricula, String senha) {
		boolean resultado = dao.validarAcesso(matricula, senha);
		
		if(resultado) {
			setUsuario(matricula);
		}
		
		return resultado;
	}
	
	private static void setUsuario(Long matricula) {
		ServidorMemory.setServidor(dao.obterPorMatricula(matricula));
	}
	
	public static boolean valido() {
		return ServidorMemory.isValido();
	}
}
