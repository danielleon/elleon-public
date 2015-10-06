package de.elleon.dbca.application.ui.navigation;

/**
 * A ViewContext contains all relevant meta data for a corresponding BasicView.
 * 
 * @see BasicView
 * 
 * @author Daniel
 *
 */
public class ViewContext {

	/**
	 * Internal name of the view that can be used for user navigation
	 */
	private String viewName;
	
	/**
	 * URL parameters which is required to navigate to the corresponding view
	 */
	private String parameters;
	
	/**
	 * A String that represents the view and is dedicated for displaying to the user.
	 * Usually it's used in a breadcrumb display. If not explicitly set, the breadcrumpDisplay
	 * is equal to the viewName
	 */
	private String breadcrumbDisplay;
	
	/**
	 * Instantiating ViewContext by the name of the corresponding view.
	 * 
	 * @param viewName Internal name of the view that can be used for user navigation
	 */
	public ViewContext(String viewName) {
		this.viewName = viewName;
		this.parameters = "";
		this.breadcrumbDisplay = viewName;
	}
	
	/**
	 * Instantiating ViewContext by the name of the corresponding view and the URL
	 * parameters that are required to navigate to the view in a specific state
	 * 
	 * @param viewName Internal name of the view that can be used for user navigation
	 * @param parameters URL parameters that represents a specific state of the view
	 */
	public ViewContext(String viewName, String parameters) {
		this.viewName = viewName;
		this.parameters = parameters;
		this.breadcrumbDisplay = viewName;
	}
	
	/**
	 * Instantiating ViewContext by the name of the corresponding view and the URL
	 * parameters that are required to navigate to the view in a specific state.
	 *  
	 * @param viewName Internal name of the view that can be used for user navigation
	 * @param parameters URL parameters that represents a specific state of the view
	 * @param breadcrumbDisplay String representation of the view which is dedicated for displaying to the user
	 */
	public ViewContext(String viewName, String parameters, String breadcrumbDisplay) {
		this.viewName = viewName;
		this.parameters = parameters;
		this.breadcrumbDisplay = breadcrumbDisplay;
	}
	
	/**
	 * setter method for the internal name of the referenced view
	 * 
	 * @param viewName Internal name of the view that can be used for user navigation
	 */
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	/**
	 * returns the internal name of the referenced view
	 * @return internal name of the referenced view
	 */
	public String getViewName() {
		return viewName;
	}
	
	/**
	 * setter method for the URL parameters of the referenced view's state
	 * 
	 * @param parameters URL parameters that represents a specific state of the view 
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	
	/**
	 * returns the URL parameters that represents a specific state of the referenced view
	 * @return URL parameters that represents a specific state of the referenced view
	 */
	public String getParameters() {
		return parameters;
	}
	
	/**
	 * splits the parameters by "/" and returns the parameter specified by the index
	 * 
	 * same functionality as getParameters().split("/")[index]
	 * 
	 * @param index order number of the wanted parameter in the parameters String
	 * @return parameter specified by the index
	 */
	public String getParameter(int index) {
		return parameters.split("/")[index];
	}

	/**
	 * setter method for the breadcrumpDisplay, i.e. a String that represents the view 
	 * and is dedicated for displaying to the user.
	 * 
	 * @param breadcrumbDisplay String representation of the view which is dedicated for displaying to the user
	 */
	public void setBreadcrumbDisplay(String breadcrumbDisplay) {
		this.breadcrumbDisplay = breadcrumbDisplay;
	}

	/**
	 * returns the breadcrumDisplay, i.e. a String that represents the view and is dedicated for displaying 
	 * to the user.
	 * 
	 * @return  String that represents the view and is dedicated for displaying to the user.
	 */
	public String getBreadcrumbDisplay() {
		return breadcrumbDisplay;
	}

	
}
