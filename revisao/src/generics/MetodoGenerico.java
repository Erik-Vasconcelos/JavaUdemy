package generics;

public class MetodoGenerico {
	
	public static <T> void printArray(T[] var) {
		for(T ele: var) {
			System.out.println(ele);
		}
		
	}
	
	public static void main(String[] args) {
		Double[] notas = {8.9, 9.4, 1.2};
		Integer[] idades = {76, 17, 14};
		String[] nomes = {"José", "Erik", "Ana"};
		
		MetodoGenerico.printArray(notas);
		MetodoGenerico.printArray(idades);
		MetodoGenerico.printArray(nomes);
	}
}
