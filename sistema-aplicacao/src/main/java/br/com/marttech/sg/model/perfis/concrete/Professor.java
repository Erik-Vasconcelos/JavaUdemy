package br.com.marttech.sg.model.perfis.concrete;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.marttech.sg.model.dados.Endereco;
import br.com.marttech.sg.model.dados.Telefone;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;
import br.com.marttech.sg.model.perfis.enuns.Cargo;
import br.com.marttech.sg.model.perfis.enuns.Permissao;

@Entity
@DiscriminatorValue("SE")
public class Professor extends Servidor {
	
	public Professor() {
		super();
		this.setPermissao(Permissao.GERENCIADOR_TURMA);
	}

	public Professor(String nome, String cpf, String email, Double salario,
			Cargo cargo, Permissao permissao) {
		super(nome, cpf, email,  salario, cargo, permissao);
	}

	public Professor(String nome, String cpf, Telefone telefone, String email, Endereco endereco,
			 Double salario, Cargo cargo, Permissao permissao) {
		super(nome, cpf, telefone, email, endereco, salario, cargo, permissao);
	}
	
}
