/**
 * 
 */
package com.client.android.fedlib.interfaces;

import com.client.android.fedlib.listeners.EventEntriesCreationListener;
import com.client.android.fedlib.listeners.EventEntriesDeletionListener;
import com.client.android.fedlib.listeners.EventEntriesDetailListener;
import com.client.android.fedlib.listeners.EventEntriesListingListener;
import com.client.android.fedlib.listeners.EventEntriesUpdationListener;
import com.client.android.fedlib.models.EventEntry;

/**
 * This interface is used to handle event entries related web-services
 * @author Varun
 * @date Feb 13, 2014
 *
 */
public interface EventEntriesManager {
	
	/**
	 * Implement this to get list of event entries
	 * @param aUserId
	 * @param aPageNum
	 * @param aCount
	 * @param aRememberToken
	 * @param aListener
	 */
	public void listEventEntries(long aUserId, int aPageNum, int aCount, String aRememberToken, EventEntriesListingListener aListener);
	
	/**
	 * Implement this to get list of event entries
	 * @param aUserId
	 * @param aRememberToken
	 * @param aListener
	 */
	public void listEventEntries(long aUserId, String aRememberToken, EventEntriesListingListener aListener);
	
	/**
	 * Implement this to create a event entry
	 * @param aUserId
	 * @param aEventEntry
	 * @param aListener
	 */
	public void createEventEntry(EventEntry aEventEntry, long aUserId, EventEntriesCreationListener aListener);
	
	/**
	 * Implement this to get event entry details
	 * @param aUserId
	 * @param aId
	 * @param aRememberToken
	 * @param aListener
	 */
	public void getEventEntryDetails(long aUserId, long aId, String aRememberToken, EventEntriesDetailListener aListener);
	
	
	/**
	 * Implement this to update event entry
	 * @param aEventEntry
	 * @param aUserId
	 */
	public void updateEventEntry(EventEntry aEventEntry, long aUserId, EventEntriesUpdationListener aListener);
	
	
	/**
	 * Implement this to delete event entry
	 * @param aUserId
	 * @param aId
	 * @param aRememberToken
	 * @param aListener
	 */
	public void deleteEventEntry(long aUserId, long aId, String aRememberToken, EventEntriesDeletionListener aListener);


}
