package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Turma;

public class TurmaDao {
	private Connection con;

	public TurmaDao() {
		con = ConnectionFactory.getConnection();
	}

	public void adicionar(Turma turma) throws SQLException {
		String sql = "insert into turma (nome,dia,horario,idInstrutor) values (?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, turma.getNome());
		stmt.setString(2, turma.getDia());
		stmt.setString(3, turma.getHorario());
		stmt.setInt(4, turma.getInstrutor().getId());

		stmt.execute();
		stmt.close();
		con.close();
	}

	public void excluir(int id) throws SQLException {
		String sql = "delete from turma where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		con.close();
	}

	public void editar(Turma turma) throws SQLException {
		String sql = "update turma set nome = ?, dia = ?, horario = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, turma.getNome());
		stmt.setString(2, turma.getDia());
		stmt.setString(3, turma.getHorario());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Turma listarUm(int id) throws SQLException {
		String sql = "select id, nome, dia, horario from turma where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		Turma turma = null;
		ResultSet rs = stmt.executeQuery();	
		if (rs.next()) {
			turma = new Turma();
			turma.setId(rs.getInt("id"));
			turma.setDia(rs.getString("dia"));
			turma.setNome(rs.getString("nome"));
			turma.setHorario(rs.getString("horario"));
		}
		stmt.close();
		con.close();
		return turma;
	}
	
	public List<Turma> listarTodos() throws SQLException {
		String sql = "select id, dia, nome, horario from turma";
		PreparedStatement stmt = con.prepareStatement(sql);
		Turma turma = null;
		List<Turma> turmas = new ArrayList<Turma>();
		ResultSet rs = stmt.executeQuery();	
		while (rs.next()) {
			turma = new Turma();
			turma.setId(rs.getInt("id"));
			turma.setNome(rs.getString("nome"));
			turma.setDia(rs.getString("dia"));
			turma.setHorario(rs.getString("horario"));
			turmas.add(turma);
		}
		stmt.close();
		con.close();
		return turmas;
		
	}
}
