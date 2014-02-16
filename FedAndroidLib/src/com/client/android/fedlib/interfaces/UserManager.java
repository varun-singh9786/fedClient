package com.client.android.fedlib.interfaces;

import com.client.android.fedlib.listeners.UserCreationListener;
import com.client.android.fedlib.listeners.UserDeletionListener;
import com.client.android.fedlib.listeners.UserDetailsListener;
import com.client.android.fedlib.listeners.UserUpdationListener;
import com.client.android.fedlib.models.User;


/**
 * This class is used to handle user related web-services
 * @author Varun
 * @date Jan 26, 2014
 *
 */
public interface UserManager{
	
	
	/**
	 * Implement this to list all the users
	 */
	public void listUsers();
	
	/**
	 * Implement this to create a new user	
	 * @param aUser
	 * @param aListener
	 */
	public void createUser(User aUser, UserCreationListener aListener);
	
	/**
	 * Implement this to get the details of a user
	 * @param aId
	 * @param aRememberToken
	 * @param aListener
	 */
	public void getUserDetails(int aId, String aRememberToken, UserDetailsListener aListener);
	
	
	/**
	 * Implement this change user details
	 * @param aUser
	 * @param aListener
	 */
	public void updateUser(User aUser, UserUpdationListener aListener);
	
	
	/**
	 * Implement this to delete a user
	 * @param aId
	 * @param aRememberToken
	 * @param aListener
	 */
	public void deleteUser(int aId, String aRememberToken, UserDeletionListener aListener);

}
