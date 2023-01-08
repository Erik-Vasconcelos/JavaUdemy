package Arrays_E_Collections.Collections;

import java.util.ArrayList;

public class List {
	public static void main(String[] args) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		Usuario u1 = new Usuario("Joao");
		
		lista.add(u1);
		
		lista.add(new Usuario("Erik"));
		lista.add(new Usuario("Manu"));
		lista.add(new Usuario("Bia"));
		
		System.out.println(lista.get(1).nome);
		System.out.println(lista.remove(new Usuario("Manu")));
		System.out.println("Tem? "+lista.contains(new Usuario("Bia")));
		for(Usuario u:lista) {
			System.out.println(u.nome);
		}
	}
}
