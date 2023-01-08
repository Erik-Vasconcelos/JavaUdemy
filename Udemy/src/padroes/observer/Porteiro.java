package padroes.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Porteiro {
	private List<ObservadorChegadaAniversariante> convidados = new ArrayList<>();
	
	public void registrarObservador(ObservadorChegadaAniversariante observador) {
		convidados.add(observador);
	}
	
	public void monitorar() {
		// Erik Vasconcelos 21 de abr. de 2022
		Scanner leitor = new Scanner(System.in);
		String valor="";
		
		while(!"sair".equalsIgnoreCase(valor)) {
			System.out.println("Aniversariante chegou? ");
			valor = leitor.nextLine();
			
			if("sim".equalsIgnoreCase(valor)) {
				//Criar o evento
				EventoChegadaAniversariante evento =
						new EventoChegadaAniversariante(new Date());
				//notificar o observador
				convidados.stream().forEach(o -> o.chegou(evento));
				valor = "sair";
				
			}else {
				System.out.println("Alarme falso!");
			}
			
		}
		

		leitor.close();
	}
	
}
