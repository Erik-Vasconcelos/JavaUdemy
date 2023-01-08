package br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.agrupador;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.marttech.sg.controller.AgrupadorController;
import br.com.marttech.sg.model.dto.ServidorDTO;
import br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.agrupador.informacoes.ContainerInformacoes;
import br.com.marttech.sg.view.interfaces.telas_funcoes.usuarios.container_user.ContainerUsuario;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * @author erikv
 * @date 19:33:40 11 de nov. de 2022
 */

public class AgrupadorUsuarios extends VBox {

	private static int qtdContents = 0;
	
	private static int paginaAtual;
	private static int totalPaginas;
	
	private static int usuariosPorPagina = 5;
	private static int totalUsuarios;
	
	private static TipoConsulta ultimaConsulta;
	private static String ultimoFiltro;
	
	private ContainerInformacoes informacoes;
	private List<ContainerUsuario> listContentUser;
	
	private EventHandler acaoBotaoUpdateContent;
	
	
	/*--------------------------Construtores------------------------------*/

	public AgrupadorUsuarios(EventHandler acaoBotaoUpdateContent) {
		this.acaoBotaoUpdateContent = acaoBotaoUpdateContent;
		configuration();
		initComponents();
		addTodosContents();
	}
	
	/*--------------------------Métodos de configuraçoe------------------------------*/
	
	private void configuration() {
		setAlignment(Pos.TOP_CENTER);
		setPadding(new Insets(25, 20, 20, 20));
		setSpacing(2);
		
		String css = getClass().getResource("Agrupador.css").toExternalForm();
		getStylesheets().add(css);
		getStyleClass().add("Agrupador");
	}
	
	private void initComponents() {
		informacoes = new ContainerInformacoes();
		listContentUser = new ArrayList<>();
		getChildren().add(informacoes);
	}
	
	/*-----------------------Métodos de adicionar contents no agrupador------------------------------*/
	
	public void addTodosContents(int pagina) {
		List<ServidorDTO> listaUsuarios = AgrupadorController.getUsuariosPaginados(pagina);
		ultimaConsulta = TipoConsulta.PADRAO;
		setPaginaAtual();
		setTotalPaginas();
		setTotalUsuarios();
		addComponents(listaUsuarios);
	}
	
	public void addTodosContents() {
		addTodosContents(1);
	}
	
	public void addContentsComParteNomeUsuario(String parteNome) {
		addContentsComParteNomeUsuario(parteNome, 1);
	}
	
	public void addContentsComParteNomeUsuario(String parteNome, int pagina) {
		ultimaConsulta = TipoConsulta.FILTRO;
		List<ServidorDTO> usuarios = AgrupadorController.getUsuariosParteNome(parteNome, pagina);
		setPaginaAtual();
		setTotalPaginas();
		setTotalUsuarios();
		addComponents(usuarios);
		ultimoFiltro = parteNome;
	}
	
	/*-----------------------Métodos de auxiliares------------------------------*/
	
	private void addComponents(List<ServidorDTO> listaUsuarios) {
		resetListContents();
		Predicate<Integer> isEspaco = v -> v < usuariosPorPagina;
		
		listaUsuarios.stream().forEach(s -> {
			if(isEspaco.test(qtdContents)) {
				listContentUser.add(new ContainerUsuario(s, acaoBotaoUpdateContent));
				qtdContents++;
			}
		});
		
		getChildren().addAll(listContentUser);
	}
	
	/*-----------------------Métodos de paginacao------------------------------*/
	
	//Paginacao normal/de todos os usuarios
	
	public void recarregar() {
		if (ultimaConsulta.equals(TipoConsulta.PADRAO)) {
			addTodosContents(paginaAtual);
		}else {
			addContentsComParteNomeUsuario(ultimoFiltro, paginaAtual);
		}
	}
	
	public void addProximosContentsPaginados() {
		if(paginaAtual < totalPaginas) {
			resetListContents();
			List<ServidorDTO> usuarios = AgrupadorController.getUsuariosPaginados(++paginaAtual);
			addComponents(usuarios);
			setPaginaAtual();
		}
	}
	
	public void addContentsAterioresPaginados() {
		if(paginaAtual > 1) {
			resetListContents();
			List<ServidorDTO> usuarios = AgrupadorController.getUsuariosPaginados(--paginaAtual);
			addComponents(usuarios);
			setPaginaAtual();
		}
	}
	
	//Paginacao por filtro do nome
	
	public void addProximosContentsPaginadosPorFiltro() {
		if(paginaAtual < totalPaginas) {
			resetListContents();
			List<ServidorDTO> usuarios = AgrupadorController.getUsuariosParteNome(ultimoFiltro, ++paginaAtual);
			addComponents(usuarios);
			setPaginaAtual();
		}
	}
	
	public void addContentsAterioresPaginadosPorFiltro() {
		if(paginaAtual > 1) {
			resetListContents();
			List<ServidorDTO> usuarios = AgrupadorController.getUsuariosParteNome(ultimoFiltro, --paginaAtual);
			addComponents(usuarios);
			setPaginaAtual();
		}
	}
	
	/*-----------------limpa a lista dos de armazenamento contentes-------------------*/
	
	private void resetListContents() {
		getChildren().removeAll(listContentUser);
		listContentUser = new ArrayList<>();
		qtdContents = 0;
	}
	
	/*------------------------Métodos de config de atributos----------------------------*/
	
	private void setTotalPaginas() {
		totalPaginas = AgrupadorController.getTotalPaginas();
	}
	
	private static void setPaginaAtual() {
		paginaAtual = AgrupadorController.getPagina();
	}
	
	private static void setTotalUsuarios() {
		totalUsuarios = AgrupadorController.getQtdTotalUsuarios();
	}
	
	/*------------------------Métodos de acesso por outras classes----------------------------*/
	
	public void reset() {
		getChildren().removeAll(listContentUser);
		listContentUser.clear();
		qtdContents = 0;
		totalPaginas = 0;
		paginaAtual = 1;
		totalUsuarios = 0;
	}
	
	public static int getTotalUsuarios() {
		return totalUsuarios;
	}

	public String getInfoPaginas() {
		 return String.format("Página %d de %d", paginaAtual,
				 totalPaginas < 1 ? totalPaginas = 1: totalPaginas);
	}

	public List<ContainerUsuario> getListContentUser() {
		return listContentUser;
	}
	
}
