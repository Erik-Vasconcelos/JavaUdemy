package br.com.marttech.sg.view.interfaces.telas_funcoes.cadastro;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import org.controlsfx.control.Notifications;

import br.com.marttech.sg.controller.CadastroController;
import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.model.infra.ConfirmacaoCadastro;
import br.com.marttech.sg.view.interfaces.telas_funcoes.TelaSystem;
import br.com.marttech.sg.view.libs.CurrencyField;
import br.com.marttech.sg.view.libs.MaskedTextField;
import br.com.marttech.sg.view.libs.PermissaoFront;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TelaCadastro extends GridPane implements TelaSystem{
	
	private Circle imagemUsuario;
	private String caminhoImagem;
	private Label titulo;
	private Label lNome;
	private Label lCpf;
	private Label lEmail;
	private Label lFuncao;
	private Label lPermissao;
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
	private Button botaoCadastar;
	private Button botaoSelecionarImagem;
	
	List<TextField> camposTexto = new ArrayList<>();
	List<MaskedTextField> camposFormatados = new ArrayList<>();
	List<ComboBox<String>> campoSelecao = new ArrayList<>();
	
	public TelaCadastro(PermissaoFront permissaoFront) {
		setHgap(20);
		getColumnConstraints().addAll(coluna(), coluna(), coluna(), coluna(HPos.CENTER));
		getRowConstraints().addAll(linha(97), linhaLabel(), linha(), linhaLabel(), linha(), 
				linha(86, VPos.BOTTOM), linhaLabel(), linha(), linhaLabel(), linha(), linhaLabel(),linha(), linha(86, VPos.BOTTOM),
				linhaLabel(), linha(), linha());
		String css = getClass().getResource("Cadastro.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Tela");
		setAlignment(Pos.CENTER);
		setPadding(new Insets(30));
		
		setMaxWidth(USE_COMPUTED_SIZE);
		setMaxHeight(USE_COMPUTED_SIZE);
		
		construirComponentes(permissaoFront);
		
		add(titulo, 0, 0, 2, 1);
		add(lNome, 0, 1);
		add(campoNome, 0, 2);
		
		add(lCpf,1, 1);
		add(campoCpf, 1, 2);
		
		add(lEmail, 0, 3);
		add(campoEmail, 0, 4);
		
		add(lFuncao, 1, 3);
		add(campoFuncao, 1, 4);
		
		add(lPermissao, 2, 3);
		add(campoPermissao, 2, 4);
		
		add(lSalario, 2, 1);
		add(campoSalario, 2, 2);
			
		add(lEndereco, 0, 5, 2, 1);
		add(lRua, 0, 6);
		add(campoRua, 0, 7);
		
		add(lBairro, 1, 6);
		add(campoBairro, 1, 7);
		
		add(lNumero, 0, 8);
		add(campoNumero, 0, 9);
		
		add(lCidade, 1, 8);
		add(campoCidade, 1, 9);
		
		add(lEstado, 0, 10);
		add(campoEstado, 0, 11);
		
		add(lTelefones, 0, 12, 2, 1);
		add(lTelefone, 0, 13);
		add(campoTelefone, 0, 14);
		
		add(lTipo, 1, 13);
		add(campoTipoTelefone, 1, 14);
		
		add(botaoCadastar, 0, 16);
		
		add(imagemUsuario, 3, 0, 1, 7);
		add(botaoSelecionarImagem, 3, 8);
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
		rc.setPrefHeight(43);
		rc.setPercentHeight(-1);
		rc.setFillHeight(true);
		return rc;
	}
	
	private ColumnConstraints coluna(HPos posicao) {
		ColumnConstraints cc = coluna();
		cc.setHalignment(posicao);
		return cc;
	}
	
	private RowConstraints linha(double tamanho) {
		RowConstraints rc = linha();
		rc.setPrefHeight(tamanho);
		return rc;
	}
	
	private RowConstraints linha(double tamanho, VPos posicao ) {
		RowConstraints rc = linha(tamanho);
		rc.setValignment(posicao);
		return rc;
	}
	
	private RowConstraints linhaLabel() {
		RowConstraints rc = linha();
		rc.setValignment(VPos.BOTTOM);
		return rc;
	}
	
	private void construirComponentes(PermissaoFront permissaoFront) {
		titulo = new Label("Cadastrar Usuario");
		lNome = new Label("Nome:");
		lCpf = new Label("CPF:");
		lEmail = new Label("Email:");
		lFuncao = new Label("Funcão:");
		lPermissao = new Label("Permissão: ");
		lSalario = new Label("Salário:");
		lEndereco = new Label("Cadastro de Endereço");
		lRua = new Label("Rua:");
		lBairro = new Label("Bairro:");
		lNumero = new Label("Numero:");
		lCidade = new Label("Cidade:");
		lEstado = new Label("Estado:");
		lTelefones = new Label("Cadastro de Telefones:");
		lTelefone = new Label("Telefone:");
		lTipo = new Label("Tipo do telefone:");
		campoNome = new TextField();
		campoCpf = new MaskedTextField();
		campoEmail = new TextField();
		campoFuncao = new ComboBox<>();
		campoPermissao = new ComboBox<>();
		campoSalario = new CurrencyField(new Locale("pt", "BR"));
		campoRua = new TextField();
		campoBairro = new TextField();
		campoNumero = new TextField();
		campoCidade = new TextField();
		campoEstado = new ComboBox<>();
		campoTelefone = new MaskedTextField();
		campoTipoTelefone = new ComboBox<>();
		botaoCadastar = new Button("Cadastrar");
		botaoSelecionarImagem = new Button("Selecionar imagem");
		imagemUsuario = new Circle(280, 280, 140);
		imagemUsuario.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("imagens/imgUsuario.png"))));
		
		titulo.getStyleClass().add("Texto-titulo");
		lNome.getStyleClass().add("Texto-form");
		lCpf.getStyleClass().add("Texto-form");
		lEmail.getStyleClass().add("Texto-form");
		lFuncao.getStyleClass().add("Texto-form");
		lPermissao.getStyleClass().add("Texto-form");
		lSalario.getStyleClass().add("Texto-form");
		lEndereco.getStyleClass().add("Texto-form-titulo");
		lRua.getStyleClass().add("Texto-form");
		lBairro.getStyleClass().add("Texto-form");
		lNumero.getStyleClass().add("Texto-form");
		lCidade.getStyleClass().add("Texto-form");
		lEstado.getStyleClass().add("Texto-form");
		lTelefones.getStyleClass().add("Texto-form-titulo");
		lTelefone.getStyleClass().add("Texto-form");
		lTipo.getStyleClass().add("Texto-form");
		
		campoNome.getStyleClass().add("Campo-form");
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
		botaoCadastar.getStyleClass().add("Botao-form");
		botaoSelecionarImagem.getStyleClass().add("Botao-Selecionar-Imagem");
		
		campoFuncao.getItems().addAll(Arrays.asList("PROFESSOR"));
		configurarItensCadastroPermissao(permissaoFront);
		
		campoEstado.getItems().addAll(Arrays.asList("RN", "PB", "PE", "CE", "MA", "PI"));
		
		campoTipoTelefone.getItems().addAll(Arrays.asList("CEL", "RES"));
		
		settarMascarasCampos();
		adicionarAcoes();
		preencherListas();
	}
	
	private void preencherListas() {
		camposTexto.addAll(Arrays.asList(campoNome, campoSalario, campoEmail, campoRua,
				campoBairro, campoCidade, campoNumero));
		
		camposFormatados.addAll(Arrays.asList(campoCpf, campoTelefone));
		
		campoSelecao.addAll(Arrays.asList(campoFuncao, campoPermissao, campoEstado, 
				campoTipoTelefone));
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
	
	private void adicionarAcoes() {
		botaoCadastar.setOnAction(e -> cadastrar());
		botaoSelecionarImagem.setOnAction(e -> {
			buscarImagem();
		});
	}
	
	private void buscarImagem() {
		FileChooser seletorArquivos = new FileChooser();
		seletorArquivos.setTitle("Selecione uma imagem");
		seletorArquivos.getExtensionFilters().add(
				new ExtensionFilter("Imagens", Arrays.asList("*.jpeg", "*.jpg", "*.png", "*.jfif")));
		
		File imagem = seletorArquivos.showOpenDialog(new Stage());
		
		if(imagem != null) {
			String caminho = "file:///" + imagem.getAbsolutePath();
			imagemUsuario.setFill(new ImagePattern(new Image(caminho)));
			caminhoImagem = imagem.getAbsolutePath();
		}
	}
	
	private boolean verificarCampos() {
		Predicate<TextField> isBlackTextField = c -> c.getText().trim().isBlank();
		Predicate<MaskedTextField> isBlackFormatterField = cf -> cf.getPlainText().isBlank();
		
		boolean camposTextoValidos = camposTexto.stream()
				.noneMatch(c -> isBlackTextField.test(c));
		
		boolean camposFormatadosValido = camposFormatados.stream()
				.noneMatch(cf -> isBlackFormatterField.test(cf));
		
		boolean camposSelecaoValidos = campoSelecao.stream()
				.noneMatch(cs -> cs.getValue() == null);
		
		boolean campoSalarioValido = campoSalario.getAmount() > 0.0;
		
		if (camposTextoValidos && camposFormatadosValido && campoSalarioValido &&camposSelecaoValidos) {
			return true;
			
		}else {
			
			if(!campoSalarioValido) {
				campoSalario.setOnKeyReleased(e -> removerEstiloErro(campoSalario));
				campoSalario.getStyleClass().add("Campo-Form-Erro");
			}
			
			camposTexto.stream()
				.filter(c -> isBlackTextField.test(c))
				.map(c -> {
					//Adiciona a ação de remover o estilo de erro ao digitar no campo
					c.setOnKeyReleased(e -> removerEstiloErro(c));
					return c;
				})
				.forEach(c -> {
					c.getStyleClass().add("Campo-Form-Erro");
					c.setPromptText("Preencha este campo...");
				}
			);
			
			camposFormatados.stream()
				.filter(cf -> isBlackFormatterField.test(cf))
				.map(cf -> {
					cf.setOnKeyReleased(e -> removerEstiloErro(cf));
					return cf;
				})
				.forEach(cf -> {
					cf.getStyleClass().add("Campo-Form-Erro");
					cf.setPromptText("Preencha este campo...");
				}
			);
			
			campoSelecao.stream()
				.filter(cs -> cs.getValue() == null)
				.map(cs -> {
					cs.setOnAction(e -> {
						removerEstiloErro(cs);
					});
			
					return cs;
				})
				.forEach(cs -> {
					cs.getStyleClass().add("Campo-Form-Erro");
					cs.setPromptText("Selecione uma opção");
				}
			);
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private void removerEstiloErro(Object campo) {
		if(campo instanceof TextField) {
			((TextField) campo).getStyleClass().remove("Campo-Form-Erro");
		}else {
			((ComboBox<String>) campo).getStyleClass().remove("Campo-Form-Erro");
		}
	}
	
	private void configurarItensCadastroPermissao(PermissaoFront permissao) {
		switch (permissao) {
			case ADMINISTRADOR_GERAL: 
				campoPermissao.getItems().addAll(Arrays.asList("ADMINISTRADOR_GERAL", "ADMINISTRADOR", "GERENCIADOR_TURMA"));
				break;
			case ADMINISTRADOR:
				campoPermissao.getItems().addAll(Arrays.asList("GERENCIADOR_TURMA"));
				break;
			default:
				campoPermissao.getItems().addAll(Arrays.asList("GERENCIADOR_TURMA"));
		}
	}
	
	private void cadastrar() {
		boolean dadosValidos = verificarCampos();
		
		if (!dadosValidos) {
			Notifications.create()
				.text("Preencha os campos obrigatórios")
				.position(Pos.CENTER)
				.hideAfter(Duration.seconds(2))
				.showWarning();
			return;
		}
		
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
				tranferirParaByte(caminhoImagem)
			);
			
		ConfirmacaoCadastro confirmacao = CadastroController.cadastrar(servidor);
			
		Alert info = new Alert(AlertType.NONE);
			
		if(confirmacao.isCasdastado()) {
			String mensagem = String.format("Usuário cadastrado com sucesso!\n"
					+ "Matricula do usuário: %d\n"
					+ "Senha: %s", confirmacao.getMatricula(), "@EENSINO + Cpf do usuário sem pontuação\n"
							+ "Ex.: @EENSINO99999999999");
				
			limparCamposTexto();
			info.setAlertType(AlertType.CONFIRMATION);
			info.setHeaderText(mensagem);
			info.setTitle("Informação");
			info.showAndWait();
				
		}else {
			info.setAlertType(AlertType.ERROR);
			info.setHeaderText("Não foi possivel cadastar o usuário");
			info.setTitle("Informação");
			info.showAndWait();
		}
	}
	
	private byte[] tranferirParaByte(String caminho){
		try {
			if(caminho != null) {
				return Files.readAllBytes(new File(caminhoImagem).toPath());
				
			}else {
				return null;
			}
			
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	private void limparCamposTexto() {
		camposTexto.forEach(c -> c.clear());
		camposFormatados.forEach(cf -> cf.clear());
		campoSelecao.forEach(cs -> cs.setValue(""));
		campoSalario.setText("R$ 0,00");
		
		imagemUsuario.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("imagens/imgUsuario.png"))));
	}
	
	public void reload() {
		limparCamposTexto();
	}

}
