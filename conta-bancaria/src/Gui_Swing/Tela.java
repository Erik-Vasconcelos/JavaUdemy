package Gui_Swing;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Tela extends JFrame{

	public Tela() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 200 ));
		JMenuBar menu = new JMenuBar();
//		ImageIcon img = new ImageIcon(getClass().getResource("\"C:\\Users\\Erik Vasconcelos\\Downloads\\Desktop Wallpaper Wallpaper Aesthetic Backgrounds.jfif\""));
//		
//		setIconImage()

		JMenu m = new JMenu("Login");
		JMenu m2 = new JMenu("Cadastro");
		JMenuItem c = new JMenuItem("Nova Conta", KeyEvent.VK_N);
		c.addActionListener(e-> new TelaCadastro().setLocationRelativeTo(menu));
		m2.add(c);
		menu.add(m);
		menu.add(m2);
		setJMenuBar(menu);
	
		add(new PainelLogin());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Tela();
	}
}
