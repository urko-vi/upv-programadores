package eus.ehu.informatica.gestionalumno.controller.config;

import static java.lang.Class.forName;
import eus.ehu.informatica.gestionalumno.controller.acciones.interfaces.Accion;

public class ActionFactory {
	private String action;
	private String actionClass;

	private ActionFactory() {
		super();
	}

	/**
	 * @param action
	 * @param actionClass
	 */
	public ActionFactory(String action, String actionClass) {
		super();
		this.action = action;
		this.actionClass = actionClass;
	}

	public Accion obtenerAccion() {
		Accion accion = null;
		if (actionClass != null && !actionClass.isEmpty()) {

			try {
				accion = (Accion) forName(actionClass).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return accion;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the actionClass
	 */
	public String getActionClass() {
		return actionClass;
	}

	/**
	 * @param actionClass
	 *            the actionClass to set
	 */
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}

}
