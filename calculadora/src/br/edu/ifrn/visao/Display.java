package br.edu.ifrn.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifrn.modelo.Memoria;
import br.edu.ifrn.modelo.MemoriaObservador;

public class Display extends JPanel implements MemoriaObservador {
	private final JLabel label;
	
	public Display() {
		
		Memoria.getMemoryInstanci().registrarObservador(this);
		label= new JLabel(Memoria.getMemoryInstanci().getTextoAtual());
		setBackground(new Color(31,31,31));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Calibre", Font.BOLD, 50));
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 62));
	
		add(label);
	}

	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
		
	}
	
	
}
