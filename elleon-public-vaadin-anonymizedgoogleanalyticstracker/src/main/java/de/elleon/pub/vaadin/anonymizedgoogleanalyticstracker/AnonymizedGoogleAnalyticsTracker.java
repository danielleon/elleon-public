package de.elleon.pub.vaadin.anonymizedgoogleanalyticstracker;

import javax.servlet.http.Cookie;

import org.vaadin.googleanalytics.tracking.GoogleAnalyticsTracker;
import com.vaadin.annotations.JavaScript;
import com.vaadin.server.VaadinService;

/**
 * Extends the GoogleAnalyticsTracker Vaadin Add-On by additional features for privacy protection.
 * In some countries these features are required for legal usage of GoogleAnalytics.
 * 
 * (1) Enables the "AnonymizeIP" parameter in the GA tracking. Can be disabled by setAnonymizeIp(false).
 * 	   If AnonymizeIP is enabled Google doesn't store the complete IP of the user. 
 *     Check the GoogleAnalytics API documentation for more information about that parameter.
 *     This feature is only available when using the universal tracking mode.
 * 
 * (2) Provides an opt-out option by calling the method addOptOutCookie(). It sets a cookie which disables
 * 	   tracking for the user.
 * 
 * @author Daniel Becker
 *
 */
@JavaScript("anonymized_tracker_extension.js")
public class AnonymizedGoogleAnalyticsTracker extends GoogleAnalyticsTracker {

	private static final long serialVersionUID = 1L;
	
	private boolean optOut = false;

	/**
     * Instantiate new Google Analytics tracker without id. Universal tracker is
     * created by default. AnonymizeIP is set by default.
     */
	public AnonymizedGoogleAnalyticsTracker() {
		super();
	}
	
    /**
     * Instantiate new Google Analytics tracker by id. Checks if opt-out cookie is
     * set for the given tracker id. AnonymizeIP is set by default.
     *
     * @param trackerId The tracking id from Google Analytics. Something like
     * 'UA-658457-8'. Universal tracker is created by default.
     */
	public AnonymizedGoogleAnalyticsTracker(String trackerId) {
		super(trackerId);
		optOut = existsOptOutCookie();
	}

    /**
     * Instantiate new Google Analytics tracker by id and domain. Checks if opt-out cookie is
     * set for the given tracker id. AnonymizeIP is set by default.
     *
     * @param trackerId The tracking id from Google Analytics. Something like
     * 'UA-658457-8'.
     * @param domainName The name of the domain to be tracked. Something like
     * 'vaadin.com'. Universal tracker is created by default.
     */
	public AnonymizedGoogleAnalyticsTracker(String trackerId, String domainName) {
		super(trackerId, domainName);
		optOut = existsOptOutCookie();
	}

    /**
	 * Instantiate new Google Analytics tracker by id and domain. Checks if opt-out cookie is
     * set for the given tracker id. AnonymizeIP is set by default.
	 *
	 * @param trackerId The tracking id from Google Analytics. Something like
	 * 'UA-658457-8'.
	 * @param domainName The name of the domain to be tracked. Something like
	 * 'vaadin.com'. Universal tracker is created by default.
	 */
	public AnonymizedGoogleAnalyticsTracker(String trackerId, String domainName, String trackingPrefix) {
		super(trackerId, domainName, trackingPrefix);
		optOut = existsOptOutCookie();
	}
	
	/**
	 * This method enables/disables the anonymizeIp feature.
	 * @param anonymizeIp is IP anonymization enabled (default is 'true')
	 */
    public void setAnonymizeIp(boolean anonymizeIp) {
        getState().anonymizeIp = anonymizeIp;
    }
    
    /**
     * This method adds an cookie to the user's browser. The cookie is a flag for
     * telling that the user don't want to get tracked.
     * 
     */
    public void addOptOutCookie() {
    	callFunction("optOut");
    	optOut = true;
    }
    
    /**
     * Check if opt-out option is set, i.e. tracking is disabled until the opt-out cookie
     * is deleted
     * 
     * @return true if opt-out is set
     */
    public boolean isOptOut() {
    	return optOut;
    }
    
    /**
     * Track a single page view. This effectively invokes the 'trackPageview' in
     * ga.js file. If opt-out is set the method does nothing.
     *
     * @param pageId The page id. Use a scheme like '/topic/page' or
     * '/view/action'.
     */
    @Override
    public void trackPageview(String pageId) {
    	if (!optOut) super.trackPageview(pageId);
    }
    
	@Override
    protected AnonymizedGoogleAnalyticsTrackerState getState() {
        return (AnonymizedGoogleAnalyticsTrackerState) super.getState();
    }
	
	/**
	 * Internal method for building the cookie name
	 * 
	 * @return name of the opt-out cookie
	 */
	private String getOptOutCookieName() {
		return getState().COOKIE_NAME_PREFIX + getState().trackerId;
	}
	
	/**
	 * Internal method to verify if the opt-out cookie is set.
	 * Note: After setting the cookie via addOptOutCookie() the method will still return 
	 * false until the next Vaadin session is started (as the verification relies on 
	 * VaadinService.getCurrentRequest().getCookies()).
	 * 
	 * In this phase this method returns a wrong result. That's why it's private and only
	 * used for the initial construction.
	 * 
	 * Use isOptOut() if you need a valid information if tracking is enabled or not.
	 * 
	 * @return 'true' if opt-out cookie is found in the current Vaadin request
	 */
	private boolean existsOptOutCookie() {
		return (getOptOutCookie() != null);
	}
	
	/**
	 * Internal method for reading the opt-out cookie from the current Vaadin request.
	 * 
	 * @return Cookie object representing the opt-out cookie or null if not found
	 */
	private Cookie getOptOutCookie() { 
	
		String cookieName = getOptOutCookieName();
		
		Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();

		for (Cookie cookie:cookies) { 
			if (cookieName.equals(cookie.getName())) return cookie; 
		}

		return null; 
	} 

}
