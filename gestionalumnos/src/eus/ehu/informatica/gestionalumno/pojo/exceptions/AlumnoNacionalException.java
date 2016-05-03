package eus.ehu.informatica.gestionalumno.pojo.exceptions;

import eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional;

public class AlumnoNacionalException extends Exception {

	public static final String MSG_ANYO_ERROR = "El año tiene que ser inferior al año actual";
	public static final String MSG_N_HERMANOS = "El número de hermanos tiene que ser mayor o igual a 0";
	private AlumnoNacional alumno;

	/**
	 * 
	 */
	public AlumnoNacionalException(AlumnoNacional alumno) {
		super();
		this.alumno = alumno;
	}

	/**
	 * @param message
	 */
	public AlumnoNacionalException(String message) {
		super(message);
	}

}
