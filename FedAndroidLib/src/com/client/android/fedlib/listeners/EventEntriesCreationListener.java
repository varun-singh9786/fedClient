/**
 * 
 */
package com.client.android.fedlib.listeners;

import com.client.android.fedlib.models.EventEntry;
import com.client.android.fedlib.models.Response;

/**
 * @author Varun
 * @date Feb 13, 2014
 *
 */
public interface EventEntriesCreationListener {
	
	/**
	 * Called when event entry is created successfully
	 * @param aFoodEntry
	 */
	public void onEventEntryCreated(EventEntry aEventEntry);
	
	/**
	 * Called when creating EventEntry fails
	 * @param aResponse
	 */
	public void onEventEntryCreationFailed(Response aResponse);

}
