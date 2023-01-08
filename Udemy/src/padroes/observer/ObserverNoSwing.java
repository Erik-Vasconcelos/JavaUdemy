package padroes.observer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ObserverNoSwing {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Observador");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);/*ao clicar o X 
		de sair termina toda a aplicação*/
		janela.setSize(600, 300);
		janela.setLayout(new FlowLayout());//define o layout
		janela.setLocationRelativeTo(null);//centraliza na tela
		
		JButton botao = new JButton("Clicar");
		janela.add(botao);
		
		
		JLabel label = new JLabel();
		janela.add(label);
		
//		botao.addActionListener(new ActionListener() {
//			//ActionListener() é uma interface funcional
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				label.setText("O evento ocorreu! ");
//				System.out.println("O evento ocorreu! ");
//				
//			}
//		});
		
		//Outra forma de adicinar uma evento com Lambda expression
		botao.addActionListener(e -> {System.out.println("O evento ocorreu! "); 
		label.setText("O evento ocorreu2");});
		
		
		janela.setVisible(true);//Visibilidade da janela
	}
}
