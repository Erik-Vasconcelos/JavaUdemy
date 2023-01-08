package br.com.marttech.sg.view;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Janela extends Application{
	
	private static Stage palco;
	private static Scene login;
	private static Scene telaInicio;

	@Override
	public void start(Stage primaryStage) throws Exception {
		palco = primaryStage;
		
		URL caminho = getClass().getResource("TelaAdmG.fxml");
		GridPane tela = FXMLLoader.load(caminho);
		//telaInicio = new Scene(tela, 1920, 1020);
		
		login = new Scene(new Login(), 600, 400);
		palco.setResizable(false);
		palco.setScene(login);
		palco.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void setTelaInicio() {
		palco.setScene(telaInicio);
	}
}
