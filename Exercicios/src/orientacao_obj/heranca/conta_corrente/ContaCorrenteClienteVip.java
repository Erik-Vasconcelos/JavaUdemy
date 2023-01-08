package orientacao_obj.heranca.conta_corrente;

public class ContaCorrenteClienteVip extends ContaCorrente {
	
	public ContaCorrenteClienteVip(double saldo) {
		super(saldo, 0.01);
	}
	
	public static void main(String[] args) {
		ContaCorrenteClienteVip clienteVip = new ContaCorrenteClienteVip(1000);
	}
}
