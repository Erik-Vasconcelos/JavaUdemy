package fundamentos;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ExerciciosDoModulo {
	public static void main(String[] args) {
		
	// 1 Questão Criar um programa que leia a temperatura em Fahrenheit e converta para Celsius.
		
		/*
		double temperatura = Double.parseDouble(JOptionPane.showInputDialog("Digite uma temperatura Celsius: "));
		
		double resCel= (temperatura-32) * 5/9;
		JOptionPane.showMessageDialog(null,String.format("(%.1f -32)* (5/9) = %.1fC ",temperatura,resCel),"Resultado", JOptionPane.WARNING_MESSAGE );
		*/
		
		
		
	// 2 Questão Criar um programa que leia a temperatura em Celsius e converta para Fahrenheit.
		/*
		double temperaturaCel = Double.parseDouble(JOptionPane.showInputDialog("Digite uma temperatura em Fahrenheit: "));
		double resFahre = (temperaturaCel *9/5) + 32;
		JOptionPane.showMessageDialog(null, String.format("(%.1f × 9/5) + 32 = %.1f", temperaturaCel,resFahre), "Resultado", JOptionPane.WARNING_MESSAGE);
		*/
		
	// 3 Questão Criar um programa que leia o peso e a altura do usuário e imprima no console o IMC.
		
		
		/*Scanner leitor = new Scanner(System.in);
		System.out.println("Digite seu peso: ");
		double peso = leitor.nextDouble();
		System.out.println("Digite sua altura: ");
		double altura = leitor.nextDouble();
		
		double imc = peso/ Math.pow(altura, 2);
		System.out.println(String.format("Seu IMC = %.2f", imc));
		*/
		
	// 4 Questão Criar um programa que leia um valor e apresente os resultados ao quadrado e ao cubo do valor.
		/*
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite um valor: ");
		int valor = leitor.nextInt();
		System.out.printf("O valor ao quadrado é %d e ao cubo: %d",(int) Math.pow(valor, 2), (int)Math.pow(valor, 3));
		*/
		
		
	// 5 Questão Criar um programa que leia o valor da base e da altura de um triângulo e calcule a área.
		/*
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite a base: ");
		int base = leitor.nextInt();		
		System.out.println("Digite a altura: ");
		int altura = leitor.nextInt();
		
		int res = (base * altura)/2;
		System.out.println(res);
		
		leitor.close();
		*/
		
	// 6 Questão Criar um programa que resolve equações do segundo grau (ax2 + bx + c = 0) utilizando a fórmula de Bhaskara. Use como exemplo a = 1, b = 12 e c = -13. Encontre o delta
		
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o A: ");
		int a = leitor.nextInt();		
		System.out.println("Digite o B: ");
		int b= leitor.nextInt();
		System.out.println("Digite o C: ");
		int c= leitor.nextInt();
		
		int res =(int) Math.pow(b, 2)-4 * a * c;
		
		System.out.printf("%d² -4 * %d * %d\nΔ = %d ", b, a, c, res);
	}
}
