package collections.projetinho.controller;

public class CapacidadeMaximaException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "A capacidade máxima da estante ja foi atingida";
	}

}
