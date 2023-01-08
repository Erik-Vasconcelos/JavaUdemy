package br.com.marttech.sg.matricula.interno.infra;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {
	/**
	 * @date 21:47:48 24 de set. de 2022
	 * @system_unity_description Classe responsável por criar a conexao com o banco de dados 
	 * @version 1.0 24 de set. de 2022
	 */

	private Connection conexao;
	
	public static Connection getConexao() {
		try {
			Properties prop = getProperties();
			
			final String url = prop.getProperty("banco.url");
			final String usuario =prop.getProperty("banco.usuario") ;
			final String senha = prop.getProperty("banco.senha");
			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (IOException | SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "connection.properties";
		prop.load(FabricaConexao.class.getResourceAsStream(caminho));
		return prop;
	}
	
}
