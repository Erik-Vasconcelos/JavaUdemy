package br.edu.ifrn.portal.sm.view;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		URL caminho = getClass().getResource("/view/Tela.fxml");
		
		GridPane parent = FXMLLoader.load(caminho);
		Scene scene =  new Scene(parent, 300, 400);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
