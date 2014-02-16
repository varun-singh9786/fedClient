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
public interface UserDetailsListener {
	
	/**
	 * Called when user details are received
	 * @param aUser
	 */
	public void onUserDetailsReceived(User aUser);

	/**
	 * Called when receiving user details fails
	 * @param aResponse
	 */
	public void onUserDetailsFailed(Response aResponse);

}
