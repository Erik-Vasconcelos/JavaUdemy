package design_capa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Design extends JFrame {
	
	JPanel panel  =new JPanel();
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();
	
	public Design() {
		initComponents();
	}
		
	private void initComponents() {
		configPanel();
		c.insets = new Insets(20, 30, 5, 550);
		c.gridy=1;
		JLabel logo1 = new JLabel();
		
		logo1.setIcon(new ImageIcon("/cursoemvideo-logo.png"));
		panel.add(logo1);
		
		JLabel logo2 = new JLabel();
		logo2.setIcon(new ImageIcon("Udemy_logo.svg.png"));
		panel.add(logo2);
		
		c.gridy =2;
		c.insets = new Insets(20,  42,  5, 90);
		Label title = new Label("APRENDENDO A PROGRAMAR");
		title.setFont(new Font("Antonio Bold", Font.BOLD, 73));
		panel.add(title, c);
		
		c.gridy = 3;
		c.insets = new Insets(10,  42,  100, 0);
		Label subTitulo = new Label("Uma viagem ao mundo do Software");
		subTitulo.setFont(new Font("29LT Makina", Font.PLAIN, 52));
		panel.add(subTitulo, c);
		
		c.gridy= 4;
		c.insets = new Insets(10,  42,  500, 0);
		JLabel logoJava = new JLabel();
		logoJava.setIcon(new ImageIcon("/javaLogo.png"));
		panel.add(logoJava, c);
		
		c.gridy=5;
		Label name = new Label("Erik Vasconcelos");
		panel.add(name, c);
		
	}
	
	private void configJFrame() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(new Dimension(141, 255));
		setLocationRelativeTo(null);
		//setExtendedState(MAXIMIZED_BOTH);
	}
	
	/*logoJava.setIcon(new ImageIcon("D:/Java_Udemy/Exercicios/src/design_capa/imagens/javaLogo.png"));
	 * logo1.setIcon(new ImageIcon("D:/Java_Udemy/Exercicios/src/design_capa/imagens/cursoemvideo-logo.png"));
	logo2.setIcon(new ImageIcon("D:/Java_Udemy/Exercicios/src/design_capa/imagens/Udemy_logo.svg.png"));*/
	private void configPanel() {
		configJFrame();
		panel.setLayout(layout);
		panel.setMaximumSize(new Dimension(1920, 1080));
		panel.setBackground(new Color(01, 01, 01));
		panel.setPreferredSize(new Dimension(1250, 1920));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setForeground(Color.WHITE);
		add(panel);
	}
	private JPanel getPanel() {
		return panel;
	}

	public static void main(String[] args) {
		new Design();
	}
}
