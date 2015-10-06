package de.elleon.dbca.server;

import java.io.InputStream;

/**
 * A ResourceProvider can be used to access resources (e.g. config files, image, ...) 
 * from the runtime environment
 * 
 * @author Daniel
 *
 */
public interface ResourceProvider {

	/**
	 * Returns an InputStream for the resource identified by the parameter resourcePath
	 * 
	 * @param resourcePath path to the required resource
	 * @return InputStream for the resource identified by the parameter resourcePath
	 */
	public InputStream getResourceAsStream(String resourcePath);
	
}
