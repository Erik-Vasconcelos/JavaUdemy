package oo;

public abstract class Animal {
	
	private String tipo;
	private double peso;
	
	public Animal(String tipo, double peso) {
		super();
		this.tipo = tipo;
		this.peso = peso;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	
}
