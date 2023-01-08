package br.com.ifrn.portal.sm.views;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
	
	private static Stage janela;
	private static Scene cenaInicio;
	private static Scene cenaCadastro;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			janela = primaryStage;
			
			Parent parent1 = getParent("/br/com/ifrn/portal/sm/views/TelaInicio.fxml");
			Parent parent2 = getParent("/br/com/ifrn/portal/sm/views/TelaCadastroUser.fxml");
			
			cenaInicio = new Scene(parent1);
			cenaCadastro = new Scene(parent2);
			
			App.janela.setScene(cenaInicio);
			App.janela.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Parent getParent(String absolutePath) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setClassLoader(getClass().getClassLoader()); // definir o carregador de classe 
		loader.setLocation(getClass().getResource(absolutePath));
		return loader.load();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void setCenaCadastro() {
		janela.setScene(cenaCadastro);
	}
	
	public static void setCenaInicio() {
		janela.setScene(cenaInicio);
	}
}
