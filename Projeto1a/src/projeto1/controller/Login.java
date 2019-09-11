package projeto1.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String usuario = request.getParameter("usuariologin");
		String senha = request.getParameter("senhalogin");
		try {
			Usuario usuarioLogin = dao.login(usuario, senha);
			PrintWriter out = response.getWriter();
			
			if (usuarioLogin == null) {
				out.print("<body>");
				out.print("<h3>Você não está cadastrado ou senha incorreta!</h3>");
				out.print("</body>");
			} else {
				List<Nota> notas = dao.getLista(usuarioLogin.getId());
				request.setAttribute("notas", notas);
				request.setAttribute("usuario", usuarioLogin);
				RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
			
			}
		} catch (SQLException e) {
			PrintWriter out = response.getWriter();
			out.print("<body>");
			out.print("<h3>Você não está cadastrado!</h3>");
			out.print("</body>");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
