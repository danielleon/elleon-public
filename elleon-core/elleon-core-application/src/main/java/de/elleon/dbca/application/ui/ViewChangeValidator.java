package de.elleon.dbca.application.ui;

import de.elleon.dbca.application.ui.navigation.BasicView;

/**
 * A ViewChangeValidator is used to control the navigation between different views.
 * It can be added to a Navigator as a view change listener in order to implement any
 * logical validation before and after the view change
 * 
 * @author Daniel
 *
 */
public interface ViewChangeValidator {

	/**
	 * validates if the requested view change is allowed. if the method returns false
	 * then the Navigator must not perform the view change
	 * @param oldView the old view before the view change (or null if it's an initial view access)
	 * @param newViewName name of the requested destination view
	 * @param newViewParameters URI parameters of the requested destination view
	 * @return 'true' if view change is allowed, 'false' if forbidden
	 */
	public boolean beforeViewChange(BasicView oldView, String newViewName, String newViewParameters);
	
	/**
	 * method that is executed after the view change was performed by the navigator.
	 * can be used to update e.g. breadcrumb by the new view's context data
	 * @param oldView the old view before the view change (or null if it's an initial view access)
	 * @param newView the new view instance after successful view change
	 */
	public void afterViewChange(BasicView oldView, BasicView newView);
	
}
