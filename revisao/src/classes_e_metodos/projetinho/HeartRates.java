package classes_e_metodos.projetinho;

import java.time.LocalDate;

import classes_e_metodos.Date;

public class HeartRates {
	/**
	 * Este programa tem como objetivo calcular a partir da idade da pessoa 
	 * a sua frequencia cardiaca maxima e a frequecia alvo
	 * Data de criacao: 12/07/2022
	 * @author erik vasconcelos
	 */
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	
	public HeartRates(String nome, String sobrenome, Date dataNascimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade() {
		int idade = LocalDate.now().getYear() - dataNascimento.getAno();
		return idade;
				 
	}
	
	public int getFrequenciaMaxima() {
		return 220 - getIdade();
	}
	
	public String getFrequenciaAlvo() {
		int minimo = getFrequenciaMaxima() * 5 /10;
		int maxima = getFrequenciaMaxima() *85/100;
		
		return String.format("Sua frequencia cardiaca alvo é entre %d - %d", minimo, maxima);
		
	}
	
	@Override
	public String toString() {
		return String.format("Nome e sobrenome: %s %s%nData de nascimento = %s%n"
				+ "Idade: %d%nFrequencia Cardiaca Maxima: %d%nFrequencia Alvo: %s"
				,nome, sobrenome, dataNascimento.displayDate(),
				getIdade(), getFrequenciaMaxima(), getFrequenciaAlvo());
	}
	
}
