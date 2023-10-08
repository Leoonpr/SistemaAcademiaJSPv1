package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.InstrutorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Instrutor;

/**
 * Servlet implementation class InstrutorListar
 */
public class InstrutorListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrutorListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = request.getParameter("next");
		String msg;
		InstrutorDao instDao = new InstrutorDao();
		List<Instrutor> instrutores = null;
		try {
			instrutores = instDao.listarTodos();
		} catch (SQLException e) {
			next = "msg.jsp";
			msg = "Erro ao listar.";
			request.setAttribute("msg", msg);
		}
		
		request.setAttribute("instrutores", instrutores);
		RequestDispatcher rd = request.getRequestDispatcher(next);
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
