package principal;

import java.util.Calendar;
import java.util.Date;

public class Pessoa {
	
	private String nome;
	private Date dataNascimento;
	private double altura;
	
	public Pessoa(String nome, Date dataNascimento, double altura) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.altura = altura;
	}
	
	public int calcularIdade() {
		Calendar dataNasc = Calendar.getInstance();
		dataNasc.setTime(dataNascimento);
		dataNasc.getWeekYear();
		
		Calendar datAtual = Calendar.getInstance();
		datAtual.setTime(new Date());
		return datAtual.getWeekYear() - dataNasc.getWeekYear();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
	
	@Override
	public String toString() {
		return String.format("Nome: %s\nData de Nascimeto: %s"
				+ "\nAltura: %.1f\n", this.nome, this.dataNascimento, this.altura);
	}
}
