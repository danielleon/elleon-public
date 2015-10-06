package de.elleon.dbca.application.ui.navigation;

/**
 * A BreadcrumbEnabledView provides a getBreadcrumbDisplay() method which returns
 * a String representation of the view intended to display on a UI, esp. in a breadcrumb path.
 * 
 * It also provides a default view path that can be used for showing a breadcrumb path even
 * if the user navigated from an unknown location to the view.
 * 
 * @author Daniel
 *
 */
public interface BreadcrumbEnabledView extends BasicView {

	/**
	 * returns String representation of the view intended to display on a UI, esp. in a breadcrumb path
	 * implementations of the method should consider localization
	 * @return
	 */
	public String getBreadcrumbDisplay();

	/**
	 * returns a default view path, represented by an array of ViewContext instances.
	 * Can be used for showing a breadcrumb path even if the user navigated from an 
	 * unknown location to the view.
	 * 
	 * @return default view path, represented by an array of ViewContext instances
	 */
	public ViewContext[] getBreadcrumbs();
	
}
