package br.com.marttech.sg.model.perfis.todo;

import java.sql.Date;

import br.com.marttech.sg.model.dados.Endereco;
import br.com.marttech.sg.model.dados.Telefone;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;
import br.com.marttech.sg.model.perfis.enuns.Cargo;
import br.com.marttech.sg.model.perfis.enuns.Permissao;

public abstract class UsuarioServidorConcursado extends Servidor{

	private Date dataEntrada;
	
	private Double bonus;

	public UsuarioServidorConcursado() {
		super();
	}

	public UsuarioServidorConcursado(String nome, String cpf, String email, Double salario,
			Cargo cargo, Permissao permissao, Double bonus) {
		super(nome, cpf, email, salario, cargo, permissao);
//		this.dataEntrada = dataEntrada;
		this.bonus = bonus;
	}

	public UsuarioServidorConcursado(String nome, String cpf, Telefone telefone, String email, Endereco endereco,
			Double salario, Cargo cargo, Permissao permissao, Date dataEntrada, Double bonus) {
		super(nome, cpf, telefone, email, endereco, salario, cargo, permissao);
		this.dataEntrada = dataEntrada;
		this.bonus = bonus;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	
}
