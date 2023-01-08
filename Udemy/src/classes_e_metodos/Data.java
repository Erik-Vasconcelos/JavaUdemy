package classes_e_metodos;

public class Data {
	
	int dia;
	int mes;
	int ano;
	
	// Construtores 
	public Data(){
		dia = 01;
		mes = 01;
		ano =1970;
	}
	
	Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	
	
	String dataFormatada() {
		return String.format("%d/%d/%d", dia, mes, ano);
	}
	void imprimirDataFormatada() {
		//Chamando um método dentro de outro
		System.out.println(dataFormatada());
	}
}
