package metodos3.game;

import java.security.SecureRandom;

public class InstrucaoAssistida {
	
	/**
	 * @system_description Este Programa tem como objetivo atender a demanda 
	 * 	de apredizado de multiplica��o para um aluno proposto pelo o exercicio
	 *  6.35 do livro Java: Como Programar
	 * @version 1.0 13 de jul. de 2022 
	 * @author erik vasconcelos
	 * @date 14:42:21 13 de jul. de 2022
	 */
	
	//Metodo que recebe um tipo de ocorrencia, e de acordo com ela retorna uma mensagem
	public String getMensagem(Evento ocorrencia) {
		return getResposta(ocorrencia, getNumeroResposta());
	}
	
	//Metodo para sele��o da resposta de acordo com o numero recebido
	private String getResposta(Evento evento, int numeroResposta) {
		String resposta="";
		
		if(evento== Evento.ACERTOU) {
			switch(numeroResposta) {
				case 1: 
					resposta= "Parabens, voc� acertou!!\n";
					break;
				case 2: 
					resposta= "Muito Bom!!\n";
					break;
				case 3: 
					resposta= "Bom trabalho!!\n";
					break;
				case 4: 
					resposta= "Excelente!\n";
			}
		}else {
			switch(numeroResposta) {
				case 1: 
					resposta= "N�o, por favor tente de novo.\n";
					break;
				case 2: 
					resposta= "Errado. Tente mais uma vez\n";
					break;
				case 3: 
					resposta= "N�o desista!\n";
					break;
				case 4: 
					resposta= "N�o. Continue tentando!\n";
			}
		}
		return resposta;
	}
	
	public String perguntar(int n1, int n2) {
		return String.format("Quanto � %d vezes %d? ", n1, n2);
	}
	
	//Metodo para fornecer uma intancia da classe em que � gerado o n�mero aleat�rio
	private SecureRandom getInstance() {
		SecureRandom random = new SecureRandom();
		return random;
	}
	
	//metodo para gera��o do n�mero
	public int gerarNumero() {
		int numero = getInstance().nextInt(1, 50);
		//(1, 50 intevalo de valores perguntados)
		return numero;
	}
	
	//Gera��o do n�mero de resposta aleat�rio
	private int getNumeroResposta() {
		return getInstance().nextInt(1, 5);
	}
	
}
