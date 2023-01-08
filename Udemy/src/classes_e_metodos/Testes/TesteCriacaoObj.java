package classes_e_metodos.Testes;


import classes_e_metodos.DesafioDoModulo.Comida;

public class TesteCriacaoObj {
	public static void main(String[] args) {
		
		Comida c1 = Math.random() >0.5?new Comida("Macarrão", 0.340):null;
		if(c1 != null) {
		System.out.println(c1.getNome()+" "+c1.getPeso());
		}
	} 
}
