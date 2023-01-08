package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.dados.concreto.EnderecoServidor;
import br.com.marttech.sg.model.dados.concreto.TelefoneServidor;
import br.com.marttech.sg.model.dados.enuns.Estado;
import br.com.marttech.sg.model.dados.enuns.TipoTelefone;
import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.model.infra.DAOServidor;
import br.com.marttech.sg.model.memoria.UsuarioEditadoMemory;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;
import br.com.marttech.sg.model.perfis.concrete.Diretor;
import br.com.marttech.sg.model.perfis.concrete.Professor;
import br.com.marttech.sg.model.perfis.enuns.Cargo;
import br.com.marttech.sg.model.perfis.enuns.Permissao;

public class EditUsuarioController {
	
	private static DAOServidor dao = new DAOServidor();
	
	public static ServidorDTO getDados() {
		ServidorDTO usuario = tranferirDados(UsuarioEditadoMemory.getInstance());
		return usuario;
	}
	
	private static ServidorDTO tranferirDados(Servidor servidor) {
		ServidorDTO usuario = new ServidorDTO(
			servidor.getId().toString(),
			servidor.getMatricula().toString(),
			servidor.getNome(),
			servidor.getCpf(),
			servidor.getEmail(),
			servidor.getCargo().toString(),
			servidor.getPermissao().toString(),
			servidor.getSalario().toString(),
			servidor.getTelefone().getNumero(),
			servidor.getTelefone().getTipo().toString(),
			servidor.getEndereco().getRua(),
			servidor.getEndereco().getBairro(),
			servidor.getEndereco().getCidade(),
			servidor.getEndereco().getNumero().toString(),
			servidor.getEndereco().getEstado().toString(),
			servidor.getSenha(),
			servidor.getImagem()
		);
		return usuario;
	}
	
	public static boolean salvarUsuario(ServidorDTO usuario){
		Servidor servidor = setDados(usuario);
		
		dao.abrirT()
			.atualizar(servidor)
			.fecharT();

		UsuarioEditadoMemory.setServidor(servidor);
		
		return true;
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
			servidor = new Professor(nome, cpf, email, UsuarioEditadoMemory.getInstance().getMatricula(),
					UsuarioEditadoMemory.getInstance().getSenha(), salario, funcao, permissao, imagem);
		}else {
			servidor = new Diretor(nome, cpf, email, UsuarioEditadoMemory.getInstance().getMatricula(),
					UsuarioEditadoMemory.getInstance().getSenha(), salario, funcao, permissao, imagem);
		}
		
		servidor.setId(UsuarioEditadoMemory.getInstance().getId());
		EnderecoServidor endereco = new EnderecoServidor(rua, bairro, cidade, numeroEnd, estado, servidor);
		TelefoneServidor telefone = new TelefoneServidor(numeroTel, tipoTel, servidor);
		
		servidor.setEndereco(endereco);
		servidor.setTelefone(telefone);
		
		try {
			servidor.getEndereco().setId(UsuarioEditadoMemory.getInstance().getEndereco().getId());
			servidor.getTelefone().setId(UsuarioEditadoMemory.getInstance().getTelefone().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return servidor;
	}

	public static void resetMemory() {
		UsuarioEditadoMemory.resetMemory();
	}
	
	public static void setUsuarioInMemory(Long id){
		try {
			Servidor servidor = dao.bucarPorId(id);
			UsuarioEditadoMemory.setServidor(servidor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
