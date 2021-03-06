package eus.ehu.informatica.gestionalumno.model;

import java.net.ConnectException;
import java.sql.SQLException;

import javax.naming.NamingException;

import eus.ehu.informatica.gestionalumno.model.interfaces.IConnection;
import eus.ehu.informatica.gestionalumno.model.rdbms.AlumnoNacionalDAOImp;
import eus.ehu.informatica.gestionalumno.model.rdbms.AsignaturaDAOImp;
import eus.ehu.informatica.gestionalumno.model.rdbms.interfaces.AlumnoNacionalDAO;
import eus.ehu.informatica.gestionalumno.model.rdbms.interfaces.AsignaturaDAO;

public class MySQLFactory extends DAOFactory {
	private static MySQLFactory instance = null;

	private MySQLFactory() {
		super();
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new MySQLFactory();

		}
	}

	public static MySQLFactory getInstance() {
		if (instance == null)
			createInstance();
		return instance;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	@Override
	public IConnection getIConnection() throws NamingException, SQLException {
		return MySQLConnection.getInstance();
	}

	@Override
	public AlumnoNacionalDAO getAlumnoNacionalDAO(int whichfactory)
			throws ConnectException, NamingException, SQLException {

		return AlumnoNacionalDAOImp.getInstance(whichfactory);
	}

	@Override
	public AsignaturaDAO getAsignaturaDAO(int whichfactory) {
		// TODO Auto-generated method stub
		return new AsignaturaDAOImp();
	}

}
