package br.com.marttech.sg.view.libs;

public enum PermissaoFront {
	ADMINISTRADOR_GERAL(4),
	ADMINISTRADOR(3),
	GERENCIADOR_TURMA(2),
	USUARIO(1);
	
	private int nivelPermissao;

	private PermissaoFront(int nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}

	public int getNivelPermissao() {
		return nivelPermissao;
	}
	
}
