package calculator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class BarraTitulo extends HBox{
	
	public BarraTitulo() {
		setMinHeight(35);
		setAlignment(Pos.CENTER_RIGHT);
		setPadding(new Insets(10));
		setSpacing(18);
		
		Label titulo = new Label("Calculadora");
		titulo.getStyleClass().add("texto");
		titulo.setPadding(new Insets(10, 35, 10, 10));
		Button botaoMin = new Button("-");
		botaoMin.setOnAction(e -> Aplicacao.palco.setIconified(true));
		
		botaoMin.getStyleClass().add("botao-barra-titulo");
		Button botaoMax = new Button("🗖");
		botaoMax.getStyleClass().add("botao-barra-titulo");
		Button botaoFechar = new Button("×");
		botaoFechar.getStyleClass().add("botao-barra-titulo");
		botaoFechar.setOnAction(e -> System.exit(0));
		
		getChildren().addAll(titulo, botaoMin, botaoMax, botaoFechar);
	}

}
