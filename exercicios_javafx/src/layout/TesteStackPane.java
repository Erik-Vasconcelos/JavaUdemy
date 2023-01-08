package layout;


import javafx.application.Platform;
import javafx.scene.layout.StackPane;

public class TesteStackPane extends StackPane {

	public TesteStackPane() {
		Caixa c1 = new Caixa().comTexto("1");
		Caixa c2 = new Caixa().comTexto("2");
		Caixa c3 = new Caixa().comTexto("3");
		Caixa c4 = new Caixa().comTexto("4");
		Caixa c5 = new Caixa().comTexto("5");
		Caixa c6 = new Caixa().comTexto("6");
		
		getChildren().addAll(c2, c3, c4, c5, c6, c1);
		
		setOnMouseClicked(e -> {
			if(e.getSceneX() > getScene().getWidth()/2) {
				getChildren().get(0).toFront();
				/*Se o local onde a cena foi clicada for maior 
				 * do que a metade da largura da cena, (foi clicado do lado direito)
				 * mande o primeiro filho para ser apresentado na tela*/
			}else {
				/*Pega o compoenente que está sendo apresentado e 
				manda-o para o indice 0 */
				getChildren().get(5).toBack();
				//getChildren().get(getChildren().size() - 1).toBack();
			}
			
		});
		
		Thread t = new Thread(() -> {
			while(true) {
				try {
					//setando o tempo para a execucao da thread
					Thread.sleep(3000);
					
					//traformando em uma thread FX
					Platform.runLater(() ->{
						//mudando a caixa 
						getChildren().get(0).toFront();
					});
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
			
		});
		
		//finaliza a thread ao finalizar a Thread principal
		t.setDaemon(true);
		//inicia a thread
		t.start();
	}
	
}
