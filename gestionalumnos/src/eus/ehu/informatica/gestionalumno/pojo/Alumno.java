package eus.ehu.informatica.gestionalumno.pojo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import eus.ehu.informatica.gestionalumno.pojo.interfaces.Validable;

/**
 * Esta clase encapsulara los datos de los alumnos de la UPV.
 * 
 * @author va00
 *
 */

public abstract class Alumno implements Validable {
	private int codigo;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private int nHermanos;
	private int anyo;
	private List<Asignatura> asignaturas;

	public Alumno() {
		super();
		Calendar calendario = Calendar.getInstance();
		this.nombre = "";
		this.apellidos = "";
		this.fechaNacimiento = new Date();
		this.nHermanos = 0;
		this.anyo = calendario.get(Calendar.YEAR);
		this.asignaturas = new ArrayList<Asignatura>();
	}

	/**
	 * @return the asignaturas
	 */
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	/**
	 * @param asignaturas
	 *            the asignaturas to set
	 */
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return this.codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the nHermanos
	 */
	public int getnHermanos() {
		return nHermanos;
	}

	/**
	 * @param nHermanos
	 *            the nHermanos to set
	 */
	public void setnHermanos(int nHermanos) {
		this.nHermanos = nHermanos;
	}

	/**
	 * @return the anyo
	 */
	public int getAnyo() {
		return anyo;
	}

	/**
	 * @param anyo
	 *            the anyo to set
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

}
