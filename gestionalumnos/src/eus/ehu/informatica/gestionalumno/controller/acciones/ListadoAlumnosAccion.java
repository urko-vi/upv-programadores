package eus.ehu.informatica.gestionalumno.controller.acciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eus.ehu.informatica.gestionalumno.controller.View;
import eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional;
import eus.ehu.informatica.gestionalumno.service.dao.AlumnoNacionalServiceImpl;
import eus.ehu.informatica.gestionalumno.service.dao.interfaces.AlumnoNacionalService;

public class ListadoAlumnosAccion extends ActionAbstractFactory {

	@Override
	public View ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		// capturar los datos que se reciben: validar, controlar excepciones y
		// convertirlos a objetos java

		// llamar a la logica de la aplicación (capa de negocio)
		AlumnoNacionalService ans = new AlumnoNacionalServiceImpl();
		List<AlumnoNacional> alumnos = ans.getAll();
		// montar el objeto de tipo View datos + página de destino
		Map<String, List<AlumnoNacional>> datos = null;
		datos = new HashMap<String, List<AlumnoNacional>>();
		// añadimos la lista al mapa
		datos.put("alumnos", alumnos);
		View vista = new View("/index.jsp", datos);
		return vista;
	}
}
