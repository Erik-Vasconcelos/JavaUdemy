package br.com.marttech.sg.view;

import java.io.InputStream;

public class ImageSearchEngine {

	public InputStream getImagem(String caminho) {
		return getClass().getResourceAsStream(caminho);
	}
}
