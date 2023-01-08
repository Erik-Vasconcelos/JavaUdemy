package collections;

import javax.swing.JOptionPane;

public class C_PilhaTest {
	public static void main(String[] args) {
		
		C_Pilha pilha  = new C_Pilha();
		
		String nome = "";
		while(!"sair".equalsIgnoreCase(nome)) {
			nome = JOptionPane.showInputDialog("Digite o nome do livro: ");
			if(!"sair".equalsIgnoreCase(nome)) {
				String nomeAutor = JOptionPane.showInputDialog("Digite o nome do autor: ");
				pilha.adicionarLivro(new Livro(nome, nomeAutor));
				System.out.println("Livro adicionado!!");
			}
		}
		
		System.out.println(pilha.listaLivros());
	}
}
