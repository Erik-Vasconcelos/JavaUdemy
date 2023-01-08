package fundamentos;

public class TipoStrinng {
	public static void main(String[] args) {
		String s  = "Olá, boa tarde!";
		//Mostra qual letra está no indice informado
		System.out.println("Seja bem vindo! ".charAt(5));
		
		//mostra se a string comeca com o informado retorna boleano
		System.out.println(s.startsWith("Olá"));
		
		//mostra se a string termina com o informado retorna boleano
		System.out.println(s.endsWith("tarde!"));
		
		//informa se o que foi passado é igual a variável ignorando se tem letras maiusculas ou minusculas
		System.out.println(s.equalsIgnoreCase("olá, boa tarde!"));
		
		//verifica se em alguma parte da frase contém a palavra ou letra passada como parâmetro
		System.out.println(s.contains("boa"));
		
		//mostraem que indice começa a palavra passada
		System.out.println(s.indexOf("vindo"));
		
		//conta a partir do indice informado
		System.out.println(s.substring(4));
		
		//conta a partir do indice informado e para no indice final passado nao printandoo a letra que está no indice final
		System.out.println(s.substring(5, 8));
	}
}
