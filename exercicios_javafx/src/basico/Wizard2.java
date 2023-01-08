package basico;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Wizard2 extends Application{
	
	private Stage janela;
	private Scene passo1;
	private Scene passo2;
	private Scene passo3;
	
	String caminho = getClass().getResource("/basico/Wizard.css")
			.toExternalForm();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		janela = primaryStage;
		
		criarPasso1();
		criarPasso2();
		criarPasso3();
		
		adicionarEstilo();
		
		janela.setScene(passo1);
		janela.setTitle("Wizard");
		
		
		primaryStage.show();
	}
	
	private void adicionarEstilo() {
		passo1.getStylesheets().add(caminho);
		passo2.getStylesheets().add(caminho);
		passo3.getStylesheets().add(caminho);
	}
	
	private void criarPasso1() {
		Button proximoPasso = new Button("Next >");
		proximoPasso.getStyleClass().add("botao");
		proximoPasso.setOnAction(e -> {
			janela.setScene(passo2);
		});
		Label label = new Label("CENA 1 ");
		label.getStyleClass().add("texto");
		
		HBox box = new HBox();
		box.getStyleClass().add("menu");
		box.setMinHeight(10);
		box.setMargin(proximoPasso, new Insets(12, 0, 12, 25));
		box.getChildren().add(proximoPasso);
		
		
		VBox boxPrincipal = new VBox();
		boxPrincipal.setAlignment(Pos.BOTTOM_CENTER);
		boxPrincipal.getChildren().add(label);
		boxPrincipal.getChildren().add(box);
		
		passo1 = new Scene(boxPrincipal, 500, 300);
	}
	
	private void criarPasso2() {
		Button passoAnterior = new Button("< Voltar");
		passoAnterior.getStyleClass().add("botao");
		passoAnterior.setOnAction(e -> {
			janela.setScene(passo1);
		});
		
		Button proximoPasso = new Button("Next >");
		proximoPasso.getStyleClass().add("botao");
		proximoPasso.setOnAction(e -> {
			janela.setScene(passo3);
		});
		
		HBox box = new HBox();
		box.getStyleClass().add("menu");
		box.setAlignment(Pos.CENTER_LEFT);
		box.setMargin(passoAnterior, new Insets(12, 10, 12, 25));
		box.getChildren().add(passoAnterior);
		box.getChildren().add(proximoPasso);
		
		Label label = new Label("CENA 2 ");
		label.getStyleClass().add("texto");
		
		VBox boxPrincipal = new VBox();
		boxPrincipal.setAlignment(Pos.BOTTOM_CENTER);
		boxPrincipal.getChildren().add(label);
		boxPrincipal.getChildren().add(box);
		
		passo2 = new Scene(boxPrincipal, 500, 300);
	}
	
	private void criarPasso3() {
		Button passoAnterior = new Button("< Voltar");
		passoAnterior.getStyleClass().add("botao");
		passoAnterior.setOnAction(e -> {
			janela.setScene(passo2);
		});
		
		Button finalizar = new Button("Finsh");
		finalizar.getStyleClass().add("botao");
		finalizar.setOnAction(e -> {
			System.exit(0);
		});
		
		HBox box = new HBox();
		box.getStyleClass().add("menu");
		box.setAlignment(Pos.CENTER_LEFT);
		box.setMargin(passoAnterior, new Insets(12, 10, 12, 25));
		box.getChildren().add(passoAnterior);
		box.getChildren().add(finalizar);
		
		Label label = new Label("CENA 3");
		label.getStyleClass().add("texto");
		
		VBox boxPrincipal = new VBox();
		boxPrincipal.setAlignment(Pos.BOTTOM_CENTER);
		boxPrincipal.getChildren().add(label);
		boxPrincipal.getChildren().add(box);
		
		passo3 = new Scene(boxPrincipal, 500, 300);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
