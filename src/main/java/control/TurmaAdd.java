package control;

import java.io.IOException;
import java.sql.SQLException;

import dao.InstrutorDao;
import dao.TurmaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Instrutor;
import model.Turma;

/**
 * Servlet implementation class TurmaAdd
 */
public class TurmaAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TurmaAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String dia = request.getParameter("dia");
		String horario = request.getParameter("horario");
		int idInstrutor = Integer.valueOf(request.getParameter("idInstrutor"));
		
		InstrutorDao instDao = new InstrutorDao();
		Instrutor instrutor = null;
		
		try {
			instrutor = instDao.listarUm(idInstrutor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Turma turma = new Turma();
		turma.setNome(nome);
		turma.setDia(dia);
		turma.setHorario(horario);
		turma.setInstrutor(instrutor);

		TurmaDao turDao = new TurmaDao();
		
		try {
			turDao.adicionar(turma);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
