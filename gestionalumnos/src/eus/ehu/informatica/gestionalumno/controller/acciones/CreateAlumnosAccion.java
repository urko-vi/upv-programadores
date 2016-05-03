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
import eus.ehu.informatica.gestionalumno.pojo.exceptions.AlumnoNacionalException;
import eus.ehu.informatica.gestionalumno.service.dao.AlumnoNacionalServiceImpl;
import eus.ehu.informatica.gestionalumno.service.dao.interfaces.AlumnoNacionalService;
import eus.ehu.informatica.gestionalumno.service.mensajes.Mensaje;

public class CreateAlumnosAccion extends ActionAbstractFactory {
	private Logger log = Logger.getLogger(CreateAlumnosAccion.class);
	private Mensaje msg = null;

	@Override
	public View ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		View vista = null;
		// recoger y validar
		AlumnoNacional alumno = recogerDatos(request);
		if (msg != null) {
			// llamar a la capa logica (bussiness), paquete service,...
			try {
				procesarAlumno(alumno);
				List<AlumnoNacional> alumnos = cargarListaAlumnos();
				// montamos el objeto de datos
				vista = montarVista(alumnos);
			} catch (ConnectException e) {
				log.error("La conexion a base de datos esta desactivada");
				msg = new Mensaje(
						"La operación no se puede realizar en estos momentos",
						msg.MSG_TYPE_DANGER);
			}
			// cargamos listado de alumnos
			catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// montar la vista --> Los datos (MSG) y el destino
			vista = montarVista(msg, alumno);
		}

		return vista;
	}

	private View montarVista(Mensaje msg2, AlumnoNacional alumno) {
		View vista = null;
		Map<String, Object> datos = null;
		datos = new HashMap<String, Object>();
		datos.put("mensaje", msg2);
		datos.put("alumno", alumno);
		vista = new View("/alumnos/alumno.jsp", datos);
		return vista;
	}

	private View montarVista(List<AlumnoNacional> alumnos) {
		Map<String, Object> datos = null;
		View vista = null;
		datos = new HashMap<String, Object>();
		datos.put("alumnos", alumnos);
		msg = new Mensaje("El alumno ha sido insertado correctamente",
				Mensaje.MSG_TYPE_SUCCESS);
		datos.put("mensaje", msg);
		// procesar los datos y crear la vista
		vista = new View("/alumnos/listado.jsp", datos);
		return vista;
	}

	private List<AlumnoNacional> cargarListaAlumnos() throws ConnectException,
			NamingException, SQLException {
		List<AlumnoNacional> alumnos = null;
		AlumnoNacionalService ans = new AlumnoNacionalServiceImpl();
		alumnos = ans.getAll();
		return alumnos;
	}

	private void procesarAlumno(AlumnoNacional alumno) throws ConnectException,
			NamingException, SQLException {
		AlumnoNacionalService ans = new AlumnoNacionalServiceImpl();
		alumno = ans.create(alumno);
	}

	private AlumnoNacional recogerDatos(HttpServletRequest request) {
		// ?id=8
		AlumnoNacional alumno = null;

		alumno = new AlumnoNacional();

		try {
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			int anyo = Integer.parseInt(request.getParameter("anyo"));

			alumno.setAnyo(anyo);
			alumno.setNombre(nombre);
			alumno.setApellidos(apellidos);
			alumno.validar();
		} catch (AlumnoNacionalException e) {
			log.error(e.getMessage());
			msg = new Mensaje(e.getMessage(), Mensaje.MSG_TYPE_DANGER);
		} catch (NullPointerException e) {
			log.error("Es nulo un parametro " + e.getMessage());
			msg = new Mensaje(e.getMessage(), Mensaje.MSG_TYPE_INFO);
		} catch (Exception e) {
			log.error("Error no controlado " + e.getMessage());
			msg = new Mensaje(e.getMessage(), Mensaje.MSG_TYPE_WARNING);
		}

		return alumno;
	}
}
