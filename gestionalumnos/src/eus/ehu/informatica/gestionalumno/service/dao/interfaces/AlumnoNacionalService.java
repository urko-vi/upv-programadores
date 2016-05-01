package eus.ehu.informatica.gestionalumno.service.dao.interfaces;

import java.util.List;

import eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional;

public interface AlumnoNacionalService {
	/**
	 * Operaciones de CRUD --> Create, Read, Update, Delete.
	 */
	public AlumnoNacional create(AlumnoNacional alumno);

	public int delete(int codigo);

	public List<AlumnoNacional> getAll();

	public AlumnoNacional getById(int codigo);

	public AlumnoNacional update(AlumnoNacional alumno);
}
