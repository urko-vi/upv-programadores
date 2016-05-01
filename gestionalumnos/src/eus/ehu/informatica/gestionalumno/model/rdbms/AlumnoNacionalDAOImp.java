package eus.ehu.informatica.gestionalumno.model.rdbms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eus.ehu.informatica.gestionalumno.model.DAOFactory;
import eus.ehu.informatica.gestionalumno.model.interfaces.IConnection;
import eus.ehu.informatica.gestionalumno.model.rdbms.interfaces.AlumnoNacionalDAO;
import eus.ehu.informatica.gestionalumno.pojo.AlumnoNacional;

public class AlumnoNacionalDAOImp implements AlumnoNacionalDAO {
	private static AlumnoNacionalDAOImp instance = null;
	private IConnection conexion;
	private Connection conn;

	private AlumnoNacionalDAOImp(int whichfactory) {
		super();
		conexion = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getIConnection();
		conn = conexion.getConnection();
	}

	private synchronized static void createInstance(int whichfactory) {
		if (instance == null) {
			instance = new AlumnoNacionalDAOImp(whichfactory);

		}
	}

	public static AlumnoNacionalDAOImp getInstance(int whichfactory) {
		if (instance == null)
			createInstance(whichfactory);
		return instance;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	@Override
	public AlumnoNacional create(AlumnoNacional alumno) {
		AlumnoNacional aux = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		int nFilas = 0;
		int codigo = -1;
		try {
			cs = conn.prepareCall("{call createAlumno(?,?,?)}");
			cs.setString("pnombre", alumno.getNombre());
			cs.setString("papellidos", alumno.getApellidos());
			cs.setInt("purte", alumno.getAnyo());
			nFilas = cs.executeUpdate();

			rs = cs.getGeneratedKeys();
			while (rs.next()) {
				codigo = rs.getInt(1);
			}
			aux = alumno;
			aux.setCodigo(codigo);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}

	@Override
	public int delete(int codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AlumnoNacional> getAll() {
		List<AlumnoNacional> alumnos = null;
		CallableStatement cSmt = null;
		ResultSet rs;
		// PreparedStatement pSmt = null;
		try {
			cSmt = conn.prepareCall("{call getAll()}");
			// cSmt = conn.prepareCall("{call nnpkg.getAll(?)}");// ORACLE
			// cSmt.registerOutParameter(1, OracleTypes.CURSOR);// ORACLE
			rs = cSmt.executeQuery();// SELECT
			// int i = cSmt.executeUpdate();// UPDATE, DELETE, INSERT

			// rs = (ResultSet) cSmt.getObject(1); // PARA ORACLE

			alumnos = generateAlumnoNacional(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos;
	}

	/**
	 * @param alumnos
	 * @throws SQLException
	 */
	private List<AlumnoNacional> generateAlumnoNacional(ResultSet rs)
			throws SQLException {
		List<AlumnoNacional> alumnos = new ArrayList<AlumnoNacional>();

		AlumnoNacional alumno;
		while (rs.next()) {
			alumno = new AlumnoNacional();
			alumno.setCodigo(rs.getInt("codigo"));
			// alumno.setAnyo(rs.getInt(""));
			alumno.setNombre(rs.getString("nombre"));
			alumnos.add(alumno);
		}
		return alumnos;
	}

	@Override
	public AlumnoNacional getById(int codigo) {
		AlumnoNacional alumno = null;
		CallableStatement cSmt = null;
		ResultSet rs;
		try {
			cSmt = conn.prepareCall("{call getById(?)}");
			cSmt.setInt(1, codigo);
			rs = cSmt.executeQuery();
			alumno = generateAlumnoNacional(rs).get(0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumno;
	}

	@Override
	public AlumnoNacional update(AlumnoNacional alumno) {
		// TODO Auto-generated method stub
		return null;
	}

}
