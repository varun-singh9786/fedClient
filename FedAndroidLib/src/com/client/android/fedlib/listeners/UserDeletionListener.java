/**
 * 
 */
package com.client.android.fedlib.listeners;

import com.client.android.fedlib.models.Response;

/**
 * @author Varun
 * @date Feb 2, 2014
 *
 */
public interface UserDeletionListener {
	
	/**
	 * Called when user is deleted successfully
	 */
	public void onUserDeleted();
	
	/**
	 * Called when deleting user fails
	 * @param aResponse
	 */
	public void onUserDeletionFailed(Response aResponse);

}
