package fundamentos;

import javax.swing.JOptionPane;

public class DesafioCalculadora {
	public static void main(String[] args) {
		
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um n�mero: "));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite um n�mero: "));
		String op  = JOptionPane.showInputDialog("Digite a opera��o: ");
		
		int result = op.equals("+")?n1+n2: op.equals("-")?n1-n2 :op.equals("*")? n1*n2:op.equals("/")? n1/n2:op.equals("%")?n1%n2: 0*(n1+n2);
		
		JOptionPane.showMessageDialog(null,String.format("%d %s %d = %d", n1,op, n2,result), "Resultado",JOptionPane.WARNING_MESSAGE);
	}
}
