package fundamentos;

import javax.swing.JOptionPane;

public class EstruturasDeControle {
	public static void main(String[] args) {
		
		double media = 4.9;
		if(media >= 7) {
			System.out.println("Aprovado");
			
		}else if(media>=5){
			System.out.println("Em recuperação");
		}else {
			System.out.println("Reprovado");
		}
		
		String nome =  JOptionPane.showInputDialog(null, "Informe seu nome: ");
		if(nome.trim().equalsIgnoreCase("erik")) {
			System.out.println("seja bem vindo " +nome);
		}else {
			System.out.println("Usuário não indentificado");
		}
		
		
		
		
		//while > qunatidade inderterminada de vezes
		int cont = 0;
		while(cont<10) {
			System.out.println(cont);
			cont++;
		}
		
		System.out.println();
		// for > quantidade determinada de repetições
		
		for(int i=1; i<=5; i++) {
			System.out.println("Bom dia "+i);
		}
		
		
		//do-while > garante que o código seja executado ao menos uma vez
		//ENQUANTO A PALAVRA DIGITADA FOR DIFERENTE DE sair EXECUTE
		String op;
		do {
			op= JOptionPane.showInputDialog(null, "Digite uma palavra: ");
			
		}while(!"sair".equalsIgnoreCase(op));
		
		
		
		
		
		
		
	}
}
