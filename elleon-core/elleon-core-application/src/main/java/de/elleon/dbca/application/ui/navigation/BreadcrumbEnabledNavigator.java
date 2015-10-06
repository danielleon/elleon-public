package de.elleon.dbca.application.ui.navigation;

/**
 * Extends a Navigator by methods to link the internal navigation to a visible
 * breadcrumb component. A BreadcrumbEnabledNavigator communicates view changes
 * to the breadcrumb component and supports navigation by user clicks on the
 * breadcrumb (breadcrumb return).
 * 
 * To support correct breadcrumb building the Navigator must know all valid links
 * from which and to which view a use can change. For a standard view change, the
 * new view must be added to the end of the breadcrumb path. For invalid view changes
 * a default path should be created as breadcrumb. Valid links between views are
 * registered by addViewLink().
 * 
 * @see Breadcrumb, BreadcrumbEnabledView
 * 
 * @author Daniel
 *
 */
public interface BreadcrumbEnabledNavigator extends Navigator {

	/**
	 * Returns the Breadcrumb instance to which the Navigator is connected.
	 * 
	 * @return Breadcrumb instance to which the Navigator is connected
	 */
	public Breadcrumb getBreadcrumb();
	
	/**
	 * Lets the Navigator navigate to the ViewContext. The difference to the
	 * standard navigateTo() is, that the breadcrumb view path must be reduced
	 * to the path of to the given ViewContext instead of adding the ViewContext
	 * to the end of the path.
	 * @param viewContext
	 */
	public void breadcrumbReturn(ViewContext viewContext);
		
	/**
	 * Registers a valid view link from a view instance of class fromView to a view
	 * instance of class toView.
	 * 
	 * @param fromView view class from where the user comes
	 * @param toView view class to which the user navigates
	 */
	public void addViewLink(Class<? extends BreadcrumbEnabledView> fromView, Class<? extends BreadcrumbEnabledView> toView);
	
	/**
	 * Returns true if the link from fromView to toView is valid, i.e.
	 * the link between their classes was added to the navigator by addViewLink().
	 * Otherwise returns false.
	 * 
	 * @param fromView
	 * @param toView
	 * @return true if the link from fromView to toView is valid, i.e. the link 
	 * between their classes was added to the navigator by addViewLink().
	 * Otherwise returns false.
	 */
	public boolean isSupportedLink(BreadcrumbEnabledView fromView, BreadcrumbEnabledView toView);

	/**
	 * Returns true if there must be a view link validation when the user navigates
	 * between two views. False otherwise.
	 * 
	 * @return true if there must be a view link validation when the user navigates
	 * between two views. False otherwise.
	 */
	public boolean isCheckSupportedLink();

	/**
	 * Method to enable/disable view link validation. If view link validation is
	 * disabled the navigator must handle every view change as a valid view link,
	 * no matter if it was registered by addViewLink() or not.
	 *  
	 * @param checkSupportedLink true if view link validation should be enabled, 
	 * false otherwise
	 */
	public void setCheckSupportedLink(boolean checkSupportedLink);

}
