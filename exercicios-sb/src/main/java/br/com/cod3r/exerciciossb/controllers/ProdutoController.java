package br.com.cod3r.exerciciossb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Produto;
import br.com.cod3r.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired /*Injecao de dependencia. 
	Ao ser chamado, o spring providencia uma implementacao para o atributo*/
	private ProdutoRepository produtoRepository;
	
	/*@PostMapping
	public @ResponseBody Produto novoProduto(@RequestParam String nome,
				@RequestParam double preco, @RequestParam double desconto) {
		Produto produto = new Produto(nome, preco, desconto);
		produtoRepository.save(produto);
		return produto;
	}*/
	 
	/*Metodo para inserir ou atualizar*/
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto salvarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	/*@ResponseBody - Deixa claro que o produto faz parte do corpo da resposta*/
	
	
	@GetMapping
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
		//O método irá retornar TODOS os produtos do banco de dados
	}
	
	@GetMapping(path  = "/nome/{parteNome}")
	public Iterable<Produto> obterProdutoPorNome(@PathVariable String parteNome){
		
		return produtoRepository.searchByNameLike(parteNome);
		//return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdPagina}")
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina,
			@PathVariable int qtdPagina){
		if(qtdPagina > 5) qtdPagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdPagina);
		return produtoRepository.findAll(page);
	}
	
	/*@GetMapping
	public List<Produto> obterProdutos(){
		Iterable<Produto> produtos = produtoRepository.findAll();
		List<Produto> lProdutos = new ArrayList<>();
		produtos.forEach(lProdutos::add);
 
		return lProdutos; 
	}*/
	
	 
	@GetMapping(path = "/{id}")
	public Optional<Produto> getProdutoPorId(@PathVariable int id) {
		/*O Optional de Produto retorna um produto caso o id passado 
		 * seja valido, senao nao dara um erro*/
		return produtoRepository.findById(id);
	}
	
	
	/*@PutMapping
	public Produto atualizarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}*/
	
	/*Ele recebe um produto com o id e ele vai atualizar o 
	 * produto no banco de dados que tenha esse id*/
	
	@DeleteMapping(path = "/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
	
	
}
