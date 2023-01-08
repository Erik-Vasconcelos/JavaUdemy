package Arrays_E_Collections.Arrays;

public class Usuario {
	String nome;
	String email;
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Usuario) {
			/*Define uma variavel do tipo outro e atribui a 
			ela cast de um objeto(Transforma o objeto para Usuario)*/
			Usuario outro = (Usuario) obj;
			
			//Testa se os atributos de outro sao iguais aos atributos do objeto atual
			boolean testeNome =outro.nome.equals(this.nome);
			boolean testeEmail = outro.email.equals(this.email);
			
			//retorna o teste logico feito
			return testeNome && testeEmail;
		}else {
			//Caso contrario retorna falso
			return false;
		}
	}
}
