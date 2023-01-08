package Gui_Swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import br.edu.ifrn.cb.modelo.Cadastro;

@SuppressWarnings("serial")
public class TelaCadastro extends JFrame{
	JTextField nomeUsu;
	JTextField cpfUsu;
	JTextField dataNas;
	JTextField emailUsu;
	JTextField senhaUsu;
	JTextField conSenhaUsu;
	JButton confirmar;
	
	Label lConfir;
	
	public TelaCadastro() {
		setTitle("Cadastrar Novo Cliente");
		setSize(new Dimension(800, 500));
		setVisible(true);
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c= new GridBagConstraints();
		setLayout(layout);
		setFont(new Font("Arial", ABORT, 18));
		
		Label lN = new Label("Nome do Cliente*");
		Label lCpf = new Label("CPF*");
		Label lD = new Label("Data de nascimento*");
		Label lE = new Label("E-mail*");
		Label lS = new Label("Senha*");
		Label lCs = new Label("Confirmar Senha*");
		lConfir = new Label();
		lConfir.setVisible(true);
		lConfir.setPreferredSize(new Dimension(100, 30));
		
		
		
		nomeUsu = new JTextField();
		nomeUsu.setVisible(true);
		nomeUsu.setPreferredSize(new Dimension(400, 30));
		
		cpfUsu = new JTextField();
		cpfUsu.setPreferredSize(new Dimension(130, 30));
		
		dataNas = new JTextField();
		dataNas.setPreferredSize(new Dimension(120, 30));
		
		emailUsu = new JTextField();
		emailUsu.setPreferredSize(new Dimension(500, 30));
		
		senhaUsu = new JTextField();
		senhaUsu.setPreferredSize(new Dimension(200, 30));
		
		conSenhaUsu = new JTextField();
		conSenhaUsu.setPreferredSize(new Dimension(200, 30));
		
		confirmar = new JButton("Criar Conta");
	
		confirmar.addActionListener(e-> {lConfir.setText(Cadastro.cadastrar(nomeUsu.getText(), dataNas.getText(), new Date(1970, 1, 1),
		emailUsu.getText(), senhaUsu.getText())); limparDados();} );
		
		c.insets= new Insets(0, 0, 10, 0);
		add(lN, c);
		add(nomeUsu, c);
		add(lCpf, c);
		add(cpfUsu, c);
		c.gridy =1;
		add(lD, c);
		add(dataNas, c);
		c.gridy =2;
		add(lE, c);
		add(emailUsu, c);
		c.gridy =3;
		add(lS, c);
		add(senhaUsu, c);
		c.gridy =4;
		add(lCs,c);
		add(conSenhaUsu, c);
		c.gridwidth=1;
		c.gridx=1;
		c.gridy =5;
		c.insets= new Insets(20, 0, 10, 0);
		add(confirmar, c);
		c.gridy =6;
		add(lConfir,c);
	}
	
	
	public void setFuncaoBotao() {
		confirmar.addActionListener(e-> {lConfir.setText(Cadastro.cadastrar(nomeUsu.getText(), cpfUsu.getText(), new Date(1970, 1, 1),
				emailUsu.getText(), senhaUsu.getText())); limparDados(); } );
	}
	
	public void limparDados() {
		nomeUsu.setText("");
		cpfUsu.setText("");
		dataNas.setText("");
		emailUsu.setText("");
		senhaUsu.setText("");
		lConfir.setText("");
		//lConfir.setText("");
	}
	
	
}
