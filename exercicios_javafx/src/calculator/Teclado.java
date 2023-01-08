package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Teclado extends GridPane implements Consumer<String>{
	
	private List<Consumer<String>> funcoes = new ArrayList<>();
	
	private Botao botaoPor = new Botao("%", this, "botao-operacao");
	private Botao botaoCe = new Botao("CE", this, "botao-operacao");
	private Botao botaoLimpar = new Botao("C", this, "botao-operacao");
	private Botao botaoApagar = new Botao("⌫", this, "botao-operacao");
	
	private Botao botaoX1 = new Botao("x/1", this, "botao-operacao");
	private Botao botaoX2 = new Botao("x²", this, "botao-operacao");
	private Botao botaoXX = new Botao("xx", this, "botao-operacao");
	private Botao botaoDiv = new Botao("÷", this, "botao-operacao");

	private Botao botao7 = new Botao("7", this);
	private Botao botao8 = new Botao("8", this);
	private Botao botao9 = new Botao("9", this);
	private Botao botaoMult = new Botao("×", this, "botao-operacao");
	
	private Botao botao4 = new Botao("4", this);
	private Botao botao5 = new Botao("5", this);
	private Botao botao6 = new Botao("6", this);
	private Botao botaoSub = new Botao("-", this, "botao-operacao");
	
	private Botao botao1 = new Botao("1", this);
	private Botao botao2 = new Botao("2", this);
	private Botao botao3 = new Botao("3", this);
	private Botao botaoAdi = new Botao("+", this, "botao-operacao");
	
	private Botao botaoMaMe = new Botao("7", this);
	private Botao botao0 = new Botao("0", this);
	private Botao botaoPonto = new Botao(".", this);
	private Botao botaoResult = new Botao("=", this, "botao-result");
	
	public Teclado() {
		setHgap(3);
		setVgap(3);
		setPadding(new Insets(5));
		
		add(botaoPor, 0, 0);
		add(botaoCe, 1, 0);
		add(botaoLimpar, 2, 0);
		add(botaoApagar, 3, 0);
		
		add(botaoX1, 0, 1);
		add(botaoX2, 1, 1);
		add(botaoXX, 2, 1);
		add(botaoDiv, 3, 1);
		
		add(botao7, 0, 2);
		add(botao8, 1, 2);
		add(botao9, 2, 2);
		add(botaoMult, 3, 2);
		
		add(botao4, 0, 3);
		add(botao5, 1, 3);
		add(botao6, 2, 3);
		add(botaoSub, 3, 3);
		
		add(botao1, 0, 4);
		add(botao2, 1, 4);
		add(botao3, 2, 4);
		add(botaoAdi, 3, 4 );
		
		add(botaoMaMe, 0, 5);
		add(botao0, 1, 5);
		add(botaoPonto, 2, 5);
		add(botaoResult, 3, 5);
		
	}
	
	public void noCliqueChame(Consumer<String> funcao) {
		funcoes.add(funcao);
	}
	
	@Override
	public void accept(String texto) {
		funcoes.forEach(funcao -> funcao.accept(texto));
	}

}
