package br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.group_imagens;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class ContainerImagens extends GridPane{
	
	private Button botaoProxima;
	private Button botaoAnterior;
	private PilhaImagens imagens;
	
	public ContainerImagens() {
		String css = getClass().getResource("ImagensContainer.css").toExternalForm();
		getStylesheets().add(css);
		setPadding(new Insets(25));
		getStyleClass().add("Container");
		
		getColumnConstraints().addAll(coluna(30), coluna(900), coluna(30));
		getRowConstraints().addAll(linha(30), linha(500), linha(30));
		
		construirComponentes();
		
		add(imagens, 0, 0, 3, 3);
		add(botaoAnterior, 0, 1);
		add(botaoProxima, 2, 1);
		
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
	}
	
	private void construirComponentes() {
		botaoProxima = new Button("", new ImageView(new Image(getClass().getResourceAsStream("imagens/proximo.png"))));
		botaoAnterior = new Button("", new ImageView(new Image(getClass().getResourceAsStream("imagens/anterior.png"))));
		imagens = new PilhaImagens();
		
		botaoAnterior.getStyleClass().add("Botao-Mudar");
		botaoProxima.getStyleClass().add("Botao-Mudar");
		
		addActions();
	}
	private void addActions() {
		botaoProxima.setOnAction(e -> imagens.proximaImagen());
		botaoAnterior.setOnAction(e -> imagens.imagemAnterior());
	}

	private ColumnConstraints coluna(double width) {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(width);
		cc.setPercentWidth(-1);
		cc.setHgrow(Priority.ALWAYS);
		cc.setHalignment(HPos.CENTER);
		cc.setFillWidth(true);
		return cc;
	}
	
	private RowConstraints linha(double height) {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(height);
		rc.setPercentHeight(-1);
		rc.setVgrow(Priority.ALWAYS);
		rc.setValignment(VPos.CENTER);
		rc.setFillHeight(true);
		return rc;
	}
	
}
