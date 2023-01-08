package classes;

public class Atribuicao {
	public static void main(String[] args) {
		
		int a = 2;
		int b =a;
		
		
		//VALOR
		//s�o valores independentes de modo que � feita uma c�pia
		System.out.println(a);
		System.out.println(b);
		System.out.println();
		
		a++;
		b--;
		System.out.println(a);
		System.out.println(b);
		
		
		//REFERENCIA
		//s�o valores que apontam para uma �rea de mem�ria de modo que 
		//se um valor � alterado em uma variavel, ela e percebida pela outra
		Produto p = new Produto();
		p.nome= "Celular";
		Produto p1 = p;
		
		System.out.println(p1.nome);
		p.nome = "Notebook";
		System.out.println(p1.nome);
		
		//p agora � um objeto independente
		p1 = new Produto();
		p1.nome = "Impressora";
		System.out.println(p1.nome);
		System.out.println(p.nome);
		
		/*se voce passar o objeto como parametro para um metodo e ele 
		for alterado, isso ser� permante, porque o que est� sendo passado
		� a referencia do objeto*/
		
		Produto.resetaProduto(p1);
		System.out.println(p1.nome);
		
		
		
	}
}
