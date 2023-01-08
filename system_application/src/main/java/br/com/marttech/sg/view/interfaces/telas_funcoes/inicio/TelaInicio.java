package br.com.marttech.sg.view.interfaces.telas_funcoes.inicio;

import br.com.marttech.sg.view.interfaces.telas_funcoes.TelaSystem;
import br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.central.ContainerCentral;
import br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.group_imagens.ContainerImagens;
import br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.hora.ContainerHorario;
import br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.notas.ContainerMinhasNotas;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class TelaInicio extends GridPane implements TelaSystem{
	
	private ContainerHorario containerHorario;
	private ContainerImagens containerImagens;
	private ContainerCentral containerCentral;
	private static ContainerMinhasNotas containerNotas;
	
	public TelaInicio() {
		String css = getClass().getResource("Inicio.css").toExternalForm();
		getStylesheets().add(css);
		setAlignment(Pos.CENTER_LEFT);
		setPadding(new Insets(25));
		getStyleClass().add("Container");
		setHgap(15);
		setVgap(15);
		getColumnConstraints().addAll(coluna(538), coluna(864), coluna(480));
		getRowConstraints().addAll(linha(302), linha(540), linha(130));
		
		construirComponentes();
		
		add(containerHorario, 0, 0);
		add(containerImagens, 0, 1, 2, 2);
		add(containerCentral, 1, 0);
		add(containerNotas, 2, 0, 1, 3);
	}
	
	private void construirComponentes() {
		containerHorario = new ContainerHorario();
		containerImagens = new ContainerImagens();
		containerCentral = new ContainerCentral();
		containerNotas = new ContainerMinhasNotas();
	}
	
	private ColumnConstraints coluna(double width) {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(width);
		cc.setPercentWidth(-1);
		cc.setHalignment(HPos.LEFT);
		cc.setHgrow(Priority.ALWAYS);
		cc.setFillWidth(true);
		return cc;
	}
	
	private RowConstraints linha(double height) {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(height);
		rc.setPercentHeight(-1);
		rc.setVgrow(Priority.ALWAYS);
		rc.setFillHeight(true);
		return rc;
	}
	
	public void reload() {
		ContainerMinhasNotas.reload();
	}
	
}
