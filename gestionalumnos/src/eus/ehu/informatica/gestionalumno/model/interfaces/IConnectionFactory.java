package eus.ehu.informatica.gestionalumno.model.interfaces;

import java.sql.SQLException;

import javax.naming.NamingException;

public interface IConnectionFactory {
	public IConnection getIConnection() throws NamingException, SQLException;
}
