/**
 * 
 */
package com.client.android.fedlib.listeners;

import org.apache.http.HttpResponse;


/**
 * @author Varun
 * @date Jan 25, 2014
 *
 */
public interface NetworkHelperListener {
	
	/**
	 * Called when a response is received
	 * @param aResponse
	 */
	public void onReceived(HttpResponse aResponse);
	
	/**
	 * Called when response received successfully
	 * @param aResponseString
	 */
	public void onSuccess(String aResponseString);
	
	/**
	 * Called when request failed
	 * @param aError
	 */
	public void onFailure(String aError);
	
	/**
	 * Called when request failed with an exception
	 * @param e
	 */
	public void onFailure(Exception e);
}
