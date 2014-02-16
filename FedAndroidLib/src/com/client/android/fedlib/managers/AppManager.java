/**
 * 
 */
package com.client.android.fedlib.managers;

import com.client.android.fedlib.interfaces.EventEntriesManager;
import com.client.android.fedlib.interfaces.FoodEntriesManager;
import com.client.android.fedlib.interfaces.UserManager;

/**
 * @author Varun
 * @date Jan 26, 2014
 *
 */
public enum AppManager {
	APP_MANAGER;
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private UserManager mUserManager;
	private FoodEntriesManager mFoodEntriesManager;
	private EventEntriesManager mEventEntriesManager;
	//----------------------------------------------------------------------------------------------------
	//Getters/Setters
	//----------------------------------------------------------------------------------------------------
	public synchronized UserManager getUserManager() {
		if (this.mUserManager == null) {
			this.mUserManager = new DefaultUserManager();
		}
		return this.mUserManager;
	}
	
	public synchronized FoodEntriesManager getFoodEntriesManager() {
		if (this.mFoodEntriesManager == null) {
			this.mFoodEntriesManager = new DefaultFoodEntriesManager();
		}
		return this.mFoodEntriesManager;
	}
	
	public synchronized EventEntriesManager getEventEntriesManager() {
		if (this.mEventEntriesManager == null) {
			this.mEventEntriesManager = new DefaultEventEntriesManager();
		}
		return this.mEventEntriesManager;
	}
	

}
