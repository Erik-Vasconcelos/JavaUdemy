package orientacao_obj.asbtrato;

public abstract class Notebook {
	private double velProcessador = 2.20;
	
	
//	public Notebook(double velocProce) {
//		this.velProcessador = velocProce;
//	}
	
	public String abrirJogo() {
		if(velProcessador >=4.1) {
			return "Demourou 5s";
		}
		else if(velProcessador >= 2.40) {
			return "Demourou 20s";
		}
		else {
			return "Demourou 30S";
		}
	}
	
	
	abstract String mostrarImagem();


	/**
	 * @return the velProcessador
	 */
	public double getVelProcessador() {
		return velProcessador;
	}


	/**
	 * @param velProcessador the velProcessador to set
	 */
	public void setVelProcessador(double velProcessador) {
		this.velProcessador = velProcessador;
	}
	
	
	
}
