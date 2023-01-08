package br.edu.ifrn.portal.pr.model;

import java.security.SecureRandom;

public class Gerador {
	
	private Gerador() {
	}
	
	public static int[] fabricarBits(int quantidade) {
		
		int[] bytes = new int[2];
		
		int[] bits = new int[quantidade];
		SecureRandom random = new SecureRandom();
		Integer numero = 0;
		
		for (int i = 0; i < bytes.length; i++) {
			for (int j =0; j < bits.length; j++) {
				numero = Integer.parseInt(numero.toString() + "" + random.nextInt(0, 2));
			}
		
			bytes[i] = numero;
			numero = 0;
		}
		
		return bytes;
	}
	
	
}
