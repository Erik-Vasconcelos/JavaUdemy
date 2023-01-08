package layout.exercicio;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class PilhaImagens extends StackPane{
	
	public PilhaImagens() {
		Image imagem = new Image("C:/Users/erikv/Downloads/beach-2836300.jpg");
		ImageView viImagem = new ImageView(imagem);
		
		Image imagem2 = new Image("C:/Users/erikv/Downloads/hd-wallpaper-g60a6fb6b0_1920.jpg");
		ImageView viImagem2 = new ImageView(imagem2);
		
		Image imagem3 = new Image("C:/Users/erikv/Downloads/hd-wallpaper-gc84ba798e_1920.jpg");
		ImageView viImagem3 = new ImageView(imagem3);
		
		Image imagem4 = new Image("C:/Users/erikv/Downloads/hd-wallpaper-g1e82136d5_1920.jpg");
		ImageView viImagem4 = new ImageView(imagem4);
		
		getChildren().addAll(viImagem, viImagem2, viImagem3, viImagem4);
	}

}
