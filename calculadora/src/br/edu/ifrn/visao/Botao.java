package br.edu.ifrn.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton {

	public Botao(String texto, Color cor) {
		setText(texto);
		setOpaque(true);
		setFont(new Font("calibre", Font.PLAIN, 18));
		setForeground(Color.WHITE);
		setBackground(cor);
		setBorder(BorderFactory.createLineBorder(new Color(73,73,73)));
		
		
	}
}
