module  app.financeiro {
	
	requires java.base; // Por padrão já importado
//	requires app.calculo;
	
	requires app.api;
	
	uses br.com.cod3r.app.Calculadora;
	/*Diz que voce quer usar o servico que foi definido a partir da interface calculadora */
}