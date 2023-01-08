package br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.container_user;

import br.com.marttech.sg.controller.ContentUsuarioController;
import br.com.marttech.sg.controller.EditUsuarioController;
import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.view.App;
import br.com.marttech.sg.view.interfaces.interface_sistema.TelaSistema;
import br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.telas.grerenciamento.TelaGerenciamentoUsuarios;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * @author erikv
 * @date 20:54:43 11 de nov. de 2022
 * 
 */

public class ContainerUsuario extends GridPane{
	
	private static int contador = 1;
	
	private Long id;
	private Label lMatricula;
	private Label lNome;
	private Label lEmail;
	private Label lFuncao;
	private Label lPermissao;
	private Button botaoUpdate;
	private Button botaoDelete;
	private HBox agrupadorBotoes;
	
	private EventHandler acaoBotaoUpdate;
	
	public ContainerUsuario(EventHandler acaoBotaoUpdate) {
		this.acaoBotaoUpdate = acaoBotaoUpdate;
		setPadding(new Insets(10));
		setAlignment(Pos.CENTER_LEFT);
		setHgap(3);
		
		String css = getClass().getResource("ContentUsuario.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Content");
		
		if(contador %2 == 1) {
			getStyleClass().add("Content-Escuro");
			
		}else {
			getStyleClass().add("Content-Claro");
		}
		contador ++;
		
		configComponentes();
		
		add(lMatricula, 0, 0);
		add(lNome, 1, 0);
		add(lEmail, 2, 0);
		add(lFuncao, 3, 0);
		add(lPermissao, 4, 0);
		add(agrupadorBotoes, 5, 0);
		
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
	}
	
	public ContainerUsuario(ServidorDTO servidor, EventHandler acaoBotaoUpdate) {
		this(acaoBotaoUpdate);
		setDados(servidor);
	}
	
	private ColumnConstraints coluna() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(160);
		cc.setPercentWidth(-1);
		cc.setHgrow(Priority.ALWAYS);
		cc.setHalignment(HPos.LEFT);
		cc.setFillWidth(true);
		return cc;
	}
	
	private ColumnConstraints coluna(double width) {
		ColumnConstraints cc = coluna();
		cc.setPrefWidth(width);
		return cc;
	}
	
	private RowConstraints linha() {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(25);
		rc.setPercentHeight(-1);
		rc.setVgrow(Priority.SOMETIMES);
		rc.setValignment(VPos.CENTER);
		rc.setFillHeight(true);
		return rc;
	}
	
	private void configComponentes() {
		getColumnConstraints().addAll(coluna(), coluna(260), coluna(200), coluna(120), coluna(), coluna(90));
		getRowConstraints().addAll(linha());
		
		lMatricula = new Label("Teste");
		lNome = new Label("Teste");
		lEmail = new Label("Teste");
		lFuncao = new Label("Teste");
		lPermissao = new Label("Teste");
		botaoUpdate = new Button("", new ImageView(new Image(getClass().getResourceAsStream("../imagens/lapis.png"))));
		botaoDelete = new Button("", new ImageView(new Image(getClass().getResourceAsStream("../imagens/excluir.png"))));
		agrupadorBotoes = new HBox();
		
		lMatricula.getStyleClass().add("Texto");
		lNome.getStyleClass().add("Texto");
		lEmail.getStyleClass().add("Texto");
		lFuncao.getStyleClass().add("Texto");
		lPermissao.getStyleClass().add("Texto");
		botaoUpdate.getStyleClass().add("Botao");
		botaoDelete.getStyleClass().add("Botao");
		
		botaoUpdate.setCursor(Cursor.HAND);
		botaoDelete.setCursor(Cursor.HAND);
		
		agrupadorBotoes.setAlignment(Pos.CENTER);
		agrupadorBotoes.setSpacing(5);
		agrupadorBotoes.getChildren().addAll(botaoUpdate, botaoDelete);
		agrupadorBotoes.setMaxWidth(90);
		adicionarAcoes();
	}
	
	private void setDados(ServidorDTO servidor) {
		id = Long.parseLong(servidor.getId());
		lMatricula.setText(servidor.getMatricula());
		lNome.setText(servidor.getNome());
		lEmail.setText(servidor.getEmail());
		lFuncao.setText(servidor.getCargo());
		lPermissao.setText(servidor.getPermissao());
	}
	
	//Refanzendo
	private void adicionarAcoes() {
		botaoDelete.setOnAction(e -> excluirUsuario());
		botaoUpdate.setOnAction(e -> {
			botaoUpdate.getOnAction();
			setUsuarioInMemoryEdition();
			App.getTelaSistema().telaUsuarios.adicionarTelaEdit();
			App.getTelaSistema().telaUsuarios.paraParaTraz();
		});
		
	}
	
	private void setUsuarioInMemoryEdition() {
		EditUsuarioController.setUsuarioInMemory(id);
	}
	
	private void excluirUsuario() {
		Alert caixaConfirmacao = new Alert(AlertType.CONFIRMATION);
		String texto = String.format("Deseja realmente excluir o usuario de matricula (%s) e nome (%s) ?",
				lMatricula.getText(), lNome.getText());
		
		caixaConfirmacao.setTitle("Excluir usuário");
		caixaConfirmacao.setHeaderText("Confirmação");
		caixaConfirmacao.setContentText(texto);
		caixaConfirmacao.showAndWait();
		
		executarDelete(caixaConfirmacao.getResult());
	}
	
	private void executarDelete(ButtonType botaoClicado) {
		if(botaoClicado == ButtonType.OK) {
			boolean result = ContentUsuarioController.deleteUsuario(id);
			
			if(result) {
				Alert info = new Alert(AlertType.INFORMATION);
				info.setHeaderText("O usuário foi removido com sucesso!");
				info.showAndWait();
				
				TelaGerenciamentoUsuarios.reload();
			}else {
				Alert info = new Alert(AlertType.ERROR);
				info.setHeaderText("Não foi possivel remover o usuário");
				info.showAndWait();
			}
		}
	}

	public Button getBotaoUpdate() {
		return botaoUpdate;
	}

}
