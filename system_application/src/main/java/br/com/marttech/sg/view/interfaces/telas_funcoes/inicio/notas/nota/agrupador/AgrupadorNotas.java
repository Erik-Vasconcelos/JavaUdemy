package br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.notas.nota.agrupador;

import java.util.ArrayList;
import java.util.List;

import br.com.marttech.sg.controller.AgrupadorNotasController;
import br.com.marttech.sg.model.dto.NotaDTO;
import br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.notas.nota.BotaoNota;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class AgrupadorNotas extends VBox{
	
	private List<BotaoNota> listaAnotacoes = new ArrayList<>();
	
	public AgrupadorNotas() {
		configStyle();
		addComponentes();
	}
	
	private void configStyle() {
		String css = getClass().getResource("AgrupadorNotas.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Container");
		setPadding(new Insets(10));
		setAlignment(Pos.TOP_CENTER);
		setSpacing(4);
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
		setVgrow(this, Priority.ALWAYS);
	}
	
	/*--------------------Metodos estruturais--------------------*/
	
	public void addComponentes() {
		getAnotacoes();
		if (!listaAnotacoes.isEmpty()) {
			getChildren().addAll(listaAnotacoes);
		}
	}
	
	private void getAnotacoes() {
		List<NotaDTO> notas = AgrupadorNotasController.buscarTodas();
		
		notas.stream().forEach(n -> {
			BotaoNota botao = new BotaoNota(n.getId(), n.getTitulo());
			listaAnotacoes.add(botao);
		});
	}
	
	public void reload() {
		getChildren().removeAll(listaAnotacoes);
		listaAnotacoes.clear();
		addComponentes();
	}
	
}
