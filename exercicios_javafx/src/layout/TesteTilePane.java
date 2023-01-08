package layout;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class TesteTilePane extends TilePane {

	public TesteTilePane() {
		List<Quadrado> quadrados = new ArrayList<>();
		
		for(int i = 1; i < 10; i++) {
			quadrados.add(new Quadrado(i * 10));
		}
		BackgroundFill preenchimento = 
				new BackgroundFill(Color.web("gray"), CornerRadii.EMPTY, Insets.EMPTY);
		
		setBackground(new Background(preenchimento));
		
		setPadding(new Insets(20));
		setVgap(10);
		setHgap(10);
//		setOrientation(Orientation.VERTICAL);
		
		//Alinhamento do componenete em relacao ao espaco que ele está ocupando
		setTileAlignment(Pos.BOTTOM_RIGHT);
		
		getChildren().addAll(quadrados);
		
	}
}
