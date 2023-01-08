package classes;

public class Data {
	int dia;
	int mes;
	int ano;
	
	Data(){
		//chama o contrutor de baixo
		this(01,01,1970);
	}
	
	public Data(int dia, int mes, int ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	
	
	
}
