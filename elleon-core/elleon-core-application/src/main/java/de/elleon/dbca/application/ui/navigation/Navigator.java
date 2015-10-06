package de.elleon.dbca.application.ui.navigation;

import de.elleon.dbca.application.ui.ViewChangeValidator;

/**
 * A Navigator is used to control which view is visible for the user. It provides
 * several navigatTo() methods to switch between views.
 * 
 * The views must be registered to the Navigator instance by using registerView().
 * 
 * You can also set the navigator's "forwarding state", i.e. an internally stored
 * view to which the navigator switches whenever executeForwarding() is invoked.
 * 
 * @author Daniel
 *
 */
public interface Navigator {
	
	/**
	 * Registers a view class to the navigator by assigning it to an internal name.
	 * When navigating to the view name, a view of the given view class will get
	 * visible to the user. The navigator implementation is free to decide whether
	 * a new instance of the view class is created each time or an existing instance 
	 * is reused.
	 * 
	 * @param viewName name to which the view class should b known by the navigator
	 * @param viewClass view class of which an instance is created when navigating
	 * to the viewName
	 */
	public void registerView(String viewName, Class<? extends BasicView> viewClass);
	
	/**
	 * Making the view identified by it's name visible to the user.
	 * 
	 * @param viewName the registered name of the view
	 */
	public void navigateTo(String viewName);
	
	/**
	 * Making the view identified by it's name visible to the user.
	 * The parameters String contains an URL extension which determines a
	 * dedicated view state.
	 * 
	 * @param viewName the registered name of the view
	 * @param parameters parameters String (URL extension)
	 */
	public void navigateTo(String viewName, String parameters);
	
	/**
	 * Making the view identified by it's ViewContext visible to the user.
	 * 
	 * @param viewContext the ViewContext which identifies the view
	 */
	public void navigateTo(ViewContext viewContext);
	
	/**
	 * This method can be used during initialization of the Navigator. The
	 * initialState String should identify the starting point, i.e. the first
	 * visible view
	 * 
	 * @param initialState first visible view representation
	 */
	public void setInitialState(String initialState);
	
	/**
	 * This method defines a fallback view class. Whenever the Navigator can't
	 * open the required view it should try to navigate to the fallback view.
	 * 
	 * @param viewClass class of the fallback view
	 */
	public void setFallbackView(Class<? extends BasicView> viewClass);
	
	/**
	 * Adds a ViewChangeValidator to the Navigator which contains all rules and 
	 * actions that must be performed when a user navigates to another view.
	 * 
	 * @param viewChangeValidator ViewChangeValidator instance containing rules
	 * actions that must be performed when a user navigates to another view.
	 * 
	 * @see ViewChangeValidator
	 */
	public void setViewChangeValidator(ViewChangeValidator viewChangeValidator);
	
	/**
	 * Sets the forwarding state to a given view name, identifying a registered 
	 * view. When executeForwarding() is invoked the Navigator navigates to this
	 * view.
	 * 
	 * @param viewName the registered name of the view
	 */
	public void setForwardingState(String viewName);
	
	/**
	 * Sets the forwarding state to a given view name, identifying a registered 
	 * view. When executeForwarding() is invoked the Navigator navigates to this
	 * view.
	 * 
	 * The parameters String contains an URL extension which determines a
	 * dedicated view state.
	 * 
	 * @param viewName the registered name of the view
	 * @param parameters parameters String (URL extension)
	 */
	public void setForwardingState(String viewName, String parameters);
	
	/**
	 * Sets the forwarding state to the view identified by it's ViewContext.
	 * When executeForwarding() is invoked the Navigator navigates to this
	 * view.
	 * 
	 * @param viewContext the ViewContext which identifies the view
	 */
	public void setForwardingState(ViewContext viewContext);
	
	/**
	 * Clears the forwarding state
	 */
	public void resetForwardingState();
	
	/**
	 * Returns true if a forwarding state is set, otherwise false
	 * 
	 * @return true if a forwarding state is set, otherwise false
	 */
	public boolean hasForwardingState();
	
	/**
	 * Navigates to the current forwarding state (if set)
	 */
	public void executeForwarding();
}
