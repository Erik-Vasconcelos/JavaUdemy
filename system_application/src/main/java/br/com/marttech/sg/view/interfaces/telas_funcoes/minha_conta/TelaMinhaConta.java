package br.com.marttech.sg.view.interfaces.telas_funcoes.minha_conta;


import br.com.marttech.sg.model.memoria.ServidorMemory;
import br.com.marttech.sg.view.interfaces.telas_funcoes.TelaSystem;
import br.com.marttech.sg.view.interfaces.telas_funcoes.minha_conta.content.ContainerAlterarSenha;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class TelaMinhaConta extends GridPane implements TelaSystem{
	
	private Label conta;
	private Label matricula;
	
	private ContainerAlterarSenha containerCredenciais;
	
	public TelaMinhaConta() {
		setPadding(new Insets(25));
		setAlignment(Pos.TOP_CENTER);
		setVgap(15);
		String css = getClass().getResource("MinhaConta.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Tela");
		
		getColumnConstraints().addAll(coluna(), coluna(HPos.RIGHT));
		getRowConstraints().addAll(linha(), linha(), linha());
		
		construiComponentes();
		
		add(conta, 0, 0);
		add(matricula, 1, 0);
		add(containerCredenciais, 0, 1, 2, 6);
		
		setMaxWidth(USE_COMPUTED_SIZE);
		setMaxHeight(USE_COMPUTED_SIZE);
	}
	
	private ColumnConstraints coluna() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(960);
		cc.setPercentWidth(-1);
		cc.setHalignment(HPos.LEFT);
		cc.setHgrow(Priority.ALWAYS);
		cc.setFillWidth(true);
		return cc;
	}
	
	private ColumnConstraints coluna(HPos alinhamento) {
		ColumnConstraints cc = coluna();
		cc.setHalignment(alinhamento);
		return cc;
	}
	
	private RowConstraints linha() {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(30);
		rc.setPercentHeight(-1);
		rc.setFillHeight(true);
		return rc;
	}
	
	private void construiComponentes() {
		conta = new Label();
		matricula = new Label();
		containerCredenciais = new ContainerAlterarSenha();
		setDados();
		addAcoes();
		
		conta.getStyleClass().add("Titulo");
		matricula.getStyleClass().add("Titulo");
	}
	
	private void setDados() {
		conta.setText("Minha Conta: " + ServidorMemory.getInstance().getNome());
		matricula.setText("Matricula: " + ServidorMemory.getInstance().getMatricula());
	}
	
	private void addAcoes() {
		containerCredenciais.getAlterarSenha().setOnAction(e -> novo());
		containerCredenciais.getCancelar().setOnAction(e -> cancelar());
	}
	
	public void novo() {
		getChildren().remove(containerCredenciais);
		ContainerAlterarSenha novo = new ContainerAlterarSenha(1);
		novo.getAlterarSenha().setVisible(false);
		containerCredenciais = novo;
		addAcoes();
		add(containerCredenciais, 0, 1, 2, 6);
	}
	
	public void cancelar() {
		getChildren().remove(containerCredenciais);
		ContainerAlterarSenha novo = new ContainerAlterarSenha();
		containerCredenciais = novo;
		addAcoes();
		add(containerCredenciais, 0, 1, 2, 6);
	}
	
	public void reload() {
		containerCredenciais.reload();
		setDados();
	}
	
	public void reset() {
		conta.setText("");
		matricula.setText("");
		containerCredenciais = new ContainerAlterarSenha();
	}

}
