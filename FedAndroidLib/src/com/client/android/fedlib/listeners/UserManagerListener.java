/**
 * 
 */
package com.client.android.fedlib.listeners;

import com.client.android.fedlib.models.User;

/**
 * @author Varun
 * @date Jan 26, 2014
 *
 */
public interface UserManagerListener {
	
	/**
	 * Called when a user is created
	 */
	public void onUserCreated();
	
	/**
	 * Called when creating user fails
	 * @param aError
	 */
	public void onUserCreationFailed(String aError);
	
	/**
	 * Called when user details are received
	 * @param aUser
	 */
	public void onUserDetailsReceived(User aUser);
	
	
	/**
	 * Called when receiving user details fails
	 * @param aError
	 */
	public void onUserDetailsFailed(String aError);
	
	/**
	 * Called when user information is updated successfully
	 * @param aUser
	 */
	public void onUserUpdate(User aUser);
	
	/**
	 * Called when updating user information fails
	 * @param aError
	 */
	public void onUserUpdationFailed(String aError);
	
	
	/**
	 * Called when user is deleted successfully
	 */
	public void onUserDeleted();
	
	
	/**
	 * Called when deleting user fails
	 * @param aError
	 */
	public void onUserDeletionFailed(String aError);

}
