package eus.ehu.informatica.gestionalumno.controller.acciones.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eus.ehu.informatica.gestionalumno.controller.View;

public interface Accion {
	public View ejecutar(HttpServletRequest request,
			HttpServletResponse response);
}
