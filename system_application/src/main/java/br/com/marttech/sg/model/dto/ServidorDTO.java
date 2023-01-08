package br.com.marttech.sg.model.dto;

public class ServidorDTO {
	private String id;
	private String matricula;
	private String login;
	private String nome;
	private String cpf;
	private String email;
	private String cargo;
	private String permissao;
	private String salario;
	private String telefone;
	private String tipoTelefone;
	private String rua;
	private String bairro;
	private String cidade;
	private String numero;
	private String estado;
	private String senha;
	private byte[] imagem;
	
	public ServidorDTO() {
	}
	
	public ServidorDTO(String nome, byte[] imagem) {
		super();
		this.nome = nome;
		this.imagem = imagem;
	}

	public ServidorDTO(String id, String matricula, String nome, String email, String cargo, String permissao) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
		this.permissao = permissao;
	}

	public ServidorDTO(String id, String matricula, String nome, String cpf, String email, String cargo,
			String permissao, String salario, String telefone, String tipoTelefone, String rua, String bairro,
			String cidade, String numero, String estado, String senha, byte[] imagem) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cargo = cargo;
		this.permissao = permissao;
		this.salario = salario;
		this.telefone = telefone;
		this.tipoTelefone = tipoTelefone;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.estado = estado;
		this.senha = senha;
		this.imagem = imagem;
	}
	
	public ServidorDTO(String nome, String cpf, String email, String cargo, String permissao,
			String salario, String telefone, String tipoTelefone, String rua, String bairro, String cidade,
			String numero, String estado, byte[] imagem) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cargo = cargo;
		this.permissao = permissao;
		this.salario = salario;
		this.telefone = telefone;
		this.tipoTelefone = tipoTelefone;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.estado = estado;
		this.imagem = imagem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
}
