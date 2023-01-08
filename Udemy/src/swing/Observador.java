package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Observador {
	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Observador");
		
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//no momento do clique em sair da aplicação termina o programa
		
		janela.setSize(400, 500);//define as dimensoes da janela
		
		janela.setLayout(new FlowLayout());/*Está definindo um Laout simples... , Caso o layout não esteja
		definido o botao adicionado mais abaixo ocupará a tela inteira do programa*/
		
		janela.setLocationRelativeTo(null); /*define a o local onde a janela irá abrir, 
		nesse caso que está null ela abrirá centralizada em relação ao centro da tela*/
		
		JButton botao = new JButton("Click");
		janela.add(botao);
		
		JLabel texto = new JLabel();
		texto.setSize(40, 80);
		
		texto.setVisible(true);
		janela.add(texto);
		
		botao.addActionListener(new ActionListener() {
			int cont=1;
			@Override
			public void actionPerformed(ActionEvent e) {
				
				texto.setText("Evento ocorreu!!!"+cont);
				cont++;
				//System.out.println();
				
			}
		});
		
		//Ou pode ser passado uma lambda expression 
		//botao.addActionListener(e-> System.out.println("Evento ocorreu!!! "));
		
		
		janela.setVisible(true);//Visibilidade da janela
	}
}
