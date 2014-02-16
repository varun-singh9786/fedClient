/**
 * 
 */
package com.client.android.fedlib.listeners;

import com.client.android.fedlib.models.Response;
import com.client.android.fedlib.models.User;

/**
 * @author Varun
 * @date Jan 27, 2014
 *
 */
public interface UserUpdationListener {
	/**
	 * Called when user information is updated successfully
	 * @param aUser
	 */
	public void onUserUpdated(User aUser);
	
	/**
	 * Called when updating user information fails
	 * @param aResponse
	 */
	public void onUserUpdationFailed(Response aResponse);

}
