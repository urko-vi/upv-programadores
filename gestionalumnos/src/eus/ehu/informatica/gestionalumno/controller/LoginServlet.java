package eus.ehu.informatica.gestionalumno.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) {
		// validar si la session existe
		session = request.getSession(false);

		if (session == null) {
			// llamar a patron Service ---> DAO
			// request.getSession(true); == request.getSession();
			session = request.getSession();
			session.setMaxInactiveInterval(60 * 10);
			session.setAttribute("mensaje", "Hola Mundo");
			try {
				response.sendRedirect("/index.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// destruir la session

		// crear la session

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

}
