package br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.telas.edit;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.controlsfx.control.Notifications;

import br.com.marttech.sg.controller.EditUsuarioController;
import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.model.memoria.UsuarioEditadoMemory;
import br.com.marttech.sg.view.libs.CurrencyField;
import br.com.marttech.sg.view.libs.MaskedTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class TelaEditUsuario extends GridPane{
	
	private Circle imagemUsuario;
	private String caminhoImagemUsuario;
	
	private Label titulo;
	private Label lNome;
	private Label lCpf;
	private Label lFuncao;
	private Label lPermissao;
	private Label lEmail;
	
	private Label lSalario;
	private Label lEndereco;
	private Label lRua;
	private Label lBairro;
	private Label lNumero;
	private Label lCidade;
	private Label lEstado;
	private Label lTelefones;
	private Label lTelefone;
	private Label lTipo;
	
	private TextField campoNome;
	private MaskedTextField campoCpf;
	private TextField campoEmail;
	private ComboBox<String> campoFuncao;
	private ComboBox<String> campoPermissao;
	private CurrencyField campoSalario;
	private TextField campoRua;
	private TextField campoBairro;
	private TextField campoNumero;
	private TextField campoCidade;
	private ComboBox<String> campoEstado;
	private MaskedTextField campoTelefone;
	private ComboBox<String> campoTipoTelefone;
	private Button botaoVoltar;
	private Button botaoSelecionarImagem;
	private Button botaoSalvar;
	private Button botaoUpdate;
	private Button botaoCancelar;
	private HBox agrupadorBotoes;
	
	List<TextField> camposTexto;
	List<ComboBox<String>> camposSelecao;
	
	public TelaEditUsuario() {
		setHgap(15);
		getColumnConstraints().addAll(coluna(100), coluna(), coluna(), coluna(), coluna(HPos.CENTER));
		getRowConstraints().addAll(linha(80), linhaLabel(), linha(), linhaLabel(), linha(), 
				linha(), linhaLabel(), linha(), linhaLabel(), linha(), linhaLabel(),linha(), linha(),
				linhaLabel(), linha(), linha());
		
		setPadding(new Insets(25));
		setAlignment(Pos.CENTER);
		String caminho = getClass().getResource("EditUsuario.css").toExternalForm();
		getStylesheets().add(caminho);
		getStyleClass().add("Tela");
		
		setMaxHeight(USE_COMPUTED_SIZE);
		setMaxWidth(USE_COMPUTED_SIZE);
		
		construirComponentes();
		carregarImagem();
		desabilitarCamposTexto();
		desabilitarCamposSelecao();
		
		add(botaoVoltar, 0, 0);
		
		add(titulo, 1, 0, 2, 1);
		add(lNome, 1, 1);
		add(campoNome, 1, 2);
		
		add(lCpf,2, 1);
		add(campoCpf, 2, 2);
		
		add(lEmail, 1, 3);
		add(campoEmail, 1, 4);
		
		add(lFuncao, 2, 3);
		add(campoFuncao, 2, 4);
		
		add(lSalario, 3, 1);
		add(campoSalario, 3, 2);
			
		add(lPermissao, 3, 3);
		add(campoPermissao, 3, 4);
		
		add(lEndereco, 1, 5, 2, 1);
		add(lRua, 1, 6);
		add(campoRua, 1, 7);
		
		add(lBairro, 2, 6);
		add(campoBairro, 2, 7);
		
		add(lNumero, 1, 8);
		add(campoNumero, 1, 9);
		
		add(lCidade, 2, 8);
		add(campoCidade, 2, 9);
		
		add(lEstado, 1, 10);
		add(campoEstado, 1, 11);
		
		add(lTelefones, 1, 12, 2, 1);
		add(lTelefone, 1, 13);
		add(campoTelefone, 1, 14);
		
		add(lTipo, 2, 13);
		add(campoTipoTelefone, 2, 14);
		
		add(imagemUsuario, 4, 0, 1, 6);
		add(botaoSelecionarImagem, 4, 7);
		add(botaoUpdate, 4, 8);
		
		add(agrupadorBotoes, 1, 16);
	}
	
	/*------------------------Métodos de regras do GridPane-------------------------*/
	
	private ColumnConstraints coluna() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setMinWidth(USE_COMPUTED_SIZE);
		cc.setMaxWidth(USE_COMPUTED_SIZE);
		cc.setPrefWidth(460);
		cc.setPercentWidth(-1);
		cc.setHalignment(HPos.LEFT);
		cc.setHgrow(Priority.ALWAYS);
		cc.setFillWidth(true);
		return cc;
	}
	
	private ColumnConstraints coluna(double tamanho) {
		ColumnConstraints cc = coluna();
		cc.setPrefWidth(tamanho);
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
		return rc;
	}
	
	private RowConstraints linhaLabel() {
		RowConstraints rc = linha();
		rc.setValignment(VPos.BOTTOM);
		return rc;
	}
	
	/*------------------------Init components-------------------------*/
	
	private void construirComponentes() {
		titulo = new Label("Editar Dados");
		lNome = new Label("Nome:");
		lCpf = new Label("CPF:");
		lFuncao = new Label("Função:");
		lPermissao = new Label("Permissão:");
		lEmail = new Label("Email:");
		lSalario = new Label("Salário:");
		lEndereco = new Label("Endereço");
		lRua = new Label("Rua:");
		lBairro = new Label("Bairro:");
		lNumero = new Label("Numero:");
		lCidade = new Label("Cidade:");
		lEstado = new Label("Estado:");
		lTelefones = new Label("Telefones:");
		lTelefone = new Label("Telefone:");
		lTipo = new Label("Tipo do telefone:");
		campoNome = new TextField();
		campoCpf = new MaskedTextField();
		campoFuncao = new ComboBox<>();
		campoPermissao = new ComboBox<String>();
		campoEmail = new TextField();
		campoSalario = new CurrencyField(new Locale("pt", "BR"));
		campoRua = new TextField();
		campoBairro = new TextField();
		campoNumero = new TextField();
		campoCidade = new TextField();
		campoEstado = new ComboBox<>();
		campoTelefone = new MaskedTextField();
		campoTipoTelefone = new ComboBox<>();
		botaoVoltar = new Button("", new ImageView(new Image(getClass().getResourceAsStream("../../imagens/retorna.png"))));
		botaoSelecionarImagem = new Button("Selecionar uma imagem");
		botaoSalvar = new Button("Salvar");
		botaoUpdate = new Button("Editar");
		botaoCancelar = new Button("Cancelar");
		
		titulo.getStyleClass().add("Texto-titulo");
		lNome.getStyleClass().add("Texto-form");
		lCpf.getStyleClass().add("Texto-form");
		lEmail.getStyleClass().add("Texto-form");
		lFuncao.getStyleClass().add("Texto-form");
		lPermissao.getStyleClass().add("Texto-form");
		lSalario.getStyleClass().add("Texto-form");
		lEndereco.getStyleClass().add("Sub-titulo");
		lRua.getStyleClass().add("Texto-form");
		lBairro.getStyleClass().add("Texto-form");
		lNumero.getStyleClass().add("Texto-form");
		lCidade.getStyleClass().add("Texto-form");
		lEstado.getStyleClass().add("Texto-form");
		lTelefones.getStyleClass().add("Sub-titulo");
		lTelefone.getStyleClass().add("Texto-form");
		lTipo.getStyleClass().add("Texto-form");
		
		campoNome.getStyleClass().addAll("Campo-form");
		campoCpf.getStyleClass().add("Campo-form");
		campoEmail.getStyleClass().add("Campo-form");
		campoFuncao.getStyleClass().add("Campo-form");
		campoPermissao.getStyleClass().add("Campo-form");
		campoSalario.getStyleClass().add("Campo-form");
		campoRua.getStyleClass().add("Campo-form");
		campoBairro.getStyleClass().add("Campo-form");
		campoNumero.getStyleClass().add("Campo-form");
		campoCidade.getStyleClass().add("Campo-form");
		campoEstado.getStyleClass().add("Campo-form");
		campoTelefone.getStyleClass().add("Campo-form");
		campoTipoTelefone.getStyleClass().add("Campo-form");
		botaoVoltar.getStyleClass().add("Botao-Voltar");
		botaoUpdate.getStyleClass().addAll("Botao", "Botao-padrao");
		botaoCancelar.getStyleClass().addAll("Botao", "Botao-cancelar");
		botaoSalvar.getStyleClass().addAll("Botao", "Botao-padrao");
		botaoSelecionarImagem.getStyleClass().add("Botao-Selecionar-Imagem");
		
		configAgrupador();
		
		adicionarCamposTexto();
		adicionarCamposSelecao();
		adicionarItensComboBox();
		settarMascarasCampos();
		
		habilitarAcoesBotoes();
		
		desabilitarBotaoSalvar();
		desabilitarBotaoCancelar();
		desabilitarBotaoSelecionarImagem();
	}
	
	/*------------------------Métodos Estruturais-------------------------*/
	
	private void habilitarAcoesBotoes() {
		botaoUpdate.setOnAction(e -> {
			habilitarCamposTexto();
			habilitarCamposSelecao();
			habilitarBotaoSalvar();
			habilitarBotaoSelecionarImagem();
			habilitarBotaoCancelar();
			habilitarEstiloEmEdicaoCampoTexto();
			habilitarEstiloEmEdicaoCampoSelecao();
			desabilitarBotaoUpdate();
		});
		
		botaoCancelar.setOnAction(e -> {
			desabilitarCamposSelecao();
			desabilitarCamposTexto();
			desabilitarBotaoSalvar();
			desabilitarBotaoSelecionarImagem();
			desabilitarBotaoCancelar();
			desabilitarEstiloEdicaoCampoTexto();
			desabilitarEstiloEmEdicaoCampoSelecao();
			habilitarBotaoUpdate();
		});
		
		botaoSalvar.setOnAction(e -> {
			salvarDados();
			desabilitarCamposSelecao();
			desabilitarCamposTexto();
			desabilitarBotaoSalvar();
			desabilitarBotaoSelecionarImagem();
			desabilitarBotaoCancelar();
			desabilitarEstiloEdicaoCampoTexto();
			desabilitarEstiloEmEdicaoCampoSelecao();
			habilitarBotaoUpdate();
		});
		
		botaoSelecionarImagem.setOnAction(e -> {
			buscarImagem();
		});
	}
	
	private void adicionarItensComboBox() {
		campoFuncao.getItems().addAll(Arrays.asList("PROFESSOR"));
		campoPermissao.getItems().addAll(Arrays.asList("ADMINISTRADOR_GERAL", 
				"ADMINISTRADOR", "GERENCIADOR_TURMA"));
		campoEstado.getItems().addAll(Arrays.asList("RN", "PB", "PE", "CE", "MA", "PI"));
		campoTipoTelefone.getItems().addAll(Arrays.asList("CEL", "RES"));
	}
	
	private void adicionarCamposTexto() {
		camposTexto = new ArrayList<>(Arrays.asList(campoNome,
				campoCpf,
				campoEmail,
				campoSalario,
				campoRua,
				campoBairro,
				campoNumero,
				campoCidade,
				campoTelefone)
		);
	}
	
	private void adicionarCamposSelecao() {
		camposSelecao = new ArrayList<>(Arrays.asList(
				campoFuncao,
				campoPermissao,
				campoEstado,
				campoTipoTelefone));
	}
	
	private void buscarImagem() {
		FileChooser seletorArquivos = new FileChooser();
		seletorArquivos.setTitle("Selecione uma imagem");
		seletorArquivos.getExtensionFilters().add(
				new ExtensionFilter("Imagens", Arrays.asList("*.jpeg", "*.jpg", "*.png")));
		
		File imagem = seletorArquivos.showOpenDialog(new Stage());
		
		if(imagem != null) {
			//Caminho absoluto da imagem
			// file:/// diz para o java que isso é um arquivo mesmo
			String caminho = "file:///" + imagem.getAbsolutePath();

			imagemUsuario.setFill(new ImagePattern(new Image(caminho)));
			caminhoImagemUsuario = imagem.getAbsolutePath();
		}
	}
	
	private void carregarImagem() {
		Image img = new Image(getClass().getResourceAsStream("../../imagens/imgUsuario.png"));
		imagemUsuario = new Circle(290, 290, 145);
		imagemUsuario.setFill(new ImagePattern(img));
	}
	
	private void configAgrupador() {
		agrupadorBotoes = new HBox();
		agrupadorBotoes.setAlignment(Pos.CENTER_LEFT);
		agrupadorBotoes.setSpacing(15);
		agrupadorBotoes.getChildren().addAll(botaoSalvar, botaoCancelar);
	}
	
	private void settarMascarasCampos() {
		setMascaraCpf();
		setMascaraTelefone();
	}
	
	private void setMascaraCpf() {
		campoCpf.setMask("###.###.###-##");
	}
	
	private void setMascaraTelefone() {
		campoTelefone.setMask("(###)#####-####");
	}
	
	/*----------------Métodos de habilitar/desabilitar campos de edicao--------------------*/
	
	private void habilitarCamposTexto() {
		camposTexto.forEach(c -> {
			c.setEditable(true);
			c.setDisable(false);
		});
		habilitarEstiloEmEdicaoCampoTexto();
	}
	
	private void habilitarCamposSelecao() {
		camposTexto.forEach(c -> {
			c.setEditable(true);
			c.setDisable(false);
		});
		habilitarEstiloEmEdicaoCampoSelecao();
	}
	
	private void desabilitarCamposTexto() {
		camposTexto.forEach(c -> {
			c.setEditable(false);
			c.setDisable(true);
		});
		setarDados();
		desabilitarEstiloEdicaoCampoTexto();
	}
	
	private void desabilitarCamposSelecao() {
		camposSelecao.forEach(c -> {
			//TODO - Atualizar/completar funcao
			c.setEditable(false);
		});
		desabilitarEstiloEmEdicaoCampoSelecao();
	}
	
	/*---------------------------Método de reset-------------------------------*/
	
	private void resetDados() {
		camposTexto.forEach(e -> {
			e.setText("");
		});
		camposSelecao.forEach(e -> {
			e.setValue("");
		});
	}
	
	/*-------------------Métodos habilitar/desabilitar estilo em campos---------------------*/
	
	private void habilitarEstiloEmEdicaoCampoTexto() {
		camposTexto.forEach(c -> {
			if(c.getStyleClass().contains("Campo-form-edicao")) {
				return;
			} 
			c.getStyleClass().add("Campo-form-edicao");
		});
	}
	
	private void habilitarEstiloEmEdicaoCampoSelecao() {
		camposSelecao.forEach(c -> {
			if(c.getStyleClass().contains("Campo-form-edicao")) {
				return;
			} 
			c.getStyleClass().add("Campo-form-edicao");
		});
	}
	
	private void desabilitarEstiloEdicaoCampoTexto() {
		camposTexto.forEach(c -> {
			c.getStyleClass().remove("Campo-form-edicao");
		});
	}
	
	private void desabilitarEstiloEmEdicaoCampoSelecao() {
		camposSelecao.forEach(c -> {
			c.getStyleClass().remove("Campo-form-edicao");
		});
	}
	
	/*-----------------Habilitar/desabilitar componentes-----------------------*/
	private void habilitarBotaoUpdate() {
		botaoUpdate.setVisible(true);
	}
	
	private void desabilitarBotaoUpdate() {
		botaoUpdate.setVisible(false);
	}
	
	private void habilitarBotaoSalvar() {
		botaoSalvar.setVisible(true);
	}
	
	private void desabilitarBotaoSalvar() {
		botaoSalvar.setVisible(false);
	}
	
	private void habilitarBotaoCancelar() {
		botaoCancelar.setVisible(true);
	}
	
	private void desabilitarBotaoCancelar() {
		botaoCancelar.setVisible(false);
	}
	
	private void habilitarBotaoSelecionarImagem() {
		botaoSelecionarImagem.setVisible(true);
	}
	
	private void desabilitarBotaoSelecionarImagem() {
		botaoSelecionarImagem.setVisible(false);
	}
	
	/*-----------------Acesso ao Controller-----------------------*/

	private void setarDados() {
		resetDados();
		ServidorDTO servidor = EditUsuarioController.getDados();
		campoNome.setText(servidor.getNome());
		campoCpf.setPlainText(servidor.getCpf());
		campoEmail.setText(servidor.getEmail());
		campoSalario.setText(servidor.getSalario().toString());
		campoFuncao.getSelectionModel().select(servidor.getCargo().toString());
		campoPermissao.getSelectionModel().select(servidor.getPermissao().toString());
		
		campoRua.setText(servidor.getRua());
		campoBairro.setText(servidor.getBairro());
		campoNumero.setText(servidor.getNumero());
		campoCidade.setText(servidor.getCidade());
		campoEstado.setValue(servidor.getEstado());
		
		campoTelefone.setPlainText(servidor.getTelefone());
		campoTipoTelefone.setValue(servidor.getTipoTelefone());
		
		if(servidor.getImagem() != null) {
			InputStream inputStream = new ByteArrayInputStream(servidor.getImagem());
			imagemUsuario.setFill(new ImagePattern(new Image(inputStream)));
		}
	}
	
	private void salvarDados() {
		ServidorDTO servidor = new ServidorDTO(
				campoNome.getText(),
				campoCpf.getPlainText(),
				campoEmail.getText(),
				campoFuncao.getValue(),
				campoPermissao.getValue(),
				campoSalario.getAmount().toString(),
				campoTelefone.getPlainText(),
				campoTipoTelefone.getValue(),
				campoRua.getText(),
				campoBairro.getText(),
				campoCidade.getText(),
				campoNumero.getText(),
				campoEstado.getValue(),
				tranferirParaByte(caminhoImagemUsuario)
			);
		
		boolean idSalvo = EditUsuarioController.salvarUsuario(servidor);
		
		if(idSalvo) {
			Notifications.create()
				.text("Usuario atualizado com sucesso!")
				.position(Pos.TOP_CENTER)
				.showInformation();
		}else {
			Notifications.create()
				.text("Não foi possivel atualizar o usuário!")
				.position(Pos.TOP_CENTER)
				.showWarning();
		}
	}
	
	private byte[] tranferirParaByte(String caminho){
		try {
			if(caminho != null) {
				return Files.readAllBytes(new File(caminhoImagemUsuario).toPath());
				
			}else {
				return UsuarioEditadoMemory.getInstance().getImagem();
			}
			
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	public void reload() {
		resetDados();
		imagemUsuario = null;
	}

	public Button getBotaoVoltar() {
		return botaoVoltar;
	}
	
}
