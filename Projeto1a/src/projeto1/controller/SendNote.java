package projeto1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projeto1.DAO;
import projeto1.Nota;
import projeto1.Usuario;

/**
 * Servlet implementation class SendNote
 */
@WebServlet("/SendNote")
public class SendNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendNote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		String user_id = request.getParameter("user_id");
		String title = request.getParameter("titulo");
		String message = request.getParameter("msg");
		String deadlineString = request.getParameter("deadline");

		try {
			dao.sendNote(title, message, deadlineString, user_id);
			List<Nota> notas = dao.getLista(Integer.valueOf(user_id));
			Usuario usuario = dao.getUsuario(Integer.valueOf(user_id));
			request.setAttribute("notas", notas);
			request.setAttribute("usuario", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
