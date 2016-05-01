package eus.ehu.informatica.gestionalumno.model;

import eus.ehu.informatica.gestionalumno.model.interfaces.IConnectionFactory;
import eus.ehu.informatica.gestionalumno.model.rdbms.interfaces.AlumnoNacionalDAO;
import eus.ehu.informatica.gestionalumno.model.rdbms.interfaces.AsignaturaDAO;

public abstract class DAOFactory implements IConnectionFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;

	public abstract AlumnoNacionalDAO getAlumnoNacionalDAO(int whichfactory);

	public abstract AsignaturaDAO getAsignaturaDAO(int whichfactory);

	public static DAOFactory getDAOFactory(int whichfactory) {
		DAOFactory factoria = null;
		switch (whichfactory) {
		case MYSQL:
			factoria = MySQLFactory.getInstance();

		case ORACLE:
			break;
		}

		return factoria;
	}
}
