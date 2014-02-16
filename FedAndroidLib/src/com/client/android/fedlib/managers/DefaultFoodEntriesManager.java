/**
 * 
 */
package com.client.android.fedlib.managers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpResponse;

import com.client.android.fedlib.helpers.NetworkHelper;
import com.client.android.fedlib.helpers.StringHelper;
import com.client.android.fedlib.interfaces.FoodEntriesManager;
import com.client.android.fedlib.listeners.FoodEntriesCreationListener;
import com.client.android.fedlib.listeners.FoodEntriesDeletionListener;
import com.client.android.fedlib.listeners.FoodEntriesDetailListener;
import com.client.android.fedlib.listeners.FoodEntriesListingListener;
import com.client.android.fedlib.listeners.NetworkHelperListener;
import com.client.android.fedlib.models.FoodEntry;
import com.client.android.fedlib.models.Response;
import com.client.android.fedlib.util.FedLibConstants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author Varun
 * @date Feb 10, 2014
 *
 */
public class DefaultFoodEntriesManager extends Manager implements
		FoodEntriesManager {


	//------------------------------------------------------------------------
	//Properties
	//------------------------------------------------------------------------
	private int mPageNumber;
	//TODO implement totalCount
	//------------------------------------------------------------------------
	//Implemented Interface methods
	//------------------------------------------------------------------------

	@Override
	public void listFoodEntries(long aUserId, int aPageNum, int aCount,
			String aRememberToken, FoodEntriesListingListener aListener) {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	public void listFoodEntries(long aUserId, String aRememberToken, final FoodEntriesListingListener aListener) {	
		String urlString = UrlManager.getListEventEntriesUrl(aUserId, this.mPageNumber, FedLibConstants.PER_PAGE, aRememberToken);
		if (!StringHelper.isValid(urlString)) {
			//TODO Handle this
			return;
		}
		
		NetworkHelper.get(urlString, null, new NetworkHelperListener() {
			
			@Override
			public void onSuccess(String aResponseString) {
				// TODO Auto-generated method stub
				try {
					HashMap<String, ArrayList<FoodEntry>> map = mObjectMapper.readValue(aResponseString, new TypeReference<HashMap<String, ArrayList<FoodEntry>>>() {});
					aListener.onFoodEntriesListReceived(map.get(FedLibConstants.KEY_FOOD_ENTRIES));
					
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
				
			}
			
			@Override
			public void onReceived(HttpResponse aResponse) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFailure(Exception aE) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFailure(String aError) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void createFoodEntry(FoodEntry aFoodEntry, long aUserId, final FoodEntriesCreationListener aListener) {
		String urlString = UrlManager.getCreateFoodEntriesUrl(aUserId);
		if (!StringHelper.isValid(urlString)) {
			return;
		}
		HashMap<String, FoodEntry> requestMap = new HashMap<String, FoodEntry>();
		requestMap.put(FedLibConstants.KEY_FOOD_ENTRIES, aFoodEntry);
		try {
			String jsonString = this.mObjectMapper.writeValueAsString(requestMap);
			NetworkHelper.post(urlString, null, jsonString, new NetworkHelperListener() {
				
				@Override
				public void onSuccess(String aResponseString) {
					
					try {
						HashMap<String, FoodEntry> foodEntryMap = new HashMap<String, FoodEntry>();
						foodEntryMap = mObjectMapper.readValue(aResponseString, new TypeReference<HashMap<String, FoodEntry>>() {});
						aListener.onFoodEntryCreated(foodEntryMap.get(FedLibConstants.KEY_FOOD_ENTRY));
						
					} catch (JsonParseException e) {
						// TODO Auto-generated catch block
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}
					
				}
				
				@Override
				public void onReceived(HttpResponse aResponse) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onFailure(Exception aE) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onFailure(String aError) {
					// TODO Auto-generated method stub
					
				}
			});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
		}
		

	}

	@Override
	public void getFoodEntryDetails(long aUserId, long aId, String aRememberToken, final FoodEntriesDetailListener aListener) {
		String urlString = UrlManager.getShowFoodEntriesUrl(aUserId, aId, aRememberToken);
		if (!StringHelper.isValid(urlString)) {
			//TODO Handle this
			return;
		}
		NetworkHelper.get(urlString, null, new NetworkHelperListener() {
			
			@Override
			public void onSuccess(String aResponseString) {
				try {
					HashMap<String, FoodEntry> foodEntryMap = new HashMap<String, FoodEntry>();
					foodEntryMap = mObjectMapper.readValue(aResponseString, new TypeReference<HashMap<String, FoodEntry>>() {});
					aListener.onFoodEntryDetailsReceived(foodEntryMap.get(FedLibConstants.KEY_FOOD_ENTRY));
					
				} catch (JsonProcessingException e) {
					//TODO Handle this
				} catch (IOException e) {
					// TODO Handle this
				}
			}
			
			@Override
			public void onReceived(HttpResponse aResponse) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFailure(Exception aE) {
				// TODO Handle this
				
			}
			
			@Override
			public void onFailure(String aError) {
				// TODO Handle this
				
			}
		});

	}

	@Override
	public void updateFoodEntry(FoodEntry aFoodEntry, long aUserId) {
		// Not supported yet

	}

	@Override
	public void deleteFoodEntry(long aUserId, long aId, String aRememberToken, final FoodEntriesDeletionListener aListener) {
		String urlString = UrlManager.getDeleteFoodEntriesUrl(aUserId, aId, aRememberToken);
		if (!StringHelper.isValid(urlString)) {
			//TODO Handle this
			return;
		}
		NetworkHelper.get(urlString, null, new NetworkHelperListener() {
			
			@Override
			public void onSuccess(String aResponseString) {
				try {
					
					Response response = mObjectMapper.readValue(aResponseString, Response.class);
					if (response.isSuccess()) {
						aListener.onFoodEntryDeleted();
					} else {
						aListener.onFoodEntryDeletionFailed(response);
					}
				} catch (JsonProcessingException e) {
					//TODO Handle this
				} catch (IOException e) {
					// TODO Handle this
				}
			}
			
			@Override
			public void onReceived(HttpResponse aResponse) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFailure(Exception aE) {
				// TODO Handle this
				
			}
			
			@Override
			public void onFailure(String aError) {
				// TODO Handle this
				
			}
		});

	}

}
