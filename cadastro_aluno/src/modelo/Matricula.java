package modelo;

public class Matricula {
	
	static private Long matriBase= 2022113401000L;
	
	long mat = 20201134010009L;
	
	Matricula(){
		++matriBase;
	}
	
	Long getMat() {
		return matriBase;
	}
	
	static Long mBase() {
		return matriBase;
	}
}

