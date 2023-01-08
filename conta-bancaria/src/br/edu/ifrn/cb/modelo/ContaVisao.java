package br.edu.ifrn.cb.modelo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContaVisao extends JPanel{
	private Conta conta;
	
	private JLabel nomeCli = new JLabel();
	private JLabel saldo= new JLabel();
	
	private JButton sacar = new JButton();
	private JButton depositar = new JButton();
	private JButton tranferir = new JButton();
	
	
	public ContaVisao(Conta conta) {
		this.conta=conta;
	}
	
	private void organizarLayout() {
		setVisible(true);
		
	}
	
	
	
	public void atualizarSaldo() {
		saldo.setText(Double.toString(conta.getSaldo()));
	}
	
	
	public void atualizarNome() {
		nomeCli.setText(conta.getCliente().getNome());
	}

}
