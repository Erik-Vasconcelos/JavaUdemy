package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import modelo.basico.Usuario;
@Transactional
public class NovoUsuario{
	public static void main(String[] args) {
		
		//Cria em EntityManeger
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");/*nome da unidade de persistencia
		/o banco de dados que voce quer conectar*/
		
		//responsavel por fazer a insercao, alteracao, exclusao cosulta - CRUD
		//Tem embutido uma conexão ou seja o EntityManeger representa uma conexao e tambem
		//a classe de persistencia de dados no Banco de dados
		EntityManager em =emf.createEntityManager();
		
		//Objeto a ser inserido
		Usuario user = new Usuario("Erik", "vasconcelos@gmail.com");
		
		//metodo de inserir no banco
		//inicia a transacao
		em.getTransaction().begin();
		em.persist(user);
		/*O persiste so vai realmente inserir no banco de dados se eu estiver em detro de um contexto de transacao.
		 *  Eu preciso ter uma transacao para dai abrir uma transacao ai depois voce faz um commit */
		em.getTransaction().commit();;
		em.close();
		emf.close();
	}
}
  