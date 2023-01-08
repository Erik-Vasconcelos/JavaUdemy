package controler;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Aluno;
import model.DAOAluno;

public class Systema {
	
	public Systema() {
		rodarSistema();
	}
	
	public void rodarSistema() {
		JOptionPane.showMessageDialog(null, "Seja bem vindo ao sitema!!!!");
		int op=0;
		
		while(op!=5) {
			op = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastar aluno\n2 - Atualizar aluno \n"
					+ "3 - Visualizar aluno \n4 - Deletar aluno \n5-Sair \n\nDigite uma opcao: "));
			
			if(op ==1) {
				cadastrar();
			}else if(op ==2) {
				atualizar();
			}else if(op==3) {
				visualizar();
			}else if(op==4) {
				deletar();
			}else {
				if(op!=5) {
				JOptionPane.showMessageDialog(null, "Opcao inválida");
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Obrigador por usar o sistema!!! :)");
		
	}
	
	public void cadastrar() {
		
		try {
			String nome = JOptionPane.showInputDialog("Informe o nome: ", JOptionPane.WARNING_MESSAGE);
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade: ", JOptionPane.WARNING_MESSAGE));
			String  matricula = JOptionPane.showInputDialog("Informe matricula: ", JOptionPane.WARNING_MESSAGE);
			String endereco = JOptionPane.showInputDialog("Informe edereco: ", JOptionPane.WARNING_MESSAGE);
			DAOAluno.cadatrar(new Aluno(nome, idade, matricula, endereco));
			JOptionPane.showMessageDialog(null, "Aluno cadastrado!");
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void visualizar() {
		try {
			String matri =JOptionPane.showInputDialog("Informe a matricula: ", JOptionPane.WARNING_MESSAGE);
			Aluno a = DAOAluno.visualizar(matri);
			String dados =String.format("Nome:%s \nIdade: %d \nMatricula: %s \nEndereco: %s", a.getNome(), a.getIdade(), a.getMatricula(), a.getEndereco());
			JOptionPane.showMessageDialog(null, dados);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public void atualizar() {
		String  matricula = JOptionPane.showInputDialog(null,"Informe matricula: ", JOptionPane.WARNING_MESSAGE);
		String nome = JOptionPane.showInputDialog("Informe o novo nome: ", JOptionPane.WARNING_MESSAGE);
		int resu=0;
		try {
			resu = DAOAluno.atualizar(matricula, nome);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Lihas afetadas: "+resu);
	}
	
	public void deletar() {
		String  matricula = JOptionPane.showInputDialog("Informe matricula: ", JOptionPane.WARNING_MESSAGE);
		int r =0;
		try {
			r = DAOAluno.deletar(matricula);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Lihas afetadas: "+r);
	}
	
}
