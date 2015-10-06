package de.elleon.dbca.application.config;

import java.util.Properties;

import de.elleon.dbca.util.properties.PropertiesSource;

/**
 * Holds all application specific properties read from a given PropertiesSource.
 * The class is intended to be extended by a application specific class that contains 
 * variables that needs to be initialized by values from the PropertiesSource.
 * 
 * @author Daniel
 *
 */
public abstract class ApplicationProperties {

	/**
	 * The source from where the properties are loaded from
	 */
	private PropertiesSource propertiesSource;
	
	/**
	 * Instantiates ApplicationProperties with given propertiesSource.
	 * Executes method initProperties() at the end. Override this method to
	 * initialize application specific variables with values from the propertiesSource
	 * @param propertiesSource
	 */
	public ApplicationProperties(PropertiesSource propertiesSource) {
		this.propertiesSource = propertiesSource;
		initProperties();
	}
	
	/**
	 * returns the Properties out of propertiesSource
	 * @return Properties object out of the propertiesSource
	 */
	public Properties getProperties() {
		return propertiesSource.getProperties();
	};
	
	/**
	 * returns a property value of the property identified by a propertyName
	 * @param propertyName the name of the property
	 * @return value of the property
	 */
	public Object getProperty(String propertyName) {
		return getProperties().getProperty(propertyName);
	};
	
	/**
	 * reloads the properties from propertiesSource and executes initProperties() again
	 * @throws Exception
	 */
	public void reload() throws Exception {
		propertiesSource.reload();
		initProperties();
	};
	
	/**
	 * Override this method to initialize application specific variables with values 
	 * from the propertiesSource
	 */
	protected abstract void initProperties();
}
