package br.com.marttech.sg.view.wizard_application.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.view.libs.MaskedTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class CenaDadosUtilitario extends GridPane{
	private Label lTitulo;
	private Label lRua;
	private Label lBairro;
	private Label lNumero;
	private Label lCidade;
	private Label lEstado;
	private Label lTelefone;
	private Label lTipo;
	
	private TextField campoRua;
	private TextField campoBairro;
	private TextField campoNumero;
	private TextField campoCidade;
	private ComboBox<String> campoEstado;
	private MaskedTextField campoTelefone;
	private ComboBox<String> campoTipoTelefone;
	
	private Button botaoVoltar;
	private Button botaoFinalizar;
	
	private HBox rodape;
	
	List<TextField> camposTexto = new ArrayList<>();
	List<ComboBox<String>> camposSelecao = new ArrayList<>();
	
	public CenaDadosUtilitario() {
		setHgap(20);
		getColumnConstraints().addAll(coluna(30), coluna(), coluna(), coluna(30));
		getRowConstraints().addAll(linha(40), linhaLabel(), linha(), linhaLabel(), linha(), 
				 linhaLabel(), linha(), linhaLabel(), linha(), linha(70,VPos.BOTTOM));
		
		String css = getClass().getResource("Cadastro.css").toExternalForm();
		getStylesheets().add(css);
		
		setAlignment(Pos.CENTER);
		
		setMaxWidth(USE_COMPUTED_SIZE);
		setMaxHeight(USE_COMPUTED_SIZE);
		
		construirComponentes();
		
		add(lTitulo, 1, 0);
		add(lRua, 1, 1);
		add(campoRua, 1, 2);
		
		add(lBairro, 2, 1);
		add(campoBairro, 2, 2);
		
		add(lNumero, 1, 3);
		add(campoNumero, 1, 4);
		
		add(lCidade, 2, 3);
		add(campoCidade, 2, 4);
		
		add(lEstado, 1, 5);
		add(campoEstado, 1, 6);
		
		add(lTelefone, 1, 7);
		add(campoTelefone, 1, 8);
		
		add(lTipo, 2, 7);
		add(campoTipoTelefone, 2, 8);
		
		add(rodape, 0, 11, 4, 1);
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
	
	private ColumnConstraints coluna(double tamanho) {
		ColumnConstraints cc = coluna();
		cc.setPrefWidth(tamanho);
		return cc;
	}
	
	private RowConstraints linha() {
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(USE_COMPUTED_SIZE);
		rc.setMaxHeight(USE_COMPUTED_SIZE);
		rc.setPrefHeight(43);
		rc.setVgrow(Priority.ALWAYS);
		rc.setPercentHeight(-1);
		rc.setFillHeight(true);
		return rc;
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
		rc.setPrefHeight(25);
		rc.setValignment(VPos.BOTTOM);
		return rc;
	}
	
	private void construirComponentes() {
		lTitulo = new Label("Cadastro de outros dados");
		lRua = new Label("Rua:");
		lBairro = new Label("Bairro:");
		lNumero = new Label("Numero:");
		lCidade = new Label("Cidade:");
		lEstado = new Label("Estado:");
		lTelefone = new Label("Telefone:");
		lTipo = new Label("Tipo do telefone:");
		campoRua = new TextField();
		campoBairro = new TextField();
		campoNumero = new TextField();
		campoCidade = new TextField();
		campoEstado = new ComboBox<>();
		campoTelefone = new MaskedTextField();
		campoTipoTelefone = new ComboBox<>();
		
		botaoFinalizar = new Button("Finalizar");
		botaoVoltar = new Button("Voltar");
		
		lTitulo.setStyle(""
				+ "-fx-font-size: 20px;"
				+ "	-fx-font-weight: bolder;");;
		
		campoEstado.getItems().addAll(Arrays.asList("RN", "PB", "PE", "CE", "MA", "PI"));
		
		campoTipoTelefone.getItems().addAll(Arrays.asList("CEL", "RES"));
		
		camposTexto.addAll(Arrays.asList(campoRua, campoBairro, campoCidade, campoNumero));
		
		camposSelecao.addAll(Arrays.asList(campoEstado, campoTipoTelefone));
		
		configRodape();
		setMascaraTelefone();
	}
	
	public boolean verificarCampos() {
		Predicate<TextField> isBlackTextField = c -> c.getText().trim().isBlank();
		
		boolean camposTextoValidos = camposTexto.stream()
				.noneMatch(c -> isBlackTextField.test(c));
		
		
		boolean camposSelecaoValidos = camposSelecao.stream()
				.noneMatch(cs -> cs.getValue() == null);
		
		boolean campoTelefoneValido = !campoTelefone.getPlainText().trim().isBlank();
		
		if (camposTextoValidos && camposSelecaoValidos && campoTelefoneValido) {
			return true;
			
		}else {
			
			if(!campoTelefoneValido) {
				campoTelefone.setOnKeyReleased(e -> removerEstiloErro(campoTelefone));
				campoTelefone.getStyleClass().add("Campo-Form-Erro");
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
			
			camposSelecao.stream()
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
	
	private void removerEstiloErro(Object campo) {
		if(campo instanceof TextField) {
			((TextField) campo).getStyleClass().remove("Campo-Form-Erro");
		}else {
			((ComboBox<String>) campo).getStyleClass().remove("Campo-Form-Erro");
		}
	}
	
	private void setMascaraTelefone() {
		campoTelefone.setMask("(###)#####-####");
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
		rodape.getChildren().addAll(botaoVoltar, botaoFinalizar);
	}
	
	public ServidorDTO setDados(ServidorDTO servidor) {
		servidor.setRua(campoRua.getText());
		servidor.setBairro(campoBairro.getText());
		servidor.setCidade(campoCidade.getText());
		servidor.setEstado(campoEstado.getValue());
		servidor.setNumero(campoNumero.getText());
		servidor.setTelefone(campoTelefone.getPlainText());
		servidor.setTipoTelefone(campoTipoTelefone.getValue());
		
		return servidor;
	}

	public Button getBotaoVoltar() {
		return botaoVoltar;
	}

	public Button getBotaoFinalizar() {
		return botaoFinalizar;
	}
	
}
