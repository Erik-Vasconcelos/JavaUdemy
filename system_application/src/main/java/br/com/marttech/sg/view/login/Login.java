package br.com.marttech.sg.view.login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

import org.controlsfx.control.Notifications;

import br.com.marttech.sg.controller.LoginController;
import br.com.marttech.sg.model.memoria.ServidorMemory;
import br.com.marttech.sg.view.App;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class Login extends GridPane{
	
	private ImageView imagem;
	private Label lTitulo;
	private Label lMatricula;
	private Label lSenha;
	private TextField campoMatricula = new TextField();
	
	private PasswordField campoSenha = new PasswordField();
	private Button btnAcessar = new Button("Acessar");
	
	List<TextField> campos = new ArrayList<>();
	
	public Login() {
		setAlignment(Pos.CENTER_RIGHT);
		setPadding(new Insets(25, 35, 25, 35));
		getColumnConstraints().addAll(coluna(36, HPos.LEFT), coluna(64));
		getRowConstraints().addAll( linha(28), linha(13), linha(8, VPos.BOTTOM), linha(11),
				linha(8, VPos.BOTTOM), linha(11), linha(5), linha(13));
		setHgap(5);
		setVgap(5);
		
		String css = getClass().getResource("Login.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("login");
		
		setHgrow(btnAcessar, Priority.ALWAYS);
		construirComponentes();
		construirImagem();
		
		add(imagem, 0, 0);
		add(lTitulo, 0, 1);
		add(lMatricula, 0, 2);
		add(campoMatricula, 0, 3, 2, 1);
		add(lSenha, 0, 4);
		add(campoSenha, 0, 5, 2, 1);
		add(btnAcessar, 0, 7);
		
		
		campos.addAll(Arrays.asList(campoMatricula, campoSenha));
	}
	
	private ColumnConstraints coluna(double width) {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setHalignment(HPos.CENTER);
		cc.setPercentWidth(width);
		cc.setFillWidth(true);
		return cc;
	}
	
	private ColumnConstraints coluna(double width, HPos alinhamento) {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setHalignment(alinhamento);
		cc.setPercentWidth(width);
		cc.setFillWidth(true);
		return cc;
	}
	
	private RowConstraints linha(double height) {
		RowConstraints rc = new RowConstraints();
		rc.setFillHeight(true);
		rc.setPercentHeight(height);
		return rc;
	}
	
	private RowConstraints linha(double height, VPos posicao) {
		RowConstraints rc = new RowConstraints();
		rc.setValignment(posicao);
		rc.setFillHeight(true);
		rc.setPercentHeight(height);
		return rc;
	}
	
	private void construirComponentes() {
		lTitulo = new Label("Login");
		lTitulo.getStyleClass().add("login-titulo");
		
		lMatricula = new Label("Matricula:");
		lMatricula.getStyleClass().add("login-texto");
		campoMatricula.getStyleClass().addAll("login-texto", "login-form-campo");
		campoMatricula.setPromptText("Sua matricula...");
		
		lSenha = new Label("Senha:");
		lSenha.getStyleClass().add("login-texto");
		campoSenha.getStyleClass().addAll("login-texto", "login-form-campo");
		campoSenha.setPromptText("Sua senha...");
		
		btnAcessar.setOnAction(e -> validar());
		btnAcessar.getStyleClass().add("login-form-botao");
		
		addActionForKeys();
		
		aplicarFiltroCampoMatricula();
	}
	
	private void aplicarFiltroCampoMatricula() {
		UnaryOperator<TextFormatter.Change> filtro = new UnaryOperator<TextFormatter.Change>() {
			@Override
			public TextFormatter.Change apply(TextFormatter.Change t) {
				
				if(t.isReplaced()) {
					if(t.getControlText().matches("[^0-9]")) {
						t.setText(t.getControlText().substring(t.getRangeStart(), t.getRangeEnd()));
					}
				}
				
				if(t.isAdded()) {
					if(t.getText().matches("[0-9]")) {
						t.setText(t.getText());
						
					}else if(t.getText().matches("[^0-9]")) {
						t.setText("");
					}
				
				}
				return t;
			}
		};
		
		campoMatricula.setTextFormatter(new TextFormatter<>(filtro));
	}
		
	private void validar() {
		boolean isValido = false;
		
		if(validacao()) {
			isValido = autenticar();
			
			if(isValido) {
				resetCamposCredenciais();
				App.contruirTelas();
				App.setTelaSistema();
			}
		}
		
		mensagem(isValido);
	}
	
	private void mensagem(boolean afirmacao) {
		if(afirmacao) {
			
		}else {
			Notifications.create()
				.text("Matricula ou senha inválida(s)")
				.position(Pos.TOP_CENTER)
				.showError();
		}
	}
	
	private void construirImagem() {
		Image img = new Image(getClass().getResourceAsStream("imagens/imagemUser.png"));
		imagem = new ImageView(img);
	}
	
	private boolean validacao() {
		boolean isValidos = campos.stream()
				.noneMatch(c -> c.getText().trim().isEmpty());
		
		if(isValidos) {
			return true;
		}else {
			campos.stream()
				.filter(c -> c.getText().trim().isEmpty())
				.map(c -> {
					c.setOnKeyReleased(e -> removerEstiloCampoObrigatorio(c));
					return c;
				})
				.forEach(c -> {
					c.getStyleClass().add("login-form-campo-obrigatorio");
					c.setPromptText("Preencha este campo...");
				});
				
			return false;
		}
		
	}
	
	private void removerEstiloCampoObrigatorio(TextField campo) {
		campo.getStyleClass().remove("login-form-campo-obrigatorio");
	}

	private boolean autenticar(){
		Thread t = new Thread(() -> {
			try {
				LoginController.autenticar(
						Long.parseLong(campoMatricula.getText())
						,campoSenha.getText());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		});
		
		try {
			t.start();
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return ServidorMemory.isValido();
	}
	
	public void resetCamposCredenciais() {
		campoMatricula.setText("");
		campoSenha.setText("");
	}
	
	private void addActionForKeys() {
		campoMatricula.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
					btnAcessar.fire();
				}
		});
		
		campoSenha.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				btnAcessar.fire();
			}
		});
	}
}
