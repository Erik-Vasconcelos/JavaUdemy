package br.com.marttech.sg.model.perfis.concrete;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.marttech.sg.model.dados.concreto.EnderecoServidor;
import br.com.marttech.sg.model.dados.concreto.TelefoneServidor;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;
import br.com.marttech.sg.model.perfis.enuns.Cargo;
import br.com.marttech.sg.model.perfis.enuns.Permissao;

@Entity
@DiscriminatorValue(value = "PR")
public class Professor extends Servidor {
	
	public Professor() {
		super();
		this.setPermissao(Permissao.GERENCIADOR_TURMA);
	}

	public Professor(String nome, String cpf, String email, Double salario,
			Cargo cargo, Permissao permissao, byte[] imagem) {
		super(nome, cpf, email,  salario, cargo, permissao, imagem);
	}
	
	public Professor(String nome, String cpf, String email, Long matricula, String senha, Double salario, Cargo cargo, Permissao permissao, byte[] imagem) {
		super(nome, cpf, email, matricula, senha, salario, cargo, permissao, imagem);
	}

	public Professor(String nome, String cpf, TelefoneServidor telefone, String email, EnderecoServidor endereco,
			 Double salario, Cargo cargo, Permissao permissao, byte[] imagem) {
		super(nome, cpf, telefone, email, endereco, salario, cargo, permissao, imagem);
	}
	
}
