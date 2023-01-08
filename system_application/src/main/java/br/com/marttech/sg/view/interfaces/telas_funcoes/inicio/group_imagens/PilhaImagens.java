package br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.group_imagens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class PilhaImagens extends StackPane{
	
	private ImageView imagem1;
	private ImageView imagem2;
	private ImageView imagem3;
	
	private List<ImageView> listaImagens;
	
	public PilhaImagens() {
		String css = getClass().getResource("PilhaImagem.css").toExternalForm();
		getStylesheets().add(css);
		construirComponentes();
		mudarImagens();
		
		getChildren().addAll(imagem1);
		
		setMaxWidth(USE_COMPUTED_SIZE);
		setMaxHeight(USE_COMPUTED_SIZE);
	}
	
	private void construirComponentes() {
		imagem1 = new ImageView();
		imagem2 = new ImageView();
		imagem3 = new ImageView();
		
		listaImagens = new ArrayList<>(Arrays.asList(imagem1));
	
		setImagens();
	}
	
	private void setImagens() {
		imagem1.setImage(new Image(getClass().getResourceAsStream("imagens/E-Ensino.png")));
		
		//imagem2.setImage(new Image("C:/Users/erikv/Downloads/hd-wallpaper-g60a6fb6b0_1920.jpg"));
		//imagem3.setImage(new Image("C:/Users/erikv/Downloads/hd-wallpaper-gc84ba798e_1920.jpg"));
		
		listaImagens.forEach(i -> {
			i.setPreserveRatio(false);
			i.setFitWidth(900);
			i.setFitHeight(500);
			i.autosize();
			i.getStyleClass().add("Imagem");
		});
	}
	
	private void mudarImagens() {
		Thread t = new Thread(() -> {
			try {
				while(true) {
					Thread.sleep(60000);
					Platform.runLater(() -> {
						proximaImagen();
					});
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t.setDaemon(true);
		//----------------t.start();
	}
	
	public void proximaImagen() {
		getChildren().get(0).toFront();
	}
	
	public void imagemAnterior() {
		getChildren().get(getChildren().size() -1).toBack();
	}
	
}
