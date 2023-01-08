package fundamentos;

public class TipoStrinng {
	public static void main(String[] args) {
		String s  = "Ol�, boa tarde!";
		//Mostra qual letra est� no indice informado
		System.out.println("Seja bem vindo! ".charAt(5));
		
		//mostra se a string comeca com o informado retorna boleano
		System.out.println(s.startsWith("Ol�"));
		
		//mostra se a string termina com o informado retorna boleano
		System.out.println(s.endsWith("tarde!"));
		
		//informa se o que foi passado � igual a vari�vel ignorando se tem letras maiusculas ou minusculas
		System.out.println(s.equalsIgnoreCase("ol�, boa tarde!"));
		
		//verifica se em alguma parte da frase cont�m a palavra ou letra passada como par�metro
		System.out.println(s.contains("boa"));
		
		//mostraem que indice come�a a palavra passada
		System.out.println(s.indexOf("vindo"));
		
		//conta a partir do indice informado
		System.out.println(s.substring(4));
		
		//conta a partir do indice informado e para no indice final passado nao printandoo a letra que est� no indice final
		System.out.println(s.substring(5, 8));
	}
}
