package Gui_Swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PainelLogin extends JPanel{
	
	public PainelLogin() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(layout);
		setPreferredSize(new Dimension(400, 390));
		setBackground(new Color(85, 85, 85));
		
		setForeground(Color.WHITE);
		Label lo = new Label("LOGAR");
		
		lo.setFont(new Font("Arial", ABORT, 30));
		Label l = new Label("Usuário ");
		
		//CampoArredondando usu = new CampoArredondando(25);
		JTextField usu = new JTextField();
		usu.setPreferredSize(new Dimension(250, 35));
		usu.setBackground(new Color(105,105,105));
		usu.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 14));
		usu.setForeground(Color.WHITE);
		usu.setBorder(BorderFactory.createBevelBorder(ABORT));
		
		Label s = new Label("Senha ");
		JPasswordField sen = new JPasswordField();
		sen.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 14));
		sen.setBorder(BorderFactory.createBevelBorder(ABORT));
		sen.setPreferredSize(new Dimension(250, 35));
		sen.setBackground(new Color(105,105,105));
		sen.setForeground(Color.WHITE);
		
		JCheckBox ch = new JCheckBox();
		ch.setBackground(new Color(105,105,105));
		//Label sal = new Label("Salvar meu Login");
		JButton botao = new JButton("ENTRAR");
		botao.setBackground(new Color(238, 138, 18));
		botao.setForeground(Color.WHITE);
		botao.setPreferredSize(new Dimension(250, 35));
		botao.setFont(new Font(TOOL_TIP_TEXT_KEY, ABORT, 16));
		botao.setBorder(BorderFactory.createBevelBorder(ABORT));
		
		c.insets = new Insets(0, 0, 40,0);
		add(lo, c);
		
		c.insets = new Insets(0, 0, 4,0);
		
		c.gridy =1;
		add(l ,c);
		
		c.gridy =2;
		add(usu, c);
		
		c.insets = new Insets(10, 0, 4,0);
		c.gridy =3;
		add(s, c);
		c.insets = new Insets(0, 0, 4,0);
		
		c.gridy= 4;
		add(sen, c);
		
		c.gridy =5;
		add(ch, c);
		//add(sal, c);
		
		c.gridy =6;
		c.insets = new Insets(10, 0, 4,0);
		add(botao, c);
		
		setVisible(true);
	}
	
}
