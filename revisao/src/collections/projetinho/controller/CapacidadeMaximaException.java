package collections.projetinho.controller;

public class CapacidadeMaximaException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "A capacidade m�xima da estante ja foi atingida";
	}

}
