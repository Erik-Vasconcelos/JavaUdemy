package br.com.marttech.sg.model.services;

import br.com.marttech.sg.model.excecao.DadosInvalidosException;
import br.com.marttech.sg.model.infra.DAOServidor;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;
import br.com.marttech.sg.model.validate.Validar;

public class DiretorService{

	private DAOServidor dao;
	
	public DiretorService() {
		dao = new DAOServidor();
	}
	
	public boolean cadastarUsuario(Servidor servidor) {
		if(Validar.usuario(servidor)) {
			dao.incluirAtomico(servidor);
			return true;
		}
		throw new DadosInvalidosException();
	}
	
	public Servidor visualizarUsuario(Long matricula) {
		return dao.bucarPorId(matricula);
	}
	
	public void atualizarUsuario(Servidor servidor) {
		dao.incluirAtomico(servidor);
	}
	
	public void removerUsuario(Servidor servidor) {
		dao.incluirAtomico(servidor);
	}
	
	
	
	
	
	
}
