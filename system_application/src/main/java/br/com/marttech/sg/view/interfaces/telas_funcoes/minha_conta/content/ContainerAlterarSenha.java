package br.com.marttech.sg.view.interfaces.telas_funcoes.minha_conta.content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.controlsfx.control.Notifications;

import br.com.marttech.sg.controller.AlterarSenhaController;
import br.com.marttech.sg.model.memoria.ServidorMemory;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class ContainerAlterarSenha extends GridPane{
	
	private Label lLogin;
	private Label lSenha;
	private Label lValorLogin;
	private Label lValorSenha;
	
	private ImageView imagem;
	private Label lAlterarSenha;
	private Label lSenhaAntiga;
	private Label lSenhaNova;
	private Label lConfirmarSenha;

	private PasswordField campoSenhaAtual;
	private TextField campoSenhaNova;
	private TextField campoConfirmarSenha;
	
	private Button alterarSenha;
	private Button confirmar;
	private Button cancelar;
	private HBox agrupadorBotoes;
	private HBox agrupadorCreden_Imagen;
	private VBox agrupadorCredenciais;
	private List<TextField> campos;
	
	
	public ContainerAlterarSenha() {
		configuracoes();
		getStyleClass().add("Content");
	}
	
	public ContainerAlterarSenha(int marcacao) {
		configuracoes();
		getStyleClass().add("Content-Alterado");
		getRowConstraints().addAll(linha(), linha(), linha(), linha(), linha(),
				linha(), linha(), linha(), linha());
		
		add(lAlterarSenha, 0, 6);
		add(lSenhaAntiga, 0, 7);
		add(campoSenhaAtual, 0, 8);
		add(lSenhaNova, 0, 9);
		add(campoSenhaNova, 0, 10);
		add(lConfirmarSenha, 0, 11);
		add(campoConfirmarSenha, 0, 12);
		add(agrupadorBotoes, 0, 13);
	}
	
	/*------------------------Metodos Estruturais---------------------------*/
	
	private void configuracoes() {
		setPadding(new Insets(25));
		setAlignment(Pos.TOP_CENTER);
		setVgap(3);
		setHgap(15);
		
		String css = getClass().getResource("Content.css").toExternalForm();
		getStylesheets().add(css);
		
		contruirComponentes();
		
		add(agrupadorCreden_Imagen, 0, 0, 1, 5);
		add(alterarSenha, 4, 2);
	}
	
	private void contruirComponentes() {
		lLogin = new Label("Login: ");
		lSenha = new Label("Senha: ");
		lValorLogin = new Label();
		lValorSenha = new Label();
		setDados();
		
		lAlterarSenha = new Label("Alterar Senha");
		lSenhaAntiga = new Label("Senha Atiga: ");
		lSenhaNova = new Label("Nova Senha: ");
		lConfirmarSenha = new Label("Confirmar Senha: ");
		campoSenhaAtual = new PasswordField();
		campoSenhaNova = new TextField();
		campoConfirmarSenha = new TextField();
		
		alterarSenha = new Button("Alterar Senha");
		confirmar= new Button("Confirmar");
		cancelar = new Button("Cancelar");
		imagem = new ImageView(new Image(getClass().getResourceAsStream("../imagens/senha.png")));
		
		configAgrupadorBotoes();
		configAgrupadorCredenciais();
		configAgrupadorCrendenciais_Imagem();
		
		getColumnConstraints().addAll(coluna(), coluna(), coluna(), coluna());
		getRowConstraints().addAll(linha(), linha(VPos.TOP), linha(), linha(VPos.TOP), linha());
		
		addEstilo();
		addComportamentos();
		
		campos = new ArrayList<>(Arrays.asList(campoSenhaAtual, campoSenhaNova, campoConfirmarSenha));
	}
	
	private void configAgrupadorCredenciais() {
		agrupadorCredenciais = new VBox();
		agrupadorCredenciais.setSpacing(10);
		agrupadorCredenciais.setAlignment(Pos.TOP_LEFT);
		agrupadorCredenciais.getChildren().addAll(lLogin, lValorLogin, lSenha, lValorSenha);
	}
	
	private void configAgrupadorCrendenciais_Imagem() {
		agrupadorCreden_Imagen = new HBox();
		agrupadorCreden_Imagen.setAlignment(Pos.TOP_CENTER);
		agrupadorCreden_Imagen.setSpacing(10);
		agrupadorCreden_Imagen.getChildren().addAll(imagem, agrupadorCredenciais);
	}
	
	private void setDados() {
		lValorLogin.setText(String.valueOf(ServidorMemory.getInstance()
				.getMatricula()));
		configLabelValorSenha();
	}
	
	private ColumnConstraints coluna() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(480);
		cc.setPercentWidth(-1);
		cc.setHalignment(HPos.LEFT);
		cc.setHgrow(Priority.ALWAYS);
		cc.setFillWidth(true);
		return cc;
	}
	
	private RowConstraints linha() {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(20);
		rc.setVgrow(Priority.ALWAYS);
		rc.setPercentHeight(-1);
		rc.setFillHeight(true);
		return rc;
	}
	
	private RowConstraints linha(VPos alinhamento) {
		RowConstraints rc = linha();
		rc.setValignment(alinhamento);
		return rc;
	}
	
	/*--------------------Metodos Estruturais Auxiliares-----------------------*/
	
	private void configLabelValorSenha() {
		String senha = ServidorMemory.getInstance().getSenha();
		
		Pattern pattern = Pattern.compile("[}{@,.^?~=+\\-_\\/*\\-+.\\|A-Za-z0-9]");
		lValorSenha.setText(senha.replaceAll(pattern.pattern(), "*"));
	}
	
	private void configAgrupadorBotoes() {
		agrupadorBotoes = new HBox();
		agrupadorBotoes.setSpacing(40);
		agrupadorBotoes.setAlignment(Pos.CENTER_LEFT);
		agrupadorBotoes.getStyleClass().add("Form-Agrupador-Botoes");
		agrupadorBotoes.getChildren().addAll(confirmar, cancelar);
	}
	
	/*------------------------Metodos de Funcao---------------------------*/
	
	private void addComportamentos() {
		confirmar.setOnAction(e -> {
			atualizarSenha();
		});
	}
	
	private void atualizarSenha() {
		
		boolean condicao1 = !campoSenhaAtual.getText().trim().isBlank();
		boolean condicao2 = !campoSenhaNova.getText().trim().isBlank();
		boolean condicao3 = !campoConfirmarSenha.getText().trim().isBlank();
		boolean condicao4 = campoConfirmarSenha.getText().trim().equals(campoSenhaNova.getText().trim());
		boolean condicao5 = campoSenhaAtual.getText().equals(ServidorMemory.getInstance().getSenha());
		
		boolean dadosValidos = condicao1 && condicao2 && condicao3 && condicao4 && condicao5;
		
		if(dadosValidos) {
			salvar(campoSenhaNova.getText());
			finalizarAlteracao();
			Notifications
				.create()
				.text("Senha atualizada!!!")
				.title("Aviso")
				.position(Pos.TOP_CENTER)
				.showInformation();
		}else {
			Notifications
			.create()
			.text("Dados inseridos não compativeis")
			.title("Aviso")
			.position(Pos.TOP_CENTER)
			.showError();;
		}
	}
	
	private boolean salvar(String novaSenha) {
		return AlterarSenhaController.updateSenha(novaSenha);
	}
	
	private void finalizarAlteracao() {
		campos.forEach(c -> c.setText(""));
		cancelar.fire();
	}
	
	/*------------------------Metodos de reiniciar---------------------------*/
	public void reload() {
		setDados();
	}
	/*------------------------Metodos de Estilo---------------------------*/
	
	private void addEstilo() {
		lLogin.getStyleClass().add("Label-Titulo");
		lSenha.getStyleClass().add("Label-Titulo");
		lValorLogin.getStyleClass().add("Label-Valor");
		lValorSenha.getStyleClass().add("Label-Valor");
		alterarSenha.getStyleClass().add("Botao");
		
		lAlterarSenha.getStyleClass().add("Form-Label-Titulo");
		lSenhaAntiga.getStyleClass().add("Form-Label");
		lSenhaNova.getStyleClass().add("Form-Label");
		lConfirmarSenha.getStyleClass().add("Form-Label");
		
		campoSenhaAtual.getStyleClass().add("Form-Campo");
		campoSenhaNova.getStyleClass().add("Form-Campo");
		campoConfirmarSenha.getStyleClass().add("Form-Campo");
		
		confirmar.getStyleClass().addAll("Form-Botao", "Form-Botao-Confirmar");
		cancelar.getStyleClass().addAll("Form-Botao", "Form-Botao-Cancelar");
	}
	
	/*------------------------Metodos acessores---------------------------*/

	public HBox getContentBotoes() {
		return agrupadorBotoes;
	}

	public Button getAlterarSenha() {
		return alterarSenha;
	}

	public Button getCancelar() {
		return cancelar;
	}

}
