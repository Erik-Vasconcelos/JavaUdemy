package calculator;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class Calculadora extends VBox{

	private BarraTitulo barra = new BarraTitulo();
	private Display display = new Display();
	private Teclado teclado = new Teclado();
	
	public Calculadora() {
		getStyleClass().add("calculadora");
		setAlignment(Pos.BOTTOM_CENTER);
		
		getChildren().addAll(barra, display, teclado);
		
		
		teclado.noCliqueChame(texto -> {
			if(texto.equals("CE")) {
				display.limpar();
			}else {
				display.addTexto(texto);
			}
			
		});
		
	}
	
	
	
}
