/**
 * 
 */
package com.client.android.fedlib.listeners;

import com.client.android.fedlib.models.FoodEntry;
import com.client.android.fedlib.models.Response;

/**
 * @author Varun
 * @date Feb 11, 2014
 *
 */
public interface FoodEntriesCreationListener {
	
	/**
	 * Called when food entry is created successfully
	 * @param aFoodEntry
	 */
	public void onFoodEntryCreated(FoodEntry aFoodEntry);
	
	/**
	 * Called when creating FoodEntry fails
	 * @param aResponse
	 */
	public void onFoodEntryCreationFailed(Response aResponse);

}
