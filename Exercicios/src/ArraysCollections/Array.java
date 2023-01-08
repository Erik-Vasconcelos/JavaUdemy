package ArraysCollections;

import java.util.Arrays;

public class Array {
	public static void main(String[] args) {
		
		double[] notas = {7.1, 9.4, 6.3, 5.2};
		//criando e amarrando um tamanho fixo a ele
		//double [] notas1 = new double[5];
		
		//imprimir os valores:
		System.out.println(Arrays.toString(notas));
		
		System.out.println("Usando o for...");
		double total  =0;
		for (int i = 0; i < notas.length; i++) {
			total+=notas[i];
		}
		System.out.println("A média é: "+total/notas.length);
		
	
		System.out.println("\nUsando o forEach...");
		double total2=0;
		for(double nota:notas) {
			total2+=nota;
		}
		System.out.println("A média é: "+total2/notas.length);
		
		//Pega o ultimo elemento do vetor
		System.out.println(notas[notas.length-1]);
		
		//Calcula a notas dos alunos da matriz e armazena em um vetor
		double [][]notasAlunos = {{10,8.0,8.0,10}, {10,8.9,9.0,7.1}};
		double [] mediaAlunos =  new double[notasAlunos.length];
		
		int indc =0;
		for (double[] aluno : notasAlunos) {
			
			double somatorio= 0;
			for (double notasAlu : aluno) {
				somatorio +=notasAlu;
				mediaAlunos[indc] = somatorio/aluno.length;
			}
			indc++;
			somatorio =0;
		}
		System.out.println(Arrays.toString(mediaAlunos));
			
		}
	}

