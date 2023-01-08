package br.edu.ifrn.portal.lv.view.cadastro_livro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import br.edu.ifrn.portal.lv.model.Estante;


public class PainelCadastroLivro extends JPanel {
	private JTextField isbn;
	private JComboBox<Estante> estante;
	//private JComboBox<? extends Livro> categoria;
	private JComboBox<String> categoria;
	private JTextField titulo;
	private JSpinner anoPublicacao;
	private JTextField autor;
	private JTextField valor;
	private JButton cadastro;
	private Label lConfir;
	
	public PainelCadastroLivro() {
		setPreferredSize(new Dimension(705, 530));
		setBackground(new Color(224, 224, 224));
		setSize(new Dimension(800, 500));
		setVisible(true);
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c= new GridBagConstraints();
		setLayout(layout);
		setFont(new Font("Arial", Font.BOLD, 18));
		setForeground(Color.BLACK);
		
		Label lIsbn = construirLabel("*Isbn");
		Label lEstante = construirLabel("*Estante");
		Label lTitulo = construirLabel("*Título");
		Label lAnoPubli = construirLabel("Ano");
		Label lAutor = construirLabel("*Autor");
		Label lValor = construirLabel("*Valor R$: ");
		Label lCatego = construirLabel("*Categoria ");
		
		isbn = construirTesxtFild(new Dimension(50, 30));
		titulo = construirTesxtFild(new Dimension(500, 30));
		autor = construirTesxtFild(new Dimension(70, 30));
		valor = construirTesxtFild(new Dimension(70, 30));
		
		estante = new JComboBox<>(); 
		estante.addItem(new Estante(10, 1L));
		estante.addItem(new Estante(10, 2L));
		categoria = new JComboBox<>(); 
		categoria.addItem("Informatica");
		categoria.addItem("Matemática");
		SpinnerNumberModel model = new SpinnerNumberModel();
		anoPublicacao = new JSpinner(model);
		
		cadastro = new JButton("Cadastrar");
		cadastro.setSize(new Dimension(70, 25));
		cadastro.setBackground(new Color(68, 114, 196));
		
		JLabel label = construirLabel(" Novo Livro", 42);
		ImageIcon imagem = new ImageIcon("C:/Users/erikv/Downloads/novo .png");
		label.setIcon(imagem);
		
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = 3;
		add(label, c);
		c.gridwidth = 1;
		
		c.insets= new Insets(5, 20, 5, 10);
		c.weighty= 1;
		c.weightx =1;
		c.gridy = 1;
		c.gridx = 1;
		add(lIsbn, c);
		c.gridx = 2;
		add(lEstante, c);
		c.gridx = 3;
		add(lCatego, c);
		c.insets= new Insets(2, 20, 5, 10);
		
		c.fill =1;
		c.gridy = 2;
		c.gridx = 1;
		add(isbn, c);
		c.gridx = 2;
		add(estante, c);
		c.gridx = 3;
		add(categoria, c);
		
		
		c.insets= new Insets(20, 20, 5, 10);
		c.gridx = 1;
		c.gridy = 3;
		add(lTitulo, c);
		
		c.insets= new Insets(2, 20, 5, 10);
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 3;
		add(titulo, c);
		c.weightx = 1;
		
		c.gridwidth = 1;
		c.insets= new Insets(10, 20, 5, 10);
		c.gridx = 1;
		c.gridy = 5;
		add(lAnoPubli, c);
		c.gridx = 2;
		add(lAutor, c);
		
		c.gridy = 6;
		c.gridx = 1;
		add(anoPublicacao, c);
		c.gridx = 2;
		c.gridwidth = 2;
		add(autor, c);
		c.gridwidth = 1;
		
		c.gridx = 1;
		c.gridy = 7;
		add(lValor, c);
		
		c.gridy = 8;
		c.gridx = 1;
		add(valor, c);
		
		c.gridy = 9;
		c.gridx = 3;
		c.insets= new Insets(10, 20, 35, 40);
		add(cadastro, c);
		
	}
	
	private Label construirLabel(String nome) {
		Label label = new Label(nome);
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		
		label.setForeground(Color.BLACK);
		return label;
	}
	private JLabel construirLabel(String nome, int tamanhoFont) {
		JLabel label = new JLabel(nome);
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, tamanhoFont));
		label.setForeground(Color.BLACK);
		return label;
	}
	
	private JTextField construirTesxtFild(Dimension dimensao) {
		JTextField campoTexto = new JTextField();
		campoTexto.setFont(new Font("Courier New", Font.PLAIN, 16));
		if(dimensao instanceof Dimension) {
			campoTexto.setSize(dimensao);
		}else {
			campoTexto.setSize(new Dimension(150, 45));
		}
		campoTexto.setVisible(true);
		
		return campoTexto;
	}

}
