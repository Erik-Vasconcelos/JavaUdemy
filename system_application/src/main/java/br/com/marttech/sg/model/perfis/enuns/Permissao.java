package br.com.marttech.sg.model.perfis.enuns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Permissao {

	ADMINISTRADOR_GERAL(4),
	ADMINISTRADOR(3),
	GERENCIADOR_TURMA(2),
	USUARIO(1);

	private static List<Permissao> listaPermissoes = new ArrayList<>();
	private final int nivelPermissao;
	
	Permissao(int valor) {
		this.nivelPermissao = valor;
	}

	public int getNivelPermissao() {
		return nivelPermissao;
	}
	
	public static String getNiveisAbaixo(Permissao permissao) {
		listaPermissoes.addAll(Arrays.asList(ADMINISTRADOR_GERAL, ADMINISTRADOR, GERENCIADOR_TURMA, USUARIO));
		List<Permissao> permissoes = new ArrayList<>();
		
		listaPermissoes.stream().forEach(p -> {
			if(p.nivelPermissao < permissao.nivelPermissao) {
				permissoes.add(p);
			}
		});
		
		StringBuilder stringBusca = new StringBuilder();
		
		permissoes.stream().forEach(p -> {
			if(p.equals(permissoes.get(permissoes.size() -1))){
				stringBusca.append("\'" + p + "\' ");
				
			}else {
				stringBusca.append("\'" + p + "\', ");
			}
		});
		
		System.out.println("----" + stringBusca);
		return new String(stringBusca);
	}
	
}
