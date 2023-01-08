package br.edu.ifrn.portal.lg;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class TelaCadastro extends GridPane{
	
	public TelaCadastro() {
		setAlignment(Pos.CENTER);
		setPadding(new Insets(10));
		setVgap(10);
		setHgap(10);
		
	
		Label lTitulo = new Label("Tela Cadastro");
		Label lCpf = new Label("CPF: ");
		TextField campoCpf = new TextField();
		
		Label lNome = new Label("Nome: ");
		TextField campoNome = new TextField();
		
		Label lIdade = new Label("Idade: ");
		TextField campoIdade = new TextField();
		
		Button botao = new Button("Cadastrar");
		
		getColumnConstraints().addAll(cc(), cc(), cc(), cc());
		getRowConstraints().addAll(rc(), rc(), rc(), rc(), rc());
		
		add(lTitulo, 0, 0, 2, 1);
		add(lCpf, 0, 1);
		add(campoCpf, 1, 1);
		add(lNome, 0, 2);
		add(campoNome, 1, 2);
		add(lIdade, 0, 3);
		add(campoIdade, 1, 3);
		add(botao, 0, 4, 2, 1);
		
	}
	
	private ColumnConstraints cc() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(20);
		cc.setHalignment(HPos.CENTER);
		cc.setFillWidth(true);
		return cc;
	}
	
	private RowConstraints rc() {
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(5);
		rc.setFillHeight(true);
		return rc;
	}
	
}
