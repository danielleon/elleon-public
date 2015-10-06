package de.elleon.dbca.application.ui.vaadinimplementation.navigation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.UI;

import de.elleon.dbca.application.ui.UIManager;
import de.elleon.dbca.application.ui.navigation.BasicView;
import de.elleon.dbca.application.ui.navigation.ViewContext;
import de.elleon.dbca.application.ui.vaadinimplementation.VaadinUserInterface;

/**
 * Vaadin implementation of a BasicView. The ViewContext is generated when the user enters the view,
 * i.e. the enter() method is called. 
 * In addition the ApplicationController is determined and forwarded to a further enter() method which
 * can be used in extensions of VaadinBasicView for building the UI component.
 * 
 * @see CustomComponent, View
 * 
 * @author Daniel
 *
 */
public abstract class VaadinBasicView extends CustomComponent implements BasicView, View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5517449199912514126L;
	private ViewContext context;
	

	@Override
	public void enter(ViewChangeEvent event) {

		enter(event, ((VaadinUserInterface)UI.getCurrent()).getUIManager());
		setContext(new ViewContext(getViewName(), event.getParameters()));	
	}

	/**
	 * extended enter method that contains the ApplicationController as additional parameter.
	 * It's invoked during the original enter method before the ViewContext is generated.
	 * 
	 */
	protected abstract void enter(ViewChangeEvent event, UIManager uiManager);

	@Override
	public ViewContext getContext() {
		return context;
	}

	/**
	 * setter method to set the ViewContext of this view
	 */
	protected void setContext(ViewContext context) {
		this.context = context;
	}
	
	/**
	 * returns the internal name of the view wich is used for navigation
	 * 
	 * @return String that contains the internal name of the view wich is used for navigation
	 */
	public abstract String getViewName();
}
