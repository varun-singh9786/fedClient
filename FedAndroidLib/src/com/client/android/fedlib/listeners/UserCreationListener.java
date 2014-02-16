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
public interface UserCreationListener {
	
	/**
	 * Called when a user is created
	 */
	public void onUserCreated(User aUser);
	
	
	/**
	 * Called when creating user fails
	 * @param aResponse
	 */
	public void onUserCreationFailed(Response aResponse);

}
