package br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.telas.grerenciamento;

import org.controlsfx.control.Notifications;

import br.com.marttech.sg.controller.AgrupadorController;
import br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.agrupador.AgrupadorUsuarios;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * @author erikv
 * @date 20:55:05 11 de nov. de 2022
 * 
 */

public class TelaGerenciamentoUsuarios extends GridPane {
	
	private Label tituloTela; 
	private Label lCampoBusca; 
	private TextField fieldSearch; 
	private Button searchButton; 
	private Button listAllButton; 
	private Button clearButton; 
	private static AgrupadorUsuarios usersGrouper;
	
	private static Label informacoesPaginacao;
	private static Label infoTotalUsuarios;
	private Button botaoAnterior;
	private Button botaoProximo;
	
	private HBox componetesPaginacao;
	private HBox agrupadorPesquisa;
	
	private Button utimoBotaoClicado;
	
	private boolean isFieldLimpo = true;
	
	private static EventHandler acaoBotaoUpdateAgrupadorContent;
	
	public TelaGerenciamentoUsuarios(EventHandler acaoBotaoUpdate) {
		this.acaoBotaoUpdateAgrupadorContent = acaoBotaoUpdate;
		
		setAlignment(Pos.CENTER);
		setVgap(10);
		setPadding(new Insets(30));
		String css = getClass().getResource("TelaGerenciamentoUsuarios.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Tela");
		
		configComponents();
		addComponents();
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
	}
	
	/*--------------------------Métodos estruturais------------------------------*/
	
	private ColumnConstraints coluna() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(960);
		cc.setPercentWidth(-1);
		cc.setHalignment(HPos.LEFT);
		cc.setHgrow(Priority.ALWAYS);
		cc.setFillWidth(true);
		return cc;
	}
	
	private ColumnConstraints coluna(HPos alinhamento) {
		ColumnConstraints cc = coluna();
		cc.setHalignment(alinhamento);
		return cc;
	}
	
	private RowConstraints linha() {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(40);
		rc.setPercentHeight(-1);
		rc.setValignment(VPos.CENTER);
		rc.setFillHeight(true);
		return rc;
	}
	
	private RowConstraints linha(int tamanho) {
		RowConstraints rc = linha();
		rc.setPrefHeight(tamanho);
		rc.setValignment(VPos.BOTTOM);
		rc.setFillHeight(true);
		return rc;
	}
	
	/*--------------------------Métodos de configuracão------------------------------*/
	
	private void configComponents() {
		getColumnConstraints().addAll(coluna(), coluna(HPos.RIGHT));
		getRowConstraints().addAll(linha(54), linha(), linha(), linha(), linha(),
				linha(), linha(), linha(500), linha());
		
		tituloTela = new Label("Usuarios");
		lCampoBusca = new Label("Nome:");
		fieldSearch = new TextField();
		searchButton = new Button("", new ImageView(new Image(getClass().getResourceAsStream("../../imagens/lupa.png"))));
		listAllButton = new Button("Listar todos");
		clearButton = new Button("", new ImageView(new Image(getClass().getResourceAsStream("../../imagens/cancelar.png"))));
		usersGrouper = new AgrupadorUsuarios(acaoBotaoUpdateAgrupadorContent);
		utimoBotaoClicado = new Button();
		infoTotalUsuarios = new Label();
		
		configComponentesPaginacao();
		configAgrupadorPesquisa();
		addActionToButtons();
		addActionsForKeys();
		addStyle();
	}
	
	private void addComponents() {
		add(tituloTela, 0, 0);
		add(lCampoBusca, 0, 2);
		add(agrupadorPesquisa, 0, 3);
		add(listAllButton, 0, 5);
		add(usersGrouper, 0, 7, 2, 1);
		add(componetesPaginacao, 0, 8, 2, 1);
		add(infoTotalUsuarios, 1, 8);
	}
	
	private void configAgrupadorPesquisa() {
		agrupadorPesquisa = new HBox();
		agrupadorPesquisa.setAlignment(Pos.CENTER_LEFT);
		agrupadorPesquisa.setSpacing(6);
		agrupadorPesquisa.getChildren().addAll(searchButton, fieldSearch, clearButton);
	}
	
	private void configComponentesPaginacao() {
		componetesPaginacao = new HBox();
		componetesPaginacao.setAlignment(Pos.CENTER);
		componetesPaginacao.setSpacing(10);
		
		botaoProximo = new Button("Proximo");
		botaoAnterior = new Button("Anterior");
		informacoesPaginacao = new Label();
		
		informacoesPaginacao.getStyleClass().add("Texto");
		
		atualizarInfoPaginacao();
		
		botaoProximo.setOnAction(e -> {
			proximaPagina();
		});
		
		botaoAnterior.setOnAction(e -> {
			paginaAnterior();
		});
		
		componetesPaginacao.getChildren().addAll(botaoAnterior, informacoesPaginacao, botaoProximo);
	}
	
	/*--------------------------Métodos de ativar acões por teclas------------------------------*/
	
	private void addActionsForKeys() {
		fieldSearch.setOnKeyPressed(e -> {
			
			if(e.getCode() != KeyCode.BACK_SPACE) {
				isFieldLimpo = false;
			}	
			
			if (e.getCode() == KeyCode.ENTER) {
				searchButton.fire();
					
			}else if(e.getCode() == KeyCode.BACK_SPACE && fieldSearch.getText().length() == 0) {
				if(!isFieldLimpo) {
					limparPesquisa();
					isFieldLimpo = true;
				}
				
			}else if(!fieldSearch.getText().trim().isEmpty()) {
				searchButton.fire();
			}
			
		});
	}
	
	/*--------------------------Métodos delegados------------------------------*/
	public static void reset() {
		usersGrouper.reset();
		infoTotalUsuarios.setText("");
		informacoesPaginacao.setText("Página 0 de 0");
	}
	
	public static void reload() {
		usersGrouper.recarregar();
		atualizarInfoPaginacaoStatic();
	}
	
	/*--------------------------Métodos de acões------------------------------*/
	
	private void addActionToButtons() {
		searchButton.setOnAction(e -> {
			if (validateSearchField()) {
				
				if(fieldSearch.getText().trim().length() > 2) {
					getUsuariosComParteNome();
					atualizarInfoPaginacao();
					utimoBotaoClicado = searchButton;
				}
				
			}else {
				Notifications.create()
					.position(Pos.TOP_CENTER)
					.text("Informe um valor válido!")
					.showError();
			}
		});
		
		clearButton.setOnAction(e -> {
			if(!fieldSearch.getText().isEmpty()) {
				clearField();
				usersGrouper.addTodosContents();
				atualizarInfoPaginacao();
				utimoBotaoClicado = new Button();
			}
		});
		
		listAllButton.setOnAction(e -> {
			if(AgrupadorController.getPagina() != 1 || AgrupadorController.getQtdTotalUsuarios() == 0) {
				clearField();
				usersGrouper.addTodosContents();
				atualizarInfoPaginacao();
				utimoBotaoClicado = listAllButton;
			}
		});
	}
	
	private void limparPesquisa() {
		clearField();
		usersGrouper.addTodosContents();
		atualizarInfoPaginacao();
		utimoBotaoClicado = new Button();
	}

	private void atualizarInfoPaginacao() {
		informacoesPaginacao.setText(usersGrouper.getInfoPaginas());
		infoTotalUsuarios.setText("Total: " + AgrupadorUsuarios.getTotalUsuarios() );
	}
	
	private static void atualizarInfoPaginacaoStatic() {
		informacoesPaginacao.setText(usersGrouper.getInfoPaginas());
		infoTotalUsuarios.setText("Total: " + AgrupadorUsuarios.getTotalUsuarios() );
	}
	
	private void proximaPagina() {
		if(searchButton.equals(utimoBotaoClicado)) {
			usersGrouper.addProximosContentsPaginadosPorFiltro();
			atualizarInfoPaginacao();
			
		}else {
			usersGrouper.addProximosContentsPaginados();
			atualizarInfoPaginacao();
		}
	}
	
	private void paginaAnterior() {
		if(searchButton.equals(utimoBotaoClicado)) {
			usersGrouper.addContentsAterioresPaginadosPorFiltro();
			atualizarInfoPaginacao();
			
		}else {
			usersGrouper.addContentsAterioresPaginados();
			atualizarInfoPaginacao();
		}
	}
	
	private void getUsuariosComParteNome() {
		if(!fieldSearch.getText().trim().isEmpty()) {
			usersGrouper.addContentsComParteNomeUsuario(fieldSearch.getText().trim());
		}
	}
	
	private boolean validateSearchField() {
		boolean condicao1 = !(fieldSearch.getText().trim().isBlank());
		
		if(condicao1) {
			return true;
		}
		
		return false;
	}
	
	private void clearField() {
		fieldSearch.setText("");
		atualizarInfoPaginacao();
	}
	/*--------------------------Métodos de estilos------------------------------*/
	
	private void addStyle() {
		tituloTela.getStyleClass().add("Titulo");
		lCampoBusca.getStyleClass().add("Texto");
		fieldSearch.getStyleClass().add("Campo");
		listAllButton.getStyleClass().add("Botao");
		searchButton.getStyleClass().add("Botao-Icone");
		clearButton.getStyleClass().add("Botao-Icone");
		agrupadorPesquisa.getStyleClass().add("Content-Pesquisa");
		infoTotalUsuarios.getStyleClass().add("Texto");
		
		botaoAnterior.getStyleClass().add("Botao-Paginacao");
		botaoProximo.getStyleClass().add("Botao-Paginacao");
	}

}
