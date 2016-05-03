package eus.ehu.informatica.gestionalumno.controller.acciones;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import eus.ehu.informatica.gestionalumno.controller.View;
import eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional;
import eus.ehu.informatica.gestionalumno.service.dao.AlumnoNacionalServiceImpl;
import eus.ehu.informatica.gestionalumno.service.dao.interfaces.AlumnoNacionalService;
import eus.ehu.informatica.gestionalumno.service.mensajes.Mensaje;

public class ListadoAlumnosAccion extends ActionAbstractFactory {
	private Logger log = Logger.getLogger(ListadoAlumnosAccion.class);

	@Override
	public View ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		// capturar los datos que se reciben: validar, controlar excepciones y
		// convertirlos a objetos java

		// llamar a la logica de la aplicación (capa de negocio)

		View vista = null;
		Map<String, Object> datos = null;
		datos = new HashMap<String, Object>();
		try {
			List<AlumnoNacional> alumnos = obtenerListado();
			// añadimos la lista al mapa
			datos.put("alumnos", alumnos);
			// montar el objeto de tipo View datos + página de destino
			vista = new View("/index.jsp", datos);
		} catch (ConnectException e) {
			Mensaje msg = new Mensaje(
					"La operación que intenta realizar no se encuentra disponible en este momento",
					Mensaje.MSG_TYPE_DANGER);
			log.error("Error conexion");
			datos.put("mensaje", msg);
			vista = new View("/index.jsp", datos);
		} catch (NamingException e) {
			Mensaje msg = new Mensaje(
					"La operación que intenta realizar no se encuentra disponible en este momento",
					Mensaje.MSG_TYPE_DANGER);
			datos.put("mensaje", msg);
			log.error("Error en la configuración del contexto");
			vista = new View("/index.jsp", datos);
		} catch (SQLException e) {
			Mensaje msg = new Mensaje(
					"La operación que intenta realizar no se encuentra disponible en este momento",
					Mensaje.MSG_TYPE_DANGER);
			datos.put("mensaje", msg);

			log.error("No se encuentra la conexion a ");
			vista = new View("/index.jsp", datos);
		}
		return vista;
	}

	/**
	 * @return
	 * @throws ConnectException
	 * @throws SQLException
	 * @throws NamingException
	 */
	private List<AlumnoNacional> obtenerListado() throws ConnectException,
			NamingException, SQLException {
		AlumnoNacionalService ans = new AlumnoNacionalServiceImpl();
		List<AlumnoNacional> alumnos = ans.getAll();
		return alumnos;
	}
}
