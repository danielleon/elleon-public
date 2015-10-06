package de.elleon.dbca.application.ui.navigation;

/**
 * A BasicView represents a GUI component visible to the user. It must provide a ViewContext
 * that holds all relevant meta information for navigation between different views.
 * 
 * @author Daniel
 *
 */
public interface BasicView {

	/**
	 * returns the view's ViewContext that holds all relevant meta information for navigation 
	 * between different views
	 * 
	 * @return ViewContext that holds all relevant meta information for the view
	 */
	public ViewContext getContext();
	
}
