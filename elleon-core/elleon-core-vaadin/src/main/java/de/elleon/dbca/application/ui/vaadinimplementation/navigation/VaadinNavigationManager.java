package de.elleon.dbca.application.ui.vaadinimplementation.navigation;

import de.elleon.dbca.application.ui.navigation.NavigationManager;
import de.elleon.dbca.application.ui.navigation.Navigator;
import de.elleon.dbca.application.ui.vaadinimplementation.VaadinUserInterface;

/**
 * Vaadin implementation of the NavigationManager interface.
 * It binds a VaadinBreadcrumbEnabledNavigator to a VaadinUserInterface.
 * 
 * @author Daniel
 *
 */
public class VaadinNavigationManager implements NavigationManager {

	/**
	 * The VaadinUserInterface which contains the navigation area, where the views
	 * registered to the Navigator should be displayed.
	 */
	private VaadinUserInterface ui;
	
	/**
	 * The navigator instance
	 */
	private Navigator navigator;
	
	/**
	 * Instantiates the VaadinNavigationManager by a VaadinUserInterface reference.
	 * The VaadinUserInterface which contains the navigation area, where the views
	 * registered to the Navigator should be displayed.
	 * 
	 * @param ui VaadinUserInterface which should be bound to a Navigator
	 */
	public VaadinNavigationManager(VaadinUserInterface ui) {
		this.ui = ui;
	}
	
	@Override
	public Navigator getNavigator() {
		
		if (navigator == null) navigator = new VaadinBreadcrumbEnabledNavigator(ui);
		return navigator;
	}

}
