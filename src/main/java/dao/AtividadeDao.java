package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Atividade;


public class AtividadeDao {
	private Connection con;	
	
	public AtividadeDao() {
		con = ConnectionFactory.getConnection();
	}
	
	public void adicionar(Atividade atividade) throws SQLException {
		String sql = "insert into atividade (nome) values (?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, atividade.getNome());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void excluir (int id) throws SQLException {
		String sql = "delete from atividade where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void editar (Atividade atividade) throws SQLException {
		String sql = "update atividade set nome = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, atividade.getNome());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Atividade listarUm(int id) throws SQLException {
		String sql = "select id, nome from atividade where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		Atividade atividade = null;
		ResultSet rs = stmt.executeQuery();	
		if (rs.next()) {
			atividade = new Atividade();
			atividade.setId(rs.getInt("id"));
			atividade.setNome(rs.getString("nome"));
		}
		stmt.close();
		con.close();
		return atividade;
	}
	
	public List<Atividade> listarTodos() throws SQLException {
		String sql = "select id, nome from atividade";
		PreparedStatement stmt = con.prepareStatement(sql);
		Atividade atividade = null;
		List<Atividade> atividades = new ArrayList<Atividade>();
		ResultSet rs = stmt.executeQuery();	
		while (rs.next()) {
			atividade = new Atividade();
			atividade.setId(rs.getInt("id"));
			atividade.setNome(rs.getString("nome"));
			atividades.add(atividade);
		}
		stmt.close();
		con.close();
		return atividades;
	}

}
