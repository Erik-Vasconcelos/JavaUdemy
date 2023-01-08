package br.com.marttech.sg.model.perfis.concrete;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.marttech.sg.model.dados.concreto.EnderecoServidor;
import br.com.marttech.sg.model.dados.concreto.TelefoneServidor;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;
import br.com.marttech.sg.model.perfis.enuns.Cargo;
import br.com.marttech.sg.model.perfis.enuns.Permissao;

@Entity
@DiscriminatorValue(value = "DI")
public class Diretor extends Servidor{

	public Diretor() { 
		super();
		this.setPermissao(Permissao.ADMINISTRADOR_GERAL);
	}

	public Diretor(String nome, String cpf, String email, Double salario, Cargo cargo, Permissao permissao, byte[] imagem) {
		super(nome, cpf, email, salario, cargo, permissao, imagem);
	}
	
	public Diretor(String nome, String cpf, String email, Long matricula, String senha, Double salario, Cargo cargo, Permissao permissao, byte[] imagem) {
		super(nome, cpf, email, matricula, senha, salario, cargo, permissao, imagem);
	}

	public Diretor(String nome, String cpf, TelefoneServidor telefone, String email, EnderecoServidor endereco,
			Double salario, Cargo cargo, Permissao permissao, byte[] imagem) {
		super(nome, cpf, telefone, email, endereco, salario, cargo, permissao, imagem);
	}

}
