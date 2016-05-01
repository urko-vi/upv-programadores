package eus.ehu.informatica.gestionalumno.service.dao;

import java.util.ArrayList;
import java.util.List;

import eus.ehu.informatica.gestionalumno.model.DAOFactory;
import eus.ehu.informatica.gestionalumno.model.rdbms.interfaces.AlumnoNacionalDAO;
import eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional;
import eus.ehu.informatica.gestionalumno.service.dao.interfaces.AlumnoNacionalService;

public class AlumnoNacionalServiceImpl implements AlumnoNacionalService {
	private List<AlumnoNacional> alumnos;
	private DAOFactory factoria;
	private AlumnoNacionalDAO alumnoDAO;

	/**
	 *
	 */
	public AlumnoNacionalServiceImpl() {
		super();
		factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		alumnoDAO = factoria.getAlumnoNacionalDAO(DAOFactory.MYSQL);
	}

	@Override
	public AlumnoNacional create(AlumnoNacional alumno) {
		AlumnoNacional aux = null;
		aux = alumnoDAO.create(alumno);
		return aux;
	}

	@Override
	public int delete(int codigo) {
		int error;
		if (this.alumnos.remove(codigo) == null) {
			error = -2000;
		} else {
			error = 0;
		}
		return error;
	}

	@Override
	public List<AlumnoNacional> getAll() {
		List<AlumnoNacional> alumnos = null;
		alumnos = alumnoDAO.getAll();
		return alumnos;
	}

	@Override
	public AlumnoNacional getById(final int codigo) {
		AlumnoNacional alumno = null;
		alumno = this.alumnos.get(codigo);
		return alumno;
	}

	private void init() {
		this.alumnos = new ArrayList<AlumnoNacional>();
		AlumnoNacional al = new AlumnoNacional();

		al.setApellidos("Fernandez Hernandez");
		al.setNombre("Alberto");

		this.create(al);

	}

	@Override
	public AlumnoNacional update(final AlumnoNacional alumno) {
		this.alumnos.add(alumno.getCodigo(), alumno);
		return alumno;
	}

}
