/**
 * 
 */
package com.client.plusclientwrapper.listeners;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.plus.model.people.Person;

/**
 * @author Home
 *
 */
public interface PlusClientWrapperListener {
	
	
	/**
	 * implement this to receive current person's data
	 * @param aPerson
	 */
	public void onReceivedCurrentPerson(Person aPerson);
	
	/**
	 * implement this to receive a callback in case of error
	 * @param aResult
	 */
	public void onFailedWithError(ConnectionResult aResult);

	/**
	 * implement this to receive a callback after PlusClient disconnects
	 */
	public void onDisconnected();
	
	/**
	 * implement this to receive a callback when the user signs out
	 * @param aConnectionResult
	 */
	public void onSignedOut(ConnectionResult aConnectionResult);

}
