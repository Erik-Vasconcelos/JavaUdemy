package br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.telas;

import br.com.marttech.sg.view.interfaces.telas_funcoes.TelaSystem;
import br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.telas.edit.TelaEditUsuario;
import br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.telas.grerenciamento.TelaGerenciamentoUsuarios;
import javafx.scene.layout.StackPane;

public class TelaUsuarios extends StackPane implements TelaSystem{
	
	private TelaGerenciamentoUsuarios telaGerenciamento;
	private TelaEditUsuario telaEdicao;
	
	public TelaUsuarios() {
		configComponents();
		
		setMinHeight(800);
		setMinWidth(1100);
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
	}
	
	private void configComponents() {
		telaGerenciamento = new TelaGerenciamentoUsuarios(e -> {
			paraParaTraz();
			adicionarTelaEdit();
		});
		
		getChildren().addAll(telaGerenciamento);
	}
	
	public void adicionarTelaEdit() {
		telaEdicao = new TelaEditUsuario();
		adicionarAcoes();
		getChildren().add(telaEdicao);
		
	}
	
	public void paraFrente() {
		getChildren().get(getIndex(telaGerenciamento)).toFront();
	}
	
	
	public void paraParaTraz() {
		getChildren().get(getIndex(telaGerenciamento)).toBack();
	}
	
	private int getIndex(Object componente) {
		return getChildren().indexOf(componente);
	}
	
	@SuppressWarnings("static-access")
	private void adicionarAcoes() {
		telaEdicao.getBotaoVoltar().setOnAction(e -> {
			paraFrente();
		});
	}
	
	public void reload() {
		if(telaEdicao != null) {
			telaEdicao.reload();
		}
		
		telaGerenciamento.reload();
	}
	
	public void reset() {
		telaGerenciamento.reset();
	}
}
