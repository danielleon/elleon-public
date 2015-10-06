package de.elleon.dbca.application.ui.vaadinimplementation.navigation;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.UI;

import de.elleon.dbca.application.ui.navigation.BreadcrumbEnabledView;
import de.elleon.dbca.application.ui.navigation.ViewContext;
import de.elleon.dbca.application.ui.vaadinimplementation.VaadinUserInterface;

/**
 * Vaadin implementation of BreadcrumbEnabledView:
 * When generating the ViewContext at the end of the enter() method, the method getBreadcrumDisplay()
 * is invoked to add the returned String representation to it.
 * 
 * @see BreadcrumbEnabledView
 * 
 * @author Daniel
 *
 */
public abstract class VaadinBreadcrumbEnabledView extends VaadinBasicView implements BreadcrumbEnabledView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2040548496924976647L;

	@Override
	public void enter(ViewChangeEvent event) {
		
		enter(event, ((VaadinUserInterface)UI.getCurrent()).getUIManager());
		setContext(new ViewContext(getViewName(), event.getParameters(), getBreadcrumbDisplay()));
	}

	@Override
	public abstract String getBreadcrumbDisplay();

	@Override
	public abstract ViewContext[] getBreadcrumbs();
}
