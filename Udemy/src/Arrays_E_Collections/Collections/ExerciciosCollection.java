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
		
		
		// 2- Crie um set que receba nomes só que agora conserve a ordem de inserção
		
		/*SortedSet<String> nomes2 = new TreeSet<>();
		
		nomes2.add("Paulo");
		nomes2.add("Ronaldo");
		nomes2.add("Saulo");
		nomes2.add("João");
		
		System.out.println(nomes2);
		*/
		
		
		// 3- Crie uma lista que receba os nomes dos aprovados
		
			// a lista é ordenada ,ou seja, preserva a ordem de inserção e aceita obj duplicados
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
		//Método offer caso nao consiga adicionar renorna true ou false já o add retorna uma Exeption
		fila.offer(5);
		fila.peek();
		
		//pega o primeiro elemento sem o remover
		System.out.println(fila.peek());//caso a fila estiver vazia retorna null
		System.out.println(fila.element());//retorna uma Exeption
		//System.out.println(fila.isEmpty());
		
		System.out.println(fila.poll());/*pega o primeiro elemento da fila e remove-o, se estiver
		vazia retorna null
		System.out.println(fila.remove());//remove o primeiro elemento, se estiver vazia retorna uma exeption
		System.out.println(fila.contains(3)); // Verifica se contém o elemento 
		*/
		
		
		//Crie uma pilha de livros
		
		/*Deque<String> livros = new ArrayDeque<>();
		livros.add("O Pequeno Principe");
		livros.add("O Poder da Ação");
		livros.add("Fisica 1"); //Caso não seja possivel adicionar retorna uma exeption
		
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
cadastro buscar usuário, listar todos os usuários e por último a opção de sair*/
		
		// Erik Vasconcelos 1 de abr. de 2022
		Scanner leitor = new Scanner(System.in);
		
		//Criação do Map de armazenamento dos dados
		Map<Integer, String> cadastro = new HashMap<>();
		System.out.println("====>Sistema de cadastro de usuários<====\n".toUpperCase());
		
		String op = null;
		
		Integer opcao = 0;
		do {
			//Cabeçalho do programa
			System.out.println("Escolha uma opcao: ");
			System.out.println("1 - Cadastrar;\n"
					+ "2 - Buscar Usuário;\n"
					+ "3 - Listar Todos Usuários;\n"
					+ "4 - Sair.");
			
			//Ponto de escolha das funções do programa
			System.out.println("Digite a opção: ");
			opcao = leitor.nextInt();
			if(opcao>0 && opcao<5) {
				if(opcao == 1) {
					// opção 1: cadastro dos usuários
					do {
						System.out.println("Digite o CPf:  ");
						Integer cpf = leitor.nextInt();
						
						System.out.println("Digite o nome: ");
						String nome = leitor.next();
						//Adiciona ao Map o cpf e nome
						cadastro.put(cpf, nome);
						System.out.println("Usuário cadastrado!\n");
						
						System.out.println("Voce quer cadastrar mais pessoas S/N: ");
						op =leitor.next().toUpperCase();
					}while(!op.equals("N"));
				
				}else if(opcao == 2) {
					// Opção 2: Busca de usuário através do cpf
					String esc = "";
					while(!esc.equals("N")) {
						System.out.println("Digite o cpf do usuário: ");
						Integer cpf = leitor.nextInt();
						System.out.println(cadastro.get(cpf)+"\n");
						System.out.println("Quer procurar mais alguem? S/N");
						esc = leitor.next().toUpperCase();
					}
				}else if(opcao == 3) {
					//opção 3: lista todos os usuários cadastrados no Map
					for(Entry<Integer, String> usuario:cadastro.entrySet()) {
						System.out.println(usuario.getKey()+" "+ usuario.getValue());
					}System.out.println();
				}
				}else {
					//Caso a entrada digitada seja inválida executa:
					System.out.println("\nOpcao invalida! Tente novamente \n");
					
				}
			
		}while(!opcao.equals(4));
		System.out.println("\nPrograma finalizado...");
		leitor.close();	
		
		
	}
}
