package br.com.marttech.sg.view.wizard_application;

import br.com.marttech.sg.controller.WizardController;
import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.model.infra.ConfirmacaoCadastro;
import br.com.marttech.sg.view.App;
import br.com.marttech.sg.view.wizard_application.cadastro.CenaCadastroAdm;
import br.com.marttech.sg.view.wizard_application.cadastro.CenaDadosUtilitario;
import br.com.marttech.sg.view.wizard_application.inicio.CenaInicial;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class WizardStartApplication extends Stage{
	
	private Scene cenaInicial;
	private Scene cenaCadastro;
	private Scene cenaOutrosDados;
	
	private ServidorDTO servidorDTO;
	
	public WizardStartApplication() {
		servidorDTO = new ServidorDTO();
		criarCenaInicial();
		configCenaCadastro();
		configCenaDadosUtilitario();
		setResizable(false);
		setMaximized(false);
		
		setScene(cenaInicial);
	}
	
	private void criarCenaInicial() {
		CenaInicial inicial = new CenaInicial();
		inicial.getBotaoProximo().setOnAction(e -> setScene(cenaCadastro));
		cenaInicial = new Scene(inicial, 700, 400);
		
	}
	
	private void configCenaCadastro() {
		CenaCadastroAdm cadastroAdm = new CenaCadastroAdm();
		cadastroAdm.getBotaoAnterior().setOnAction(e -> setScene(cenaInicial));
		
		cadastroAdm.getBotaoProximo().setOnAction(e -> {
			if(cadastroAdm.verificarCampos()) {
				setScene(cenaOutrosDados);
				cadastroAdm.setDados(servidorDTO);
			}
		});
		cenaCadastro = new Scene(cadastroAdm, 700, 400);
	}
	
	private void configCenaDadosUtilitario() {
		CenaDadosUtilitario cenaDadosUtilitario = new CenaDadosUtilitario();
		cenaDadosUtilitario.getBotaoVoltar().setOnAction(e -> setScene(cenaCadastro));
		
		cenaDadosUtilitario.getBotaoFinalizar().setOnAction(e -> {
			if(cenaDadosUtilitario.verificarCampos()) {
				cenaDadosUtilitario.setDados(servidorDTO);
				
				ConfirmacaoCadastro confirmacao = WizardController.salvarAdministrador(servidorDTO);
				
				Alert info = new Alert(AlertType.NONE);
					
				if(confirmacao.isCasdastado()) {
					String mensagem = String.format("Usuário cadastrado com sucesso!\n"
							+ "Matricula do usuário: %d\n"
							+ "Senha: %s", confirmacao.getMatricula(), "@EENSINO + Cpf do usuário sem pontuação\n"
									+ "Ex.: @EENSINO99999999999");
						
					info.setAlertType(AlertType.CONFIRMATION);
					info.setHeaderText(mensagem);
					info.setTitle("Informação");
					info.showAndWait();
					
					getScene().getWindow().hide();
					
					App.setTelaLogin();
				}else {
					info.setAlertType(AlertType.ERROR);
					info.setHeaderText("Não foi possivel cadastar o usuário");
					info.setTitle("Informação");
					info.showAndWait();
				}
			}
		});
		cenaOutrosDados = new Scene(cenaDadosUtilitario, 700, 400);
	}

	public Scene getCenaInicial() {
		return cenaInicial;
	}

	public Scene getCenaCadastro() {
		return cenaCadastro;
	}

	public Scene getCenaOutrosDados() {
		return cenaOutrosDados;
	}
	
}
