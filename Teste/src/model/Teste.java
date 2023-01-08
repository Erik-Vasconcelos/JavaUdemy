package model;

import javax.swing.JOptionPane;

public class Teste {

	int[][] matriz = new int [2][2];
	
	
	public void inserir() {
		
		for (int i = 0; i < 2; i++) {
			
			for (int j = 0; j < 2; j++) {
				matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero:"));
			}
		}
	}
	
	
	public String imprimir() {
		String result = "";
		for (int i = 0; i < 2; i++) {
			
			for (int j = 0; j < 2; j++) {
				if(matriz[i][j] > 8){
					
					result += String.format("matriz[%d][%d] = %d, ", i, j, matriz[i][j]);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Teste teste = new Teste();
		
		/*teste.inserir();
		
		JOptionPane.showMessageDialog(null, teste.imprimir());*/
		
		teste.teste(8,8, 8);
		
	}
	
	public void teste(int n1, int n2, int n3){
		
		if(n1 == n2 && n1 == n3) {
			System.out.println("Equilátero");
		}
		
		else if(n1==n2 || n2 == n3 || n1 ==n3){
			
		}
	}
}
