package br.com.marttech.sg.model.perfis.todo;

import java.sql.Date;

import br.com.marttech.sg.model.dados.Endereco;
import br.com.marttech.sg.model.dados.Telefone;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;
import br.com.marttech.sg.model.perfis.enuns.Cargo;
import br.com.marttech.sg.model.perfis.enuns.Permissao;


public abstract class UsuarioServidorContratado extends Servidor{

	private Date dataContrato;
	
	private Date dataTerminoContrato;

	public UsuarioServidorContratado() {
		super();
	}

	public UsuarioServidorContratado(String nome, String cpf, String email,
			Double salario, Cargo cargo, Permissao permissao,  Date dataContrato, Date dataTerminoContrato) {
		super(nome, cpf, email, salario, cargo, permissao);
		this.dataContrato = dataContrato;
		this.dataTerminoContrato = dataTerminoContrato;
	}

	public UsuarioServidorContratado(String nome, String cpf, Telefone telefone, String email,
			Endereco endereco, Double salario, Cargo cargo, Permissao permissao, Date dataContrato, Date dataTerminoContrato) {
		super(nome, cpf, telefone, email, endereco, salario, cargo, permissao);
		this.dataContrato = dataContrato;
		this.dataTerminoContrato = dataTerminoContrato;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}

	public Date getDataTerminoContrato() {
		return dataTerminoContrato;
	}

	public void setDataTerminoContrato(Date dataTerminoContrato) {
		this.dataTerminoContrato = dataTerminoContrato;
	}
	
}
