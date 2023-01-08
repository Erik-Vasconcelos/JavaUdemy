package padroes.observer_;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Prteiro extends Thread{
	private List<ObservadorChegadaAniversariante> observadores = new ArrayList<>();
	
	public void registrar(ObservadorChegadaAniversariante observer) {
		observadores.add(observer);
	}
	
	public void monitorar() {
		// Erik Vasconcelos 10 de mai. de 2022
		Scanner leitor = new Scanner(System.in);
		String op ="";
		
		while(!op.equalsIgnoreCase("sair")) {
			
			System.out.println("Chegou? ");
			op= leitor.nextLine();
			EventoChegadaAniversariante evento = new EventoChegadaAniversariante(new Date());
			if(op.equalsIgnoreCase("sim")) {
				observadores.stream().forEach(o-> o.chegou(evento));
				op="sair";
				
			}else{
				System.out.println("Alarme falso");
			}
		}
		

		leitor.close();
	}
}
