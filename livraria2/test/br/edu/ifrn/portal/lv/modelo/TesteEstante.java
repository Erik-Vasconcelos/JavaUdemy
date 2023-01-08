package br.edu.ifrn.portal.lv.modelo;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifrn.portal.lv.controller.CapacidadeMaximaException;
import br.edu.ifrn.portal.lv.controller.LivroNaoEncontradoException;
import br.edu.ifrn.portal.lv.model.Estante;
import br.edu.ifrn.portal.lv.model.Livro;
import br.edu.ifrn.portal.lv.model.LivroInformatica;

class TesteEstante {
	private Estante estante;
	
	@BeforeEach //para cada um do métodos execute essa função
	void iniciarEstante() {
		estante = new Estante(20, 1L);
		//para acada novo teste ele vai chamar essa função
	}
	
	@Test
	void getNumeroEstante() {
		Long numero = estante.getNumeroEstante();
		assertEquals(1L, numero);
	}
	
	@Test
	void inserirLivro() {
		Livro livro1 = new LivroInformatica(5668L, "Java como programar", "Paul deitel",360.2, 2017);
		boolean resultado = estante.inserirLivro(livro1);
		assertTrue(resultado);
	}
	@Test
	void naoInserirLivro() {
		inserirLivro();
		Livro livro1 = new LivroInformatica(5668L, "Java como programar", "Paul deitel",0.0, 2017);
		assertThrows(CapacidadeMaximaException.class, () ->  {
			estante.inserirLivro(livro1);
		});
	}
	
	@Test
	void validarLivro() {
		Livro livro3 = new LivroInformatica(2575L, "Uml", "Grady Booch",124.09, 2010);
		boolean resultado =  estante.validarLivro(livro3);
		assertTrue(resultado);
	}
	@Test
	void testLivroInvalido() {
		Livro livro3 = new LivroInformatica(0L, "", "",-124.09, 150);
		boolean resultado =  estante.validarLivro(livro3);
		assertFalse(resultado);
	}
	@Test
	void testLivroNullo() {
		Livro livro3 = null;
		boolean resultado =  estante.validarLivro(livro3);
		assertFalse(resultado);
	}
	
	@Test
	void inserirLivros() {
		Livro livro3 = new LivroInformatica(2575L, "Uml", "Grady Booch",124.09,2016 );
		Livro livro4 = new LivroInformatica(4582L, "Design Patterns", "Gang of four", 92.65, 2020 );
		Livro livro5 = new LivroInformatica(6787L,"Domain Drive design", "Eric Evans",82.14, 2018);
		Livro livro6 = new LivroInformatica( 6569L, "Refatoração", "Martin Fowler", 95.55,2011);
		
		List<Livro> livros = Arrays.asList(livro3, livro4, livro5, livro6);
		assertTrue(estante.inserirLivros(livros));
	}
	
	@Test
	void inserirLivrosInvalidos() {
		
		Livro livro3 = new LivroInformatica(2575L, "", "Grady Booch",-124.09,2016 );
		Livro livro4 = new LivroInformatica(4582L, "Design Patterns", "Gang of four", 92.65, 2020 );
		Livro livro5 = new LivroInformatica(6787L,"Domain Drive design", "Eric Evans",82.14, 2018);
		Livro livro6 = new LivroInformatica( 6569L, "Refatoração", "Martin Fowler", 95.55,2011);
		
		
		List<Livro> livros = Arrays.asList(livro3, livro4, livro5, livro6);
		assertFalse(estante.inserirLivros(livros));
	}
	
	@Test
	void getLivro() {
		inserirLivro();
		Livro livro = estante.getLivro(5668L);
		assertInstanceOf(Livro.class, livro);
	}
	
	@Test
	void testeLivroNaoEncontrado() {
		assertThrows(LivroNaoEncontradoException.class, () -> {
			estante.getLivro(8772L);
		});
	}
	
	@Test
	void getLocalLivro() {
		Livro livro2 = new LivroInformatica(8792L, "Codigo Limpo", "Robert c.", 71.56,2015 );
		estante.inserirLivro(livro2);
		long numero = estante.getLocalLivro(8792L);
		assertEquals(estante.getNumeroEstante(), numero);
	}
	
	@Test
	void getLocalLivroInvalido() {
		long numero = estante.getLocalLivro(2557L);
		assertNotEquals(estante.getNumeroEstante(), numero);
	}
	
	@Test
	void venderLivro() {
		inserirLivro();
		Livro livro = estante.venderLivro(5668L);
		assertInstanceOf(Livro.class, livro);
		assertFalse(estante.verificarExistencia(5668L));
	}
	
	@Test
	void testeQuantidadeLivros() {
		inserirLivro();
		int qtd = estante.getQuantidadeLivros();
		assertEquals(1, qtd);
	}
	
}
