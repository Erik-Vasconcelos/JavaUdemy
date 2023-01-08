package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.infra.DAO;
import br.com.marttech.sg.model.perfis.abstracts.Usuario;

public class LoginController {

	static DAO<Usuario>  dao = new DAO<>();
	
	
	public static boolean autenticar(Long matricula, String senha) {
		return dao.validarAcesso(matricula, senha);
	}
}
