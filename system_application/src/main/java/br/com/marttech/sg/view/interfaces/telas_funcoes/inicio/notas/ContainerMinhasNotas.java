package br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.notas;

import br.com.marttech.sg.controller.MinhasNotasController;
import br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.notas.nota.agrupador.AgrupadorNotas;
import br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.notas.nota.container.ContainerNota;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ContainerMinhasNotas extends VBox{
	
	private Label minhasTarefas;
	private Button novaNota;
	
	private VBox cabecalho;
	
	private static AgrupadorNotas containerAnotacoes;

	public ContainerMinhasNotas() {
		String css = getClass().getResource("MinhasNotas.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Container");
		setPadding(new Insets(12));
		setAlignment(Pos.TOP_CENTER);
		setSpacing(5);
		
		Thread t = new Thread(() -> {
			try {
				Platform.runLater(() -> {
					construirComponentes();
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
		
		t.setDaemon(true);
		t.start();
	}
	
	private void construirComponentes() {
		minhasTarefas = new Label("Minhas Notas");
		novaNota = new Button("", new ImageView(new Image(getClass().getResourceAsStream("imagens/novaNota.png"))));
		containerAnotacoes = new AgrupadorNotas();
		configCabecalho();
		
		minhasTarefas.getStyleClass().add("Titulo");
		novaNota.getStyleClass().add("Botao-Add");
		
		
		getChildren().addAll(cabecalho, containerAnotacoes);
		addActions();
	}
	
	private void configCabecalho() {
		cabecalho = new VBox();
		cabecalho.setAlignment(Pos.CENTER_LEFT);
		cabecalho.setSpacing(15);
		
		cabecalho.getChildren().addAll(minhasTarefas, novaNota);
	}
	
	private void addActions() {
		novaNota.setOnAction(e -> {
			boolean limiteAtingido = MinhasNotasController.verificarLimite();
			
			if(!limiteAtingido) {
				new ContainerNota();
			}else {
				
				Alert alerta = new Alert(AlertType.WARNING);
				alerta.setHeaderText("Limite Atingido!");
				alerta.setContentText("O seu limite de notas foi atingido, "
						+ "libere espaço para inserir novas");
				alerta.showAndWait();
				alerta.setTitle("Aviso");
			}
		});
	}
	
	public static void reload() {
		containerAnotacoes.reload();
	}
}
