package eus.ehu.informatica.gestionalumno.pojo;

public class AlumnoExtranjero extends Alumno {
	private String pais;

	@Override
	public boolean validar() {
		boolean valido = false;
		// ==
		// !=
		// String spain = "españa";
		if (this.pais != null && "españa".equalsIgnoreCase(this.pais)) {
			valido = true;
		}

		return valido;
	}

}
