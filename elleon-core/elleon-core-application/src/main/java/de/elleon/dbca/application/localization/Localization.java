package de.elleon.dbca.application.localization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * This class provides standard localization functionalities by usage of ResourceBundle.
 * 
 * @see ResourceBundle 
 *  
 * @author Daniel
 *
 */
public class Localization {

	/**
	 * name of the ResourceBundle that is used by default if no name is explicitly
	 * given as parameter in the getTranslation() methods
	 */
	private static String defaultResourceBundle;
	
	private Localization() {}
	
	/**
	 * returns the name of the ResourceBundle that is used by default if no name is explicitly
	 * given as parameter in the getTranslation() methods
	 * 
	 * @return String that represents the name of the default ResourceBundle
	 */
	public static String getDefaultResourceBundle() {
		return defaultResourceBundle;
	}

	/**
	 * setter method for the name of the ResourceBundle that is used by default if no name is explicitly
	 * given as parameter in the getTranslation() methods
	 * 
	 * @param defaultResourceBundle name of the default ResourceBundle
	 */
	public static void setDefaultResourceBundle(String defaultResourceBundle) {
		Localization.defaultResourceBundle = defaultResourceBundle;
	}
	
	/**
	 * returns translation for a Locale and a key from the default ResourceBundle
	 * 
	 * @param locale the Locale which should be used for translation
	 * @param key the to be translated String
	 * @return String that contains the translation of the key
	 */
	public static String getTranslation(Locale locale, String key) {
	
		return getTranslation(defaultResourceBundle, locale, key);
		
	}
	
	/**
	 * returns translation for a Locale and a key from a dedicated ResourceBundle
	 * 
	 * @param resourceBundle the ResourceBundle for the translation
	 * @param locale the Locale which should be used for translation
	 * @param key the to be translated String
	 * @return String that contains the translation of the key
	 */
	public static String getTranslation(String resourceBundle, Locale locale, String key) {
		
		ResourceBundle labels = ResourceBundle.getBundle(resourceBundle, locale);
		
		try {
			return labels.getString(key);
		}
		catch(MissingResourceException e) {
			return key;
		}
		
	}
	
	/**
	 * returns translation for a Locale and a key from the default ResourceBundle
	 * and dynamically inserts the params into the places marked by {}.
	 * 
	 * same functionality as: java.text.MessageFormat.format(getTranslation(locale, key), params)
	 * 
	 * @see MessageFormat
	 * 
	 * @param locale the Locale which should be used for translation
	 * @param key the to be translated String
	 * @param params
	 * @return String that contains the translation of the key
	 */
	public static String getTranslation(Locale locale, String key, Object... params) {
		return MessageFormat.format(getTranslation(locale, key), params);
    }
	
	/**
	 * returns translation for a Locale and a key from a dedicated ResourceBundle
	 * and dynamically inserts the params into the places marked by {}.
	 * 
	 * same functionality as: java.text.MessageFormat.format(getTranslation(locale, key), params)
	 * 
	 * @see MessageFormat
	 * 
	 * @param resourceBundle the ResourceBundle for the translation
	 * @param locale the Locale which should be used for translation
	 * @param key the to be translated String
	 * @param params
	 * @return String that contains the translation of the key
	 */
	public static String getTranslation(String resourceBundle, Locale locale, String key, Object... params) {
		return MessageFormat.format(getTranslation(resourceBundle, locale, key), params);
    }

	
}
