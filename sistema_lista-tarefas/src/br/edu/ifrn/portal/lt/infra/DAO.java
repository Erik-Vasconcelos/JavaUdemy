package br.edu.ifrn.portal.lt.infra;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifrn.portal.lt.model.Evento;

public class DAO {
	private Connection conexao;
	PreparedStatement stmt;
	
	private Connection getConexao() {
		try {
			if(conexao != null && !conexao.isClosed()) {
				return conexao;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		 conexao = FabricaConexao.getConexao();
		 return conexao;
	}
	
	private PreparedStatement getStatement(TipoSql tipo) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				return stmt;
			}else {
				stmt = getConexao().prepareStatement(getSql(tipo));
				return stmt;
			}
			
		} catch (SQLException e) {
		}
		return stmt;
		
	}
	
	
	/*CRUD*/
	public int create(Evento evento) throws SQLException {
		PreparedStatement stmt = getConexao().prepareStatement(getSql(TipoSql.CREATE), PreparedStatement.RETURN_GENERATED_KEYS);
		setarAtributos(stmt, evento);
		int linhasAfetadas = stmt.executeUpdate();
		return linhasAfetadas;
	}
	
	public Evento read(String titulo) throws SQLException {
		PreparedStatement stmt = getConexao().prepareStatement(getSql(TipoSql.READ));
		stmt.setString(1, "%"+titulo+"%");
		ResultSet r = stmt.executeQuery();
		
		Evento eventoRecebido = null;
		
		if(r.next()) {
			Long id  = r.getLong("id");
			String tituloAt = r.getString("titulo");
			String descricao = r.getString("descricao");
			Date dtCriacao = r.getDate("data_criacao");
			Date dtEntrega = r.getDate("data_entrega");
			boolean status = Boolean.parseBoolean(r.getString("concluido"));
			
			eventoRecebido = new Evento(id, tituloAt, descricao, dtCriacao, dtEntrega, status);
		}
		return eventoRecebido;
	}
	
	public int update(Evento evento) throws SQLException {
			PreparedStatement stmt = getConexao().prepareStatement(getSql(TipoSql.UPDATE));
			setarAtributos(stmt, evento);
			stmt.setLong(6, evento.getId());
			return stmt.executeUpdate();
	} 
	
	public int delete(Evento evento) throws SQLException {
			PreparedStatement stmt = getConexao().prepareStatement(getSql(TipoSql.DELETE));
			stmt.setLong(1, evento.getId());
			return stmt.executeUpdate();
	}
	
	private void close() throws SQLException {
		conexao.close();
		conexao = null;
	}
	
	/*Metodos auxiliares*/
	private String getSql(TipoSql tipo) {
		String sql = "";
		
		switch(tipo) {
			case CREATE:
				sql = "INSERT INTO evento(titulo, descricao, data_criacao, data_entrega, concluido)"
					+ "VALUES(?, ?, ?, ?, ?)";
				break;
			case READ:
				sql= "SELECT * FROM evento WHERE titulo like ?";
				break;
			case UPDATE:
				sql = "UPDATE EVENTO SET TITULO = ?, DESCRICAO = ?, DATA_CRIACAO = ?,"
						+ " DATA_ENTREGA = ?, CONCLUIDO = ?"
						+ "WHERE ID = ?";
				break;
			case DELETE:
				sql = "DELETE FROM EVENTO WHERE ID = ?";
				break;
			default:
				sql = "";
		}
		return sql;
	}
	
	private void setarAtributos(PreparedStatement stmt, Evento evento) {
		try {
			stmt.setString(1, evento.getTitulo());
			stmt.setString(2, evento.getDescricao());
			stmt.setDate(3, (Date) evento.getDtaCriacao());
			stmt.setDate(4, (Date) evento.getDtaEntrega());
			stmt.setString(5, evento.isConcluido()+"");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
