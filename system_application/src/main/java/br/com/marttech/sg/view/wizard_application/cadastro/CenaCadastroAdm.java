package br.com.marttech.sg.view.wizard_application.cadastro;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.view.libs.CurrencyField;
import br.com.marttech.sg.view.libs.MaskedTextField;
import br.com.marttech.sg.view.wizard_application.WizardStartApplication;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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

public class CenaCadastroAdm extends GridPane{
	
	private String caminhoImagem;
	
	private Label titulo;
	private Label lNome;
	private Label lCpf;
	private Label lEmail;
	private Label lPermissao;
	private Label lFuncao;
	private Label lSalario;
	
	private TextField campoNome;
	private MaskedTextField campoCpf;
	private TextField campoEmail;
	private CurrencyField campoSalario;
	private ComboBox<String> campoPermissao;
	private ComboBox<String> campoFuncao;
	
	private Circle imagemUsuario;
	
	private Button botaoSelecionarImagem;
	private Button botaoProximo;
	private Button botaoAnterior;
	private HBox rodape;
	
	List<TextField> camposTexto = new ArrayList<>();
	
	public CenaCadastroAdm() {
		setHgap(20);
		getColumnConstraints().addAll(coluna(30), coluna(), coluna(), coluna(HPos.CENTER));
		getRowConstraints().addAll(linha(40, VPos.CENTER), linhaLabel(), linha(), linhaLabel(), linha(), 
				 linhaLabel(),linha(), linha(Priority.ALWAYS), linha(70, VPos.BOTTOM));
		setAlignment(Pos.CENTER);
		
		String css = getClass().getResource("Cadastro.css").toExternalForm();
		getStylesheets().add(css);
		
		construirComponentes();
		
		setMaxWidth(USE_COMPUTED_SIZE);
		setMaxHeight(USE_COMPUTED_SIZE);
		
		add(titulo, 1, 0, 2, 1);
		add(lNome, 1, 1);
		add(campoNome, 1, 2);
		
		add(lCpf,2, 1);
		add(campoCpf, 2, 2);
		
		add(lSalario, 1, 3);
		add(campoSalario, 1, 4);
		
		add(lEmail, 2, 3);
		add(campoEmail, 2, 4);
		
		add(lFuncao, 1, 5);
		add(campoFuncao, 1, 6);
		
		add(lPermissao, 2, 5);
		add(campoPermissao, 2, 6);
		
		add(imagemUsuario, 3, 1, 1, 4);
		add(botaoSelecionarImagem, 3, 6);
		
		add(rodape, 0, 10, 4, 1);
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
	
	private ColumnConstraints coluna(double tamanho) {
		ColumnConstraints cc = coluna();
		cc.setPrefWidth(tamanho);
		return cc;
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
	
	private RowConstraints linha(Priority prioridade) {
		RowConstraints rc = linha();
		rc.setVgrow(prioridade);
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
		rc.setPrefHeight(25);
		return rc;
	}
	
	private void construirComponentes() {
		titulo = new Label("Cadastro Do Administrador");
		lNome = new Label("Nome:");
		lCpf = new Label("CPF:");
		lEmail = new Label("Email:");
		lPermissao = new Label("Permissão:");
		lFuncao = new Label("Funcão:");
		lSalario = new Label("Salário:");
		campoNome = new TextField();
		campoCpf = new MaskedTextField();
		campoCpf.setText("");
		campoSalario = new CurrencyField(new Locale("pt", "BR"));
		campoEmail = new TextField();
		campoPermissao = new ComboBox<>();
		campoPermissao.setEditable(false);
		campoPermissao.setValue("ADMINISTRADOR_GERAL");
		campoFuncao = new ComboBox<>();
		campoFuncao.setEditable(false);
		campoFuncao.setValue("DIRETOR");
		
		titulo.setStyle(""
				+ "-fx-font-size: 20px;"
				+ "	-fx-font-weight: bolder;");
		
		botaoProximo = new Button("Próximo");
		botaoAnterior = new Button("Voltar");
		
		botaoSelecionarImagem = new Button("Selecionar Imagem");
		
		imagemUsuario = new Circle(150, 150, 75);
		imagemUsuario.setFill(new ImagePattern(
				new Image(getClass().getResourceAsStream("imgUsuario.png"))));
		
		botaoSelecionarImagem.setOnAction(e -> buscarImagem());
		
		camposTexto.addAll(Arrays.asList(campoNome, campoSalario, campoEmail));
		
		setMascaraCpf();
		configRodape();
	}
	
	public boolean verificarCampos() {
		Predicate<TextField> isBlackTextField = c -> c.getText().trim().isBlank();
		
		boolean camposTextoValidos = camposTexto.stream()
				.noneMatch(c -> isBlackTextField.test(c));
		
		boolean campoCpfValido = !campoCpf.getPlainText().trim().isBlank();
		
		boolean campoSalarioValido = campoSalario.getAmount() > 0.0;
		
		if (camposTextoValidos && campoCpfValido && campoSalarioValido) {
			return true;
			
		}else {
			if(!campoCpfValido) {
				campoCpf.setOnKeyReleased(e -> removerEstiloErro(campoCpf));
				campoCpf.getStyleClass().add("Campo-Form-Erro");
			}
			
			if(!campoSalarioValido) {
				campoSalario.setOnKeyReleased(e -> removerEstiloErro(campoSalario));
				campoSalario.getStyleClass().add("Campo-Form-Erro");
			}
			
			
			camposTexto.stream()
				.filter(c -> isBlackTextField.test(c))
				.map(c -> {
					c.setOnKeyReleased(e -> removerEstiloErro(c));
					return c;
				})
				.forEach(c -> {
					c.getStyleClass().add("Campo-Form-Erro");
					c.setPromptText("Preencha este campo...");
				}
			);
			
		}
		return false;
	}
	
	private void removerEstiloErro(Object campo) {
		if(campo instanceof TextField) {
			((TextField) campo).getStyleClass().remove("Campo-Form-Erro");
		}else {
			((ComboBox<String>) campo).getStyleClass().remove("Campo-Form-Erro");
		}
	}
	
	private void setMascaraCpf() {
		campoCpf.setMask("###.###.###-##");
	}
	
	private void configRodape() {
		rodape = new HBox();
		rodape.setAlignment(Pos.CENTER_LEFT);
		rodape.setPadding(new Insets(20));
		rodape.setSpacing(20);
		rodape.setStyle(
				"-fx-background-color : #c9c9c9;"
				+ "	-fx-max-height: 70px;"
				+ " -fx-min-height: 70px;");
		rodape.getChildren().addAll(botaoAnterior, botaoProximo);
	}
	
	private void buscarImagem() {
		FileChooser seletorArquivos = new FileChooser();
		seletorArquivos.setTitle("Selecione uma imagem");
		seletorArquivos.getExtensionFilters().add(
				new ExtensionFilter("Imagens", Arrays.asList("*.jpeg", "*.jpg", "*.png")));
		
		File imagem = seletorArquivos.showOpenDialog(new Stage());
		
		if(imagem != null) {
			String caminho = "file:///" + imagem.getAbsolutePath();
			imagemUsuario.setFill(new ImagePattern(new Image(caminho)));
			caminhoImagem = imagem.getAbsolutePath();
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

	public ServidorDTO setDados(ServidorDTO servidor) {
		servidor.setEmail(campoEmail.getText());
		servidor.setNome(campoNome.getText());
		servidor.setCpf(campoCpf.getPlainText());
		servidor.setPermissao(campoPermissao.getValue());
		servidor.setCargo(campoFuncao.getValue());
		servidor.setSalario(campoSalario.getAmount().toString());
		servidor.setImagem(tranferirParaByte(caminhoImagem));
		
		return servidor;
	}
	
	public Button getBotaoProximo() {
		return botaoProximo;
	}

	public Button getBotaoAnterior() {
		return botaoAnterior;
	}
}
