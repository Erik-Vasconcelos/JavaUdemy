package br.com.marttech.sg.view.loading;

import java.util.Arrays;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class TelaCarregamento extends VBox{
	
	private Label progresso;
	private ProgressBar barraProgresso;
	
	public TelaCarregamento() {
		String css = getClass().getResource("Carregamento.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Container");
		
		setAlignment(Pos.BOTTOM_CENTER);
		setPadding(new Insets(10));
		
		configConponents();
		getChildren().addAll(Arrays.asList(barraProgresso, progresso));
		
	}
	
	private void configConponents() {
		progresso = new Label();
		progresso.getStyleClass().add("Label");
		barraProgresso = new ProgressBar();
		barraProgresso.setProgress(0.0);
		barraProgresso.setMinWidth(450);
		
		barraProgresso.getStyleClass().add("Progress");
	}
	
	public void setProgress(double progresso) {
		barraProgresso.setProgress(progresso);
		
		Platform.runLater(() -> {
			double progressoBarra = barraProgresso.getProgress();
			
			if(progressoBarra > 0.01 && progressoBarra < 0.05) {
			this.progresso.setText("Iniciando aplicacao...");
			
			}else if(progressoBarra > 0.05 && progressoBarra < 0.4){
			this.progresso.setText("Carregando Módulos...");
			
			}else if(progressoBarra > 0.4 && progressoBarra < 0.6){
			this.progresso.setText("Quase lá...");
			}
			else if(progressoBarra > 0.6){
				this.progresso.setText("Finalizando...");
			}
		});
		
	}

}
