package eus.ehu.informatica.gestionalumno.model.rdbms.interfaces;

import java.util.List;

import eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional;
import eus.ehu.informatica.gestionalumno.pojo.Asignatura;

public interface AsignaturaDAO {
	public List<Asignatura> getByAlumno(AlumnoNacional alumno);

	public Asignatura getById(Asignatura asignatura);
}
