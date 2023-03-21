package principal;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Contador extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox vBox = new VBox();
		vBox.setSpacing(20);
		vBox.setAlignment(Pos.CENTER);
		
		Label label = new Label("0");
		label.setFont(new Font(30));
		
		Button buttonDecrease = new Button("-");
		Button buttonInrcrease = new Button("+");
		
		HBox hBox = new HBox(20);
		hBox.setMaxWidth(300);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(buttonDecrease, buttonInrcrease);
		
		buttonDecrease.setOnAction(e -> decrease(label));
		buttonInrcrease.setOnAction(e -> increase(label));
		
		vBox.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.SUBTRACT) {
				decrease(label);
			}else if(e.getCode() == KeyCode.ADD) {
				increase(label);
			}
		});
		
		vBox.getChildren().addAll(label, hBox);
		
		primaryStage.setScene(new Scene(vBox, 400, 500));
		primaryStage.setTitle("Contador");
		primaryStage.show();
	}
	
	
	private void decrease(Label label) {
		int valor = Integer.parseInt(label.getText());
		label.setText(--valor + "");
		
		if(valor < 0) {
			label.setStyle("-fx-background-color: rgb(255, 0, 0)");
		}
	}
	
	private void increase(Label label) {
		int valor = Integer.parseInt(label.getText());
		label.setText(++valor + "");
		
		if(valor > 0) {
			label.setStyle("-fx-background-color: rgb(0, 255, 0)");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}

}
