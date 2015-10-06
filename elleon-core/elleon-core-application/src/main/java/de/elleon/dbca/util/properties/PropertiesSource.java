package de.elleon.dbca.util.properties;

import java.util.Properties;

/**
 * instances of type PropertiesSource provide a method to receive a Properties object
 * and a reload method to read the properties newly from the (external) source, e.g. 
 * a properties file
 * 
 * @author Daniel
 *
 */
public interface PropertiesSource {

	/**
	 * returns a Properties object, containing all properties of the PropertiesSource
	 * @return Properties object, containing all properties of the PropertiesSource
	 */
	public Properties getProperties();
	
	/**
	 * reloads all properties from the (external) source, e.g. a properties file
	 * @throws Exception
	 */
	public void reload() throws Exception;
}
