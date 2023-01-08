package br.com.marttech.sg.model.memoria;

import br.com.marttech.sg.model.perfis.abstracts.Servidor;

public class UsuarioEditadoMemory {
	private static Servidor servidor;
	
	public static void setServidor(Servidor servidor) {
		UsuarioEditadoMemory.servidor = servidor;
	}
	
	public static Servidor getInstance() {
		return UsuarioEditadoMemory.servidor;
	}
	
	public static boolean isValido() {
		if(servidor != null) return true;
		return false;
	}
	
	public static void resetMemory() {
		UsuarioEditadoMemory.servidor = null;
	}
}
