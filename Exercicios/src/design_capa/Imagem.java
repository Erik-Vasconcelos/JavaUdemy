package design_capa;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Imagem extends JFrame{
	public Imagem() {
		setVisible(true);
		setPreferredSize(new Dimension(200, 500));
		/*JLabel udemy = new JLabel();
		udemy.setIcon(new ImageIcon("D:/Java_Udemy/Exercicios/src/teste/JavaLogo.png"));	
		udemy.setVisible(true);
		add(udemy);*/
		
		JLabel logoJava = new JLabel();
		logoJava.setIcon(new ImageIcon("D:/Java_Udemy/Exercicios/src/design_capa/imagens/Udemy_logo.svg.png"));
		add(logoJava);
		setExtendedState(MAXIMIZED_BOTH);
		/*setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(141, 255));
		setLocationRelativeTo(null);
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setExtendedState(MAXIMIZED_BOTH);
		
		JPanel panel  =new JPanel();
		setLayout(new FlowLayout());
		panel.setLayout(layout);
		panel.setMaximumSize(new Dimension(1920, 1080));
		panel.setBackground(new Color(01, 01, 01));
		//panel.setPreferredSize(new Dimension(141, 255));
		panel.setPreferredSize(new Dimension(1250, 1920));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel);*/
		
		//Color colorWhite = new Color(255, 255, 255, 01);
	}
	
	public static void main(String[] args) {
		new Imagem();
	}
}
