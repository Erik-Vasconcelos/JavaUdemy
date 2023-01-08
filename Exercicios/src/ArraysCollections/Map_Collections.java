package ArraysCollections;

import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;

public class Map_Collections {
	public static void main(String[] args) {
		
		/*   ===MAP===
		 * 
		 * •Chave/Valor
		 * • Chave não aceita repetição
		 * • Valor aceita repetição
		 */
		
		
		Map<Integer, String> usuarios = new HashMap<>();
		//nao existe o add no map
		usuarios.put(01, "Erik");//Adiciona como substitui o valor associado
		usuarios.put(02, "Erik");
		usuarios.put(03, "Erik");
		usuarios.put(04, "Joelson");
		usuarios.put(05, "Cleberson");
		usuarios.put(06, "Guilherme");
		usuarios.put(07, "Saulo");
		
		//substituindo...
		usuarios.put(03, "Vanderley");
		
		System.out.println(usuarios.entrySet());
		
		System.out.println(usuarios.size());
		
		//pega o valor pela a chave
		System.out.println(usuarios.get(03));
		
		//pega todas as chaves presentes na collection
		System.out.println(usuarios.keySet());
		//Verifica se contém a chave passada como parametro
		System.out.println(usuarios.containsKey(4));
		
		//pega todas os valores presentes na collection
		System.out.println(usuarios.values());
		//Verifica se contém o valor passada como parametro
		System.out.println(usuarios.containsValue("Erik"));
		
		//PERCORRENDO O MAP...
		
		System.out.println("\na partir da chave..");
		for(int chave: usuarios.keySet()) {
			System.out.println("Essa é a chave: "+chave);
		}
		
	
		System.out.println("\na partir do valor..");
		for(String valor: usuarios.values()) {
			System.out.println("Esse é o valor: "+valor);
		}
		
		System.out.println("\nUsando o Entry e imprimindo a chave e valor");
		for(Entry<Integer, String> registro: usuarios.entrySet()) {
			System.out.print(registro.getKey()+" ");
			System.out.println(registro.getValue());
		}
		
		
		System.out.println("\nremover usuario..");
		usuarios.remove(4);
		usuarios.remove(5, "Cleberson");
		
		for(Entry<Integer, String> registro: usuarios.entrySet()) {
			System.out.print(registro.getKey()+" ");
			System.out.println(registro.getValue());
		}
		
		
	}
}
