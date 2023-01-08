package principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class Agenda {
	//private int sentinela = 0;
	//private Pessoa[] pessoas = new Pessoa[10];
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public void armazenarPessoa(String nome, Date dataNascimento, double altura) {
		pessoas.add(new Pessoa(nome, dataNascimento, altura));
	}
	
	public void removerPessoa(String nome) {
		Pessoa pessoa = buscarPessoa(nome);
		pessoas.remove(pessoa);
		if(pessoa != null) {
		}else {
			JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
		}
	}
	
	public int getPosicao(String nome) {
		Pessoa pessoa = buscarPessoa(nome);
		
		if(pessoa != null) {
			return pessoas.indexOf(pessoa);
		}
		JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
		return -1;
	}
	
	public void imprimirAgenda() {
		pessoas.forEach(System.out::println);
	}
	
	public void imprimirPessoa(int index) {
		System.out.println(pessoas.get(index));
	}
	
	private Pessoa buscarPessoa(String nome) {
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getNome().equals(nome)) {
				return pessoa;
			}
		}
		return null;
	}

}
