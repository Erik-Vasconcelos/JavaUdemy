package br.edu.ifrn.portal.lv.view.janela;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.ifrn.portal.lv.view.cadastro_livro.PainelCadastroLivro;

public class Tela extends JFrame{
	
	public static JPanel painel = new PainelPrincipal() ;
	public Tela() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(new Dimension(960, 540));
		setLayout(new BorderLayout());
		//painel = new PainelPrincipal();
		add(painel, BorderLayout.EAST);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		new Tela();
	}
}
