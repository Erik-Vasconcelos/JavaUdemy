package layout.exercicio;


import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoadingPage extends GridPane{
	
	public LoadingPage() {
		
		PilhaImagens painelImagens = new PilhaImagens();
		
		Thread t = new Thread(() -> {
			try {
				while(true) {
					Thread.sleep(30000);
					Platform.runLater(() -> {
						painelImagens.getChildren().get(0).toFront();
					});
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t.setDaemon(true);
		t.start();
		
		getColumnConstraints().addAll(cc(), cc(), cc());
		getRowConstraints().addAll(rc(), rc(), rc());
		
		Label label = new Label("");
		label.setFont(new Font(150.0));
		label.setTextFill(Color.web("white"));
		
		Thread t2 = new Thread(() -> {
			while(true) {
				try {
					Thread.sleep(995);
					Platform.runLater(() -> {
						
						SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
						String hora = format.format(new Date().getTime());
						label.setText(hora);
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t2.setDaemon(true);
		t2.start();

		add(label, 2, 2);
		add(painelImagens, 0, 0, 3, 3);
		
	}
	
	private ColumnConstraints cc() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(33.3);
		cc.setFillWidth(true);
		return cc;
	}
	
	private RowConstraints rc() {
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(33.3);
		rc.setFillHeight(true);
		return rc;
	}

}
