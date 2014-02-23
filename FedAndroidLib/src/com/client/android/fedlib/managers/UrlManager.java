package com.client.android.fedlib.managers;

import com.client.android.fedlib.helpers.StringHelper;


/**
 * 
 * @author Varun
 * @date Jan 26, 2014
 *
 */
public class UrlManager {
	
//	private static final String BASE_URL = "young-dusk-5076.herokuapp.com";
//	private static final String BASE_URL = "localhost:3000";
	private static final String BASE_URL = "fed.ngrok.com";
	private static final String SCHEME = "https";
	
	//Users
	private static final String MANAGE_USERS_GET = "users/:id/:remember_token";
	private static final String MANAGE_USERS_POST = "users/:id/";
	private static final String CREATE_USERS = "users";
	
	//Food entry
	private static final String MANAGE_FOOD_ENTRIES_GET = "users/:user_id/food_entries/:id/:remember_token";
	private static final String MANAGE_FOOD_ENTRIES_POST = "users/:user_id/food_entries/:id";
	private static final String CREATE_FOOD_ENTRIES = "users/:user_id/food_entries";
	private static final String LIST_FOOD_ENTRIES = "users/:user_id/food_entries/:page/:count/:remember_token";
	
	//Event entry
	private static final String MANAGE_EVENT_ENTRIES_GET = "users/:user_id/event_entries/:id/:remember_token";
	private static final String MANAGE_EVENT_ENTRIES_POST = "users/:user_id/event_entries/:id";
	private static final String CREATE_EVENT_ENTRIES = "users/:user_id/event_entries";
	private static final String LIST_EVENT_ENTRIES = "users/:user_id/event_entries/:page/:count/:remember_token";
	
	
	//Users
	public static String getListUsersUrl() {
		return SCHEME + "://" + BASE_URL + "/" + CREATE_USERS;
	}
	
	public static String getCreateUsersUrl() {
		return SCHEME + "://" + BASE_URL + "/" + CREATE_USERS;
	}
	
	public static String getGetUserDetailsUrl(long aId, String aRememberToken) {
		if (aId <= 0) {
			return null;
		}
		
		if (!StringHelper.isValid(aRememberToken)) {
			return null;
		}
		return SCHEME + "://" + BASE_URL + "/" + MANAGE_USERS_GET.replaceAll(":id", String.valueOf(aId)).replaceAll(":remember_token", aRememberToken);
	}
	
	public static String getUpdateUsersUrl(long aId) {
		if (aId <= 0) {
			return null;
		}
		return SCHEME + "://" + BASE_URL + "/" + MANAGE_USERS_POST.replaceAll(":id", String.valueOf(aId));
	}
	
	public static String getDeleteUsersUrl(long aId, String aRememberToken) {
		if (aId <= 0) {
			return null;
		}
		
		if (!StringHelper.isValid(aRememberToken)) {
			return null;
		}
		return SCHEME + "://" + BASE_URL + "/" + MANAGE_USERS_GET.replaceAll(":id", String.valueOf(aId)).replaceAll(":remember_token", aRememberToken);
	}
	
	//Food entry
	public static String getListFoodEntriesUrl(long aUserId, int aPageNum, int aCount, String aRememberToken) {
		if (aUserId <= 0) {
			return null;
		}
		
		if (aPageNum <= 0) {
			return null;
		}
		
		if (aCount <= 0) {
			return null;
		}
		
		if (!StringHelper.isValid(aRememberToken)) {
			return null;
		}
		return SCHEME + "://" + BASE_URL + "/" + LIST_FOOD_ENTRIES.replaceAll(":user_id", String.valueOf(aUserId)).replaceAll(":remember_token", aRememberToken).replaceAll(":page", String.valueOf(aPageNum)).replaceAll(":count", String.valueOf(aCount));
	}
	
	public static String getCreateFoodEntriesUrl(long aUserId) {
		if (aUserId <= 0) {
			return null;
		}
		return SCHEME + "://" + BASE_URL + "/" + CREATE_FOOD_ENTRIES.replaceAll(":user_id", String.valueOf(aUserId));
	}
	
	public static String getShowFoodEntriesUrl(long aUserId, long aId, String aRememberToken) {
		if (aUserId <= 0) {
			return null;
		}
		
		if (aId <= 0) {
			return null;
		}
		
		if (!StringHelper.isValid(aRememberToken)) {
			return null;
		}
		return SCHEME + "://" + BASE_URL + "/" + MANAGE_FOOD_ENTRIES_GET.replaceAll(":user_id", String.valueOf(aUserId)).replaceAll(":id", String.valueOf(aId)).replaceAll(":remember_token", aRememberToken);
	}
	
	public static String getUpdateFoodEntriessUrl(long aUserId, long aId) {
		if (aUserId <= 0) {
			return null;
		}
		
		if (aId <= 0) {
			return null;
		}
		
		return SCHEME + "://" + BASE_URL + "/" + MANAGE_FOOD_ENTRIES_POST.replaceAll(":user_id", String.valueOf(aUserId)).replaceAll(":id", String.valueOf(aId));
	}
	
	public static String getDeleteFoodEntriesUrl(long aUserId, long aId, String aRememberToken) {
		if (aUserId <= 0) {
			return null;
		}
		
		if (aId <= 0) {
			return null;
		}
		
		if (!StringHelper.isValid(aRememberToken)) {
			return null;
		}
		return SCHEME + "://" + BASE_URL + "/" + MANAGE_FOOD_ENTRIES_GET.replaceAll(":user_id", String.valueOf(aUserId)).replaceAll(":id", String.valueOf(aId)).replaceAll(":remember_token", aRememberToken);
	}
	
	//Event entry
	public static String getListEventEntriesUrl(long aUserId, int aPageNum, int aCount, String aRememberToken) {
		if (aUserId <= 0) {
			return null;
		}
		
		if (aPageNum <= 0) {
			return null;
		}
		
		if (aCount <= 0) {
			return null;
		}
		
		if (!StringHelper.isValid(aRememberToken)) {
			return null;
		}
		
		return SCHEME + "://" + BASE_URL + "/" + LIST_EVENT_ENTRIES.replaceAll(":user_id", String.valueOf(aUserId)).replaceAll(":page", String.valueOf(aPageNum)).replaceAll(":count", String.valueOf(aCount)).replaceAll(":remember_token", aRememberToken);
	}
	
	public static String getCreateEventEntriesUrl(long aUserId) {
		if (aUserId <= 0) {
			return null;
		}
		
		return SCHEME + "://" + BASE_URL + "/" + CREATE_EVENT_ENTRIES.replaceAll(":user_id", String.valueOf(aUserId));
	}
	
	public static String getShowEventEntriessUrl(long aUserId, long aId, String aRememberToken) {
		if (aUserId <= 0) {
			return null;
		}
		if (aId <= 0) {
			return null;
		}
		if (!StringHelper.isValid(aRememberToken)) {
			return null;
		}
		return SCHEME + "://" + BASE_URL + "/" + MANAGE_EVENT_ENTRIES_GET.replaceAll(":user_id", String.valueOf(aUserId)).replaceAll(":id", String.valueOf(aId)).replaceAll(":remember_token", aRememberToken);
	}
	
	public static String getUpdateEventEntriesUrl(long aUserId, long aId) {
		if (aUserId <= 0) {
			return null;
		}
		
		if (aId <= 0) {
			return null;
		}
		return SCHEME + "://" + BASE_URL + "/" + MANAGE_EVENT_ENTRIES_POST.replaceAll(":user_id", String.valueOf(aUserId)).replaceAll(":id", String.valueOf(aId));
	}
	
	public static String getDeleteEventEntriesUrl(long aUserId, long aId, String aRememberToken) {
		if (aUserId <= 0) {
			return null;
		}
		
		if (aId <= 0) {
			return null;
		}
		
		if (!StringHelper.isValid(aRememberToken)) {
			return null;
		}
		return SCHEME + "://" + BASE_URL + "/" + MANAGE_EVENT_ENTRIES_GET.replaceAll(":user_id", String.valueOf(aUserId)).replaceAll(":id", String.valueOf(aId)).replaceAll(":remember_token", aRememberToken);
	}
}
