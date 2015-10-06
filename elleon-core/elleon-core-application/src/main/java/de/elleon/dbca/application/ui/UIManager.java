package de.elleon.dbca.application.ui;

import javax.servlet.ServletContext;

import de.elleon.dbca.application.controller.ApplicationController;
import de.elleon.dbca.application.ui.navigation.Navigator;

/**
 * The UIManager binds a UserInterface instance to an ApplicationController. 
 * It mainly controls the user navigation between different views.
 * 
 * @see UserInterface, ApplicationController, Navigator
 * @author Daniel
 *
 */
public abstract class UIManager {

	/**
	 * The UserInterface which initiates a user session via GUI
	 */
	private UserInterface ui;
	
	/**
	 * The Navigator instance provided by the ui to change between different views.
	 */
	private Navigator navigator;
	
	/**
	 * The ApplicationController which provides the application's business logic
	 * and services
	 */
	private ApplicationController applicationController;
	
	/**
	 * The URI that is initially requested by the first user interaction. It
	 * determines which view is provided first by the navigator (initial navigation
	 * state)
	 */
	private String forwardUri;
	
	/**
	 * Instantiates a UIManager object for a UserInterface which was initiated by the 
	 * ServletContainer after the user requested the application URL without URI extension, 
	 * i.e. user requests the default initial navigation state.
	 * 
	 * @param ui the UserInterface which initiated the user session
	 * @param servletContext the ServletContext from the servlet container which runs the UI
	 */
	public UIManager(UserInterface ui, ServletContext servletContext) {
		this(ui, servletContext, null);
	}
	
	/**
	 * Instantiates a UIManager object for a UserInterface which was initiated by the 
	 * ServletContainer after the user requested the application URL with a dedicated URI extension.
	 * 
	 * @param ui the UserInterface which initiated the user session
	 * @param servletContext the ServletContext from the servlet container which runs the UI
	 * @param uri the URI extension determining a requested initial navigation state
	 */
	public UIManager(UserInterface ui, ServletContext servletContext, String uri) {
		setUI(ui);
		setForwardUri(uri == null ? "" : uri);
		setNavigator(ui.getNavigationManager().getNavigator());
		
	}

	/**
	 * Provides the Navigator which is used to switch between different views
	 * @return Navigator which is used to switch between different views
	 */
	public Navigator getNavigator() {
		return navigator;
	}

	/**
	 * setter method for the Navigator which is used to switch between different views
	 * @param navigator Navigator instance that can be used to switch between different views
	 */
	protected void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}
	
	/**
	 * returns the UserInterface which initiates a user session via GUI
	 * 
	 * @return UserInterface which initiates a user session via GUI
	 */
	public UserInterface getUI() {
		return ui;
	}

	/**
	 * setter method for the UserInterface which initiates a user session via GUI
	 * 
	 * @param ui UserInterface which initiates a user session via GUI
	 */
	protected void setUI(UserInterface ui) {
		this.ui = ui;
	}

	/**
	 * Method to access the application's ApplicationController
	 * 
	 * @return ApplicationController of the application that provides the business logic
	 */
	public ApplicationController getApplicationController() {
		return applicationController;
	}

	/**
	 * setter method for the ApplicationController that provides the business logic
	 * 
	 * @param applicationController ApplicationController that provides the business logic
	 */
	public void setApplicationController(ApplicationController applicationController) {
		this.applicationController = applicationController;
	}

	/**
	 * returns the forwardUri String which determines the requested initial navigation state
	 * 
	 * @return URI String which determines the requested initial navigation state
	 */
	public String getForwardUri() {
		return forwardUri;
	}

	/**
	 * setter method to manipulate the forwardUri String which determines the requested initial navigation state
	 * @param forwardUri URI String which determines the requested initial navigation state
	 */
	public void setForwardUri(String forwardUri) {
		this.forwardUri = forwardUri;
	}
	


}
