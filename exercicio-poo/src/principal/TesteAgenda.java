package principal;

import java.util.Date;

public class TesteAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		agenda.armazenarPessoa("Jose", new Date("1952/05/23"), 1.73);
		agenda.armazenarPessoa("Anchieta", new Date("1900/10/14"), 1.93);
		agenda.armazenarPessoa("Paulo", new Date("2001/05/07"), 1.73);
		agenda.armazenarPessoa("Armando", new Date("2005/03/21"), 1.73);
		
		agenda.imprimirAgenda();
		
		agenda.imprimirPessoa(2);
		
		agenda.removerPessoa("Paulo");
		
		agenda.imprimirAgenda();
	}
}
