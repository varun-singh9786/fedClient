/**
 * 
 */
package com.client.android.fed.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;

import com.client.android.fed.adapters.EventEntriesAdapter;
import com.client.android.fedlib.listeners.EventEntriesListingListener;
import com.client.android.fedlib.managers.AppManager;
import com.client.android.fedlib.models.EventEntry;
import com.client.android.fedlib.models.Response;
import com.client.android.fedlib.models.User;

/**
 * @author work
 * 
 */
public class EventEntriesFragment extends ListFragment {
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private static final String TAG = EventEntriesFragment.class.getSimpleName();

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
		
		AppManager.APP_MANAGER.getUserManager().setCurrentUser(new User(1, "varun", "varun@gslab.com", "123456"));
		User currentUser = AppManager.APP_MANAGER.getUserManager().getCurrentUser();
		
		AppManager.APP_MANAGER.getEventEntriesManager().listEventEntries(currentUser.getId(), currentUser.getRememberToken(), new EventEntriesListingListener() {
			
			@Override
			public void onEventEntriesListReceived(
					ArrayList<EventEntry> aEventEntriesList) {
				Log.v(TAG, "onActivityCreated#called");
				EventEntriesAdapter adapter = new EventEntriesAdapter(aEventEntriesList, getActivity());
				setListAdapter(adapter);
			}
			
			@Override
			public void onEventEntriesListFailed(Response aResponse) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	

}
