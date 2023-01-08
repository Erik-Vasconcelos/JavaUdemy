package br.com.marttech.sg.matricula.interno.model;

import java.util.Calendar;

import br.com.marttech.sg.matricula.interno.infra.DAO;

public abstract class GeradorMatricula {
	/**
	 * @author erikv
	 * @date 21:36:36 24 de set. de 2022
	 * @system_unity_description Classe resposavel por realizar a logica de geracao de 
	 * matricula para as entidade(no momento servidor)
	 * @version 1.0 24 de set. de 2022
	 */
	
	static DAO dao = new DAO();
	private static Calendar calendario;
	private static Long codServ = 471L;
	
	private static Long ultimaMat;
	/*20224711045 - valor base -> [1045]*/
	private static Long valorBase;
	/*Usado para iniciar a tabela ou quando é um novo ano*/
	private static Long codBase = 1000L;
	
	private GeradorMatricula() {
	}
	
	public static Long gerarMatServ() {
		if(dao.verifyBankIsEmpty()) {
			setCalendar();
			String valor = calendario.getWeekYear() +""+codServ+""+codBase; 
			Long matri = Long.parseLong(valor);
			iserirMat(matri);
			return matri;
			
		}else {
			setAtributos();
			Long matri = gerarNovaMat();
			iserirMat(matri);
			return matri;
		}
	}
	
	private static Long gerarNovaMat() {
		int ultimoAno = Integer.parseInt(ultimaMat.toString().substring(0, 4));
		System.out.println(ultimoAno);
		int anoAtual = calendario.getWeekYear();
		String valor = "";
		
		if(ultimoAno != anoAtual) {
			valor = String.format("%d%d%d", anoAtual, codServ, codBase);
			
		}else {
			valor = String.format("%d%d%d", anoAtual, codServ, (++valorBase));
		}
		
		return Long.parseLong(valor);
	}
	
	private static void iserirMat(Long v) {
		try {
			dao.insertNovaMat(v);
		} catch (Exception e) {
			e.printStackTrace();
			Long mat = gerarNovaMat() + 1L;
			dao.insertNovaMat(mat);
		}
	}
	
	private static void setAtributos() {
		setCalendar();
		setMatBase();
		setValorBase();
	}
	
	private static void setMatBase() {
		ultimaMat = dao.getUltimaMat();
	}
	
	private static void setValorBase() {
		String valor = String.valueOf(ultimaMat);
		valor = valor.substring(7);
		valorBase = Long.parseLong(valor);
	}
	
	private static void setCalendar() {
		calendario = Calendar.getInstance();
	}
	
}
