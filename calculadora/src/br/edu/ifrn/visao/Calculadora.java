package br.edu.ifrn.visao;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame {
	
	public Calculadora() {
		
		organizarLayout();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(337, 540);
		setTitle("Calculator");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void organizarLayout() {
		
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(337, 138));
		add(display, BorderLayout.NORTH);
		
		
		Teclado teclado = new Teclado();
		teclado.setPreferredSize(new Dimension(337, 402));
		add(teclado, BorderLayout.CENTER);
	
	}

	public static void main(String[] args) {
		new Calculadora();
	}

}
