package br.edu.ifrn.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	private enum TipoComando{
		ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL,VIRGULA, APAGAR, SINAL; 
	};
	
	private static final Memoria memoryInstanci =new Memoria();
	private final List<MemoriaObservador> observadores = new ArrayList<>();
	
	private TipoComando ultimaOperacao = null;
	private boolean substituir = false;
	private String textoAtual ="";
	private String textoBuffer = "";
	
	
	private Memoria() {
	}
	
	public void registrarObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty()?"0":textoAtual;
	}

	public void processarComandos(String valor) {
		
		TipoComando tipoComando = detectarTipoComando(valor);
		if(tipoComando == null) {
			return;
		}else if(tipoComando == TipoComando.ZERAR) {
			textoAtual="";
			textoBuffer="";
			substituir=false;
			ultimaOperacao=null;
		}else if(tipoComando == TipoComando.SINAL && !textoAtual.contains("-")) { 
			textoAtual="-"+textoAtual;
			
		}else if(tipoComando == TipoComando.SINAL && textoAtual.contains("-")) { 
			textoAtual=textoAtual .substring(1);
			
		}
		else if(tipoComando == TipoComando.NUMERO || tipoComando == TipoComando.VIRGULA) {
			textoAtual  = substituir? valor: textoAtual+valor;
			substituir= false;	
		}else {
			
			substituir=true;
			textoAtual= obterResultadoOperacao();
			textoBuffer=textoAtual;
			ultimaOperacao= tipoComando;
		}
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
		
	}

	private String obterResultadoOperacao() {
		if(ultimaOperacao == null) {
			return textoAtual;
		}
		
		double numeroBuffer = Double.parseDouble(textoBuffer.replace(",", "."));
		double numeroAtual = Double.parseDouble(textoAtual.replace(",", "."));
		
		double resultado =0;
		if(ultimaOperacao == TipoComando.SOMA) {
			resultado = numeroBuffer+numeroAtual;
			
		}else if(ultimaOperacao == TipoComando.SUB) {
			resultado = numeroBuffer - numeroAtual;
			
		}else if(ultimaOperacao == TipoComando.DIV) {
			resultado = numeroBuffer / numeroAtual;
			
		}else if(ultimaOperacao == TipoComando.MULT) {
			resultado = numeroBuffer * numeroAtual;
		}
		
		System.out.println(resultado);
		String stringResultado = Double.toString(resultado).replace(".", ","); 
		boolean inteiro = stringResultado.endsWith(",0");
		
		return inteiro?stringResultado.replace(",0", ""):stringResultado;
		
		
	}

	private TipoComando detectarTipoComando(String valor) {
		// TODO Auto-generated method stub
		
		if(valor.isEmpty() && valor.equals("0")) {
		    return null;
		}
		
		try {
			Integer.parseInt(valor);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			
			if("CE".equals(valor)) {
				return TipoComando.ZERAR;
			}else if("÷".equals(valor)) {
				return TipoComando.DIV;
				
			}else if("x".equals(valor)) {
				return TipoComando.MULT;
				
			}else if("-".equals(valor)) {
				return TipoComando.SUB;
				
			}else if("+".equals(valor)) {
				return TipoComando.SOMA;
				
			}else if("⌫".equals(valor)) {
				return TipoComando.APAGAR;
				
			}else if(",".equals(valor) && !textoAtual.contains(",")) {
			}
			else if("±".equals(valor)) {
				return TipoComando.SINAL;
				
			}else if(",".equals(valor) && !textoAtual.contains(",")) {
				return TipoComando.VIRGULA;
	
			}else if("=".equals(valor)) {
				return TipoComando.IGUAL;
			}
			
		}
		
		return null;
	}

	public static Memoria getMemoryInstanci() {
		return memoryInstanci;
	}


	
	
}
