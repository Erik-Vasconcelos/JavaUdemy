package principal;

public class Empresario extends Pessoa implements Investidor, Economista{

	private double patrimonio;

	public Empresario(String nome, int peso, double patrimonio) {
		super(nome, peso);
		this.patrimonio = patrimonio;
		
	}

	@Override
	public void seApresentar() {
		System.out.println("Eu sou o "+getNome()+"E tenho "+patrimonio +" de patrimonio");
	}

	@Override
	public void guardarDinheiro(double valor) {
		this.patrimonio += valor;
	}

	@Override
	public void investir(double valor) {
		this.patrimonio -= valor;
		
	}

	@Override
	public void informarInvestimento() {
		System.out.println(patrimonio + "->" + patrimonio + (rentabilidade * patrimonio));
		
	}
	
}
