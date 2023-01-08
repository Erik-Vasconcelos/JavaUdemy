package br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.central;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class ContainerCentral extends GridPane{
	
	public ContainerCentral() {
		String css = getClass().getResource("Central.css").toExternalForm();
		getStylesheets().add(css);
		setPadding(new Insets(25));
		getStyleClass().add("Container");
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
	}

}
