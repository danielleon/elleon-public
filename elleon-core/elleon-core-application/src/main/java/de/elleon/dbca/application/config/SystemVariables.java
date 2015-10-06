package de.elleon.dbca.application.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import de.elleon.dbca.util.properties.PropertiesReader;

/**
 * Holds all system variables from the runtime environment that are relevant for
 * the application. The SystemVariables object takes a dedicated system variable
 * as "root variable". The root variable should contain the path of an accessible
 * Java properties file. The SystemVariables object reads out the properties from 
 * the file and makes them available via the getSystemVariable() method.
 * The class is intended to be extended by a application specific class that contains 
 * type save variables that needs to be initialized by values from the properties file.
 * 
 * @author Daniel
 *
 */

public abstract class SystemVariables {

	/**
	 * the name of the system variable that works as "root variable"
	 */
	private String rootVariable;
	
	/**
	 * the properties read from the Java properties file which is determined by the root variable
	 */
	private Properties systemVariables;
	
	/**
	 * initiates the SystemVariables by a given "root variable". The root variable should contain 
	 * the path of an accessible Java properties file. The SystemVariables object reads out the 
	 * properties from the file and makes them available via the getSystemVariable() method.
	 * 
	 * @param rootVariable name of the system variable that works as "root variable"
	 * @throws IOException if it can't read from the Java properties file determined by the root
	 * variable
	 */
	public SystemVariables(String rootVariable) throws IOException {
		this.setRootVariable(rootVariable);
		reload();
		initVariables();
	}

	/**
	 * returns the name of the "root variable".
	 * 
	 * @return name of the "root variable"
	 */
	public String getRootVariable() {
		return rootVariable;
	}

	/**
	 * setter method for the "root variable". The root variable should contain the path of an accessible
	 * Java properties file. Notice, that this method doesn't force a reload() automatically.
	 * 
	 * @param rootVariable name of the system variable that works as "root variable"
	 */
	public void setRootVariable(String rootVariable) {
		this.rootVariable = rootVariable;
	}
	
	/**
	 * returns the property value from the Properties read out of the Java properties file
	 * 
	 * @param variableName name of the property
	 * @return the property value from the Properties read out of the Java properties file
	 */
	protected String getSystemVariable(String variableName) {
		return systemVariables.getProperty(variableName);
	}
	
	/**
	 * start determining the Java properties file from the root variable again and reloads 
	 * the properties out of it. After that initVariables() is executed
	 * @throws IOException
	 */
	private void reload() throws IOException {
		String propertiesFilePath = System.getenv(rootVariable);
		File propertiesFile = new File(propertiesFilePath);
		PropertiesReader reader = new PropertiesReader(new FileInputStream(propertiesFile));
		systemVariables = reader.getProperties();
		initVariables();
	}
	
	/**
	 * Override this method to initialize type save variables with values 
	 * from systemVariables
	 */
	protected abstract void initVariables();

}
