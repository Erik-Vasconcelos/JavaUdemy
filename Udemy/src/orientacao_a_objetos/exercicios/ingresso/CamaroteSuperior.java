package orientacao_a_objetos.exercicios.ingresso;

public class CamaroteSuperior extends Vip{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		super.setTipoIngresso("Camarote superior");
		return super.toString();
	}
	
	
	/*public String local() {
		return this.local;
	}*/
	
	@Override
	public int imprimeValor() {
		
		super.setValorAdicional(30);
		
		return super.imprimeValor() ;
	}
	
}
