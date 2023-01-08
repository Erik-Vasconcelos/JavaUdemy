package orientacao_obj.heranca;

public class Ferrari extends Carro{
	

	Ferrari( int VELOCIDADEMAXIMA) {
		super(VELOCIDADEMAXIMA);
		
	}
	
	@Override
	void acelerar() {
		super.setVelociadeAtual(25+getVelociadeAtual());;
	}

}
