
package br.com.marttech.sg.view;

import java.io.InputStream;

import br.com.marttech.sg.controller.CarregarApp;
import br.com.marttech.sg.model.memoria.ServidorMemory;
import br.com.marttech.sg.model.perfis.enuns.Permissao;
import br.com.marttech.sg.view.interfaces.interface_sistema.TelaSistema;
import br.com.marttech.sg.view.libs.PermissaoFront;
import br.com.marttech.sg.view.loading.TelaCarregamento;
import br.com.marttech.sg.view.login.Login;
import br.com.marttech.sg.view.wizard_application.WizardStartApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
	
	/**
	 * @author erikv
	 * @date 16:01:34 23 de dez. de 2022
	 * @version 1.0 23 de dez. de 2022
	 * Sistema iniciado em 13 de setembro de 2022 e a primeira versão finalizada hoje, 23 dezembro de 2022.
	 * este sistema foi motivo de muitas noites e tarde cansativas, umas terminavam com vitórias e alegria, 
	 * outras com triteza, aflição e sentimento de incapacidade, muitas pesquisas de erros e de como implementar 
	 * alguma funcionalidade e também muitas dores de cabeça. Porém, também esse sistema foi motivo de muito crescimento, 
	 * aprendizado e acima de tudo um treinamento da capacidade de persistência para resolver problemas.
	 * Emfim, dianate das tardes, noites, dores, sogfrimentos, aprendizado, crescimento e persistência e 
	 * das vezes que pensei em parar, Deus me dava forças para continuar, e hoje delaro a primeira versão 
	 * do sistema E-Ensino desktop finalizada, com várias melhoria para serem feitas, contudo, em um futuro próximo.
	 * 
	 */
	
	private static WizardStartApplication janelaWizard;
	public static Stage janelaCarregamento;
	public static Stage janelaLogin;
	public static Stage janelaPrincipal;
	
	private static Scene telaCarregamento;
	private static Scene telaLogin;
	private static Scene telaPrincipal;
	
	private static TelaCarregamento carregamento;
	private static TelaSistema telaSistema;
	
	private static PermissaoFront ultimaPermissao;
	 
	private static Image iconeSistema;
	
	private static ImageSearchEngine pesquisadorImagem = new ImageSearchEngine();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		janelaLogin = primaryStage;
		
		buscarIconeSistema();
		
		construirCaregamento();
		setTelaCarregamento();
		
		Thread threadStartHibernate = new Thread(() -> {
			try {
				CarregarApp.startHibernate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Thread threadLogin = new Thread(() -> {
			Platform.runLater(() -> {
				construirLogin();
				configJanelaLogin();
			});
		});
		
		threadLogin.setDaemon(true);
		threadLogin.setPriority(8);
		threadLogin.start();
		
		threadStartHibernate.setDaemon(true);
		threadStartHibernate.start();
		
		Thread threadProgress = new Thread(() -> {
			double progress = 0.0;
			
			while(threadStartHibernate.isAlive()) {
				try {
					Thread.sleep(40);
					progress += 0.004;
					carregamento.setProgress(progress);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			while(progress <= 100) {
				
				try {
					Thread.sleep(1);
					progress += 0.7;
					carregamento.setProgress(progress);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			long result = CarregarApp.verificarUsuario();
			
			Platform.runLater(() -> {
			if(result == 0) {
				fecharPrimeiroCarregamentoSistema();
			}else {
				fecharCarregamento();
			}});
			
		});
		
		threadProgress.setDaemon(true);
		threadProgress.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/*----------------------------Configuração de janelas---------------------------------*/
	
	private static void configJanelaLogin() {
		janelaLogin.getIcons().add(iconeSistema);
		janelaLogin.setTitle("Sistema E-Ensino");
		janelaLogin.setResizable(false);
		janelaLogin.setMaximized(false);
		janelaLogin.centerOnScreen();
		//janelaLogin.setAlwaysOnTop(true); deixa a janela em cima de outra
	}
	
	private static void configJanelaPrincipal() {
		janelaPrincipal = new Stage();
		janelaPrincipal.getIcons().add(iconeSistema);
		janelaPrincipal.setTitle("Sistema E-Ensino");
		janelaPrincipal.setMaximized(true);
		janelaPrincipal.setResizable(true);
		janelaPrincipal.centerOnScreen();
	}
	
	private void setJanelaWizard() {
		buscarIconeSistema();
		janelaWizard = new WizardStartApplication();
		janelaWizard.getIcons().add(iconeSistema);
		janelaWizard.show();
	}
	
	/*----------------------------Fechamento das janelas---------------------------------*/
	
	private static void fecharJanelaLogin() {
		janelaLogin.getScene().getWindow().hide(); //tenta ocultar esta janela definindo a visibilidade como falsa
	}
	
	private static void fecharJanelaPrincipal() {
		janelaPrincipal.getScene().getWindow().hide();
		telaSistema.reset();
	}
	
	private void fecharCarregamento() {
		janelaCarregamento.getScene().getWindow().hide();
		setTelaLogin();
	}
	
	private void fecharPrimeiroCarregamentoSistema() {
		janelaCarregamento.getScene().getWindow().hide();
		setJanelaWizard();
	}
	
	/*----------------------------Construção das cenas---------------------------------*/
	
	public static void construirLogin() {
		telaLogin = new Scene(new Login(), 420, 520);
	}
	
	private static void construirCaregamento() {
		janelaCarregamento = new Stage();
		janelaCarregamento.getIcons().add(iconeSistema);
		carregamento = new TelaCarregamento();
		telaCarregamento = new Scene(carregamento, 480, 320);
	}
	
	public static void contruirTelas() {
		PermissaoFront permissao = transformarPermissao(ServidorMemory.getInstance().getPermissao());
		if(telaPrincipal == null || permissao != ultimaPermissao) {
			
			telaSistema = new TelaSistema(permissao);
			GridPane raiz = telaSistema;
			telaPrincipal = new Scene(raiz);
			
			ultimaPermissao = permissao;
		}
	}
	
	private static PermissaoFront transformarPermissao(Permissao permissao) {
		PermissaoFront permissaoFront = null;
		
		switch (permissao) {
		case ADMINISTRADOR_GERAL:
			permissaoFront = PermissaoFront.ADMINISTRADOR_GERAL;
			break;
		case ADMINISTRADOR:
			permissaoFront = PermissaoFront.ADMINISTRADOR;
			break;
		case GERENCIADOR_TURMA:
			permissaoFront = PermissaoFront.GERENCIADOR_TURMA;
			break;
		default:
			permissaoFront = PermissaoFront.USUARIO;
		}
		
		return permissaoFront;
	}
	
	/*----------------------------Reset da aplicação---------------------------------*/
	
	public static void reset() {
		ServidorMemory.resetMemory();
		fecharJanelaPrincipal();
		setTelaLogin();
	}
	
	/*-------------------------Métodos de Settar as cenas------------------------------*/
	
	public static void setTelaCarregamento() {
		if(janelaCarregamento.getScene() == null) {
			janelaCarregamento.setScene(telaCarregamento);
		}
		
		janelaCarregamento.initStyle(StageStyle.UNDECORATED);
		janelaCarregamento.centerOnScreen();
		janelaCarregamento.show();
	}
	
	public static void setTelaLogin() {
		if(janelaLogin.getScene() == null) {
			janelaLogin.setScene(telaLogin);
		}
		janelaLogin.show();
	}

	public static void setTelaSistema() {
		fecharJanelaLogin();
		
		if (janelaPrincipal == null) {
			configJanelaPrincipal();
		}else {
			telaSistema.reload();
		}
		
		janelaPrincipal.setScene(telaPrincipal);
		janelaPrincipal.show();
	}
	
	private static void buscarIconeSistema() {
		InputStream imagem = pesquisadorImagem.getImagem("logo/diplomado.png");
		iconeSistema = new Image(imagem);
	}

	public static TelaSistema getTelaSistema() {
		return telaSistema;
	}

}
