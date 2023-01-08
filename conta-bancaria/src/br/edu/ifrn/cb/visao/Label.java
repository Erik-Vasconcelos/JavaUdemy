package br.edu.ifrn.cb.visao;

import javax.swing.JLabel;

import br.edu.ifrn.cb.modelo.ContaObservador;
import br.edu.ifrn.cb.modelo.Operacao;

public class Label extends JLabel implements ContaObservador{
	
	
	@Override
	public void atualizacaoOcorreu(Operacao operacao) {
		
		
	}
	

}
