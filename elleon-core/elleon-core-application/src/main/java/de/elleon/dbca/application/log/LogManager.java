package de.elleon.dbca.application.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class LogManager provides static methods to retrieve Logger instances
 * 
 * @see Logger
 * 
 * @author Daniel
 *
 */
public class LogManager {

	private LogManager() {}

	/**
	 * Return a logger named corresponding to the class passed as parameter
	 * 
	 * @param clazz class for which the logger should be created
	 * @return Logger instance named corresponding to the class passed as parameter
	 */
	public static Logger getLogger(Class<?> clazz) {		
		return LoggerFactory.getLogger(clazz);
	}

	/**
	 * Return a logger named according to the name parameter 
	 * 
	 * @param name the logger's name
	 * @return Logger instance named according to the name parameter
	 */
	public static Logger getLogger(String name) {
		return LoggerFactory.getLogger(name);
	}
}
