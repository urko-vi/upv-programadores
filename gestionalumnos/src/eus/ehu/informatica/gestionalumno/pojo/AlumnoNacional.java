/**
 *
 */
package eus.ehu.informatica.gestionalumno.pojo;

import java.util.Calendar;

/**
 * @author va00
 *
 */
public class AlumnoNacional extends Alumno {
	private String nss;

	/**
	 *
	 */
	public AlumnoNacional() {
		super();
		this.nss = new String("");
		this.nss = "";
		/*
		 * final String provincia = this.nss.substring(0, 2); final int codigo =
		 * Integer.parseInt(provincia); final String prov =
		 * String.valueOf(codigo);
		 */
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return this.nss;
	}

	/**
	 * @param nss
	 *            the nss to set
	 */
	public void setNss(final String nss) {
		this.nss = nss;
	}

	@Override
	public boolean validar() {
		boolean valido = false;
		final Calendar calendario = Calendar.getInstance();
		final int year = calendario.get(Calendar.YEAR);
		// AND --> &&
		// OR --> ||
		if (this.getnHermanos() >= 0 && this.getAnyo() <= year) {
			valido = true;
		}

		return valido;
	}

}
