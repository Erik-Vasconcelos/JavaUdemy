package Gui_Swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PainelGeral extends JPanel{
	public PainelGeral() {
		setLayout(new FlowLayout());
		add(new PainelLogin(), BorderLayout.CENTER);

		
		setVisible(true);
	}
}
