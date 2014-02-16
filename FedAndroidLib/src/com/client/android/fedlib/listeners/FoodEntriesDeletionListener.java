/**
 * 
 */
package com.client.android.fedlib.listeners;

import com.client.android.fedlib.models.Response;

/**
 * @author Varun
 * @date Feb 13, 2014
 *
 */
public interface FoodEntriesDeletionListener {
	
	/**
	 * To be called if the food entry is deleted successfully
	 */
	public void onFoodEntryDeleted();
	
	/**
	 * to be called if the food entry deletion failed
	 * @param aResponse
	 */
	public void onFoodEntryDeletionFailed(Response aResponse);

}
