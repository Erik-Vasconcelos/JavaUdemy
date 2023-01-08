package br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.notas.nota;

import br.com.marttech.sg.controller.BotaoNotaController;
import br.com.marttech.sg.model.dto.NotaDTO;
import br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.notas.nota.container.ContainerNota;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class BotaoNota extends Button{
	
	private Long id;
	
	public BotaoNota(Long idNota, String texto) {
		this.id = idNota;
		setAlignment(Pos.CENTER_LEFT);
		setPadding(new Insets(5));
		setText(texto);
		setMaxWidth(USE_COMPUTED_SIZE);
		configStyle();
		setAction();
	}

	private void setAction() {
		setOnAction(e -> {
			NotaDTO nota = BotaoNotaController.obterDadosNota(this.id);
			new ContainerNota(nota);
		});
	}
	
	private void configStyle() {
		String css = getClass().getResource("BotaoNota.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Botao-Nota");
	}
	
	public Long getIdBotao() {
		return id;
	}
	
}
