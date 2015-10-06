package de.elleon.dbca.application.ui.vaadinimplementation.navigation;

import com.vaadin.navigator.ViewChangeListener;

import de.elleon.dbca.application.ui.ViewChangeValidator;
import de.elleon.dbca.application.ui.navigation.BasicView;
import de.elleon.dbca.application.ui.navigation.Navigator;
import de.elleon.dbca.application.ui.navigation.ViewContext;
import de.elleon.dbca.application.ui.vaadinimplementation.VaadinUserInterface;

/**
 * Vaadin implementation of the Navigator interface mainly by using Vaadin's build-in 
 * component com.vaadin.navigator.Navigator.
 * 
 * @author Daniel
 *
 */
public class VaadinNavigator extends com.vaadin.navigator.Navigator implements Navigator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4139830239857337549L;

	/**
	 * A ViewChangeListener that is used for realizing the ViewChangeValidator approach by
	 * Vaadin build-in components.
	 */
	private ViewChangeListener defaultViewChangeListener;
	
	/**
	 * The internal representation of the forwarding state. This String identifies the 
	 * view which should be displayed when executeForwarding() is called.
	 */
	private String forwardingState;
	
	/**
	 * Instantiates the Navigator and binds it to the component which is returned by
	 * ui.getNavigationArea().
	 * 
	 * @param ui VaadinUserInterface that contains the navigation area, where the views
	 * registered to the navigator are displayed.
	 */
	public VaadinNavigator(VaadinUserInterface ui) {
        super(ui, ui.getNavigationArea());
        
        	
    }

	@Override
	public void registerView(String viewName, Class<? extends BasicView> viewClass) {
		addView(viewName, viewClass.asSubclass(VaadinBasicView.class));
		
	}
	
	@Override
	public void navigateTo(ViewContext viewContext) {
		navigateTo(viewContext.getViewName(), viewContext.getParameters());
		
	}

	@Override
	public void navigateTo(String viewName, String parameters) {
		super.navigateTo(viewName + "/" + parameters);
		
	}

	@Override
	public void setInitialState(String initialState) {
		getStateManager().setState(initialState);
		
	}

	@Override
	public void setFallbackView(Class<? extends BasicView> viewClass) {
		super.setErrorView(viewClass.asSubclass(VaadinBasicView.class));
		
	}

	@Override
	public void setViewChangeValidator(ViewChangeValidator viewChangeValidator) {
		
		removeViewChangeListener(defaultViewChangeListener);
		
		if (viewChangeValidator != null)  {
			
			defaultViewChangeListener = new ViewChangeListener() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 5546028737661344599L;

				@Override
				public boolean beforeViewChange(ViewChangeEvent event) {
					return viewChangeValidator.beforeViewChange(
							(VaadinBasicView) event.getOldView(), event.getViewName(), event.getParameters());
				}

				@Override
				public void afterViewChange(ViewChangeEvent event) {
					viewChangeValidator.afterViewChange(
							(VaadinBasicView) event.getOldView(), (VaadinBasicView) event.getNewView());
				}
				
			};
			
			addViewChangeListener(defaultViewChangeListener);
			
		}
		
	}

	@Override
	public void setForwardingState(String viewName) {
		forwardingState = viewName;
		
	}

	@Override
	public void setForwardingState(String viewName, String parameters) {
		forwardingState = viewName + "/" + parameters;
		
	}

	@Override
	public void setForwardingState(ViewContext viewContext) {
		setForwardingState(viewContext.getViewName());
		
	}

	@Override
	public void resetForwardingState() {
		forwardingState = null;
	}
	
	@Override
	public boolean hasForwardingState() {
		return forwardingState != null;
		
	}

	@Override
	public void executeForwarding() {
		if (hasForwardingState()) {
			String fs = forwardingState;
			resetForwardingState();
			super.navigateTo(fs);
		}
		
		
	}



}
