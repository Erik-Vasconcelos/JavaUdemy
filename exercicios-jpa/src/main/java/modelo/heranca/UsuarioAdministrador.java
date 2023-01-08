package modelo.heranca;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administradores")
public class UsuarioAdministrador extends Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int tipoAdm;
	
	private String cargo;

	public int getTipoAdm() {
		return tipoAdm;
	}

	public void setTipoAdm(int tipoAdm) {
		this.tipoAdm = tipoAdm;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
