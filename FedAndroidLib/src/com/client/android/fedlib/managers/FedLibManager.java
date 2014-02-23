/**
 * 
 */
package com.client.android.fedlib.managers;

import android.content.Context;

/**
 * This class is used to access other managers and configurations
 * @author Varun
 * @date Feb 17, 2014
 *
 */
public class FedLibManager {
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private Context mApplicationContext = null;
	private static FedLibManager sInstance = null;
	
	//--------------------------------------------------------------------------------
	//Getters/Setters
	//--------------------------------------------------------------------------------
	/**
	 * @return the applicationContext
	 */
	public synchronized Context getApplicationContext() {
		return this.mApplicationContext;
	}

	/**
	 * @param aApplicationContext the applicationContext to set
	 */
	public synchronized void setApplicationContext(Context aApplicationContext) {
		this.mApplicationContext = aApplicationContext;
	}

	//--------------------------------------------------------------------------------
	//Constructors
	//--------------------------------------------------------------------------------
	private FedLibManager() {
		
	}
	
	private FedLibManager(Context aContext) {
		this.mApplicationContext = aContext;
	}
	
	
	//--------------------------------------------------------------------------------
	//Others
	//--------------------------------------------------------------------------------
	public static synchronized FedLibManager getInstance() {
		if (sInstance == null) {
			sInstance = new FedLibManager();
		}
		return sInstance;
	}

}
