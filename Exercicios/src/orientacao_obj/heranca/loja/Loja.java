package orientacao_obj.heranca.loja;

public class Loja {
	public static void main(String[] args) {
		Cd c1 = new Cd("Padre Zezinho", 5.0, 13);
		Cd c2 = new Cd("Padre Reginaldo", 16.0, 17);
		
		Livro l1 = new Livro("O Poder da Ação", 23.49, "Paulo Vieira");
		Livro l2 = new Livro("Ágape", 17.47, "Padre Marcelo Rossi");
		
		Dvd dvd1 = new Dvd("Sonic", 8.18, 124);
		Dvd dvd2 = new Dvd("Maze Runner", 5.14, 98);
		
		Produto[] produtos = {c1, c2, l1, l2, dvd1, dvd2};
		
		for(Produto produto: produtos) {
			System.out.println(produto.toString());
		}
	}
}
