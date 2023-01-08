package calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Aplicacao extends Application{

	static Stage palco;
	private double posX;
	private double posY;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		palco =  primaryStage;
		
		Scene principal = new Scene(new Calculadora(), 320, 500);
		
		String css = getClass().getResource("Estilo.css").toExternalForm();
		
		principal.getStylesheets().add(css);
		
		principal.setOnMouseClicked(event -> {
			posX = primaryStage.getX() - event.getScreenX();
			posY = primaryStage.getY() - event.getScreenY();
		});
		
		principal.setOnMouseDragged(e -> {
			primaryStage.setX(e.getScreenX() + posX);
			primaryStage.setY(e.getScreenY() + posY);
		});
		
		
		palco.setScene(principal);
		palco.setTitle("Calculadora");
		palco.initStyle(StageStyle.UNDECORATED);
		palco.setResizable(false);
		palco.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
