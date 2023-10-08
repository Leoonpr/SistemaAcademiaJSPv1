package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.AtividadeDao;
import dao.InstrutorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atividade;
import model.Instrutor;

/**
 * Servlet implementation class InstrutorAdd
 */
public class InstrutorAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrutorAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String especialidade = request.getParameter("especialidade");
		int idAtividade = Integer.valueOf(request.getParameter("idAtividade"));
		
		AtividadeDao atvDao = new AtividadeDao();
		Atividade atividade = null;
		
		try {
			atividade = atvDao.listarUm(idAtividade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Instrutor instrutor = new Instrutor();
		instrutor.setNome(nome);
		instrutor.setCpf(cpf);
		instrutor.setEmail(email);
		instrutor.setTelefone(telefone);
		instrutor.setEspecialidade(especialidade);
		instrutor.setAtividade(atividade);
		
		InstrutorDao instDao = new InstrutorDao();
		
		try {
			instDao.adicionar(instrutor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Atividade> atividades = null;
		try {
			atividades = atvDao.listarTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("atividades", atividades);
		
		request.setAttribute("instrutor", instrutor);
		RequestDispatcher rd = request.getRequestDispatcher("mostraInstrutor.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
