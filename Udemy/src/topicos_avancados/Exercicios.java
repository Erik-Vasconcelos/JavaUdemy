package topicos_avancados;

import java.util.Arrays;

public class Exercicios {

	public static void main(String[] args) {
		
//		System.out.println(mystery(3, 4));
//		System.out.println(power(2, 6));
//		System.out.println(fatorial(6));
//		System.out.println(mdc(8, 12));
		
		/*int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int result = mystery(array, array.length);
		System.out.printf("Result is: %d%n", result);*/
		
		/*int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String results = someMethod(array, 0);
		System.out.println(results);*/
		
//		System.out.println(testPalindrome("reviVER"));
		
//		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		
//		System.out.println(printArray(array, 10));
		/*char[] array = {'E', 'r', 'i', 'k', ' ', 'V', 'a', 's', 'c', 'o', 'n', 'c', 'e', 'l', 'o', 's'};
		
		System.out.println(stringReverse(array));*/
		int[] array = {0, -1, 1, 2, 3, 4, 5, -6, 7, 8, 9, 10};
		System.out.println(recursiveMinimum(array));
	}
	
	
	public static int mystery(int a, int b) {
		if (b == 1)
			return a;
		
		else
			return a + mystery(a, b - 1);
	}
	
	/*(M�todo recursivo power) Escreva uma m�todo recursivo power(base, exponent) que,
	 *  quando chamado, retorna base ^ expoente*/ 
	public static int power(int base, int exponent) {
		if(exponent == 1) {
			return base;
		}
		
		return base * power(base, exponent - 1);
	}
	
	
	/*(Visualiza��o de recurs�o) � interessante observar a recurs�o �em a��o�. Modifique o m�todo fatorial na 
	 * Figura 18.3 para exibir sua vari�vel local e o par�metro de chamada recursiva. Para cada chamada
	 *  recursiva, exiba as sa�das em uma linha separada e adicione um n�vel de recuo. Fa�a o melhor que voc�
	 *   puder para tornar a sa�da limpa, interessante e significativa. Seu objetivo aqui � projetar e 
	 *   implementar um formato de sa�da que facilite o entendimento da recurs�o. Voc� pode querer adicionar
	 *    essas capacidades de exibi��o a outros exemplos de recurs�o e a exerc�cios por todo o texto.*/
	
	public static int fatorial(int valor) {
		if(valor <= 1) {
			System.out.printf("Caso base: fatorial(0! ou 1!) = %d\n", 1);
			System.out.printf("    Retorno: %d\n\n", 1);
			return 1;
		}
		int result =  valor * fatorial(valor - 1);
		System.out.printf("-Chamada %d!: %d * fatorial(%d)\n", valor ,valor, valor - 1);
		System.out.printf("    Retorno: %d\n\n", result);
		return result;
	}
	
	/*(M�ximo divisor comum) O m�ximo divisor comum dos inteiros x e y � o maior inteiro que divide tanto x como y.
	Escreva um m�todo recursivo gcd que retorna o m�ximo divisor comum de x e y. O gcd de x e y � definido recursivamente
	como segue: se y � igual a 0, ent�o gcd(x, y) � x; do contr�rio, gcd(x, y) � gcd(y, x % y), onde % � o operador
	de resto. Utilize esse m�todo para substituir o que voc� escreveu no aplicativo do Exerc�cio 6.27.*/
	
	public static int mdc(int x, int y) {
		if(y == 0) {
			return x;
		}
		
		System.out.printf("(x=%d, y=%d)\n", x, y);
		int result = mdc(y, x % y);
		System.out.printf("    (%d, %d %% %d) = %d\n", y, x, y, result);
		
		return result;
	}
	
	public static int mystery(int[] array2, int size) {
		if (size == 1)
			return array2[0];
		else
			return array2[size - 1] + mystery(array2, size - 1);
	 }
	
	public static String someMethod(int[] array2, int x)
	{
	if (x < array2.length)
		return String.format("%s%d ", someMethod(array2, x + 1), array2[x]);
	else
		return "";
	 }
	
	public static boolean testPalindrome(String palavra) {
		
		if(palavra.length() <= 1) {
			return true;
		}
		
		boolean isIgual = palavra.substring(0, 1).equalsIgnoreCase(
				String.valueOf(palavra.charAt(palavra.length() - 1)));
		
		return isIgual && testPalindrome(palavra.substring(1, palavra.length() - 1));
	}
	
	public static String printArray(int[] array, int length) {
		if(length == 0) {
			return "";
		}
		
		return printArray(array, length - 1) + " " +array[length-1];
	}
	
	public static String stringReverse(char[] caracteres) {

		if(caracteres.length == 1 ) {
			return caracteres[0] + "";
			
		}else if(caracteres.length < 1) {
			return "";
		}
		
		char[] arrayReduzido = Arrays.copyOfRange(caracteres, 1, caracteres.length - 1);
		
		return caracteres[caracteres.length - 1]
				+ stringReverse(arrayReduzido)
				+ caracteres[0];
	}
	
	public static int recursiveMinimum(int[] array) {
		if(array.length == 2) {
			return array[0] < array[1] ? array[0] : array[1];
		}
		
		int menor = array[array.length - 1];
		
		int[] novoArray = Arrays.copyOfRange(array, 0, array.length - 1);
		
		int valorRetornado = recursiveMinimum(novoArray);
		
		return valorRetornado < menor ? valorRetornado : menor; 
	}
}
