package eus.ehu.informatica.gestionalumno.model.interfaces;

//cuidado con el import tiene que ser java.sql.Connection
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

public interface IConnection {
	//
	public void conectar() throws NamingException, SQLException;

	//
	public void desconectar();

	//
	public Connection getConnection() throws NamingException, SQLException;
}
