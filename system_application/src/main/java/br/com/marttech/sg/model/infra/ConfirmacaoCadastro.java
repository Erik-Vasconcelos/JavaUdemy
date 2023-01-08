package br.com.marttech.sg.model.infra;

public class ConfirmacaoCadastro {
	
	private final boolean isCasdastado;
	private final Long matricula;
	
	public ConfirmacaoCadastro() {
		this.isCasdastado = false;
		this.matricula = 0L;
	}
	
	public ConfirmacaoCadastro(boolean isCasdastado, Long matricula) {
		this.isCasdastado = isCasdastado;
		this.matricula = matricula;
	}

	public boolean isCasdastado() {
		return isCasdastado;
	}

	public Long getMatricula() {
		return matricula;
	}
	
}
