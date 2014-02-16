/**
 * 
 */
package com.client.android.fedlib.util;

/**
 * @author Varun
 * @date Jan 25, 2014
 *
 */
public class FedLibConstants {
	
	//NetworkHelper constants
	public final static String HEADER_VALUE_APPLICATION_JSON = "application/json";
	
	//User model constants
	public final static String KEY_USER = "user";
	public final static String KEY_USER_ID = "id";
	public final static String KEY_USER_NAME = "name";
	public final static String KEY_USER_EMAIL = "email";
	public final static String KEY_REMEMBER_TOKEN = "remember_token";
	
	//Food entries model constants
	public static final String KEY_FOOD_ENTRY = "food_entry";
	public final static String KEY_FOOD_ENTRIES = "food_entries";
	public final static String KEY_TIMESTAMP = "timestamp";
	public final static String KEY_FOODS = "foods";

	//Food model constants
	public final static String KEY_FOOD_NAME = "food_name";
	public final static String KEY_COOKED_DESCRIPTION = "cooked_description";
	
	//Event model constants
	public final static String KEY_EVENT_ENTRY = "event_entry";
	public final static String KEY_EVENT_ENTRIES = "event_entries";
	public final static String KEY_EVENT_DESCRIPTION = "event_description";
	public final static String KEY_EVENT_TIMESTAMP = "event_timestamp";
	public final static String KEY_EVENT_RATING = "event_rating";
	
	//Response json constants
	public final static String KEY_SUCCESS = "success";
	public final static String KEY_CODE = "code";
	public final static String KEY_MESSAGE = "message";
	
	//Generic constants
	public static final int PER_PAGE = 20;

}
