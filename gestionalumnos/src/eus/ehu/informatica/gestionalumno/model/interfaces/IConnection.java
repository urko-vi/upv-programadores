package eus.ehu.informatica.gestionalumno.model.interfaces;

//cuidado con el import tiene que ser java.sql.Connection
import java.sql.Connection;

public interface IConnection {
	//
	public void conectar();

	//
	public void desconectar();

	//
	public Connection getConnection();
}
