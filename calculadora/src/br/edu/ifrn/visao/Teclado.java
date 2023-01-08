package br.edu.ifrn.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import br.edu.ifrn.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{
	
	private final Color FG_BRANCO = Color.WHITE;
	private final Color BG_CINCA_ESCURO = new Color(19,19,19);
	private final Color BG_ESCURO = new Color(6,6,6);
	private final Color BG_SELECIONADO = new Color(73, 73, 73);
	private final Color BG_BASE = new Color(31,31,31);
	
	public Teclado() {
		
		
		setBackground(new Color(31,31,31));
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
//		//c.gridx =4;
//		
//		JPanel painel = new JPanel();
//		painel.setBackground(BG_BASE);
//		
//		
//		add(painel, c);
//		painel.add(new Botao("MC", BG_BASE));
//		painel.add(new Botao("MR", BG_BASE));
//		painel.add(new Botao("M+", BG_BASE));
//		painel.add(new Botao("M-", BG_BASE));
//		painel.add(new Botao("MS", BG_BASE));
//		painel.add(new Botao("M", BG_BASE));
//		
//		c.gridx =1;
//		
		setLayout(layout);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx=1;
		c.weighty=1;
		
		
		/*adicionarBotao("MC", BG_BASE, c, 0, 0);
		adicionarBotao("MC", BG_BASE, c, 1, 0);
		adicionarBotao("MC", BG_BASE, c, 2, 0);
		adicionarBotao("MC", BG_BASE, c, 3, 0);
		adicionarBotao("MC", BG_BASE, c, 4, 0);
		adicionarBotao("MC", BG_BASE, c, 5, 0);*/
		
		//Linha 1
		
		adicionarBotao("%", BG_CINCA_ESCURO, c, 0, 1);
		adicionarBotao("CE", BG_CINCA_ESCURO, c, 1, 1);
		adicionarBotao("C", BG_CINCA_ESCURO, c, 2, 1);
		adicionarBotao("⌫", BG_CINCA_ESCURO, c, 3, 1);
		
		//Linha 2
		adicionarBotao("1/X", BG_CINCA_ESCURO, c, 0, 2);
		adicionarBotao("x²", BG_CINCA_ESCURO, c, 1, 2);
		adicionarBotao("2/x", BG_CINCA_ESCURO, c, 2, 2);
		adicionarBotao("÷", BG_CINCA_ESCURO, c, 3, 2);
		
		//Linha 3
		adicionarBotao("7", BG_ESCURO, c, 0, 3);
		adicionarBotao("8", BG_ESCURO, c, 1, 3);
		adicionarBotao("9", BG_ESCURO, c, 2, 3);
		adicionarBotao("x", BG_CINCA_ESCURO, c, 3, 3);
		
		//Linha 4
		adicionarBotao("4", BG_ESCURO, c, 0, 4);
		adicionarBotao("5", BG_ESCURO, c, 1, 4);
		adicionarBotao("6", BG_ESCURO, c, 2, 4);
		adicionarBotao("-", BG_CINCA_ESCURO, c, 3, 4);
		
		//Linha 5
		adicionarBotao("1", BG_ESCURO, c, 0, 5);
		adicionarBotao("2", BG_ESCURO, c, 1, 5);
		adicionarBotao("3", BG_ESCURO, c, 2, 5);
		adicionarBotao("+", BG_CINCA_ESCURO, c, 3, 5);
		
		//Linha 6
		adicionarBotao("±", BG_ESCURO, c, 0, 6);
		adicionarBotao("0", BG_ESCURO, c, 1, 6);
		adicionarBotao(",", BG_ESCURO, c, 2, 6);
		adicionarBotao("=", BG_CINCA_ESCURO, c, 3, 6);
		
		
		
//		c.gridy =0;
//		c.gridx =0;
//		add(new Botao("%", BG_CINCA_ESCURO), c);
//		
//		c.gridx=1;
//		add(new Botao("CE", BG_CINCA_ESCURO ), c);
//		c.gridx=2;
//		add(new Botao("C", BG_CINCA_ESCURO ), c);
//		add(new Botao("⌫", BG_CINCA_ESCURO ), c);
//		
//		add(new Botao("1/X", BG_CINCA_ESCURO ), c);
//		add(new Botao("x²", BG_CINCA_ESCURO ), c);
//		add(new Botao("2/x", BG_CINCA_ESCURO ), c);
//		add(new Botao("÷", BG_CINCA_ESCURO ), c);
//		
//		add(new Botao("7", BG_ESCURO), c);
//		add(new Botao("8", BG_ESCURO), c);
//		add(new Botao("9", BG_ESCURO), c);
//		add(new Botao("×", BG_CINCA_ESCURO), c);
//		
//		add(new Botao("4", BG_ESCURO), c);
//		add(new Botao("5", BG_ESCURO), c);
//		add(new Botao("6", BG_ESCURO), c);
//		add(new Botao("-", BG_CINCA_ESCURO), c);
//		
//		add(new Botao("1", BG_ESCURO), c);
//		add(new Botao("2", BG_ESCURO));
//		add(new Botao("3", BG_ESCURO), c);
//		add(new Botao("+", BG_CINCA_ESCURO), c);
//		
//		add(new Botao("±", BG_ESCURO), c);
//		add(new Botao("0", BG_ESCURO), c);
//		add(new Botao(",", BG_ESCURO), c);
//		add(new Botao("=", BG_CINCA_ESCURO), c);
		setBorder(BorderFactory.createLineBorder(new Color(73,73,73)));
		
	}

	
	private void adicionarBotao(String texto, Color cor,
		GridBagConstraints c, int x, int y) {
		c.gridy= y;
		c.gridx = x;
		
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		
		add(botao, c);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			
			JButton botao = (JButton)e.getSource();
			
			Memoria.getMemoryInstanci().processarComandos(botao.getText());
		}
		
	}

	
}
