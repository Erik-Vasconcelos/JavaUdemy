package br.com.marttech.sg.view.wizard_application.inicio;


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class CenaInicial extends GridPane{
	
	private ImageView imagemMensagem;
	private Button botaoProximo;
	private HBox rodape;
	
	public CenaInicial() {
		construirComponentes();
		
		getColumnConstraints().add(coluna());
		getRowConstraints().addAll(linha(Priority.ALWAYS), linha(Priority.NEVER));
		
		add(imagemMensagem, 0, 0);
		add(rodape, 0, 1);
	}
	
	private void construirComponentes() {
		imagemMensagem = new ImageView(new Image(getClass().getResourceAsStream("ImagemInicial.png")));
		botaoProximo = new Button("Próximo");
		configRodape();
	}
	
	private void configRodape() {
		rodape = new HBox();
		rodape.setAlignment(Pos.CENTER_LEFT);
		rodape.setPadding(new Insets(20));
		rodape.setSpacing(20);
		rodape.setStyle(""
				+ "-fx-background-color : #c9c9c9;"
				+ "	-fx-max-height: 70px;"
				+ "	-fx-min-height: 70px;");
		rodape.getChildren().add(botaoProximo);
	}
	
	
	private ColumnConstraints coluna() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(480);
		cc.setPercentWidth(-1);
		cc.setHalignment(HPos.LEFT);
		cc.setHgrow(Priority.ALWAYS);
		cc.setFillWidth(true);
		return cc;
	}
	
	private RowConstraints linha(Priority prioridade) {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(70);
		rc.setPercentHeight(-1);
		rc.setVgrow(prioridade);
		rc.setValignment(VPos.CENTER);
		rc.setFillHeight(true);
		return rc;
	}

	public Button getBotaoProximo() {
		return botaoProximo;
	}

}
