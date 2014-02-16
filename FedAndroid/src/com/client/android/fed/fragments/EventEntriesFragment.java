/**
 * 
 */
package com.client.android.fed.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

/**
 * @author work
 * 
 */
public class EventEntriesFragment extends ListFragment {

	// --------------------------------------------------------------------------------
	// Constructors
	// --------------------------------------------------------------------------------
	public EventEntriesFragment() {
		// TODO Auto-generated constructor stub
	}
	
	//--------------------------------------------------------------------------------
	//Others
	//--------------------------------------------------------------------------------
	public static EventEntriesFragment newInstance() {
		EventEntriesFragment eventEntriesFragment = new EventEntriesFragment();
		return eventEntriesFragment;
	}

	
	//--------------------------------------------------------------------------------
	//Implemented Interfaces/Listeners
	//--------------------------------------------------------------------------------
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
	}

	

}
