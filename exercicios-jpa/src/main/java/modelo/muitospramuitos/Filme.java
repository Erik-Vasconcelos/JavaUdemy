package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Double nota;
	
	@ManyToMany(cascade = CascadeType.PERSIST)//No momento que é inserido um filme também é inserido os atores
	@JoinTable(
			name = "atores_filmes",
			joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id")
	)
	private List<Ator> atores;
	
	//@JoinTable -> Annotation de junção de tabelas
	
	/* joinColumns : está relacionado com a classe atual que é Filme 
	 * referencesColumnName : coluna que ela se referencia dentro da tabela
	 * inverseJoinColumns : é aquilo que vem a partir da outra entidade que nesse caso é o Ator
	 * */
	
	public Filme() {
		
	}

	public Filme(String nome, Double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public List<Ator> getAtores() {
		if(atores ==null) {
			atores  = new ArrayList<>();
		}
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	//Método para adiciona o ator a lista de filmes e os filme ao ator garantindo que nao haja duplicação
	public void adicionarAtor(Ator ator) {
		if(ator != null && !getAtores().contains(ator)) {
			getAtores().add(ator);
			
			if(!ator.getFilmes().contains(this)) {
				ator.getFilmes().add(this);
			}
		}
	}
}