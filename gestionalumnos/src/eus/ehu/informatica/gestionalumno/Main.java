package eus.ehu.informatica.gestionalumno;

import eus.ehu.informatica.gestionalumno.pojo.Alumno;
import eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional;
import eus.ehu.informatica.gestionalumno.pojo.interfaces.Validable;

public class Main {

	private static String ejecutarValidacion(final Validable valido) {
		String mensaje = "Hay un error";
		// valido.
		try {
			if (valido.validar()) {
				mensaje = "Todo es correcto";
			} else {
				mensaje = "Hay un error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mensaje;
	}

	public static void main(final String[] args) {
		// TODO crear un alumno y mostrar su nombre y apellidos.
		Alumno al = null;
		AlumnoNacional alnacional = null;
		Validable valido;
		valido = new AlumnoNacional();
		if (valido instanceof AlumnoNacional) {
			final AlumnoNacional aux = (AlumnoNacional) valido;
		}
		al = new AlumnoNacional();
		// al.g
		alnacional = new AlumnoNacional();
		// alnacional.g
		// fijo unos determinados valores al objeto al.
		al.setNombre("Fran");
		al.setApellidos("Alvarez Fernandez");

		System.out.println("Nombre: " + al.getNombre() + " Apellidos: "
				+ al.getApellidos());
		// alnacional.
		// syso + ctrl + espacio
		System.out.println(Main.ejecutarValidacion(alnacional));
		Math.pow(5, 3);
	}
}
