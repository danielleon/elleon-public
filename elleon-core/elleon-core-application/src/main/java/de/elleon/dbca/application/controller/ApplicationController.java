package de.elleon.dbca.application.controller;

import javax.servlet.ServletContext;

import de.elleon.dbca.application.config.ApplicationProperties;
import de.elleon.dbca.application.config.SystemVariables;
import de.elleon.dbca.server.ResourceProvider;
import de.elleon.dbca.server.servletimplementation.ServletResourceProvider;

/**
 * The ApplicationController object is the root component of the application's logical layer.
 * It contains references to basic services useful for most applications.
 * 
 * @author Daniel
 *
 */
public class ApplicationController {

	/**
	 * the ServletContext object provided by the servlet container running the application
	 */
	private ServletContext servletContext;
	
	/**
	 * the ResourceProvider for accessing files from the runtime environment
	 */
	private ResourceProvider resourceProvider;
	
	/**
	 * basic properties for global parameterization of the application;
	 * should be delivered within the application WAR, e.g. by using a Java properties file
	 */
	private ApplicationProperties applicationProperties;
	
	/**
	 * contains system variables specific to the respective environment where the application
	 * is running, e.g. for distinguish configurations between a productive or a test installation
	 */
	private SystemVariables systemVariables;
	
	/**
	 * instantiates the ApplicationController by a given ServletContext object from
	 * the servlet container that runs the application
	 * @param servletContext
	 */
	public ApplicationController(ServletContext servletContext) {
		setServletContext(servletContext);
		setResourceProvider(new ServletResourceProvider(servletContext));
	}
	
	/**
	 * returns the ServletContext from the servlet container that runs the application
	 * @return
	 */
	public ServletContext getServletContext() {
		return servletContext;
	}

	/**
	 * sets current servletContext for the application
	 * @param servletContext
	 */
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
	 * returns the ResourceProvider for accessing resources on the runtime environment
	 * @return ResourceProvider for accessing resources on the runtime environment
	 */
	public ResourceProvider getResourceProvider() {
		return resourceProvider;
	}

	/**
	 * sets the ResourceProvider for accessing resources on the runtime environment
	 * @param resourceProvider the ResourceProvider for accessing resources on the runtime environment
	 */
	public void setResourceProvider(ResourceProvider resourceProvider) {
		this.resourceProvider = resourceProvider;
	}
	
	/**
	 * returns an ApplicationProperties object containing all global parameters of the application
	 * @return ApplicationProperties object containing all global parameters of the application
	 */
	protected ApplicationProperties getApplicationProperties() {
		return applicationProperties;
	}
	
	/**
	 * setter method to set applicationProperties as global parameters of the applications
	 * @param applicationProperties contains properties that are used as global control 
	 * parameters of the application
	 */
	protected void setApplicationProperties(ApplicationProperties applicationProperties) {
		this.applicationProperties = applicationProperties;
	}

	/**
	 * returns a SystemVariables object containing all system variables relevant for the application
	 * @return SystemVariables object containing all system variables relevant for the application
	 */
	protected SystemVariables getSystemVariables() {
		return systemVariables;
	}

	/**
	 * setter method to set systemVariables which should contain all system variables relevant for the application
	 * @param systemVariables contains all system variables relevant for the application
	 */
	protected void setSystemVariables(SystemVariables systemVariables) {
		this.systemVariables = systemVariables;
	}

	
}
