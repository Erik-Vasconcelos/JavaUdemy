package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.infra.DAOServidor;
import br.com.marttech.sg.model.memoria.ServidorMemory;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;

public class AlterarSenhaController {
	/**
	 * @author erikv
	 * @date 18:39:06 8 de nov. de 2022
	 * 
	 */
	private static DAOServidor dao = new DAOServidor();
	
	public static boolean updateSenha(String novaSenha) {
		try {
			Servidor servidor = ServidorMemory.getInstance();
			servidor.setSenha(novaSenha);
			
			System.out.println(servidor.getId()+ " " +servidor.getMatricula());
			
			dao.abrirT()
				.atualizar(servidor)
				.fecharT();
			
			ServidorMemory.setServidor(servidor);
			
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
