package Arrays_E_Collections.Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ExerciciosCollection {
	public static void main(String[] args) {
		
		// 1- crie um set que receba alguns nomes e imprima
		/*HashSet<String> nomes  = new HashSet<String>();
		nomes.add("Erik");
		nomes.add("Jose");
		nomes.add("Flavio");
		nomes.add("Bia");
		System.out.println(nomes.contains("Erik"));
		System.out.println(nomes);*/
		
		
		// 2- Crie um set que receba nomes s� que agora conserve a ordem de inser��o
		
		/*SortedSet<String> nomes2 = new TreeSet<>();
		
		nomes2.add("Paulo");
		nomes2.add("Ronaldo");
		nomes2.add("Saulo");
		nomes2.add("Jo�o");
		
		System.out.println(nomes2);
		*/
		
		
		// 3- Crie uma lista que receba os nomes dos aprovados
		
			// a lista � ordenada ,ou seja, preserva a ordem de inser��o e aceita obj duplicados
		/*ArrayList<String> listaAprovados = new ArrayList<>();
		listaAprovados.add("Erik");
		listaAprovados.add("Gustavo");
		listaAprovados.add("Raul");
		listaAprovados.add("Raul");
		System.out.println(listaAprovados);*/
		
		
		// 4- Crie uma fila com tickets para sacar dinheiro
		
		/*Queue<Integer> fila = new LinkedList<>();
		
		fila.add(1);
		fila.add(2);
		fila.add(3);
		fila.add(4);
		//M�todo offer caso nao consiga adicionar renorna true ou false j� o add retorna uma Exeption
		fila.offer(5);
		fila.peek();
		
		//pega o primeiro elemento sem o remover
		System.out.println(fila.peek());//caso a fila estiver vazia retorna null
		System.out.println(fila.element());//retorna uma Exeption
		//System.out.println(fila.isEmpty());
		
		System.out.println(fila.poll());/*pega o primeiro elemento da fila e remove-o, se estiver
		vazia retorna null
		System.out.println(fila.remove());//remove o primeiro elemento, se estiver vazia retorna uma exeption
		System.out.println(fila.contains(3)); // Verifica se cont�m o elemento 
		*/
		
		
		//Crie uma pilha de livros
		
		/*Deque<String> livros = new ArrayDeque<>();
		livros.add("O Pequeno Principe");
		livros.add("O Poder da A��o");
		livros.add("Fisica 1"); //Caso n�o seja possivel adicionar retorna uma exeption
		
		// o forEach pode ser usado
		for(String livro : livros) {
			System.out.println(livro);
		}
		// obtem o proximo item sem remiover
		System.out.println(livros.peek());
		livros.push("O Hobbit");//Toca o ultimo elemento que foi adicionado
		
		
		System.out.println("\nImprime e remove");
		System.out.println(livros.pop());
		System.out.println(livros.pop());
		System.out.println(livros.pop());
		*/
		
/*Crie um programa que receba um CPF e um nome associado a ele e tenha as opcoes de 
cadastro buscar usu�rio, listar todos os usu�rios e por �ltimo a op��o de sair*/
		
		// Erik Vasconcelos 1 de abr. de 2022
		Scanner leitor = new Scanner(System.in);
		
		//Cria��o do Map de armazenamento dos dados
		Map<Integer, String> cadastro = new HashMap<>();
		System.out.println("====>Sistema de cadastro de usu�rios<====\n".toUpperCase());
		
		String op = null;
		
		Integer opcao = 0;
		do {
			//Cabe�alho do programa
			System.out.println("Escolha uma opcao: ");
			System.out.println("1 - Cadastrar;\n"
					+ "2 - Buscar Usu�rio;\n"
					+ "3 - Listar Todos Usu�rios;\n"
					+ "4 - Sair.");
			
			//Ponto de escolha das fun��es do programa
			System.out.println("Digite a op��o: ");
			opcao = leitor.nextInt();
			if(opcao>0 && opcao<5) {
				if(opcao == 1) {
					// op��o 1: cadastro dos usu�rios
					do {
						System.out.println("Digite o CPf:  ");
						Integer cpf = leitor.nextInt();
						
						System.out.println("Digite o nome: ");
						String nome = leitor.next();
						//Adiciona ao Map o cpf e nome
						cadastro.put(cpf, nome);
						System.out.println("Usu�rio cadastrado!\n");
						
						System.out.println("Voce quer cadastrar mais pessoas S/N: ");
						op =leitor.next().toUpperCase();
					}while(!op.equals("N"));
				
				}else if(opcao == 2) {
					// Op��o 2: Busca de usu�rio atrav�s do cpf
					String esc = "";
					while(!esc.equals("N")) {
						System.out.println("Digite o cpf do usu�rio: ");
						Integer cpf = leitor.nextInt();
						System.out.println(cadastro.get(cpf)+"\n");
						System.out.println("Quer procurar mais alguem? S/N");
						esc = leitor.next().toUpperCase();
					}
				}else if(opcao == 3) {
					//op��o 3: lista todos os usu�rios cadastrados no Map
					for(Entry<Integer, String> usuario:cadastro.entrySet()) {
						System.out.println(usuario.getKey()+" "+ usuario.getValue());
					}System.out.println();
				}
				}else {
					//Caso a entrada digitada seja inv�lida executa:
					System.out.println("\nOpcao invalida! Tente novamente \n");
					
				}
			
		}while(!opcao.equals(4));
		System.out.println("\nPrograma finalizado...");
		leitor.close();	
		
		
	}
}
