package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.model.memoria.ServidorMemory;

public class MenuController {
	
	public static ServidorDTO getDadosContent() {
		ServidorDTO servidor  =new ServidorDTO(
				ServidorMemory.getInstance().getNome(),
				ServidorMemory.getInstance().getImagem()
		);
		
		return servidor;
	}

}
