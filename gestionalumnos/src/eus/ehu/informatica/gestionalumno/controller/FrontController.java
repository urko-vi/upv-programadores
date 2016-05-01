package eus.ehu.informatica.gestionalumno.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import eus.ehu.informatica.gestionalumno.controller.acciones.interfaces.Accion;
import eus.ehu.informatica.gestionalumno.controller.config.ActionFactory;
import eus.ehu.informatica.gestionalumno.controller.config.WebConfig;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MAPPING_FILE = "mappings";
	private ServletContext ctx = null;
	private WebConfig webConfig = null;
	private Logger log = Logger.getLogger(FrontController.class);
	private static Map<String, String> props = null;
	private static final String HOME = "paginaPrincipal";
	Map<String, ActionFactory> acciones = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.ctx = config.getServletContext();
		String configAcciones = config.getInitParameter(MAPPING_FILE);
		String rutaAcciones = ctx.getRealPath(configAcciones);
		log.trace(rutaAcciones);
		webConfig = new WebConfig(rutaAcciones);
		// Obtener listado de acciones
		acciones = webConfig.getAcciones();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// recoger la accion
		String servletPath = request.getServletPath();
		String accionUrl = servletPath.substring(1,
				servletPath.lastIndexOf('.'));

		// obtenemos el objeto que gestiona la accion
		ActionFactory ac = acciones.get(accionUrl);
		View vista = null;

		// props = LoadProperties.getProps();

		if (ac != null) {
			String accionPath = ac.getAction();
			if (accionPath.equals(accionUrl)) {
				Accion accion = ac.obtenerAccion();
				try {
					vista = accion.ejecutar(request, response);
					// vista.setPage(props.get(ac.getAction()));
					// preparar los datos para enviarselos al jsp
					prepararDatos(request, vista);
					// redireccionar a la pagina de destino
					enviarRequestaVista(vista, request, response);
				} catch (NullPointerException e) {
					log.error("La clase de la accion no esta creada "
							+ e.getMessage());
					response.sendRedirect(props.get(HOME));
				} catch (Exception e) {
					log.error("Error inesperado" + e.getMessage());
					response.sendRedirect("/index.jsp");
				}
			}
		} else {
			response.sendRedirect(props.get(HOME));
		}
	}

	private void enviarRequestaVista(View vista, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			String pagina = vista.getPage();
			RequestDispatcher rd = ctx.getRequestDispatcher(pagina);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void prepararDatos(HttpServletRequest request, View vista) {
		Map<String, ?> model = vista.getDatos();
		if (model != null) {
			for (Entry<String, ?> dato : model.entrySet()) {
				request.setAttribute(dato.getKey(), dato.getValue());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProccess(request, response);
	}
}
