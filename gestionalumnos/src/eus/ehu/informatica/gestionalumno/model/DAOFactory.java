package eus.ehu.informatica.gestionalumno.model;

import java.net.ConnectException;
import java.sql.SQLException;

import javax.naming.NamingException;

import eus.ehu.informatica.gestionalumno.model.interfaces.IConnectionFactory;
import eus.ehu.informatica.gestionalumno.model.rdbms.interfaces.AlumnoNacionalDAO;
import eus.ehu.informatica.gestionalumno.model.rdbms.interfaces.AsignaturaDAO;

public abstract class DAOFactory implements IConnectionFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;

	public abstract AlumnoNacionalDAO getAlumnoNacionalDAO(int whichfactory)
			throws ConnectException, NamingException, SQLException;

	public abstract AsignaturaDAO getAsignaturaDAO(int whichfactory)
			throws ConnectException;

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
