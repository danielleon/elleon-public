package de.elleon.dbca.application.ui.vaadinimplementation.navigation;

import java.util.HashMap;
import java.util.Map;

import com.lexaden.breadcrumb.BreadcrumbLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import de.elleon.dbca.application.ui.navigation.Breadcrumb;
import de.elleon.dbca.application.ui.navigation.BreadcrumbEnabledNavigator;
import de.elleon.dbca.application.ui.navigation.ViewContext;

/**
 * Vaadin implementation of BreadCrumb, mainly by using com.lexaden.breadcrumb.Breadcrumb plug-in.
 * 
 * @see Breadcrumb
 * @author Daniel
 *
 */
public class VaadinBreadcrumb extends com.lexaden.breadcrumb.Breadcrumb implements Breadcrumb {


	/**
	 * 
	 */
	private static final long serialVersionUID = 9115697119444401868L;
	
	/**
	 * Maps a Button to it's visible caption
	 */
	private Map<String, Button> viewButtons = new HashMap<String, Button>();
	
	/**
	 * clears the breadcrumb by removing all buttons
	 */
	@Override
	public void clear() {
		
		BreadcrumbLayout breadcrumbLayout = (BreadcrumbLayout) getCompositionRoot();
		breadcrumbLayout.removeAllComponents();
		
	}
	
	/**
	 * creates a Button instance and adds it to the end of the breadcrumb path.
	 * When clicking the button it will trigger navigation to the view referenced 
	 * by viewContext
	 */
	@Override
	public void setCurrentView(ViewContext viewContext) {
		
		String display = viewContext.getBreadcrumbDisplay();
				
		if (!viewButtons.containsKey(display)) {
			Button breadcrumbButton = new Button(display);
			
			
			breadcrumbButton.addClickListener(new ClickListener() {

				/**
				 * 
				 */
				private static final long serialVersionUID = -1359808785801808971L;

				@Override
				public void buttonClick(ClickEvent clickEvent) {
					((BreadcrumbEnabledNavigator)UI.getCurrent().getNavigator()).breadcrumbReturn(viewContext);
		
				}});

			addLink(breadcrumbButton);
			
			breadcrumbButton.setHeight("16px");
			viewButtons.put(display, breadcrumbButton);
		}
		
		else {
			Button breadcrumbButton = viewButtons.get(display);
			
			if (this.getIndexOfLink(breadcrumbButton) == -1) {
				addLink(breadcrumbButton);
				breadcrumbButton.setHeight("16px");
			}
			else {
				select(breadcrumbButton);
			}
		}
		
	}

	/**
	 * removes all buttons and creates new buttons for all ViewContext instances
	 * given by defaultPath
	 */
	@Override
	public void setBreadcrumbs(ViewContext[] defaultPath) {
		clear();
				
		for(int i=0; i<defaultPath.length; i++) setCurrentView(defaultPath[i]);
		
	}
	
}
