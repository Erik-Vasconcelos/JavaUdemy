package br.edu.ifrn.portal.lg;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application{

	private static Stage palco;
	private static Scene login;
	private static Scene inicio;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		palco = primaryStage;
		contruirLogin();
		construirInicio();
		
		palco.setScene(login);
		palco.setTitle("Login");
		palco.setResizable(false);
		palco.show();
	}
	
	private void contruirLogin() throws IOException {
		URL arquivoFxml = getClass().getResource("Login.fxml");
		GridPane raiz = FXMLLoader.load(arquivoFxml);
		raiz.setAlignment(Pos.CENTER);
		
		Scene cenaLogin  = new Scene(raiz, 600, 400);
		String css = getClass().getResource("Login.css").toExternalForm();
		cenaLogin.getStylesheets().add(css);
		
		login = cenaLogin;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void construirInicio() {
		TelaCadastro tela = new TelaCadastro();
		
		Scene cena = new Scene(tela, 1300, 700);
		
		inicio = cena;
	}
	
	public static void setInicio() {
		palco.setResizable(true);
		palco.setTitle("Inicio");
		palco.setScene(inicio);
		palco.setMaximized(true);
	}
}
