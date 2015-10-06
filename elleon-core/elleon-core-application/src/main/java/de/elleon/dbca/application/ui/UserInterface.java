package de.elleon.dbca.application.ui;

import de.elleon.dbca.application.ui.navigation.NavigationManager;

/**
 * The basic interface for a GUI implementation. A UserInterface initiates a user session
 * in a GUI. It provides the basic infrastructure for the interaction of an Internet Browser
 * with the ServletContainer.
 * 
 * It must provide a NavigationManager that binds a Navigator to it for supporting the user
 * navigation between different views.
 * 
 * The first action of a UserInterface should be to request a UIManager via UIManager.get().
 * The UIManager links the UserInterface to the application's backend and it controls the 
 * navigation flow.
 * 
 * @author Daniel
 *
 */
public interface UserInterface {
	
	/**
	 * provides access to the UIManager bound to the UserInterface to control
	 * navigation flow and access to the application's backend
	 * 
	 * @return UIManager which is bound to the UserInterface
	 */
	public UIManager getUIManager();
	
	/**
	 * returns the NavigationManager that binds a Navigator to the UserInterface
	 * 
	 * @return NavigationManager that binds a Navigator to the UserInterface
	 */
	public NavigationManager getNavigationManager();
	
	/**
	 * method for open implementation of layout changes
	 */
	public void updateUI();
}
