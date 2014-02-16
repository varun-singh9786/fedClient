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
public interface EventEntriesUpdationListener {
	
	/**
	 * Called when event is updated successfully
	 */
	public void onEventEntryUpdated();
	
	
	/**
	 * Called if event updation fails
	 * @param aResponse
	 */
	public void onEventEntryUpdationFailed(Response aResponse);

}
