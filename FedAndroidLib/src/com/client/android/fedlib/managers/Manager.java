package com.client.android.fedlib.managers;

import com.client.android.fedlib.helpers.NetworkHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class should serves as the parent to all the other Managers
 * @author Varun
 * @date Jan 27, 2014
 *
 */
public abstract class Manager{
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	protected NetworkHelper mNetworkHelper;
	protected ObjectMapper mObjectMapper;
	
	public Manager() {
		this.mObjectMapper = new ObjectMapper();
	}

}
