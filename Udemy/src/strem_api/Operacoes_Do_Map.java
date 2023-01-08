package strem_api;

import java.util.function.UnaryOperator;

public class Operacoes_Do_Map {

	public final static UnaryOperator<String> maiuscula = e -> e.toUpperCase();
	public final static UnaryOperator<String> primeiraLetra = e -> e.charAt(0) + "";
	
	public static String grito(String e ) {
		return  e+"!!! ";
	}
}
