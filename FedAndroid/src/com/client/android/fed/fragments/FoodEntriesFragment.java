/**
 * 
 */
package com.client.android.fed.fragments;

import java.util.ArrayList;

import com.client.android.fed.adapters.FoodEntriesAdapter;
import com.client.android.fedlib.listeners.FoodEntriesListingListener;
import com.client.android.fedlib.managers.AppManager;
import com.client.android.fedlib.models.FoodEntry;
import com.client.android.fedlib.models.Response;
import com.client.android.fedlib.models.User;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

/**
 * @author work
 *
 */
public class FoodEntriesFragment extends ListFragment {
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private static String TAG = FoodEntriesFragment.class.getSimpleName();
	
	//--------------------------------------------------------------------------------
	//Constructors
	//--------------------------------------------------------------------------------
	public FoodEntriesFragment() {
		
	}
	
	//--------------------------------------------------------------------------------
	//Others
	//--------------------------------------------------------------------------------
	public static FoodEntriesFragment newInstance() {
		FoodEntriesFragment foodEntriesFragment = new FoodEntriesFragment();
		return foodEntriesFragment;
	}
	
	//--------------------------------------------------------------------------------
	//Implemented Interfaces/Listeners
	//--------------------------------------------------------------------------------
	@Override
	public void onActivityCreated(Bundle aSavedInstanceState) {
		super.onActivityCreated(aSavedInstanceState);
		AppManager.APP_MANAGER.getUserManager().setCurrentUser(new User(1, "varun", "varun@gslab.com", "123456"));
		User currentUser = AppManager.APP_MANAGER.getUserManager().getCurrentUser();
		AppManager.APP_MANAGER.getFoodEntriesManager().listFoodEntries(currentUser.getId(), currentUser.getRememberToken(), new FoodEntriesListingListener() {
			
			@Override
			public void onFoodEntriesListReceived(ArrayList<FoodEntry> aFoodEntriesList) {
				FoodEntriesAdapter adapter = new FoodEntriesAdapter(aFoodEntriesList, getActivity());
				setListAdapter(adapter);
				
			}
			
			@Override
			public void onFoodEntriesListFailed(Response aResponse) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
