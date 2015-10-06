package de.elleon.dbca.application.ui.navigation;

/**
 * A NavigationManager must provide access to a Navigator instance.
 * 
 * @author Daniel
 *
 */
public interface NavigationManager {

	/**
	 * Returns a Navigator instance.
	 * 
	 * @return Navigator instance
	 */
	public Navigator getNavigator();
	
}
