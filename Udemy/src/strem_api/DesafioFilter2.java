package strem_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter2 {
	public static void main(String[] args) {
		ProdutoDesafio2 p1 = new ProdutoDesafio2("Notebook", 5678.9, 0.40, true);
		ProdutoDesafio2 p2 = new ProdutoDesafio2("S21 Plus", 8678.9, 0.35, true);
		ProdutoDesafio2 p3 = new ProdutoDesafio2("M52", 1940, 0.20, false);
		ProdutoDesafio2 p4 = new ProdutoDesafio2("Ipad", 3456.8, 0.29, true);
		ProdutoDesafio2 p5 = new ProdutoDesafio2("Alienware", 15867, 0.65, false);
		ProdutoDesafio2 p6 = new ProdutoDesafio2("Iphone 13 Plus", 11634.9, 0.37, true);
		
		List<ProdutoDesafio2> produtos = Arrays.asList(p1,p2,p3,p4,p5,p6);

		
		Predicate<ProdutoDesafio2> maisde30 = p -> p.desconto >= 0.30;
		Predicate<ProdutoDesafio2> isFreteGratis = p -> p.freteGratis;
		Function<ProdutoDesafio2, String> sessaoOferta = p -> p.nome +" "+p.toString().format("%.2f",p.precoFinal()) + " Super Promoção!!!";
		
		produtos.stream().filter(maisde30).filter(isFreteGratis).map(sessaoOferta).forEach(System.out::println);
	}
}
