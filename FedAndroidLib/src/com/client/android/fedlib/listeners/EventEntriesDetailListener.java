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
public interface EventEntriesDetailListener {
	
	/**
	 * Called when event entry is received
	 * @param aFoodEntry
	 */
	public void onEventEntryDetailsReceived(EventEntry aEventEntry);
	
	/**
	 * Called when receiving event entry detail fails
	 * @param aResponse
	 */
	public void onEventEntryDetailsFailed(Response aResponse);
}
