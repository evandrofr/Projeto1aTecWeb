package projeto1.controller;

import java.io.IOException;

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
 * Servlet implementation class EditNote
 */
@WebServlet("/EditNote")
public class EditNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNote() {
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
		String nota_id = request.getParameter("edit");
		Nota nota = dao.getNota(nota_id);
		request.setAttribute("nota", nota);
		Usuario usuario = dao.getUsuario(nota.getUsuario_id());
		request.setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("editor.jsp");
		rd.forward(request, response);
	}

}
