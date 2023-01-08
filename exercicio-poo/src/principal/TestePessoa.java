package principal;

import java.util.Date;

public class TestePessoa {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa("João", new Date("2005/06/15"), 1.78);
		
		System.out.println(pessoa.toString());
		System.out.println(pessoa.calcularIdade());
	}
}
