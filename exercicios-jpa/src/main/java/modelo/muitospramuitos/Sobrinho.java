package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;

@Entity
public class Sobrinho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	/*Na forma bidirecional sempre tem o relacionamento  mapeado em o ponto o outro lado é o bidirecional */
	/*Se o relacionamento principal ficar no lado do Tio a tabela intermediária tera o nome de tio_sobrindo,
	 *  mas se o relacionamento pincipal ficar do lado do sobrinho a tabela irá se chamar sobrinho_tio*/
	
	@ManyToMany(mappedBy = "sobrinhos")//Referenciando o mapeamento
	private List<Tio> tios = new ArrayList<>();

	public Sobrinho() {
		// TODO Auto-generated constructor stub
	}
	
	public Sobrinho(String nome) {
		super();
		this.nome = nome;
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

	public List<Tio> getTios() {
		return tios;
	}

	public void setTios(List<Tio> tios) {
		this.tios = tios;
	}
}