package eus.ehu.informatica.gestionalumno.controller.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.UnavailableException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import eus.ehu.informatica.gestionalumno.controller.config.LoadProperties;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
		ServletContextAttributeListener {
	private static final String PATH_LOG4J = "WEB-INF/conf/log4j.properties";
	// private static Logger log = Logger.getLogger(InitListener.class);
	private static Logger log = Logger.getLogger("ACCESOS");

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		loadLog4j(sce);
		LoadProperties.getInstance(sce.getServletContext().getRealPath("/"));
	}

	private void loadLog4j(final ServletContextEvent sce) {

		try {
			String pathReal = sce.getServletContext().getRealPath("/");

			PropertyConfigurator.configure(pathReal + PATH_LOG4J);

			// check configration, si no hay apender es que ha fallado
			if (LogManager.exists("ACCESOS") != null) {
				log.debug("LOG cargado");

			} else {
				throw new UnavailableException("Error en carga de properties");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}