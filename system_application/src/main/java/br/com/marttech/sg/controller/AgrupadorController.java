package br.com.marttech.sg.controller;

import java.util.List;

import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.model.infra.DAOServidor;

public class AgrupadorController {

	private static DAOServidor dao = new DAOServidor();
	
	private static int pagina;
	private static int totalPaginas;
	
	private static int qtdUsuariosPg = 5;
	private static int qtdTotalUsuarios;
	
	private static int inicio;
	
	/*---------------------Metodos de obter os usuarios----------------------*/
	
	public static List<ServidorDTO> getUsuariosPaginados(int numeroPagina) {
		AgrupadorController.pagina = numeroPagina;
		calcularInicio();
		totalDeUsuarios();
		calcularTotalPaginas();
	
		List<ServidorDTO> usuarios = dao.consultarParteDados(qtdUsuariosPg, inicio);
		//List<DadosServidor> usuariosParaFront = tranferirDados(usuarios);
		
		return usuarios;
	}
	
	public static List<ServidorDTO> getUsuariosParteNome(String parteNome, int numeroPagina){
		AgrupadorController.pagina = numeroPagina;
		calcularInicio();
		totalDeUsuariosPorFiltro(parteNome);
		calcularTotalPaginas();
		
		List<ServidorDTO> usuarios = dao.consultarParteDadosPorFiltro(parteNome, qtdUsuariosPg, inicio);
		//List<DadosServidor> usuariosParaFront = tranferirDados(usuarios);
		return usuarios;
	}
	
	/*---------------------Metodos da mecanica do funcionamento----------------------*/
	
	/*private static ArrayList<DadosServidor> tranferirDados(List<ServidorDTO> usuarios){
		ArrayList<DadosServidor> usuariosParaFront = new ArrayList<>();
		
		Predicate<ServidorDTO> differentThisUser = u -> 
			!u.getMatricula().equals(ServidorMemory.getInstance().getMatricula());
		
		usuarios.stream().filter(differentThisUser).forEach(u -> {
			DadosServidor servidor = convertUserToFront(u);
			usuariosParaFront.add(servidor);
		});
		
		return usuariosParaFront;
	}

	private static DadosServidor convertUserToFront(ServidorDTO usuario) {
		Long id = Long.parseLong(usuario.getId());
		String matricula = usuario.getMatricula().toString();
		String nome = usuario.getNome();
		String email = usuario.getEmail();
		String cargo = usuario.getCargo().toString();
		String permissao = usuario.getPermissao().toString();
		
		return new DadosServidor(id, matricula, nome, email, cargo, permissao);
	}*/
	
	/*-----------------------------Metodos de calculo-------------------------------*/
	
	private static void totalDeUsuarios() {
		qtdTotalUsuarios = (int) dao.obterQtdTotalUsuarios();
	}
	
	private static void totalDeUsuariosPorFiltro(String filtro) {
		qtdTotalUsuarios = (int) dao.obterQtdTotalUsuariosPorFiltro(filtro);
	}
	
	private static void calcularInicio() {
		inicio = (pagina * qtdUsuariosPg) - qtdUsuariosPg; 
	}
	
	private static void calcularTotalPaginas() {
		totalPaginas = (int) Math.ceil(qtdTotalUsuarios * 1.0 / (qtdUsuariosPg *1.0));
	}
	
	/*---------------------------Metodos getters and setter-------------------------*/
	
	public static int getPagina() {
		return pagina;
	}

	public static int getTotalPaginas() {
		return totalPaginas;
	}

	public static int getQtdUsuariosPg() {
		return qtdUsuariosPg;
	}

	public static int getInicio() {
		return inicio;
	}

	public static int getQtdTotalUsuarios() {
		return qtdTotalUsuarios;
	}
	
}
