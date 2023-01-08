package classes_e_metodos;

public class Data_Teste {
	public static void main(String[] args) {
		Data d1 = new Data();
		d1.dia = 23;
		d1.mes = 04;
		d1.ano=2022;
		
		var d2 = new Data();
		d2.dia = 05;
		d2.mes =07;
		d2.ano = 2021;
		
		System.out.println("Metodo com retorno que retorna uma string \n"
				+ "formatada e que pode ser armazenada em uma variável ou printada");
		System.out.printf(d1.dataFormatada());
		
		
		System.out.println("\nMetodo com o System.out.print para mandar o resultado");
		d2.imprimirDataFormatada();
		
		
		// usando o contrutor padrão definido e a data padrão
		Data d3 = new Data();
		System.out.println("Obj 3 \n"+d3.dataFormatada());
		
		// usando o construtor criado que recebe os parâmetros
		Data d4 = new Data(12,6,2017);
		System.out.println(d4.dataFormatada());
		
		
		
		
	}
}
