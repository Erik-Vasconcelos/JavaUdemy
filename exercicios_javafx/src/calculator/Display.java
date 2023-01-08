package calculator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Display extends VBox{
	
	Label label = new Label("0");
	
	public Display() {
		setAlignment(Pos.BOTTOM_RIGHT);
		setPadding(new Insets(10));
		setMinHeight(157);
		getChildren().add(label);
		label.getStyleClass().add("display");
	}
	
	public String getTextoAtual() {
		return "0".equals(label.getText()) ? "" : label.getText();
	}
	
	public void addTexto(String novoTexto) {
		String texto = getTextoAtual();
		
		if(texto.isEmpty() && novoTexto.equals(".")) {
			texto = "0.";
		}
		else if(!texto.contains(".") && novoTexto.equals(".")) {
			texto += novoTexto;
		}else if(novoTexto.matches("\\d")) {
			texto += novoTexto;
		}
	
		setTexto(texto);
	}
	
	private void setTexto(String valor) {
		label.setText(valor);
		ajustarTamanho();
	}
	
	public void limpar() {
		setTexto("0");
	}
	
	private void ajustarTamanho() {
		final int TAMANHO_PADRAO = 45;
		int tamanho = TAMANHO_PADRAO;
		
		Text texto = new Text(label.getText());
		
		do {
			texto.setFont(new Font(label.getFont().getName(), tamanho));
			label.setStyle("-fx-font-size:"+tamanho+"px;");
			tamanho--;
			
		}while(texto.getBoundsInLocal().getWidth() > 280 );
		
	}
}
