# AnonymizedGoogleAnalyticsTracker Add-on for Vaadin 7

AnonymizedGoogleAnalyticsTracker extends the GoogleAnalyticsTracker Vaadin Add-On by additional features for privacy protection. In some countries these features are required for legal usage of GoogleAnalytics.
 
 (1) Enables the "AnonymizeIP" parameter in the GA tracking. Can be disabled by setAnonymizeIp(false).
 	   If AnonymizeIP is enabled Google doesn't store the complete IP of the user. 
       Check the GoogleAnalytics API documentation for more information about that parameter.
       This feature is only available when using the universal tracking mode.
 
 (2) Provides an opt-out option by calling the method addOptOutCookie(). It sets a cookie which disables
     tracking for the user.

## Download release

Official releases of this add-on are available at Vaadin Directory. For Maven instructions, download and reviews, go to http://vaadin.com/addon/AnonymizedGoogleAnalyticsTracker

 
## Release notes

### Version 1.0.0
- Initial stable version


## Roadmap

There is no public roadmap or any guarantees of upcoming releases. 
We try to keep an eye on changes at the GoogleAnalytics API, new laws or guidelines concerning the privacy protection.

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

AnonymizedGoogleAnalyticsTracker is written by Daniel Becker based on the original GoogleAnalyticsTracker Vaadin Add-On.


# Developer Guide

Find here an explaining interactive elleon diagram about the structure of AnonymizedGoogleAnalyticsTracker:

https://portal.elleon.de/#!DrawingArea/public/adc37523-15c9-4950-b1c8-696724d55198


