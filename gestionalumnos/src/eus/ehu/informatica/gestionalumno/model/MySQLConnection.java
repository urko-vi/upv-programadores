package eus.ehu.informatica.gestionalumno.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import eus.ehu.informatica.gestionalumno.model.interfaces.IConnection;

public class MySQLConnection implements IConnection {
	private static Connection conexion = null;
	private static final String DATA_SOURCE = "java:comp/env/jdbc/Alumnos";
	private static MySQLConnection instance = null;

	private MySQLConnection() {
		super();
		if (conexion == null) {
			conectar();
		}
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new MySQLConnection();

		}
	}

	public static MySQLConnection getInstance() {
		if (instance == null)
			createInstance();
		return instance;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	@Override
	public void conectar() {
		if (conexion == null) {
			try {
				InitialContext ctx = new InitialContext();
				DataSource datasource = (DataSource) ctx.lookup(DATA_SOURCE);
				conexion = datasource.getConnection();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void desconectar() {
		if (conexion != null) {
			try {
				conexion.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conexion = null;
			}
		}
	}

	@Override
	public Connection getConnection() {
		if (conexion == null) {
			conectar();
		}
		return conexion;
	}

}
