package de.elleon.dbca.server.servletimplementation;

import java.io.InputStream;
import javax.servlet.ServletContext;

import de.elleon.dbca.server.ResourceProvider;

/**
 * The ServletResourceProvider uses a ServletContext to provide access to resources
 * from the runtime environment, if the application is running in a servlet container.
 * 
 * @author Daniel
 *
 */
public class ServletResourceProvider implements ResourceProvider {

	/**
	 * ServletContext from the runtime environment (servlet container)
	 */
	private ServletContext servletContext;
	
	/**
	 * Instantiation by a given ServletContext
	 * 
	 * @param servletContext ServletContext from the runtime environment (servlet container)
	 */
	public ServletResourceProvider(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public InputStream getResourceAsStream(String resourcePath) {
		return servletContext.getResourceAsStream(resourcePath);
	}
	
}
