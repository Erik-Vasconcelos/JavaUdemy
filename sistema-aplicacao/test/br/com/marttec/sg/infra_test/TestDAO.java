package br.com.marttec.sg.infra_test;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;

import br.com.marttech.sg.model.dados.Endereco;
import br.com.marttech.sg.model.dados.Telefone;
import br.com.marttech.sg.model.dados.enuns.Estado;
import br.com.marttech.sg.model.dados.enuns.TipoTelefone;
import br.com.marttech.sg.model.infra.DAO;
import br.com.marttech.sg.model.perfis.abstracts.Usuario;
import br.com.marttech.sg.model.perfis.concrete.Diretor;
import br.com.marttech.sg.model.perfis.enuns.Cargo;
import br.com.marttech.sg.model.perfis.enuns.Permissao;

@FixMethodOrder
class TestDAO {

	private DAO<Usuario> dao = new DAO<>(Usuario.class);
	
	@Test
	void testeConstrutor() {
		DAO dao = new DAO();
	}
	
	@Test
	void testeAbrirTran() {
		dao.abrirT();
	}
	
	/*@Test
	void testeInserirEnti() {
		Usuario usuario = new Diretor("José", "545848262-89", "jose@gmail.com",
				7858.23, Cargo.DIRETOR, Permissao.ADMINISTRADOR_GERAL);
		
		Telefone telefone = new Telefone("52584854", TipoTelefone.RES, usuario);
		Endereco endereco = new Endereco("Rua Urso polar", "Tirol", "Natal", 784, Estado.RN, usuario);
		dao.incluirAtomico(usuario);
	}
	
	@Test
	void buscarPorId() {
		Usuario user = dao.bucarPorId(1L);
		System.out.println(user.getNome());
	}
	*/
	@Test
	void buscarPorAproximacao() {
		List<Usuario> users = dao.obterPorAproximacao("j");
		users.stream().forEach(u -> System.out.println("User -> "+u.getNome()));
	}
	
	
	@Test
	void obterTodos() {
		List<Usuario> usuarios = dao.obterTodos(10, 0);
		usuarios.stream().forEach(u -> System.out.println(u.getNome()));
	}
	
	@Test
	void consultarMat() {
		dao.abrirT();
		System.out.println(dao.validarAcesso(20224711000L, "@EERP5451262-89"));
	}

}
