package eus.ehu.informatica.gestionalumno.controller.frontcontroller;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional;
import eus.ehu.informatica.gestionalumno.service.dao.AlumnoNacionalServiceImpl;
import eus.ehu.informatica.gestionalumno.service.dao.interfaces.AlumnoNacionalService;

/**
 * Servlet implementation class AlumnoServlet
 */
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatch = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<AlumnoNacional> alumnos = this.obtenerAlumnos();
		// cargamos el objeto redireccionador
		this.dispatch = request.getRequestDispatcher("/index.jsp");
		// añadimos nuestra lista
		request.setAttribute("alumnos", alumnos);
		// redirecciona
		this.dispatch.forward(request, response);
	}

	private List<AlumnoNacional> obtenerAlumnos() {
		List<AlumnoNacional> alumnos = null;
		AlumnoNacionalService ans;
		try {
			ans = new AlumnoNacionalServiceImpl();
			alumnos = ans.getAll();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return alumnos;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
