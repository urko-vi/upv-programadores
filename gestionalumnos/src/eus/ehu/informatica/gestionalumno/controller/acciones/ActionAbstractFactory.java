package eus.ehu.informatica.gestionalumno.controller.acciones;

import javax.servlet.http.HttpServletRequest;

import eus.ehu.informatica.gestionalumno.controller.acciones.interfaces.Accion;

public abstract class ActionAbstractFactory implements Accion {

	protected String getActionName(HttpServletRequest request) {
		String servletPath = request.getServletPath();
		String accionUrl = servletPath.substring(1,
				servletPath.lastIndexOf('.'));
		return accionUrl;
	}
}
