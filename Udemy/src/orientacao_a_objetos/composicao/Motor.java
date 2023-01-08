package orientacao_a_objetos.composicao;

public class Motor {
	boolean ligado = false;
	double fatorIngessao= 1;
	
	int giros() {
		if(!ligado) {
			return 0;
		}else {
			return (int) Math.round(fatorIngessao * 3000);
		}
	}
}
