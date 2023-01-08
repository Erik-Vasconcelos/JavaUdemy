package Testes;

public class Arrays {
	public static void main(String[] args) {
		/*Para cada conjunto de valores abaixo, escreva o código Java, usando laço(s), que
		preencha um array com os valores:
		a) 10 9 8 7 6 5 4 3 2 1
		b) 0 1 4 9 16 25 36 49 64 81 100
		c) 1 2 3 4 5 10 20 30 40 50
		d) 3 4 7 12 19 28 39 52 67 84*/
		
		/*A
		int[] vetor= new int[10];
		for(int i= 0;i<vetor.length;i++){
			vetor[i]=vetor.length-i;
		}
		for(int j =0;j<vetor.length;j++) {
			System.out.println(vetor[j]);
		}*/
		
		/*B
		int[] vetor2= new int[12];
		int fator = 0;
		
		for(int i=0;i<12;i++) {
			int auxi = i;
			if(auxi>=1) {
				if(auxi>1) {
					fator = fator+=2;
				}
			System.out.println(fator);	
		}
		for(int j =0;j<vetor2.length;j++) {
			System.out.println(vetor2[j]);
		}*/
		
		//c
		/*int[] vetor3 = new int[10];
		for(int g =0;g<10;g++) {
			if(g<=5) {
				vetor3[g]=g;
			}else {
				int cont = 0;
				vetor3[g] = (vetor3[cont])*10;
				cont++;
			}

		}
		for(int j =0;j<vetor3.length;j++) {
			System.out.println(vetor3[j]);
		}*/
		
		/*Exercício 5: Crie um método que recebe um array de inteiros a e um valor inteiro x e retorna a
		quantidade de vezes que x aparece no array a.*/
		
		Arrays a = new Arrays();
		
		int[] vetor = {-1, -3, 4,5, 1, 1, 1,-1,1,1}; 
		
		boolean[] t  =a.troca(vetor);
		for(boolean teste:t) {
			System.out.println(teste);
		}
		                                                                                                                          ;
		
	}
	
	int vezes(int[] vetor,int numero) {
		int res = 0;
		for(int i=  0;i<vetor.length;i++) {
			if(vetor[i] == numero) {
				res +=1;
			}
		}
		return res;
	}
	/*Escreva um método que recebe um array de inteiros a e devolve um array de boolean
	onde, cada posição indique true se o elemento da posição correspondente de a é positivo e false
	caso seja negativo ou zero.*/
	
	boolean[] troca(int[] vector) {
		boolean res[] = new boolean[10];
		for(int i =0; i<vector.length;i++) {
			if(vector[i]>0) {
				res[i]=true;

			}else {
				res[i] = false;
			}
		}return res;
	}
}


