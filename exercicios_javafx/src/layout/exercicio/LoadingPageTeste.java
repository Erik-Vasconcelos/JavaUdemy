package layout.exercicio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoadingPageTeste extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene cena = new Scene(new LoadingPage(), 1800, 960);
		
		primaryStage.setFullScreen(true);
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
