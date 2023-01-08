package br.edu.ifrn.portal.lv.view.janela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import br.edu.ifrn.portal.lv.view.cadastro_livro.PainelCadastroLivro;
import br.edu.ifrn.portal.lv.view.menu.PainelMenu;

public class PainelPrincipal extends JPanel{
	public static JPanel painelElemetos;
	
	public PainelPrincipal() {
		setPreferredSize(new Dimension(950, 535));
		setVisible(true);
		setLayout(new BorderLayout());
		setBackground(Color.GRAY);
		
		JMenuBar menu = new JMenuBar();
		JMenu m1 = new JMenu("Sistema");
		JMenu m2 = new JMenu("Cadastro");
		JMenuItem submenu = new JMenuItem("Novo Livro");
		
		m2.add(submenu);
		menu.add(m1);
		menu.add(m2);
		menu.setVisible(true);
		menu.setBackground(new Color(68, 114, 196));
		add(menu, BorderLayout.NORTH);
		PainelMenu opcoes = new PainelMenu();
		add(opcoes, BorderLayout.WEST);
		//painelElemetos.add(new PainelCadastroLivro(), BorderLayout.EAST);
		
		submenu.addActionListener(e -> add(new PainelCadastroLivro(), BorderLayout.EAST));
	}
	
	public JPanel getInstance() {
		return this;
	}
}
