package br.edu.ifrn.portal.pr.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BaseBinario {

	private static Map<Character, String> alfabetoBinario = new HashMap<>();
	
	private BaseBinario() {
	}
	
	private static void adicionar() {
		alfabetoBinario.put('A', "01000001");
		alfabetoBinario.put('R', "01010010");
		alfabetoBinario.put('O', "01001111");
		alfabetoBinario.put('Z', "01011010");
	}                                    
	
	public static String procurar(Character valor) {
		adicionar();
		String value ="";
		if(alfabetoBinario.containsKey(valor)) {
			for (Map.Entry<Character, String > entry : alfabetoBinario.entrySet()) {
				if(valor.equals(entry.getKey())){
					value = entry.getValue();
					break;
				}
			}
		}
		return value;	
	}
		
	public static String[] getBinario(String sequencia) {
		adicionar();
		String[] bytes = new String[sequencia.length()];
		String conjunto = "";
		for (int i = 0; i < sequencia.length(); i++) {
			 conjunto += procurar(sequencia.charAt(i));
			 bytes[i] = conjunto;
			 conjunto = "";
		}
		return bytes;
	}
		
}
