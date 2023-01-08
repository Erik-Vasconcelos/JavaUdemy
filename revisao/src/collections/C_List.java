package collections;

import java.util.ArrayList;
import java.util.List;

import classes_e_metodos.Date;

public class C_List {
	public static void main(String[] args) {

		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Erik", new Date(14, 05, 2000)));
		
		pessoas.add(new Pessoa("Riam", new Date(25, 04, 2007)));
		pessoas.add(new Pessoa("Paulo", new Date(13, 12, 2009)));
		pessoas.forEach(e -> System.out.println(e.toString()));
	}
}
