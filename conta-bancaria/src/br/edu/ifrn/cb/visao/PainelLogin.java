package br.edu.ifrn.cb.visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout.Constraints;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PainelLogin extends JPanel {
	public PainelLogin() {
		setPreferredSize(new Dimension(500, 520));
		setVisible(true);
		//setBackground(Color.GRAY);
		
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(layout);
		setBorder(BorderFactory.createBevelBorder(2));
	
		JLabel lo = new JLabel("Login ");
		lo.setFont(new Font("Arial", ALLBITS, 32));
		
		JLabel l = new JLabel("Conta* ");
		l.setFont(new Font("Arial", 3, 16));
		l.setForeground(Color.RED);
		//l.setHorizontalTextPosition(SwingConstants.LEFT);
	
		
		JTextField nConta = new JTextField();
		nConta.setFont(new Font("Arial", ABORT, 20));
		
		nConta.setVisible(true);
		nConta.setPreferredSize(new Dimension(300,40));
	
		JLabel ls = new JLabel("Senha*");
		ls.setAlignmentY(HEIGHT);;
		ls.setFont(new Font("Arial", ABORT, 16));
		ls.setForeground(Color.RED);
		
		JPasswordField senha = new JPasswordField();
		senha.setFont(new Font("Arial", ABORT, 20));
		senha.setPreferredSize(new Dimension(300,40));
		senha.setVisible(true);
		
		JButton botao = new JButton("LOGIN");
		botao.setVisible(true);
		botao.setPreferredSize(new Dimension(150, 36));
		botao.setBackground(new Color(255, 95, 11));
		botao.setForeground(Color.WHITE);
		botao.setFont(new Font("Arial", ERROR, 15));
		
		c.insets =  new Insets(0 ,0 , 40, 0);
		add(lo, c);
		
		c.gridy =1;
		c.insets=new Insets(10, 0, 3, 0);
		
		add(l, c);
		c.gridy=2;
		c.insets=new Insets(5, 0, 3, 0);
		add(nConta, c);
		
		c.insets=new Insets(15, 0, 3, 0);
		c.gridy=3;
		add(ls, c);
		c.insets=new Insets(5, 0, 3, 0);
		c.gridy=4;
		add(senha, c);
		c.insets=new Insets(15, 0, 3, 0);
		c.gridy=5;
		add(botao, c);
		
	}
}
