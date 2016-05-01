package eus.ehu.informatica.gestionalumno.controller.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class WebConfig {
	private static final String MAPPING_FILE = "mappings.properties";
	private Map<String, ActionFactory> acciones = null;

	public WebConfig(String mapFile) {
		File archivo = new File(mapFile);

		if (archivo != null && archivo.isFile() && archivo.exists()) {
			String fileName = archivo.getName();
			if (!fileName.equals(MAPPING_FILE)) {
				throw new UnsupportedOperationException(
						"El nombre del archivo debería de ser: " + MAPPING_FILE);
			}
			acciones = new HashMap<String, ActionFactory>();
			readMappingFile(archivo);
		} else {
			System.out.println("es nulo");
		}
	}

	/**
	 * Lee el archivo properties y las carga en el Map
	 * 
	 * @param archivo
	 */
	private void readMappingFile(File archivo) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(archivo));
			Set<Object> index = prop.keySet();
			Iterator<Object> it = index.iterator();
			while (it.hasNext()) {
				String clave = (String) it.next();
				String nombreClase = prop.getProperty(clave);
				ActionFactory ac = new ActionFactory(clave, nombreClase);
				// acciones.put(clave, ac);
				addAcciones(ac);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addAcciones(ActionFactory ac) {
		if (!acciones.containsKey(ac.getAction())) {
			acciones.put(ac.getAction(), ac);
		} else {
			throw new UnsupportedOperationException("La accion "
					+ ac.getAction()
					+ " ya existe. No se puede tener la misma accion dos veces");
		}

	}

	/**
	 * @return the acciones
	 */
	public Map<String, ActionFactory> getAcciones() {
		return acciones;
	}

}
