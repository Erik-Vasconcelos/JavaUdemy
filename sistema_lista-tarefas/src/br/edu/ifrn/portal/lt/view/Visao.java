package br.edu.ifrn.portal.lt.view;

import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.edu.ifrn.portal.lt.controller.Systema;
import br.edu.ifrn.portal.lt.model.Evento;

public class Visao {
	private static Systema sistema = new Systema();
	private static Scanner leitor = new Scanner(System.in);

	public void apresentacao() {
		System.out.println("Digite a opcao:\n"
				+ "1 - Cadastar atividade\n"
				+ "2 - Ver atividade\n"
				+ "3 - Atualizar atividade\n"
				+ "4 - Excluir atividade\n"
				+ "5 - Sair do sistema");
	}
	
	public String getRespostaString(String pergunta) {
		System.out.println("Digite "+ pergunta);
		String entrada = getEntradaString();
		return entrada;
	}
	
	public Date getRespostaData() {
		System.out.println("Digite a data de entrega no formato dia, mes, amo");
		
		int dia = getEntradaInt();
		int mes = getEntradaInt();
		int ano = getEntradaInt();
		
		Calendar calendario = Calendar.getInstance();
		calendario.set(ano, mes, dia);
		
		Date dtEntrega = new Date(calendario.getTimeInMillis());
		
		return dtEntrega;
	}
	
	public int getEntradaInt(){
		return leitor.nextInt();
	}
	public String getEntradaString() {
		return leitor.nextLine();
	}
	
	void iniciar() {
		int op =0;
		try {
			do {
				apresentacao();
				op = getEntradaInt();
			

				
				if(op == 1) {
					sistema.cadastrar(getRespostaString("o titulo: "),
							getRespostaString("a descricao:"), getRespostaData(), false);
					
				}else if(op == 2) {
					System.out.println("Digite o titulo da atividade");
					leitor.next();

					String valor = getEntradaString();
					
					Evento evento = sistema.visualizar(valor);
					System.out.println(evento.toString());
				}else if(op == 3) {
					System.out.println("Digite o titulo da atividade");
					
					String valor = getEntradaString();
					Evento evento = sistema.visualizar(valor);
					
					
					String novoTitulo = JOptionPane.showInputDialog(evento.toString(), evento.getTitulo());
					sistema.atualizar(valor, novoTitulo);
					
				}else if(op== 4) {
					System.out.println("Digite o titulo da atividade");
					
					String valor = getEntradaString();
					Evento evento = sistema.visualizar(valor);
					
					int escolha = JOptionPane.showConfirmDialog(null, "A atividade encontrada foi: ",
							evento.toString() + "\nDeseja excluir? ", JOptionPane.YES_NO_OPTION);
					if(escolha == JOptionPane.YES_OPTION) {
						sistema.excluir(valor);
					}
				}
				
			}while(op != 5);
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
