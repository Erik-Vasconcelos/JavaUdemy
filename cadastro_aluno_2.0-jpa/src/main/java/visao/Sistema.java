package visao;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import infra.DAO;
import infra.DAOAluno;
import infra.DAOMatricula;
import modelo.Aluno;
import modelo.Endereco;
import modelo.Matricula;

public class Sistema {
				
	public Sistema() {
		runSystem();
	}
	
	public void runSystem() {
		
		JOptionPane.showMessageDialog(null, "====Seja bem vindo ao programa====");
		int op = 0;
		while(op != 5) {
			op= getOpcao();
			
			if(op == 1) {
				Aluno aluno = cadastraAluno();
				
				JOptionPane.showMessageDialog(null,aluno.toString());
				
				Long matricula = Long.parseLong(
						JOptionPane.showInputDialog(null, "Digite a matricula do aluno: ")
						);
				
				persistir(matricula, aluno);
			}else if(op==2) {
				try {
					Long mat = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a matricula"));
					alterarAluno(mat);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
			else if(op==3) {
				try {
					Long mat = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a matricula"));
					Aluno aluno = buscarAlunoRetor(mat);
					JOptionPane.showMessageDialog(null, aluno.toString());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
			}
			else if(op==4) {
				try {
					Long mat = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a matricula"));
					Aluno aluno = buscarAlunoRetor(mat);
					
					if (aluno != null) {
						int opcao = JOptionPane.showConfirmDialog(null, aluno.toString(), "Confirmacao", JOptionPane.YES_NO_OPTION);
						
						if(opcao==JOptionPane.YES_OPTION) {
							Matricula matri = buscarAlunoMat(mat);
							removerAluno(matri);
							JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!! ");
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Opção inválida!! ");
			}
		}
		
	}
	
	
	private Aluno cadastraAluno() {
		String nome = JOptionPane.showInputDialog("Digite o nome: ");
		String cpf = JOptionPane.showInputDialog("Digite o cpf: ");
		String telefone = JOptionPane.showInputDialog("Digite o telefone: ");
		Integer idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
		
		Endereco endereco = cadastroEndereco();
		return new Aluno(nome, cpf, telefone, idade, endereco);
	}
	
	private Endereco cadastroEndereco() {
		JOptionPane.showMessageDialog(null, "Cadatro do endereco do aluno");
		String rua = JOptionPane.showInputDialog("Digite a rua: ");
		String bairro = JOptionPane.showInputDialog("Digite o bairro: ");
		String cidade = JOptionPane.showInputDialog("Digite a cidade: ");
		String estado = JOptionPane.showInputDialog("Digite o estado: ");
		
		return new Endereco(rua, bairro, cidade, estado);
	}
	
	
	//CRUD
	
	//C
	@SuppressWarnings("unused")
	private void persistir(Long matricula, Aluno aluno) {
		DAOMatricula dao = new DAOMatricula();
		dao.abrirT().inserir(new Matricula(matricula, aluno))
		.fecharT().fechar();
	}
	
	//R
	private Matricula buscarAlunoMat(Long matricula) throws SQLException{
		DAOMatricula dao = new DAOMatricula();
		return dao.obterPorMatricula(matricula);
	}
	
	private Aluno buscarAlunoRetor(Long matricula) throws SQLException{
		DAOMatricula dao = new DAOMatricula();
		return convert(dao.obterPorMatricula(matricula));
	}
	
	//U
	private void alterarAluno(Long mat) throws SQLException {
		DAOMatricula daoMat = new DAOMatricula();
		Matricula matri = buscarAlunoMat(mat);

		DAOAluno daoAluno = new DAOAluno();
		Aluno aluno =convert(matri);
		daoAluno.desassociarEntidade(aluno);
		
		String novoNome = JOptionPane.showInputDialog(null,"Digite o novo nome:", aluno.getNome());
		String novoCpf =JOptionPane.showInputDialog(null,"Digite o novo cpf:", aluno.getCPF());
		int novaIdade =Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o novo idade:", aluno.getIdade()));
		String novoTelefone =JOptionPane.showInputDialog(null,"Digite o novo telefone:", aluno.getTelefone());
		
		//Formatacao dos dados
		String dados = String.format("Nome: %s \nCPF: %s \nIdade: %d \nTelefone: %s \n\nDeseja salvar as aterações? "
				, novoNome, novoCpf, novaIdade, novoTelefone);
		
		//Caixa de dialoga para apresentacao das modificações
		int confirmcao = JOptionPane.showConfirmDialog(null, dados, "Confirmação",
				JOptionPane.YES_NO_CANCEL_OPTION);
	
		if(confirmcao == JOptionPane.YES_OPTION) {
			aluno.setNome(novoNome);
			aluno.setCPF(novoCpf);
			aluno.setIdade(novaIdade);
			aluno.setTelefone(novoTelefone);
			
			daoAluno.abrirT().atualizar(aluno).fecharT().fechar();
			JOptionPane.showMessageDialog(null, "ALteração realizada com sucesso!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Operação cancelada!");
		}
	}
	
	//D
	private void removerAluno(Matricula matricula){
		DAO<Object> dao = new DAO<>();
		dao.abrirT().remover(matricula).fecharT().fechar();
	}
	
	
	private Aluno convert(Matricula matricula) {
		return matricula.getAluno();
	}
	
	private int getOpcao() {
		return Integer.parseInt(
					JOptionPane.showInputDialog(null, 
					"1 - Cadastra aluno\n"
					+ "2 - Atualizar Aluno\n"
					+ "3 - Buscar Aluno\n"
					+ "4 - Apagar ALuno\n"
					+ "5 - Sair\n"
					+ "\nDigite: ")
				);
	}
}