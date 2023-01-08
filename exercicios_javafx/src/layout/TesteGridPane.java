package layout;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class TesteGridPane extends GridPane{

	public TesteGridPane() {
		
		Caixa c1 = new Caixa().comTexto("1");
		Caixa c2 = new Caixa().comTexto("2");
		Caixa c3 = new Caixa().comTexto("3");
		Caixa c4 = new Caixa().comTexto("4");
		Caixa c5 = new Caixa().comTexto("5");
		Caixa c6 = new Caixa().comTexto("6");
		
		//visibilidade das linhas de grades 
		setGridLinesVisible(true);
		
		//espacamentos entre as células
		setVgap(10);
		setHgap(10);
		
		//adicionando as regras do layout
		getColumnConstraints().addAll(cc(), cc(), cc(), cc(), cc());
		getRowConstraints().addAll(rc(), rc(), rc(), rc(), rc());
		
		add(c1, 0, 0, 2, 2);
		add(c2, 1, 1, 2, 2);
		add(c3, 4, 2, 1, 3);
		add(c4, 3, 1);
		add(c5, 0, 4, 2, 1);
		add(c6, 3, 3);
		
		
	}
	
	//criando as regras das colunas 
	private ColumnConstraints cc() {
		ColumnConstraints cc = new ColumnConstraints();
		//Setando o percentual da largura da coluna
		cc.setPercentWidth(20);
		//Setando o preenchiemento da coluna
		cc.setFillWidth(true);
		return cc;
	}
	
	//criando as regras das linhas
	private RowConstraints rc() {
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(20);
		rc.setFillHeight(true);
		return rc;
	}

}
