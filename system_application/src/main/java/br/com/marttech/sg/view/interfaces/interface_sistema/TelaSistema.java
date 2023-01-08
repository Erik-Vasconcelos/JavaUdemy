package br.com.marttech.sg.view.interfaces.interface_sistema;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.marttech.sg.view.App;
import br.com.marttech.sg.view.interfaces.menu.BotaoMenu;
import br.com.marttech.sg.view.interfaces.menu.Menu;
import br.com.marttech.sg.view.interfaces.telas_funcoes.TelaSystem;
import br.com.marttech.sg.view.interfaces.telas_funcoes.cadastro.TelaCadastro;
import br.com.marttech.sg.view.interfaces.telas_funcoes.inicio.TelaInicio;
import br.com.marttech.sg.view.interfaces.telas_funcoes.meus_dados.TelaMeusDados;
import br.com.marttech.sg.view.interfaces.telas_funcoes.minha_conta.TelaMinhaConta;
import br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.telas.TelaUsuarios;
import br.com.marttech.sg.view.libs.PermissaoFront;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class TelaSistema extends GridPane{
	
	private Menu menu;
	private StackPane conteudo;
	
	private TelaInicio telaInicio;
	private TelaMeusDados telaMeusDados;
	private TelaMinhaConta telaMinhaConta;
	private TelaCadastro telaCadastro;
	public  TelaUsuarios telaUsuarios;
	
	private ArrayList<TelaSystem> telas = new ArrayList<>();
	
	private PermissaoFront permissao = PermissaoFront.GERENCIADOR_TURMA;
	
	public TelaSistema(PermissaoFront permissaoFront) {
		this.permissao = permissaoFront;
		menu = new Menu(this.permissao);
		
		setAlignment(Pos.TOP_LEFT);
		construirPaginasConteudo();
		
		getColumnConstraints().addAll(coluna(307), coluna(1600));
		getRowConstraints().addAll(linha(), linha(), linha(), linha(), linha(),
				linha(), linha());
		
		add(menu, 0, 0, 1, 7);
		add(conteudo, 1, 0, 1, 7);
		
		setMinHeight(700);
		setMinWidth(1100);
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
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
	
	private RowConstraints linha() {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(162);
		rc.setPercentHeight(-1);
		rc.setVgrow(Priority.ALWAYS);
		rc.setFillHeight(true);
		return rc;
	}
	
	
	private int buscarTela(Object componente) {
		return conteudo.getChildren().indexOf(componente);
	}
	
	private void construirPaginasConteudo() {
		conteudo = new StackPane();
		conteudo.setPrefHeight(1080);
		conteudo.setPrefWidth(1800);
		conteudo.setMaxHeight(USE_COMPUTED_SIZE);
		conteudo.setMaxWidth(USE_COMPUTED_SIZE);
		
		configurarTelas();
		conteudo.getChildren().get(buscarTela(telaInicio)).toFront();
		
	}
	
	/*----------------------configuracao das telas------------------------*/
	
	private void configurarTelas() {
		switch (permissao) {
			case ADMINISTRADOR_GERAL:
				configurarTelaAdmGeral();
				break;
			case ADMINISTRADOR:
				configurarTelaAdm();
				break;
			case GERENCIADOR_TURMA:
				configurarTelaGerenciadorTurma();
				break;
			default:
				configurarTelaUsuario();
		}
	}
	
	private void configurarTelaAdmGeral() {
		configurarMenuAdmGeral();
		addTelaInicio();
		addTelaMeusDados();
		addTelaMinhaConta();
		addTelaCadastro();
		addTelaUsuarios();
	}
	
	private void configurarTelaAdm() {
		configurarMenuAdm();
		addTelaInicio();
		addTelaMeusDados();
		telaMeusDados.disableEdition();
		addTelaMinhaConta();
		addTelaCadastro();
		addTelaUsuarios();
	}
	
	private void configurarTelaGerenciadorTurma() {
		configurarMenuGerenciadorTurma();
		addTelaInicio();
		addTelaMeusDados();
		telaMeusDados.disableEdition();
		addTelaMinhaConta();
	}
	
	private void configurarTelaUsuario() {
		configurarMenuUsuario();
		addTelaInicio();
		addTelaMeusDados();
		telaMeusDados.disableEdition();
		addTelaMinhaConta();
	}
	
	private void addTelaInicio() {
		if(telaInicio == null) {
			telaInicio = new TelaInicio();
			conteudo.getChildren().add(telaInicio);
			telas.add(telaInicio);
		}
	}
	
	private void addTelaMeusDados() {
		if(telaMeusDados == null) {
			telaMeusDados = new TelaMeusDados();
			conteudo.getChildren().add(telaMeusDados);
			telas.add(telaMeusDados);
		}
	}
	
	private void addTelaMinhaConta() {
		if(telaMinhaConta == null) {
			telaMinhaConta = new TelaMinhaConta();
			conteudo.getChildren().add(telaMinhaConta);
			telas.add(telaMinhaConta);
		}
	}
	
	private void addTelaCadastro() {
		if(telaCadastro == null) {
			telaCadastro = new TelaCadastro(permissao);
			conteudo.getChildren().add(telaCadastro);
			telas.add(telaCadastro);
		}
	}
	
	private void addTelaUsuarios() {
		if(telaUsuarios == null) {
			telaUsuarios = new TelaUsuarios();
			conteudo.getChildren().add(telaUsuarios);
			telas.add(telaUsuarios);
		}
	}
	
	/*----------------------configuracao do menu------------------------*/
	
	private void configurarMenuAdmGeral() {
		addActionBotaoInicio();
		addActionBotaoMeusDados();
		addActionBotaoMinhaConta();
		addActionBotaoCadastrar();
		addActionBotaoUsuarios();
		addActionBotaoSair();
	}
	
	private void configurarMenuAdm() {
		addActionBotaoInicio();
		addActionBotaoMeusDados();
		addActionBotaoMinhaConta();
		addActionBotaoCadastrar();
		addActionBotaoUsuarios();
		addActionBotaoSair();
	}
	
	private void configurarMenuGerenciadorTurma() {
		addActionBotaoInicio();
		addActionBotaoMeusDados();
		addActionBotaoMinhaConta();
		addActionBotaoSair();
	}
	
	private void configurarMenuUsuario() {
		addActionBotaoInicio();
		addActionBotaoMeusDados();
		addActionBotaoMinhaConta();
		addActionBotaoSair();
	}
	
	private void addActionBotaoInicio() {
		BotaoMenu botaoInicio = menu.getBotaoInicio();
		botaoInicio.setOnAction(e -> {
			conteudo.getChildren().get(buscarTela(telaInicio)).toFront(); 
		});
	}
	
	private void addActionBotaoMeusDados() {
		BotaoMenu botaoMeusDados = menu.getBotaoMeusDados();
		botaoMeusDados.setOnAction(e -> {
			conteudo.getChildren().get(buscarTela(telaMeusDados)).toFront(); 
		});
	}
	
	private void addActionBotaoMinhaConta() {
		BotaoMenu botaoMinhaConta = menu.getBotaoConta();
		botaoMinhaConta.setOnAction(e -> {
			conteudo.getChildren().get(buscarTela(telaMinhaConta)).toFront();
		});
	}
	
	private void addActionBotaoCadastrar() {
		BotaoMenu botaoCadastro = menu.getBotaoCadastrar();
		botaoCadastro.setOnAction(e -> {
			conteudo.getChildren().get(buscarTela(telaCadastro)).toFront();
		});
	}
	
	private void addActionBotaoUsuarios() {
		BotaoMenu botaoUsuarios = menu.getBotaoUsuarios();
		botaoUsuarios.setOnAction(e -> {
			System.out.println(buscarTela(telaUsuarios)+ " "+ telaUsuarios == null? "nullo": "Settado");
			conteudo.getChildren().get(buscarTela(telaUsuarios)).toFront();
		});
	}
	
	private void addActionBotaoSair() {
		BotaoMenu botaoSair = menu.getBotaoSair();
		botaoSair.setOnAction(e -> App.reset());
	}
	
	public void reset() {
		if(telaUsuarios != null) {
			telaUsuarios.reset();
		}
	}
	
	public void reload() {
		Thread t = new Thread(() ->{
			try {
				Platform.runLater(() -> {
					menu.reload();
					telas.stream().forEach(tela -> tela.reload());
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		t.setPriority(10);
		t.start();
	}
}
