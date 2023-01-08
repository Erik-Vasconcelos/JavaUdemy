package br.com.marttech.sg.model.services;

import br.com.marttech.sg.model.perfis.abstracts.Usuario;

public interface AdministradorGeral {

	public boolean cadastrarUsuario(Usuario usuario);
	public boolean atualizarUsuario(Usuario usuario);
	public boolean visualizarUsuario(Long id);
	public boolean excluirUsuario(Usuario usuario);
}
