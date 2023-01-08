package orientacao_obj.heranca.loja02;

public class Loja {
	
	void buscaProd(Produto p, Produto[] lista) {
		
		String res = "Produto não encontrado";
		for(Produto produto: lista) {
			if(produto.equals(p)) {
				res = produto.toString();
				System.out.println();
			}
		}
		System.out.println(res);
		
		
	}
	public static void main(String[] args) {
		
		Cd c1 = new Cd("Padre Zezinho", 5.0, 13, 2022100L);
		Cd c2 = new Cd("Padre Reginaldo", 16.0, 17, 2022101L);
		
		Livro l1 = new Livro("O Poder da Ação", 23.49, "Paulo Vieira",2022102L );
		Livro l2 = new Livro("Ágape", 17.47, "Padre Marcelo Rossi", 2022103L);
		
		Dvd dvd1 = new Dvd("Sonic", 8.18, 124, 2022104L);
		Dvd dvd2 = new Dvd("Maze Runner", 5.14, 98, 2022105L);
		
		Produto[] produtos = {c1, c2, l1, l2, dvd1, dvd2};
		
		for(Produto produto: produtos) {
			System.out.println(produto.toString());
		}
		
		Cd ct = new Cd("Padre Reginaldo", 16.0, 17, 2022101L);
		Cd ct2 = new Cd("Padre Reginaldo", 16.0, 17, 2022109L);
		
		
		Loja l =  new Loja();
		System.out.println();
		l.buscaProd(ct, produtos);
		l.buscaProd(ct2, produtos);
	}
}
