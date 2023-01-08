package br.com.marttech.sg.model.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.marttech.sg.model.perfis.abstracts.Usuario;

public class Validar {

	public static boolean usuario(Usuario usuario) {
		boolean validacao1  = validarString(usuario.getNome());
		boolean validacao2  = validarString(usuario.getCpf());
		boolean validacao3  = validarEmail(usuario.getEmail());
		boolean validacao4  = validarSenha(usuario.getSenha());
		
		boolean isValido = validacao1 && validacao2 && validacao3 && validacao4;
		return isValido;
	}
	
	private static boolean validarString(String valor) {
		boolean validacao1 = false;
		boolean validacao2 = false;
		boolean validacao3 = true; //REFACTOR
		
		if(valor != null || !valor.isEmpty()) {
			validacao1 = true;
		}
		
		if(valor.length() >=3) {
			validacao2 = true;
		}
		
		return (validacao1 && validacao2 && validacao3);
	}
	
	private static boolean validarEmail(String email) {
		boolean isValido = false;
		
		if(validarString(email)) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern  = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			
			if(matcher.matches()) {
				isValido = true;
			}
		}
		return isValido;
	}
	
	private static boolean validarSenha(String senha) {
		boolean isValida = false;
		if(validarString(senha) && senha.length() >= 8 ) {
			isValida = true;
		}
		
		return isValida;
	}
}
