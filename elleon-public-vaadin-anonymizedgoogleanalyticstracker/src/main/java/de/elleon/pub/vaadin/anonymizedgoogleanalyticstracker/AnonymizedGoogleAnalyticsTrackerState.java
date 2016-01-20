package de.elleon.pub.vaadin.anonymizedgoogleanalyticstracker;

import org.vaadin.googleanalytics.tracking.GoogleAnalyticsTrackerState;

public class AnonymizedGoogleAnalyticsTrackerState extends GoogleAnalyticsTrackerState {

	private static final long serialVersionUID = 1L;

	public final String COOKIE_NAME_PREFIX = "ga-disable-";
	
	public boolean anonymizeIp = true;
	
}
