package br.com.marttech.sg.view.interfaces.menu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class BotaoMenu extends Button{
	private ImageView imagem;
	
	public BotaoMenu() {
	}
	
	public BotaoMenu(String texto, String caminho) {
		setAlignment(Pos.CENTER_LEFT);
		
		setText(texto);
		String css = getClass().getResource("Menu.css").toExternalForm();
		getStyleClass().add("Botao");
		getStylesheets().add(css);
		
		/*Font font = Font.loadFont("Rajdhani-Regular.ttf", 20);
		setFont(font);*/
		
		configImg(caminho);
		setGraphic(imagem);
		setMaxWidth(USE_COMPUTED_SIZE);
		setMaxHeight(USE_COMPUTED_SIZE);
	}
	
	public void setEstiloBotaoAtual(){
		getStyleClass().add("Botao-Atual");
	}
	
	public void removerEstiloBotaoAtual(){
		getStyleClass().remove("Botao-Atual");
	}
	
	private void configImg(String caminho) {
		Image img = new Image(getClass().getResourceAsStream(caminho));
		imagem = new ImageView(img);
	}

}
