package br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.hora;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.util.Duration;

public class ContainerHorario extends GridPane{
	
	private Label lHorario;
	private Label lData;
	
	public ContainerHorario() {
		String css = getClass().getResource("Horario.css").toExternalForm();
		getStylesheets().add(css);
		setAlignment(Pos.CENTER_RIGHT);
		setPadding(new Insets(25));
		getStyleClass().add("Container");
		
		getColumnConstraints().addAll(coluna(100), coluna(250));
		getRowConstraints().addAll(linha(90, VPos.BOTTOM), linha(35));
		
		contruirComponentes();
		setHorario();
		atualizarData();
		
		add(lHorario, 1, 0);
		add(lData, 0, 1, 2, 1);
		
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
	}
	
	private void contruirComponentes() {
		lHorario = new Label();
		lData = new Label();
		lHorario.getStyleClass().add("Label-Hora");
		lData.getStyleClass().add("Label-Data");
	}
	
	private void setHorario() {
		KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizarHorario());
		Timeline timeline = new Timeline(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
	private void atualizarHorario() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String hora = format.format(new Date().getTime());
		lHorario.setText(hora);
		atualizarData();
	}
	
	private void atualizarData() {
		Date data = new Date();
		DateFormat format = DateFormat.
				getTimeInstance(DateFormat.FULL, new Locale("pt", "BR"));
		
		format = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy");
		String dataFormatada = format.format(data);
		
		lData.setText(dataFormatada);
	}
	
	
	private ColumnConstraints coluna(double width) {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(width);
		cc.setHgrow(Priority.ALWAYS);
		cc.setHalignment(HPos.RIGHT);
		cc.setFillWidth(true);
		return cc;
	}
	
	private RowConstraints linha(double height) {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(height);
		rc.setFillHeight(true);
		return rc;
	}
	
	private RowConstraints linha(double height, VPos alinhamento) {
		RowConstraints rc = linha(height);
		rc.setValignment(alinhamento);
		return rc;
	}
	
	
}
