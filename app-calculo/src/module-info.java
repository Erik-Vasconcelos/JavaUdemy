import br.com.cod3r.app.Calculadora;
import br.com.cod3r.app.calculo.CalculadoraImpl;

module app.calculo {
	requires transitive app.logging;
	/*tramite o acesso do modulo logging para o modulo que usar este modulo calculo*/
	exports  br.com.cod3r.app.calculo;
	
	/*exporta o pacote somente para o modulo app.finaceiro*/
//	exports br.com.cod3r.app.calculo.interno
//		to app.financeiro, app.logging;
	
	opens br.com.cod3r.app.calculo to app.financeiro, app.logging;
	
	requires app.api; 
	
	provides Calculadora 
		with CalculadoraImpl;
	//diz que esse modulo prove uma implementacao para este servico/Interface
	/* Modulo app.calculo prove uma implemnetacao para a interface 
	 * Calculadora a partir da classe CalculadoraImpl*/
	
}