package de.elleon.dbca.application.ui.vaadinimplementation;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.SingleComponentContainer;

import de.elleon.dbca.application.ui.UserInterface;
import de.elleon.dbca.application.ui.navigation.NavigationManager;
import de.elleon.dbca.application.ui.vaadinimplementation.navigation.VaadinBreadcrumb;
import de.elleon.dbca.application.ui.vaadinimplementation.navigation.VaadinNavigationManager;

/**
 * Vaadin implementation of the UserInterface. VaadinUserInterface is an extension of Vaadin's basic
 * UI class. It connects the Vaadin GUI framework with an ApplicationController that provides the
 * business logic.
 * 
 * As visible components the VaadinUserInterface contains (at least) a SingleComponentContainer which is
 * used as "navigation area" (i.e. the component which displays the views registered to the Navigator) 
 * and a VaadinBreadcrumb component which makes the navigation path visible to the user.
 * 
 * In the init() method a NavigationManager instance is automatically created and binds a 
 * VaadinBreadcrumbEnabledNavigator to the UserInterface. Additional the methods initUIManager() and
 * initLayout() are called which can be used to bind the UserInterface to a UIManager and build the
 * visible layout components.
 * 
 * @see com.vaadin.ui.UI
 * 
 * @author Daniel
 *
 */
public abstract class VaadinUserInterface extends com.vaadin.ui.UI implements UserInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2004896786058518902L;

	/**
	 * The NavigationManager that binds the VaadinUserInterface to a Navigator.
	 */
	private NavigationManager navigationManager;
	
	@Override
	protected void init(VaadinRequest request) {
		setNavigationManager(new VaadinNavigationManager(this));
		initUIManager(request);
		initLayout();
	}

	/**
	 * Internal setter method for the NavigationManager
	 * 
	 * @param navigationManager NavigationManager instance that binds the UserInterface to a Navigator
	 */
	private void setNavigationManager(NavigationManager navigationManager) {
		this.navigationManager = navigationManager;
		
	}
	
	@Override
	public NavigationManager getNavigationManager() {
		return navigationManager;
	}
	
	/**
	 * returns the UI component which displays the views
	 * 
	 * @return SingleComponentContainer which is used for displaying the views
	 */
	public abstract SingleComponentContainer getNavigationArea();
	
	/**
	 * Returns the VaadinBreadcrumb visible for the user
	 * 
	 * @return VaadinBreadcrumb component, which is visible for the user
	 */
	public abstract VaadinBreadcrumb getBreadcrumbComponent();

	/**
	 * This method initiates a UIManager that is bound to the UserInterface.
	 * It's internally invoked from the init() method.
	 * 
	 * @param request the VaadinRequest which has initiated the VaadinUserInterface
	 */
	protected abstract void initUIManager(VaadinRequest request);
	
	/**
	 * This method is initiated at the end of the init() method and can be used
	 * to build up the visible components of the UserInterface. At least it should
	 * create a SingleComponentContainer as navigation area and a VaadinBreadcrumb. 
	 * Those components should be returned by getNavigationArea() and getBreadcrumbComponent().
	 */
	protected abstract void initLayout();
	
}
