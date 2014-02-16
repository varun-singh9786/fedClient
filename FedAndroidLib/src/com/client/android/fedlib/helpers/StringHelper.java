/**
 * 
 */
package com.client.android.fedlib.helpers;

/**
 * This class contains arbitrary string related functions
 * @author Varun
 * @date Jan 25, 2014
 *
 */
public class StringHelper {
	
	//TODO Add isValidUrl function
	
	
	/**
	 * Returns if aString is valid (non-null, non-empty) or not
	 * @param aString
	 * @return yes if valid, false otherwise
	 */
	public static Boolean isValid(String aString) {
		if(aString == null) {
			return false;
		}
		
		if (StringHelper.isEmpty(aString)) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * returns if a string is empty or not
	 * @param aString
	 * @return yes if empty, false otherwise
	 */
	public static Boolean isEmpty(String aString) {
		if (aString.trim().length() == 0) {
			return true;
		}
		return false;
	}
}
