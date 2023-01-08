package br.edu.ifrn.portal.lv.view.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifrn.portal.lv.view.cadastro_livro.PainelCadastroLivro;
import br.edu.ifrn.portal.lv.view.janela.Tela;

public class PainelMenu extends JPanel{
		
	public PainelMenu() {
		setPreferredSize(new Dimension(250, 535 ));
		setBackground(new Color(68, 114, 196));
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(layout);
		
		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 28);
		c.gridy = 0;
		c.insets = new Insets(20, 10, 30, 0);
		JLabel titulo = new JLabel("Sistema Livraria");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(fonte);
		add(titulo, c);
		
		BotaoMenu botao = new BotaoMenu("Cadastar Livro", e -> 
		Tela.painel.add(new PainelCadastroLivro(), BorderLayout.EAST));
			
		BotaoMenu botao2 = new BotaoMenu("Consultar Livro");
		BotaoMenu botao3 = new BotaoMenu("Vender Livro");
		BotaoMenu botao4 = new BotaoMenu("Listar todos livros");
		BotaoMenu botao5 = new BotaoMenu("Listar todas estantes");
		BotaoMenu botao6 = new BotaoMenu("Livro com maior preço");
		BotaoMenu botao7 = new BotaoMenu("Livro com menor preço");
		
		//botao.addActionListener(e -> {System.out.println("Funcionou!!");});
		c.fill= 1;
		c.gridy =1;
		c.insets = new Insets(20, 10, 0, 10);
		add(botao,c );
		c.insets = new Insets(5, 10, 0, 10);
		c.gridy =2;
		add(botao2,c );
		c.gridy =3;
		add(botao3,c );
		c.gridy =4;
		add(botao4,c );
		c.gridy =5;
		add(botao5,c );
		c.gridy =6;
		add(botao6,c );
		c.gridy =7;
		c.insets = new Insets(5, 10, 110, 10);
		add(botao7,c );
		
	}
	
	
	

}
