package control;

import java.io.IOException;
import java.sql.SQLException;

import dao.AlunoDao;
import dao.TurmaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Turma;

/**
 * Servlet implementation class AlunoAdd
 */
public class AlunoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunoAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Httpervlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		int idTurma = Integer.valueOf(request.getParameter("idTurma"));
		
		TurmaDao turmaDao = new TurmaDao();
		Turma turma = null;
		try {
			turma = turmaDao.listarUm(idTurma);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setEmail(email);
		aluno.setTelefone(telefone);
		aluno.setEndereco(endereco);
		aluno.setCidade(cidade);
		aluno.setBairro(bairro);
		aluno.setTurma(turma);
		AlunoDao aluDao = new AlunoDao();
		try {
			aluDao.adicionar(aluno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
