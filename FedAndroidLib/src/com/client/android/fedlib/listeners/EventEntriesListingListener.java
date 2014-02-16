/**
 * 
 */
package com.client.android.fedlib.listeners;

import java.util.ArrayList;

import com.client.android.fedlib.models.EventEntry;
import com.client.android.fedlib.models.Response;

/**
 * @author Varun
 * @date Feb 13, 2014
 *
 */
public interface EventEntriesListingListener {
	
	/**
	 * To be called when event entries list of received
	 * @param aEventEntriesList
	 */
	public void onEventEntriesListReceived(ArrayList<EventEntry> aEventEntriesList);
	
	/**
	 * to be called if receiving list fails
	 * @param aResponse
	 */
	public void onEventEntriesListFailed(Response aResponse);

}
