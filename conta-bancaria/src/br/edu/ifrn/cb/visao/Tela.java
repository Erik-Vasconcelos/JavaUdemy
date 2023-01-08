package br.edu.ifrn.cb.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Tela extends JFrame{
	
	public Tela() {
		BorderLayout layout = new BorderLayout();
		//setLayout(new FlowLayout( FlowLayout.CENTER, 250, 230));
		JMenuBar menu = new JMenuBar();
		menu.setVisible(true);
		JMenu m = new JMenu("Cadastrar");
		m.setVisible(true);
		menu.add(m);
		
		add(menu);
		
		
		setLayout(layout);
		setVisible(true);
		setLocationRelativeTo(null);
		//add(new PainelLogin(), BorderLayout.CENTER);
		//add(new PainelLogin());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new Tela();
	}

}
