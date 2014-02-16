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
public interface EventEntriesDeletionListener {
	
	/**
	 * Called when event is deleted successful
	 */
	public void onEventEntryDeleted();
	
	
	/**
	 * Called if deleting event entry fails
	 * @param aResponse
	 */
	public void onEventEntryDeletionFailed(Response aResponse);
}
