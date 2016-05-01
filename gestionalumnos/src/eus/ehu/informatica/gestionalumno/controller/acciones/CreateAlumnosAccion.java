package eus.ehu.informatica.gestionalumno.controller.acciones;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eus.ehu.informatica.gestionalumno.controller.View;
import eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional;
import eus.ehu.informatica.gestionalumno.service.dao.AlumnoNacionalServiceImpl;
import eus.ehu.informatica.gestionalumno.service.dao.interfaces.AlumnoNacionalService;

public class CreateAlumnosAccion extends ActionAbstractFactory {

	@Override
	public View ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		View vista = null;
		AlumnoNacionalService ans = null;
		// recoger y validar
		AlumnoNacional alumno = recogerDatos(request);
		if (alumno != null) {
			// llamar a la capa logica (bussiness), paquete service,...
			ans = new AlumnoNacionalServiceImpl();
			alumno = ans.create(alumno);
			Map<String, Object> datos = new HashMap<String, Object>();
			datos.put("alumno", alumno);

			// procesar los datos y crear la vista
			vista = new View("/alumnos/crearalumno.jsp", datos);
		}

		return vista;
	}

	private AlumnoNacional recogerDatos(HttpServletRequest request) {
		// ?id=8
		AlumnoNacional alumno = null;
		try {
			alumno = new AlumnoNacional();
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			int anyo = Integer.parseInt(request.getParameter("anyo"));
			alumno.setAnyo(anyo);
			alumno.setNombre(nombre);
			alumno.setApellidos(apellidos);
		} catch (Exception e) {
			alumno = null;
		}

		return alumno;
	}
}
