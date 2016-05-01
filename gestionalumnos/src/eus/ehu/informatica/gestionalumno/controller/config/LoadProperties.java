package eus.ehu.informatica.gestionalumno.controller.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class LoadProperties {
	private Logger log = Logger.getLogger(LoadProperties.class);
	private static final String PATH_PARAMETERS = "WEB-INF/conf/parameternames.properties";
	private static final String PATH_ATRIBUTES = "WEB-INF/conf/atributesnames.properties";
	private static final String PATH_URLS = "WEB-INF/conf/urls.properties";
	private static Map<String, String> properties = null;
	private static LoadProperties INSTANCE = null;

	// Private constructor suppresses
	private LoadProperties(String relativePath) {
		properties = new HashMap<String, String>();
		loadUrlProperties(relativePath);
		loadAtributesProperties(relativePath);
		loadParameterProperties(relativePath);
	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance(String relativePath) {
		if (INSTANCE == null) {
			INSTANCE = new LoadProperties(relativePath);
		}
	}

	public static LoadProperties getInstance(String relativePath) {
		if (INSTANCE == null)
			createInstance(relativePath);
		return INSTANCE;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	private void loadAtributesProperties(String relativePath) {
		Properties props = new Properties();

		try {
			File configFile = new File(relativePath + PATH_ATRIBUTES);
			InputStream inputStream = new FileInputStream(configFile);
			props.load(inputStream);
			loadProps(props);

		} catch (IOException e) {
			log.error("Loading ATTIBUTES failed " + e.getMessage());
		}
	}

	private void loadParameterProperties(String relativePath) {

		Properties props = new Properties();
		try {
			File configFile = new File(relativePath + PATH_PARAMETERS);
			InputStream inputStream = new FileInputStream(configFile);
			props.load(inputStream);
			loadProps(props);

		} catch (IOException e) {
			log.error("Loading PARAMETERS failed " + e.getMessage());
		}

	}

	private void loadUrlProperties(String pathReal) {

		Properties props = new Properties();
		try {
			File configFile = new File(pathReal + PATH_URLS);
			InputStream inputStream = new FileInputStream(configFile);
			props.load(inputStream);
			loadProps(props);

		} catch (IOException e) {
			log.error("Loading URLS failed " + e.getMessage());
		}
	}

	private void loadProps(Properties props) {
		for (Map.Entry<Object, Object> e : props.entrySet()) {
			String key = (String) e.getKey();
			String value = (String) e.getValue();
			properties.put(key, value);
		}
	}

	/**
	 * @return the props
	 */
	public static Map<String, String> getProps() {
		return properties;
	}

}