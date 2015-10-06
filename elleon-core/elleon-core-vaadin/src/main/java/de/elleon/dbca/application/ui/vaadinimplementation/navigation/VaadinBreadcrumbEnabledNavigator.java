package de.elleon.dbca.application.ui.vaadinimplementation.navigation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.elleon.dbca.application.ui.navigation.Breadcrumb;
import de.elleon.dbca.application.ui.navigation.BreadcrumbEnabledNavigator;
import de.elleon.dbca.application.ui.navigation.BreadcrumbEnabledView;
import de.elleon.dbca.application.ui.navigation.ViewContext;
import de.elleon.dbca.application.ui.vaadinimplementation.VaadinUserInterface;

/**
 * Vaadin implementation of a BreadcrumbEnabledNavigator. It extends a VaadinNavigator by the
 * required methods to make a breadcrumb path visible in a VaadinBreadcrumb component.
 * 
 * Views that should be registered to the BreadcrumbEnabledNavigator must implement the BreadcrumbEnabledView
 * interface, e.g. a VaadinBreadcrumbEnabledView.
 * 
 * @see VaadinBreadcrumb
 * 
 * @author Daniel
 *
 */
public class VaadinBreadcrumbEnabledNavigator extends VaadinNavigator implements BreadcrumbEnabledNavigator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5850613670566412794L;

	/**
	 * The internal map that holds all valid links from/to a BreadcrumbEnabledView class
	 */
	private Map<Class<? extends BreadcrumbEnabledView>, List<Class<? extends BreadcrumbEnabledView>>> viewLinks = 
			new HashMap<Class<? extends BreadcrumbEnabledView>, List<Class<? extends BreadcrumbEnabledView>>>();
	
	/**
	 * If true then a ViewChangeValidator assigned to this Navigator must not check if the view change is based
	 * on a valid view link. Instead it should handle all view changes as valid view links.
	 */
	private boolean checkSupportedLink = true;
	
	/**
	 * The VaadinBreadcrumb component that makes the view path visible to the user. It's updated by
	 * the Navigator for each view change.
	 */
	private VaadinBreadcrumb breadcrumb;
	
	/**
	 * Instantiates the navigator and binds it to the VaadinBreadcrumb that is returned by 
	 * ui.getBreadcrumbComponent().
	 * 
	 * @param ui The VaadinUserInterface which contains the VaadinBreadcrumb component and the 
	 * navigation area where the views are displayed.
	 */
	public VaadinBreadcrumbEnabledNavigator(VaadinUserInterface ui) {
		super(ui);
		breadcrumb = ui.getBreadcrumbComponent();
	}
	

	@Override
	public Breadcrumb getBreadcrumb() {
		return breadcrumb;
	}
	
	@Override
	public void breadcrumbReturn(ViewContext viewContext) {
    	setCheckSupportedLink(false);
    	navigateTo(viewContext);
		
	}

	@Override
	public void addViewLink(Class<? extends BreadcrumbEnabledView> fromView, Class<? extends BreadcrumbEnabledView> toView) {
		
		if (!viewLinks.containsKey(toView)) {
			viewLinks.put(toView, new ArrayList<Class<? extends BreadcrumbEnabledView>>());
		}
		
		viewLinks.get(toView).add(fromView);
		
	}

	@Override
	public boolean isSupportedLink(BreadcrumbEnabledView fromView, BreadcrumbEnabledView toView) {
    	if (fromView == null || toView == null) return false;
    	
    	return viewLinks.get(toView.getClass()).contains(fromView.getClass());
	}

	@Override
	public boolean isCheckSupportedLink() {
		return checkSupportedLink;
	}

	@Override
	public void setCheckSupportedLink(boolean checkSupportedLink) {
		this.checkSupportedLink = checkSupportedLink;
	}


}
