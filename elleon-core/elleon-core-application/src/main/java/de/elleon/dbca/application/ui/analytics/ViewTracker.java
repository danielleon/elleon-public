package de.elleon.dbca.application.ui.analytics;

import de.elleon.dbca.application.ui.navigation.BasicView;

/**
 * A ViewTracker is responsible for reporting view visits of the user. 
 * 
 * @author Daniel
 *
 */
public interface ViewTracker {

	/**
	 * reports the user's visit of a view to any analytics systems
	 * 
	 * @param view the visited view
	 */
	public void trackView(BasicView view);
	
}
