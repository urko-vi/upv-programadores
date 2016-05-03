/**
 *
 */
package eus.ehu.informatica.gestionalumno.pojo;

import java.util.Calendar;

import eus.ehu.informatica.gestionalumno.pojo.exceptions.AlumnoNacionalException;

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
	public boolean validar() throws AlumnoNacionalException {
		boolean valido = false;
		final Calendar calendario = Calendar.getInstance();
		final int year = calendario.get(Calendar.YEAR);
		// AND --> &&
		// OR --> ||
		if (this.getNombre().length() > 2 && this.getnHermanos() >= 0
				&& this.getAnyo() <= year) {
			valido = true;
		} else {
			checkearError();
		}

		return valido;
	}

	private void checkearError() throws AlumnoNacionalException {
		if (this.getnHermanos() < 0) {
			throw new AlumnoNacionalException(
					AlumnoNacionalException.MSG_N_HERMANOS);
		} else {
			throw new AlumnoNacionalException(
					AlumnoNacionalException.MSG_ANYO_ERROR);
		}

	}

	public String toHTML() {
		return this.getApellidos() + ", " + this.getNombre();
	}

}
