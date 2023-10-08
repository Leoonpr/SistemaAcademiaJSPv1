package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Aluno;
import model.Atividade;

public class AlunoDao {

	private Connection con;
	
	public AlunoDao() {
		con = ConnectionFactory.getConnection();
	}
	public void adicionar(Aluno aluno) throws SQLException {
		String sql = "insert into aluno (nome, cpf, email, telefone, endereco, cidade, bairro, idTurma) values(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, aluno.getNome());
		stmt.setString(2, aluno.getCpf());
		stmt.setString(3, aluno.getEmail());
		stmt.setString(4, aluno.getTelefone());
		stmt.setString(5, aluno.getEndereco());
		stmt.setString(6, aluno.getCidade());
		stmt.setString(7, aluno.getBairro());
		stmt.setInt(8, aluno.getTurma().getId());

		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void excluir (int id) throws SQLException {
		String sql = "delete from aluno where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void editar (Aluno aluno) throws SQLException {
		String sql = "update aluno set nome = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, aluno.getNome());
		stmt.execute();
		stmt.close();
		con.close();
	}
}
