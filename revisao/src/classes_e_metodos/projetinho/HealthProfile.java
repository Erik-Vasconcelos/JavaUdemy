package classes_e_metodos.projetinho;

import java.time.LocalDate;

import classes_e_metodos.Date;

public class HealthProfile {

	/**
	 * Este Sistema tem por fim atender a computadorização dos registros de saúde
	 * calculando a frequência cardiaca, frequencia alvo e Imc do paciente
	 * Data de Crição: 12/07/2022
	 * @author erikv
	 * 
	 */
	
	private String nome;
	private String sobrenome;
	private String sexo;
	private Date dataNascimento;
	private double altura;
	private double peso;
	 
	public HealthProfile(String nome, String sobrenome, String sexo, Date dataNascimento, double altura, double peso) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.altura = altura;
		this.peso = peso;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public int getIdade() {
		return LocalDate.now().getYear() - dataNascimento.getAno();
	}
	
	public int getFrequenciaMaxima() {
		return 220 - getIdade();
	}
	
	public String getFrequenciaAlvo() {
		return String.format("%d - %d", getFrequenciaMaxima()*5/10, getFrequenciaMaxima()*85/100);
	}
	
	public double getImc() {
		if(peso>0 && altura > 0) {
			return peso/(altura*altura);
		}
		return 0.0;
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s %s%nSexo: %s%nData de Nascimento: %s%nAltura: %.2f "
				+ "%nPeso: %.2f%nIdade: %d%nIMC: %.2f%nFrequenciaMaxima: %d%nFrequencia Alvo: %s",
				nome, sobrenome,sexo, dataNascimento.displayDate(), altura, peso, getIdade(), getImc(),
				getFrequenciaMaxima(), getFrequenciaAlvo() );
	}
	 
	 
}
