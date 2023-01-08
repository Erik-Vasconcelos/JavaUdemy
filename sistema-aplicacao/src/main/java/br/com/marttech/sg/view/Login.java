package br.com.marttech.sg.view;

import org.controlsfx.control.Notifications;

import br.com.marttech.sg.controller.LoginController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Login extends GridPane{
	
	private TextField campoMatricula = new TextField();
	private PasswordField campoSenha = new PasswordField();
	Button btnAcessar = new Button("Acessar");
	
	public Login() {
		setAlignment(Pos.CENTER_RIGHT);
		
		getStyleClass().add("login");
		setPadding(new Insets(30));
	
		Label label = new Label("LOGGIN");
		label.getStyleClass().add("login-titulo");
		
		Label lMatricula = new Label("Matricula: ");
		lMatricula.getStyleClass().add("login-texto");
		campoMatricula.getStyleClass().addAll("login-texto", "login-form-campo");
		
		Label lSenha = new Label("Senha: ");
		lSenha.getStyleClass().add("login-texto");
		campoSenha.getStyleClass().addAll("login-texto", "login-form-campo");
		
		btnAcessar.setOnAction(e -> validar());
		btnAcessar.getStyleClass().add("login-form-botao");
		
		getColumnConstraints().addAll(coluna(20), coluna(60), coluna(20));
		getRowConstraints().addAll(linha(15), linha(10, VPos.BOTTOM), linha(13), linha(10, VPos.BOTTOM), linha(13), linha(5), linha(15));
		
//		setVgap(10);
		setHgap(10);
		
		add(label, 1, 0);
		add(lMatricula, 1, 1);
		add(campoMatricula, 1, 2);
		add(lSenha, 1, 3);
		add(campoSenha, 1, 4);
		add(btnAcessar, 1, 6);
		
		String caminho = getClass().getResource("loggin.css").toExternalForm();
		
		//getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");
		getStylesheets().add(caminho);
		
	}
	
	private void validar() {

		boolean isValido = LoginController.autenticar(
				Long.valueOf(campoMatricula.getText())
				, campoSenha.getText()
		);
		
		if(isValido) {
			Janela.setTelaInicio();
		}else {
			Notifications.create()
				.text("Matricula ou senha inválido")
				.darkStyle()
				.position(Pos.TOP_CENTER)
				.showError();
		}
	}
	
	private ColumnConstraints coluna(double width) {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setHalignment(HPos.CENTER);
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

	private boolean autenticar() {
		return LoginController.autenticar(
				Long.parseLong(campoMatricula.getText())
				,campoSenha.getText());
	}
}
