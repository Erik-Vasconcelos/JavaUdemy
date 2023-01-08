package br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.notas.nota.container;

import java.time.LocalDate;
import java.util.function.UnaryOperator;

import org.controlsfx.control.Notifications;

import br.com.marttech.sg.controller.NotaController;
import br.com.marttech.sg.model.dto.NotaDTO;
import br.com.marttech.sg.view.App;
import br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.notas.ContainerMinhasNotas;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class ContainerNota extends GridPane{
	
	private Long idNota;
	private Label labelSeletor;
	private Button botaoSair;
	private Button botaoEditar;
	private Button botaoExcluir;
	private Button botaoSalvar;
	private TextField campoTitulo;
	private TextArea campoAnotacao;
	private DatePicker seletorData;
	private Popup popup;
	private Stage stage;
	private HBox containeBotoes;
	
	/*--------------------------Construtores----------------------------*/

	public ContainerNota() {
		configStructure();
		construirComponentes();
		addComponents();
		construirPopup();
		configPopupToNewNote();
	}
	
	public ContainerNota(NotaDTO nota) {
		configStructure();
		construirComponentes();
		addComponents();
		
		this.idNota = nota.getId();
		campoTitulo.setText(nota.getTitulo());
		seletorData.setValue(nota.getDataEntrega());
		campoAnotacao.setText(nota.getAnotacao());
		
		construirPopup();
		configPopupToEdit();
	}
	
	/*---------------------Metodos de actions------------------------*/
	
	private void configPopupToNewNote() {
		botaoSalvar.setOnAction(e -> {
			salvar();
			popup.hide();
			ContainerMinhasNotas.reload();
		});
		
		botaoSair.setOnAction(e -> {
			popup.hide();
		});
		
		desabilitarBotaoEditar();
		desabilitarBotaoExcluir();
	}
	
	private void configPopupToEdit() {
		botaoEditar.setOnAction(e -> {
			habilitarComponentesEdicao();
		});
		
		botaoSalvar.setOnAction(event -> {
			desabilitarComponentesEdicao();
			atualizar();
			ContainerMinhasNotas.reload();
		});
		
		botaoSair.setOnAction(e -> {
			popup.hide();
		});
		
		botaoExcluir.setOnAction(e -> {
			excluir();
			popup.hide();
			ContainerMinhasNotas.reload();
		});
		
		desabilitarComponentesEdicao();
	}
	
	/*---------------------Metodos estruturais------------------------*/
	
	private ColumnConstraints coluna(double width, HPos alinhamento) {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(width);
		cc.setPercentWidth(-1);
		cc.setHalignment(alinhamento);
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
		rc.setValignment(VPos.CENTER);
		rc.setFillHeight(true);
		return rc;
	}
	
	private void configStructure() {
		String css = getClass().getResource("Nota.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Agrupador");
		
		setPadding(new Insets(10));
		setAlignment(Pos.CENTER);
		setHgap(5);
		setVgap(5);
		
		getColumnConstraints().addAll(coluna(100, HPos.LEFT), coluna(100, HPos.RIGHT));
		getRowConstraints().addAll(linha(20), linha(20), linha(20), linha(20), linha(25));
	}
	
	private void construirComponentes() {
		labelSeletor = new Label("Data de entrega:");
		botaoSair = new Button("", new ImageView (new Image(getClass().getResourceAsStream("../../imagens/X.png"))));
		botaoSalvar = new Button("Salvar");
		botaoEditar = new Button("Editar");
		botaoExcluir = new Button("Excluir");
		campoTitulo = new TextField();
		campoAnotacao = new TextArea();
		seletorData = new DatePicker(LocalDate.now());
		configContainerBotoes();

		campoTitulo.setPromptText("Insira o título");
		labelSeletor.getStyleClass().add("Label");
		botaoSair.getStyleClass().addAll("Botao");
		botaoEditar.getStyleClass().addAll("Botao", "Botao-Editar");
		botaoSalvar.getStyleClass().addAll("Botao", "Botao-Salvar");
		botaoExcluir.getStyleClass().addAll("Botao", "Botao-Excluir");
		campoAnotacao.getStyleClass().add("Area-Texto");
		campoTitulo.getStyleClass().add("Campo-Titulo");
		seletorData.getStyleClass().add("Seletor-Data");
		
		campoAnotacao.setWrapText(true);
		aplicarFiltroCampoTitulo();
		aplicarTamanhoMaximoCampoAnotacao();
	}
	
	private void configContainerBotoes() {
		containeBotoes = new HBox();
		containeBotoes.setAlignment(Pos.CENTER_LEFT);
		containeBotoes.setSpacing(15);
		
		containeBotoes.getChildren().addAll(botaoEditar, botaoExcluir);
	}
	
	private void aplicarTamanhoMaximoCampoAnotacao() {
		UnaryOperator<TextFormatter.Change> filtro = new UnaryOperator<TextFormatter.Change>() {
			@Override
			public TextFormatter.Change apply(TextFormatter.Change t) {
				if(t.isReplaced()) {
					if(t.getControlText().matches("[^0-9A-Za-z]")) {
						t.setText(t.getControlText().substring(t.getRangeStart(), t.getRangeEnd()));
					}
				}
				
				if(t.isAdded()) {
					if(t.getControlText().length() < 250) {
						t.setText(t.getText());
						
					}else {
						t.setText("");
					}
				}
				return t;
			}
		};
		
		campoAnotacao.setTextFormatter(new TextFormatter<>(filtro));
	}
	
	private void aplicarFiltroCampoTitulo() {
		UnaryOperator<TextFormatter.Change> filtro = new UnaryOperator<TextFormatter.Change>() {
			@Override
			public TextFormatter.Change apply(TextFormatter.Change t) {
				
				if(t.isReplaced()) {
					if(t.getControlText().matches("[^0-9A-Za-z '~`]")) {
						t.setText(t.getControlText().substring(t.getRangeStart(), t.getRangeEnd()));
					}
				}
				
				if(t.isAdded()) {
					if(t.getControlText().length() < 25 && t.getText().matches("[0-9A-Za-z '~`]")) {
						t.setText(t.getText());
						
					}else if(t.getText().matches("[^0-9A-Za-z ]")) {
						t.setText("");
					}
				
				}
				return t;
			}
		};
		
		campoTitulo.setTextFormatter(new TextFormatter<>(filtro));
	}
	
	private void construirPopup() {
		stage = App.janelaPrincipal;
		popup = new Popup();
		popup.setAutoHide(true);
		popup.getContent().add(this);
		popup.show(stage);
	}
	
	private void addComponents() {
		add(campoTitulo, 0, 0, 2, 1);
		add(botaoSair, 1, 0);
		add(labelSeletor, 0, 1);
		add(seletorData, 1, 1);
		add(campoAnotacao, 0, 2, 2, 2);
		add(containeBotoes, 0, 4);
		add(botaoSalvar, 1, 4);
	}
	
	/*---------------------Habilitar/Desabilitar componentes------------------------*/
	
	private void habilitarComponentesEdicao() {
		habilitarBotaoSalvar();
		habilitarCampoTitulo();
		habilitarSeletorData();
		habilitarAreaTexto();
		desabilitarBotaoEditar();
		desabilitarBotaoExcluir();
	}
	
	private void desabilitarComponentesEdicao() {
		desabilitarBotaoSalvar();
		desabilitarCampoTitulo();
		desabilitarSeletorData();
		desabilitarAreaTexto();
		habilitarBotaoEditar();
		habilitarBotaoExcluir();
	}
	
	private void habilitarBotaoEditar() {
		botaoEditar.setVisible(true);
	}
	
	private void desabilitarBotaoEditar() {
		botaoEditar.setVisible(false);
	}
	
	private void habilitarBotaoSalvar() {
		botaoSalvar.setVisible(true);
	}
	
	private void desabilitarBotaoSalvar() {
		botaoSalvar.setVisible(false);
	}
	
	private void habilitarBotaoExcluir() {
		botaoExcluir.setVisible(true);
	}
	
	private void desabilitarBotaoExcluir() {
		botaoExcluir.setVisible(false);
	}
	
	private void habilitarSeletorData() {
		seletorData.setDisable(false);
		seletorData.getStyleClass().add("Seletor-Data-Edicao");
	}
	
	private void desabilitarSeletorData() {
		seletorData.setDisable(true);
		seletorData.getStyleClass().remove("Seletor-Data-Edicao");
	}
	
	private void habilitarCampoTitulo() {
		campoTitulo.setEditable(true);
		campoTitulo.getStyleClass().add("Campo-Titulo-Edicao");
	}
	
	private void desabilitarCampoTitulo() {
		campoTitulo.setEditable(false);
		campoTitulo.getStyleClass().remove("Campo-Titulo-Edicao");
	}
	
	private void habilitarAreaTexto() {
		campoAnotacao.setEditable(true);
		campoAnotacao.getStyleClass().add("Area-Texto-Edicao");
	}
	
	private void desabilitarAreaTexto() {
		campoAnotacao.setEditable(false);
		campoAnotacao.getStyleClass().remove("Area-Texto-Edicao");
	}
	
	/*------------------------Metodos de infra-------------------------*/
	
	private void salvar() {
		String titulo = campoTitulo.getText();
		LocalDate dataEntrega = seletorData.getValue(); 
		String anotacao = campoAnotacao.getText();
		
		boolean isSalvo = NotaController.salvar(new NotaDTO(titulo, dataEntrega, anotacao));
		
		if (isSalvo) {
			Notifications.create()
				.position(Pos.TOP_RIGHT)
				.text("Salvo com sucesso!")
				.showConfirm();
		}else {
			Notifications.create()
				.position(Pos.TOP_RIGHT)
				.text("Não foi possivel salvar!")
				.showError();
		}
	}
	
	private void atualizar() {
		NotaDTO nota = new NotaDTO(
				idNota,
				campoTitulo.getText(),
				seletorData.getValue(),
				campoAnotacao.getText()
		);
				
		boolean isUpdated = NotaController.atualizar(nota);
		
		if (isUpdated) {
			Notifications.create()
				.position(Pos.TOP_RIGHT)
				.text("Atualizado com sucesso!")
				.showConfirm();
		}else {
			Notifications.create()
				.position(Pos.TOP_RIGHT)
				.text("Não foi possivel Atualizar!")
				.showError();
		}
	}
	
	private void excluir() {
		boolean isUpdated = NotaController.exluir(idNota);
		
		if (isUpdated) {
			Notifications.create()
				.position(Pos.TOP_RIGHT)
				.text("Excluído com sucesso!")
				.showConfirm();
		}else {
			Notifications.create()
				.position(Pos.TOP_RIGHT)
				.text("Não foi possivel excluir!")
				.showError();
		}
	}
	
	private void createNotification() {
		
	}
	
}
