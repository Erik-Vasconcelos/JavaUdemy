package principal;

public class Teste {
	
	public static void main(String[] args) {
		Empresario p = new Empresario("Henrique", 40, 789000);
		Fisiculturista p1 = new Fisiculturista("Luiz", 80, 40.2);
		
		p.andar();
		
		p.seApresentar();
		p1.seApresentar();
		
		p.guardarDinheiro(40);
		p.informarInvestimento();
	}
}
