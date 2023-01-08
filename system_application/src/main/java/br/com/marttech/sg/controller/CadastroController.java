package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.dados.concreto.EnderecoServidor;
import br.com.marttech.sg.model.dados.concreto.TelefoneServidor;
import br.com.marttech.sg.model.dados.enuns.Estado;
import br.com.marttech.sg.model.dados.enuns.TipoTelefone;
import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.model.infra.ConfirmacaoCadastro;
import br.com.marttech.sg.model.infra.DAO;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;
import br.com.marttech.sg.model.perfis.concrete.Diretor;
import br.com.marttech.sg.model.perfis.concrete.Professor;
import br.com.marttech.sg.model.perfis.enuns.Cargo;
import br.com.marttech.sg.model.perfis.enuns.Permissao;

public class CadastroController {

	private static DAO<Servidor> dao = new DAO<>();
	
	public static ConfirmacaoCadastro cadastrar(ServidorDTO usuario) {
		try {
			Servidor servidor = setDados(usuario);
			
			dao.incluirAtomico(servidor);
			
			return new ConfirmacaoCadastro(true, servidor.getMatricula());
		} catch (Exception e) {
			e.printStackTrace();
			return new ConfirmacaoCadastro();
		}
	}
	
	private static Servidor setDados(ServidorDTO usuario) {
		String nome = usuario.getNome();
		String cpf = usuario.getCpf();
		String email =  usuario.getEmail();
		double salario = Double.parseDouble(usuario.getSalario());
		Cargo funcao = Cargo.valueOf(usuario.getCargo());
		Permissao permissao = Permissao.valueOf(usuario.getPermissao());
		
		String rua = usuario.getRua();
		String bairro = usuario.getBairro();
		String cidade = usuario.getCidade();
		int numeroEnd = Integer.parseInt(usuario.getNumero());
		Estado estado = Estado.valueOf(usuario.getEstado());
		
		String numeroTel = usuario.getTelefone();
		TipoTelefone tipoTel = TipoTelefone.valueOf(usuario.getTipoTelefone());
		
		byte[] imagem = usuario.getImagem();
		
		Servidor servidor = null;
		
		if(funcao ==  Cargo.PROFESSOR) {
			servidor = new Professor(nome, cpf, email, salario, funcao, permissao, imagem);
		}else {
			servidor = new Diretor(nome, cpf, email, salario, funcao, permissao, imagem);
		}
		
		EnderecoServidor endereco = new EnderecoServidor(rua, bairro, cidade, numeroEnd, estado, servidor);
		TelefoneServidor telefone = new TelefoneServidor(numeroTel, tipoTel, servidor);
		
		servidor.setEndereco(endereco);
		servidor.setTelefone(telefone);
		
		return servidor;
	}
	
}
