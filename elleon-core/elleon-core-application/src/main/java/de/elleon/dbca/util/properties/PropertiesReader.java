package de.elleon.dbca.util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * A PropertiesSource that reads it's Properties out of a given Java properties resource.
 * 
 * @author Daniel
 *
 */
public class PropertiesReader implements PropertiesSource {

	/**
	 * The Properties object that contains all properties read from the Java properties file
	 */
	private Properties properties = new Properties();
	
	/**
	 * The Java properties resource to be read from
	 */
	private InputStream propertiesResource;

	/**
	 * Instantiates by reading the properties from the given properties resource
	 * @param properties resource to be read from
	 * @throws IOException if it can't be read from the  properties resource
	 */
	public PropertiesReader(InputStream propertiesResource) throws IOException {
		setPropertiesResource(propertiesResource);
		loadFromPropertiesResource();
	}
	
	
	@Override
	public Properties getProperties() {
		return properties;
	}

	@Override
	public void reload() throws IOException {
		loadFromPropertiesResource();
	}
	
	/**
	 * internal method to read from the properties resource
	 * @throws IOException if it can't be read from the properties resource
	 */
	private void loadFromPropertiesResource() throws IOException {
		properties.load(getPropertiesResource());
		
	}

	/**
	 * returns the properties resource
	 * @return the properties resource as stream
	 */
	public InputStream getPropertiesResource() {
		return propertiesResource;
	}

	/**
	 * setter method for the properties resource to be read from
	 * Notice, that it's not automatically read from the new resource. Execute reload() 
	 * if the properties should be read again.
	 * 
	 * @param propertiesResource properties resource to be read from
	 */
	public void setPropertiesResource(InputStream propertiesResource) {
		this.propertiesResource = propertiesResource;
	}


}
