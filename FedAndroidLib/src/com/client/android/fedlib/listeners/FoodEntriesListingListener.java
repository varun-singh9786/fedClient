/**
 * 
 */
package com.client.android.fedlib.listeners;

import java.util.ArrayList;

import com.client.android.fedlib.models.FoodEntry;
import com.client.android.fedlib.models.Response;

/**
 * @author Varun
 * @date Feb 10, 2014
 *
 */
public interface FoodEntriesListingListener {
	/**
	 * To be called when food entries list of received
	 * @param aFoodEntriesList
	 */
	public void onFoodEntriesListReceived(ArrayList<FoodEntry> aFoodEntriesList);
	
	/**
	 * to be called if receiving list fails
	 * @param aResponse
	 */
	public void onFoodEntriesListFailed(Response aResponse);

}
