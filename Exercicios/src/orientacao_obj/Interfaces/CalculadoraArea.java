package orientacao_obj.Interfaces;

import java.util.Scanner;

public class CalculadoraArea {
	FormaGeometrica f;
	
	public CalculadoraArea() {
		executar();
	}
	
	void executar() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Seja bem vindo\n");
		
		System.out.println("Escolha o calculo:\n1 - Quadrado\n2 - Retangulo\n3 - Triangulo\n4 - Circulo\n5 - Sair");
		// Erik Vasconcelos 22 de abr. de 2022
		
		int op = leitor.nextInt();
		
		if(op ==1) {
			Quadrado q  = new Quadrado();
			System.out.println("Digite um lado: ");
			int lado = leitor.nextInt();
			q.recebeLado(lado);
			System.out.println("Área = "+q.calculaArea());
		}
		else if(op ==2) {
			Retangulo r  = new Retangulo();
			System.out.println("Digite ladoA: ");
			int ladoA = leitor.nextInt();
			System.out.println("Digite ladoB: ");
			int ladoB = leitor.nextInt();
			r.recebeLados(ladoA, ladoB);
			System.out.println("Área = "+r.calculaArea());
		}
		else if(op ==3) {
			Triangulo t   = new Triangulo();
			System.out.println("Digite a base: ");
			int base = leitor.nextInt();
			System.out.println("Digite a altura: ");
			int altura= leitor.nextInt();
			t.recebeDados(base, altura);
			System.out.println("Área = "+t.calculaArea());
		}
		else if(op ==4) {
			Circulo c   = new Circulo();
			System.out.println("Digite o raio: ");
			int raio = leitor.nextInt();
			c.recebeRaio(raio);
			System.out.println("Área = "+c.calculaArea());
		}else if(op == 5) {
			System.out.println("Finalizando...");
		}else {
			System.out.println("Opção inválida!");
		}
		
		leitor.close();
	
	}
	
	public static void main(String[] args) {
		CalculadoraArea c = new CalculadoraArea();
	}
}
