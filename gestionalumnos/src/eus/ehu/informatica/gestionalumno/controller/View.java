package eus.ehu.informatica.gestionalumno.controller;

import java.util.Map;

public class View {
	private String page;
	private Map<String, ?> datos;

	/**
	 * 
	 */
	private View() {
		super();
	}

	/**
	 * @param page
	 * @param datos
	 */
	public View(String page, Map<String, ?> datos) {
		super();
		this.page = page;
		this.datos = datos;
	}

	public void clean() {
		this.datos = null;
	}

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * @return the datos
	 */
	public Map<String, ?> getDatos() {
		return datos;
	}

	/**
	 * @param datos
	 *            the datos to set
	 */
	public void setDatos(Map<String, ?> datos) {
		this.datos = datos;
	}

}
