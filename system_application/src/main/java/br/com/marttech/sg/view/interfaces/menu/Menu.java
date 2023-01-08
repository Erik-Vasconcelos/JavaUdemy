package br.com.marttech.sg.view.interfaces.menu;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import br.com.marttech.sg.controller.MenuController;
import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.view.libs.PermissaoFront;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Menu extends VBox{
	
	private Label titulo;
	private Circle imgUsuario;
	private Button botaoPerfilConta;
	private Label nomeUsuario;
	private TextField pesquisa;
	private BotaoMenu botaoInicio;
	private BotaoMenu botaoMeusDados;
	private BotaoMenu botaoConta;
	private BotaoMenu botaoCadastrar;
	private BotaoMenu botaoUsuarios;
	private BotaoMenu botaoSair;
	
	private BorderPane agrupadorUsuario;
	
	private BotaoMenu ultimoBotao = new BotaoMenu();
	private BotaoMenu ultimoBotaoClicado;
	
	private List<BotaoMenu> botoes;
	
	public Menu(PermissaoFront permissao) {
		setAlignment(Pos.TOP_CENTER);
		setPadding(new Insets(8));
		setSpacing(4);
		String css = getClass().getResource("Menu.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Content");
		construirComponentes(permissao);
		
		getStylesheets().add("https://fonts.googleapis.com/css2?family=Rajdhani");
		
		
		getChildren().add(0, titulo); 
		getChildren().add(1, agrupadorUsuario); 
		getChildren().add(2, pesquisa); 
	}
	
	private void construirComponentes(PermissaoFront permissao) {
		titulo = new Label("Sistema E-Ensino");
		imgUsuario = new Circle(44, 44, 22);
		botaoPerfilConta = new Button("",  new ImageView(new Image(getClass().getResourceAsStream("imagens/icone-usuario.png"))));
		nomeUsuario = new Label();
		pesquisa = new TextField();
		
		configurarBotoes(permissao);
		
		configContainerUsuario();
		setUltimoBotaoClicado(botaoInicio);
		
		titulo.getStyleClass().add("Titulo");
		pesquisa.getStyleClass().add("Pesquisa");
		
		pesquisa.setPromptText("Buscar Menu");
		
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
	}
	
	private void configContainerUsuario() {
		agrupadorUsuario = new BorderPane();
		agrupadorUsuario.getStyleClass().add("Content-Usuario");
		agrupadorUsuario.setPadding(new Insets(0, 8, 0, 0));
		
		
		//-----------Configurando componentes------------
		imgUsuario = new Circle(44, 44, 22);
		nomeUsuario = new Label();
		construirBotaoMinhaconta();
		
		botaoPerfilConta.getStyleClass().add("Botao-Icone-Usuario");
		nomeUsuario.getStyleClass().add("Label-Nome-Usuario");
		
		/*--------------Settando dados---------------*/
		setDadosContainerUsuario();
		
		botaoPerfilConta.setOnAction(e -> botaoConta.fire());
		
		agrupadorUsuario.setLeft(imgUsuario);
		agrupadorUsuario.setRight(botaoPerfilConta);
		agrupadorUsuario.setCenter(nomeUsuario);
		agrupadorUsuario.setAlignment(botaoPerfilConta, Pos.CENTER_RIGHT);
		
	}
	
	private void setDadosContainerUsuario() {
		ServidorDTO servidor = MenuController.getDadosContent();
		
		if(servidor.getImagem() != null) {
			InputStream inputStream = new ByteArrayInputStream(servidor.getImagem());
			imgUsuario.setFill(new ImagePattern(new Image(inputStream)));
		}
		
		nomeUsuario.setText(servidor.getNome());
	}
	
	private void construirBotaoMinhaconta() {
		botaoPerfilConta = new Button("",  new ImageView(	
				new Image(getClass().getResourceAsStream("imagens/icone-usuario.png"))));
		botaoPerfilConta.setCursor(Cursor.HAND);
	}
	
	private void configurarBotoes(PermissaoFront permissao) {
		switch (permissao) {
			case ADMINISTRADOR_GERAL:
				configurarMenuAdmGeral();
				break;
			case ADMINISTRADOR: 
				configurarMenuAdm();;
				break;
			case GERENCIADOR_TURMA:
				configurarMenuGerenciadorTurma();
				break;
			default:
				configurarMenuUsuario();
		}
	}
	
	private void configurarMenuAdmGeral() {
		configBotaoInicio();
		configBotaoMeusDados();
		configBotaoMinhaConta();
		configBotaoCadastro();
		configBotaoUsuarios();
		configBotaoSair();
	}
	
	private void configurarMenuAdm() {
		configBotaoInicio();
		configBotaoMeusDados();
		configBotaoMinhaConta();
		configBotaoCadastro();
		configBotaoUsuarios();
		configBotaoSair();
	}
	
	private void configurarMenuGerenciadorTurma() {
		configBotaoInicio();
		configBotaoMeusDados();
		configBotaoMinhaConta();
		configBotaoSair();
	}
	
	private void configurarMenuUsuario() {
		configBotaoInicio();
		configBotaoMeusDados();
		configBotaoMinhaConta();
		configBotaoSair();
	}
	
	public void configBotaoInicio() {
		botaoInicio = new BotaoMenu("Inicio", "imagens/casa.png");
		getChildren().add(botaoInicio);
	}
	
	public void configBotaoMeusDados() {
		botaoMeusDados = new BotaoMenu("Meus dados", "imagens/dados-pessoais.png");
		getChildren().add(botaoMeusDados);
	}
	
	public void configBotaoMinhaConta() {
		botaoConta = new BotaoMenu("Minha Conta", "imagens/minha-conta.png");
		getChildren().add(botaoConta);
	}

	public void configBotaoCadastro() {
		botaoCadastrar = new BotaoMenu("Cadastrar Usuario", "imagens/novo-Usuario.png");
		getChildren().add(botaoCadastrar);
	}
	
	public void configBotaoUsuarios() {
		botaoUsuarios = new BotaoMenu("Usuarios", "imagens/usuarios.png");
		getChildren().add(botaoUsuarios);
	}
	
	public void configBotaoSair() {
		botaoSair = new BotaoMenu("Sair", "imagens/sair.png");
		getChildren().add(botaoSair);
	}
	
	public void reload() {
		setDadosContainerUsuario();
	}

	public Label getLabel() {
		return titulo;
	}
	
	public Label getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(Label nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Button getBotaoPerfilConta() {
		return botaoPerfilConta;
	}

	public BotaoMenu getBotaoInicio() {
		return botaoInicio;
	}

	public BotaoMenu getBotaoMeusDados() {
		return botaoMeusDados;
	}

	public BotaoMenu getBotaoConta() {
		return botaoConta;
	}

	public BotaoMenu getBotaoCadastrar() {
		return botaoCadastrar;
	}

	public BotaoMenu getBotaoUsuarios() {
		return botaoUsuarios;
	}

	public BotaoMenu getBotaoSair() {
		return botaoSair;
	}

	public BotaoMenu getUltimoBotao() {
		return ultimoBotao;
	}

	public Label getTitulo() {
		return titulo;
	}

	public TextField getPesquisa() {
		return pesquisa;
	}

	public BotaoMenu getUltimoBotaoClicado() {
		return ultimoBotaoClicado;
	}

	public void setUltimoBotaoClicado(BotaoMenu ultimoBotaoClicado) {
		this.ultimoBotao = this.ultimoBotaoClicado;
		this.ultimoBotaoClicado = ultimoBotaoClicado;
	}

}
