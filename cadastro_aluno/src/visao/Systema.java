package visao;

import java.util.Scanner;
import java.util.function.Consumer;

import javax.swing.JOptionPane;

import excecao.AlunoNaoEncontradoException;
import excecao.MatriculaInvalidaException;
import modelo.Aluno;
import modelo.BancoDeDados;
import modelo.Validar;

public class Systema {
	private BancoDeDados banco;
	Scanner leitor = new Scanner(System.in);
	
	public Systema() {
		executar();
	}
	
	void print(String texto) {
		System.out.println(texto);
	}
	void printErr(String texto) {
		System.err.println(texto);
	}
	
	
	void executar() {
		print("====Seja bem vindo ao programa====\n");
		int op=0;
		while(op !=4) {
			 op=getOpcao();
			 
			 if(op == 1) {
				 
				 String continuar="s";
				 while(!continuar.equalsIgnoreCase("n")) {
					 cadastro();
					 print("\nQuer cadastrar outro aluno? S/n");
					 continuar = leitor.next();
				 }
			 }else if(op==2) {
				 try {
					 banco.isVazio();
					 remove();
					 
				 }catch (RuntimeException e) {
					caixaDialogo("m", e.getMessage(), "Erro!");
				}
				 
			 }else if(op==3) {
				 try {
					 banco.isVazio();
					 String dados = busca();
					// JOptionPane.showMessageDialog(null, dados,"Dados do Aluno",JOptionPane.INFORMATION_MESSAGE);
					 caixaDialogo("m", dados, "Dados do Aluno");
				 }catch(RuntimeException e) {
					 //JOptionPane.showMessageDialog(null, e.getMessage(),"Erro" ,JOptionPane.ERROR_MESSAGE);
					 caixaDialogo("m", e.getMessage(), "Erro");
				 }
				 
			 }else if (op == 4) {
				 print("Finalizando...");
			 }else {
				 printErr("Opcão inválida! \n");
		
			 }
			
		}
	}
	
	// METODOS PRINCIPAIS
	void cadastro() {
		//try {
		
		String nome = inputTexto("Digite o nome do aluno: ");
		String CPF= inputTexto("Digite o CPF do aluno: ");
		
		int idade=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade do aluno: "));
			
		String endereco=inputTexto("Digite o endereço do aluno: ");
//		try{ 
//			Validar.aluno(nome, CPF, idade, endereco);
//		}catch(RuntimeException e) {
//			caixaDialogo("m",e.getMessage(), "Erro");
//			
//		}
		
		int op =JOptionPane.showConfirmDialog(null,"Nome: "+nome+"\nCPF: "+CPF+"\nIdade: "
				+idade+"\nEndereço: "+endereco+
				"\n\nDeseja salvar o aluno? ",
				"Comfirmacao", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(op == JOptionPane.YES_OPTION) {
			Long m =salvarAluno(nome, CPF, idade, endereco);
			
			imprimeMensagem("cadastrado com sucesso!\nMATRI: "+m);
		}else{
			printErr("Cadastro Cancelado..");
		}
//		}catch(RuntimeException e) {
//			caixaDialogo("m", e.getMessage(), "Warning");
//		}
	}
	
	void remove (){
		
		try {
			Long mat = recebeMat();
			
			Aluno a =null;
			if(Validar.matricula(mat)) {
				a = banco.buscarAluno(mat);
				
				int op =JOptionPane.showConfirmDialog(null, 
						"O aluno encontrado foi: \n\n"+a.toString()+
						"\nDeseja realmente remover o aluno? ","Comfirmação",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if(op == JOptionPane.YES_OPTION) {
					banco.removerAluno(a);
					imprimeMensagem("removido com sucesso!");
				}
				else {
					print("Operação Cancelada");
				}
			}else{
				throw new MatriculaInvalidaException();
			}
			
			
		}catch (AlunoNaoEncontradoException | MatriculaInvalidaException e) {
			caixaDialogo("m", e.getMessage(), "Warning");
			//JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	String busca() {
		try {
			Long mat  = recebeMat();
			Aluno a =null;
			if(Validar.matricula(mat)) {
				a  = banco.buscarAluno(mat);
			}else {
				throw new MatriculaInvalidaException();
			}
			
			return a.toString();
		}catch(AlunoNaoEncontradoException e){
			return e.getMessage();
		}
	}
	
	
	
	// METODOS UXILIARES
	int getOpcao() {
		print("1 - Cadastra aluno\n"
				+ "2 - Remover Aluno\n"
				+ "3 - Buscar Aluno\n"
				+ "4 - Sair\n");
		print("Digite: ");
		int op = leitor.nextInt();
		return op;
	}
	
	String inputTexto(String texto) {
		
		return JOptionPane.showInputDialog(null, texto);
	}
	
	String caixaDialogo(String tipo, String texto, String titulo) {
		
		if("m".equalsIgnoreCase(tipo)) {
			JOptionPane.showMessageDialog(null, texto, titulo ,JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if("c".equalsIgnoreCase(tipo)){
			return Integer.toString(JOptionPane.showConfirmDialog(null, texto,titulo, JOptionPane.YES_NO_CANCEL_OPTION));
		}
		else if("i".equalsIgnoreCase(texto)){
			return JOptionPane.showInputDialog(null, texto,titulo ,JOptionPane.INFORMATION_MESSAGE);
		}
		return "";
	}
	
	
	void imprimeMensagem(String msg) {
		
		Consumer<String> imp = e ->System.out.println("O Aluno foi "+msg);
		imp.accept(msg);
	}
	
	Long recebeMat() {
		Long mat = Long.parseLong(JOptionPane.showInputDialog(null, "Digite a matricula do aluno: "));
		return mat;
	}
	
	
	Long salvarAluno(String nome, String cpf, int idade, String endereco) {
		return banco.cadastrarAluno(new Aluno(nome, cpf, idade, endereco));
		
	}
	
	
}
