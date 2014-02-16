/**
 * 
 */
package com.client.android.fedlib.interfaces;

import com.client.android.fedlib.listeners.FoodEntriesCreationListener;
import com.client.android.fedlib.listeners.FoodEntriesDeletionListener;
import com.client.android.fedlib.listeners.FoodEntriesDetailListener;
import com.client.android.fedlib.listeners.FoodEntriesListingListener;
import com.client.android.fedlib.models.FoodEntry;

/**
 * This class is used to handle food entries related web-services
 * @author Varun
 * @date Feb 10, 2014
 *
 */
public interface FoodEntriesManager {
	
	/**
	 * Implement this to get list of food entries
	 * @param aUserId
	 * @param aPageNum
	 * @param aCount
	 * @param aRememberToken
	 * @param aListener
	 */
	public void listFoodEntries(long aUserId, int aPageNum, int aCount, String aRememberToken, FoodEntriesListingListener aListener);
	
	/**
	 * Implement this to get list of food entries
	 * @param aUserId
	 * @param aRememberToken
	 * @param aListener
	 */
	public void listFoodEntries(long aUserId, String aRememberToken, FoodEntriesListingListener aListener);
	
	/**
	 * Implement this to create a food entry
	 * @param aUserId
	 * @param aFoodEntry
	 * @param aListener
	 */
	public void createFoodEntry(FoodEntry aFoodEntry, long aUserId, FoodEntriesCreationListener aListener);
	
	/**
	 * Implement this to get food entry details
	 * @param aUserId
	 * @param aId
	 * @param aRememberToken
	 * @param aListener
	 */
	public void getFoodEntryDetails(long aUserId, long aId, String aRememberToken, FoodEntriesDetailListener aListener);
	
	
	/**
	 * Implement this to update food entry
	 * @param aFoodEntry
	 * @param aUserId
	 */
	public void updateFoodEntry(FoodEntry aFoodEntry, long aUserId);
	
	
	/**
	 * Implement this to delete Food entry
	 * @param aUserId
	 * @param aId
	 * @param aRememberToken
	 * @param aListener
	 */
	public void deleteFoodEntry(long aUserId, long aId, String aRememberToken, FoodEntriesDeletionListener aListener);
	
	

}
