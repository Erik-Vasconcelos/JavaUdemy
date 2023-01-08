package br.com.marttech.sg.model.memoria;

import br.com.marttech.sg.model.perfis.abstracts.Servidor;

public class ServidorMemory {
	
	private static Servidor servidor;
	
	public static void setServidor(Servidor servidor) {
		ServidorMemory.servidor = servidor;
	}
	
	public static Servidor getInstance() {
		return ServidorMemory.servidor;
	}
	
	public static boolean isValido() {
		if(servidor != null) return true;
		return false;
	}
	
	public static void resetMemory() {
		ServidorMemory.servidor = null;
	}

}
