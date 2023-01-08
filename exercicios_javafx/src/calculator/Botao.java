package calculator;

import java.util.function.Consumer;

import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

public class Botao extends Button {
	
	public Botao(String texto, Consumer<String> funcao,  String... classesCss ) {
		super(texto);
		
		setTextAlignment(TextAlignment.CENTER);
		setMinWidth(75);
		setMinHeight(47);
		getStyleClass().add("botao");
		
		setOnAction(e -> funcao.accept(getText()));
		
		for(String classe: classesCss) {
			getStyleClass().add(classe);
		}
	}

}
