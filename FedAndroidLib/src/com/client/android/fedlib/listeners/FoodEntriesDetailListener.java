/**
 * 
 */
package com.client.android.fedlib.listeners;

import com.client.android.fedlib.models.FoodEntry;
import com.client.android.fedlib.models.Response;

/**
 * @author Varun
 * @date Feb 13, 2014
 *
 */
public interface FoodEntriesDetailListener {
	
	/**
	 * Called when food entry is received
	 * @param aFoodEntry
	 */
	public void onFoodEntryDetailsReceived(FoodEntry aFoodEntry);
	
	/**
	 * Called when receiving food entry detail fails
	 * @param aResponse
	 */
	public void onFoodEntryDetailsFailed(Response aResponse);

}
