package fxml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AppFxml extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		URL arquivoXML = getClass().getResource("/fxml/Tela.fxml");
		
		GridPane raiz = FXMLLoader.load(arquivoXML);
		raiz.setGridLinesVisible(true);
		Scene cena = new Scene(raiz, 350, 350);
		
		String caminho = getClass().getResource("/fxml/Login.css").toExternalForm();
		cena.getStylesheets().add(caminho);
		
		//primaryStage.setResizable(false);
		primaryStage.setTitle("Tela de Login");
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
