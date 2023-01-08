package classes;

import java.util.Objects;

public class Produto {
		static String donaDoProduto = "Magalu";
		public String nome;
		double preco;
		double desconto;

		//Construtor padrão
		public Produto() {
		}
		
		//Construtor que recebe os parametros para preencher os atributos
		//OBS: POSSO TORNAR O CONSTRUTOR PRIVADO!
		Produto(String nome, double preco, double desconto ){
			this.nome =nome;
			this.preco =preco;
			this.desconto= desconto;
		}
		
		
		double calculaPreco() {
			return preco * (1-desconto);
		}
		
		static void resetaProduto(Produto produto) {
			produto.nome =null;
			produto.preco = 0.0;
			produto.desconto = 0.0;
		}
		
		
		String retornaMensagem() {
			return "O preço final é de: "+this.calculaPreco();
		}
		
		public static void main(String[] args) {
			Produto p1 = new Produto();
			
			p1.nome ="Notebook";
			p1.preco = 5678.9;
			p1.desconto =0.5;
			
			//double precoFinal =p1.calculaPreco();
			//System.out.println(precoFinal);
			
			String precoFinal =p1.retornaMensagem();
			System.out.println(precoFinal);
			
			System.out.println(Produto.donaDoProduto);
			
			//mudar o atributo estatico pela a classe e não pela objeto
			Produto.donaDoProduto = "Americanas";
			System.out.println(Produto.donaDoProduto);
		}

		@Override
		public int hashCode() {
			return Objects.hash(desconto, nome, preco);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Produto other = (Produto) obj;
			return Double.doubleToLongBits(desconto) == Double.doubleToLongBits(other.desconto)
					&& Objects.equals(nome, other.nome)
					&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
		}
		
		
}


