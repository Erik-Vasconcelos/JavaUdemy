package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import modelo.basico.Usuario;

public class NovoUsuario {
	public static void main(String[] args) {
		//Cria um EntityManeger
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		/*Recebe como parametro o nome da unidade de persistencia (qual é o banco que voce quer conectar) 
		esse nome é encontrado no arquivo persistence.xml -> persistenci-unit*/
		
		EntityManager em = emf.createEntityManager();
		/*Resposavel por inserir uma entidade, por alterar, por excluir e consultar - faz o CRUD
		ele rebece um objeto e vai entender que o obj tem um mapeamento e vai converter os dados do obj em comandos sql
		ele tambem tem embutido a conexao, ou seja, ele sera responsavel por persistir os dados no B.D*/
		
		String nome="";
		while(!"sair".equalsIgnoreCase(nome)) {
			nome = JOptionPane.showInputDialog("Digite o nome: ");
			
			Usuario novo = new Usuario(nome, nome+"@gmail.com");
		
			em.getTransaction().begin();
			em.persist(novo);//o persist gera uma isercao.OBS: ele só vai inserir se entiver em um contexto de transação
			em.getTransaction().commit();
		}
		
		em.close();
		emf.close();
	}
}
