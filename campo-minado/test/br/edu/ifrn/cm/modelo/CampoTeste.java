package br.edu.ifrn.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//o * importa funcoes
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifrn.cm.excecao.ExplosaoException;

class CampoTeste {
	private Campo campo;
	
	@BeforeEach
	void iniciaCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testVizinhoDistancia1Direita() {
		Campo vizinho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	@Test
	void testVizinhoDistancia1Esquerda() {
		Campo vizinho = new Campo(3,4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	@Test
	void testVizinhoDistancia1EmCima() {
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testVizinhoDistancia1EmBaixo() {
		Campo vizinho = new Campo(4,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	@Test
	void testVizinhoDistancia2Diagonal() {
		Campo vizinho = new Campo(2,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testNaoVizinho() {
		Campo vizinho = new Campo(1,1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	@Test
	void testValorPadraoMarcacao() {
		assertFalse(campo.isMarcado());
	}
	@Test
	void testAlterarMarcacao() {
		campo.alterarMarcacao();
		assertTrue(campo.isMarcado());
	}
	@Test
	void testAlterarMarcacaoDuasVezes() {
		campo.alterarMarcacao();
		campo.alterarMarcacao();
		assertFalse(campo.isMarcado());
	}
	@Test
	void testAbrirNaoMinadoNaoMarcado() {
		
		assertTrue(campo.abrir());
	}
	@Test
	void testAbrirNaoMinadoMarcado() {
		campo.alterarMarcacao();
		assertFalse(campo.abrir());
	}
	@Test
	void testAbrirMinadoMarcado() {
		campo.alterarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	@Test
	void testAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, ()-> {
			campo.abrir();
		});
	}
	@Test
	void testAbrirComVizinhos() {
		Campo campo11 = new Campo(1,1);
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	@Test
	void testAbrirComVizinhos2() {
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,1);
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
	
	@Test
	void testSimbolo() {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
		tabuleiro.abrir(3, 3);
		assertEquals("2",tabuleiro.toString() );
	}
}
