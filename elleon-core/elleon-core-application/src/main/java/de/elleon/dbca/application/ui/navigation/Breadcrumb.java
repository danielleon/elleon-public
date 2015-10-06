package de.elleon.dbca.application.ui.navigation;

/**
 * A Breadcrumb is used for building up a view path to a current view,
 * making navigation visible and easier for the user.
 * 
 * Internally the path is represented by an indexed list of ViewContext instances.
 * A ViewContext can be used to give the user a visible String representation of
 * the view. Use viewContext.getBreadcrumbDisplay() for showing it on a GUI.
 * 
 * Use viewContext.getViewName() and viewContext.getParameters() to navigate the
 * user to a specific view in the view path.
 * 
 * @author Daniel
 *
 */
public interface Breadcrumb {

	/**
	 * deletes all ViewContext instances from the view path
	 */
	public void clear();
	
	/**
	 * adds viewContext to the end of the view path
	 * 
	 * @param viewContext the ViewContext of the referenced view
	 */
	public void setCurrentView(ViewContext viewContext);
	
	/**
	 * clears an existing view path and builds it up newly by the ViewContext
	 * instances given in viewContexts array
	 * 
	 * @param viewContexts ViewContext array that represents the new view path
	 */
	public void setBreadcrumbs(ViewContext[] viewContexts);
	
}
