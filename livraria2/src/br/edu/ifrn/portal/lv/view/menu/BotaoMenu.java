package br.edu.ifrn.portal.lv.view.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotaoMenu extends JButton{
	
	
	public BotaoMenu(String titulo) {
		setText(titulo);
		setPreferredSize(new Dimension(220, 35));
		setOpaque(false);
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
		setFont(new Font(Font.SANS_SERIF , Font.PLAIN, 15));
		//setBorderPainted(false);
	}
	public BotaoMenu(String titulo, ActionListener acao) {
		this(titulo);
		addActionListener(acao);
	}
	
	public BotaoMenu(String titulo, Dimension dimensao) {
		this(titulo);
		setPreferredSize(new Dimension(dimensao));
	}
	
	public BotaoMenu(String titulo, Dimension dimensao, Color cor) {
		this(titulo, dimensao);
		setForeground(cor);
	}
	
	public BotaoMenu(String titulo, String caminhoIcone, Dimension dimensao) {
		setText(titulo);
		ImageIcon icone = new ImageIcon(caminhoIcone);
		setIcon(icone);
		setPreferredSize(dimensao);
		
	}
	public BotaoMenu(String titulo, String caminhoIcone, Dimension dimensao, Color cor) {
		setText(titulo);
		ImageIcon icone = new ImageIcon(caminhoIcone);
		setIcon(icone);
		setPreferredSize(dimensao);
		setBackground(cor);
		
	}

}
