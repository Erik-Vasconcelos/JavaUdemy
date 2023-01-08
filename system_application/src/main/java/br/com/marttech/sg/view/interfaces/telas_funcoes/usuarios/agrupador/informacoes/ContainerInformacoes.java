package br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.agrupador.informacoes;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class ContainerInformacoes extends GridPane{
	
	private Label lMatricula;
	private Label lNome;
	private Label lEmail;
	private Label lTipo;
	private Label lPermissao;
	private Label lAcao;
	
	public ContainerInformacoes() {
		setPadding(new Insets(10));
		setAlignment(Pos.CENTER_LEFT);
		String css = getClass().getResource("Informacoes.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Content");
		setHgap(3);
		
		configComponentes();
		
		add(lMatricula, 0, 0);
		add(lNome, 1, 0);
		add(lEmail, 2, 0);
		add(lTipo, 3, 0);
		add(lPermissao, 4, 0);
		add(lAcao, 5, 0);
		
		setMaxWidth(USE_COMPUTED_SIZE);
		setMaxHeight(USE_COMPUTED_SIZE);
	}
	
	private void configComponentes() {
		getColumnConstraints().addAll(coluna(), coluna(260), coluna(200), coluna(120), coluna(), coluna(90));
		getRowConstraints().addAll(linha());
		
		lMatricula = new Label("Matricula");
		lNome = new Label("Nome");
		lEmail = new Label("E-mail");
		lTipo = new Label("Função");
		lPermissao = new Label("Permissão");
		lAcao = new Label("Ações");
	}
	
	private ColumnConstraints coluna() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(160);
		cc.setPercentWidth(-1);
		cc.setHgrow(Priority.ALWAYS);
		cc.setHalignment(HPos.LEFT);
		cc.setFillWidth(true);
		return cc;
	}
	
	private ColumnConstraints coluna(double width) {
		ColumnConstraints cc = coluna();
		cc.setPrefWidth(width);
		return cc;
	}
	
	private RowConstraints linha() {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(20);
		rc.setPercentHeight(-1);
		rc.setValignment(VPos.CENTER);
		rc.setFillHeight(true);
		return rc;
	}
	
}
