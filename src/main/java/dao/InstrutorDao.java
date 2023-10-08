package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Instrutor;

public class InstrutorDao {
	private Connection con;
	
	public InstrutorDao(){
		con = ConnectionFactory.getConnection();
	}
	
	public void adicionar(Instrutor instrutor) throws SQLException {
		String sql = "insert into instrutor (nome,cpf,email,telefone,especialidade,idAtividade) values (?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, instrutor.getNome());
		stmt.setString(2,  instrutor.getCpf());
		stmt.setString(3, instrutor.getEmail());
		stmt.setString(4, instrutor.getTelefone());
		stmt.setString(5, instrutor.getEspecialidade());
		stmt.setInt(6, instrutor.getAtividade().getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void excluir(int id) throws SQLException{
		String sql = "delete from instrutor where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		con.close();		
	}
	
	public void editar(Instrutor instrutor) throws SQLException {
	    String sql = "update instrutor set nome = ?, cpf = ?, email = ?, telefone = ?, especialidade = ? where id = ?";
	    PreparedStatement stmt = con.prepareStatement(sql);
	    
	    stmt.setString(1, instrutor.getNome());
	    stmt.setString(2, instrutor.getCpf());
	    stmt.setString(3, instrutor.getEmail());
	    stmt.setString(4, instrutor.getTelefone());
	    stmt.setString(5, instrutor.getEspecialidade());
	    stmt.setInt(6, instrutor.getId());

		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Instrutor listarUm(int id) throws SQLException {
		String sql = "select id, nome, especialidade from instrutor where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		Instrutor instrutor = null;
		ResultSet rs = stmt.executeQuery();	
		if (rs.next()) {
			instrutor = new Instrutor();
			instrutor.setId(rs.getInt("id"));
			instrutor.setNome(rs.getString("nome"));
			instrutor.setEspecialidade(rs.getString("especialidade"));
		}
		
		stmt.close();
		con.close();
		return instrutor;
	}
	
	public List<Instrutor> listarTodos() throws SQLException {
		String sql = "select id, nome, especialidade from instrutor";
		PreparedStatement stmt = con.prepareStatement(sql);
		Instrutor instrutor = null;
		List<Instrutor> instrutores = new ArrayList<Instrutor>();
		ResultSet rs = stmt.executeQuery();	
		while (rs.next()) {
			instrutor = new Instrutor();
			instrutor.setId(rs.getInt("id"));
			instrutor.setNome(rs.getString("nome"));
			instrutor.setEspecialidade(rs.getString("especialidade"));
			instrutores.add(instrutor);
		}
		stmt.close();
		con.close();
		return instrutores;
	}


}
