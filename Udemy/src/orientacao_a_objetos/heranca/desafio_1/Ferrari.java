package orientacao_a_objetos.heranca.desafio_1;

public class Ferrari extends Carro implements Esportivo, Luxo{
	
	boolean ligarTurbo;
	boolean ligarAr;
	//implementando os métodos exigidos pela a interface Esportivo
	@Override
	public void ligarTurbo() {
		ligarTurbo =true;
		
	}
	@Override
	public void desligarTurbo() {
		ligarTurbo= false;
		
	}
	
	//implementando os métodos exigidos pela a interface Luxo
	@Override
	public void ligarAr() {
		ligarAr=true;
		
	}
	@Override
	public void deligarAr() {
		ligarAr=false;
		
		
	}
	@Override
	public int getDelta() {
		if(ligarTurbo && !ligarAr) {
			return 35;
		}else if(ligarTurbo && ligarAr) {
			return 30;
		}else if(!ligarTurbo && !ligarAr){
			return 20;
		}else {
			return 15;
		}
	}
	
	
	//Construtor padrão que chama o de baixo
	public Ferrari(){
		this(300);
	}
	
	public Ferrari(int veloMaxima){
		super(veloMaxima);
		setDelta(veloMaxima);
	}
	
	/* o @Override serve parea voce criar uma validação para ter certeza que voces está
	sobrescrevendo um metodo mas não é obrigatório*/
	//@Override
//	void acelerar() {
//		super.acelerar();
//		super.acelerar();
//		super.acelerar();
//		
		// 2 forma:
		//velocidadeAtual+=15;
	}


