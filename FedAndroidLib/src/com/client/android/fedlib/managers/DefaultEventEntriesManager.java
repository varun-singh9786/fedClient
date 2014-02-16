package com.client.android.fedlib.managers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpResponse;

import android.util.Log;

import com.client.android.fedlib.helpers.NetworkHelper;
import com.client.android.fedlib.helpers.StringHelper;
import com.client.android.fedlib.interfaces.EventEntriesManager;
import com.client.android.fedlib.listeners.EventEntriesCreationListener;
import com.client.android.fedlib.listeners.EventEntriesDeletionListener;
import com.client.android.fedlib.listeners.EventEntriesDetailListener;
import com.client.android.fedlib.listeners.EventEntriesListingListener;
import com.client.android.fedlib.listeners.EventEntriesUpdationListener;
import com.client.android.fedlib.listeners.NetworkHelperListener;
import com.client.android.fedlib.models.EventEntry;
import com.client.android.fedlib.models.Response;
import com.client.android.fedlib.util.FedLibConstants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author Varun
 * @date Feb 13, 2014
 *
 */
public class DefaultEventEntriesManager extends Manager implements EventEntriesManager{

	//------------------------------------------------------------------------
	//Properties
	//------------------------------------------------------------------------
	private static final String TAG = DefaultEventEntriesManager.class.getSimpleName();
	private int mPageNumber = 1;
	//TODO implement totalCount

	
	//------------------------------------------------------------------------
	//Implemented Interface methods
	//------------------------------------------------------------------------


	@Override
	public void listEventEntries(long aUserId, int aPageNum, int aCount,
			String aRememberToken, EventEntriesListingListener aListener) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void listEventEntries(long aUserId, String aRememberToken,
			final EventEntriesListingListener aListener) {
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
					HashMap<String, ArrayList<EventEntry>> map = mObjectMapper.readValue(aResponseString, new TypeReference<HashMap<String, ArrayList<EventEntry>>>() {});
					mPageNumber++;
					aListener.onEventEntriesListReceived(map.get(FedLibConstants.KEY_EVENT_ENTRIES));
					
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void onReceived(HttpResponse aResponse) {
				// TODO Auto-generated method stub
				Log.v(TAG, "onReceived#response: " + aResponse.getStatusLine().getStatusCode());
				
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
	public void createEventEntry(EventEntry aEventEntry, long aUserId,
			final EventEntriesCreationListener aListener) {
		String urlString = UrlManager.getCreateEventEntriesUrl(aUserId);
		if (!StringHelper.isValid(urlString)) {
			return;
		}
		HashMap<String, EventEntry> requestMap = new HashMap<String, EventEntry>();
		requestMap.put(FedLibConstants.KEY_FOOD_ENTRIES, aEventEntry);
		try {
			String jsonString = this.mObjectMapper.writeValueAsString(requestMap);
			NetworkHelper.post(urlString, null, jsonString, new NetworkHelperListener() {
				
				@Override
				public void onSuccess(String aResponseString) {
					
					try {
						HashMap<String, EventEntry> eventEntryMap = new HashMap<String, EventEntry>();
						eventEntryMap = mObjectMapper.readValue(aResponseString, new TypeReference<HashMap<String, EventEntry>>() {});
						aListener.onEventEntryCreated(eventEntryMap.get(FedLibConstants.KEY_EVENT_ENTRY));
						
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
	public void getEventEntryDetails(long aUserId, long aId,
			String aRememberToken, final EventEntriesDetailListener aListener) {
		String urlString = UrlManager.getShowEventEntriessUrl(aUserId, aId, aRememberToken);
		if (!StringHelper.isValid(urlString)) {
			//TODO Handle this
			return;
		}
		NetworkHelper.get(urlString, null, new NetworkHelperListener() {
			
			@Override
			public void onSuccess(String aResponseString) {
				try {
					HashMap<String, EventEntry> eventEntryMap = new HashMap<String, EventEntry>();
					eventEntryMap = mObjectMapper.readValue(aResponseString, new TypeReference<HashMap<String, EventEntry>>() {});
					aListener.onEventEntryDetailsReceived(eventEntryMap.get(FedLibConstants.KEY_EVENT_ENTRY));
					
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
	public void updateEventEntry(EventEntry aEventEntry, long aUserId, final EventEntriesUpdationListener aListener) {
		String urlString = UrlManager.getUpdateEventEntriesUrl(aUserId, aEventEntry.getId());
		if (!StringHelper.isValid(urlString)) {
			//TODO Handle this
			return;
		}
		HashMap<String, EventEntry> requestMap = new HashMap<String, EventEntry>();
		requestMap.put(FedLibConstants.KEY_EVENT_ENTRY, aEventEntry);
		try {
			String jsonString = this.mObjectMapper.writeValueAsString(requestMap);
			NetworkHelper.put(urlString, null, jsonString, new NetworkHelperListener() {
				
				@Override
				public void onSuccess(String aResponseString) {
					try {
						
						Response response = mObjectMapper.readValue(aResponseString, Response.class);
						if (response.isSuccess()) {
							aListener.onEventEntryUpdated();
						} else {
							aListener.onEventEntryUpdationFailed(response);
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
		} catch (JsonProcessingException e) {
			//TODO Handle this
		}
		
	}


	@Override
	public void deleteEventEntry(long aUserId, long aId, String aRememberToken,
			final EventEntriesDeletionListener aListener) {
		String urlString = UrlManager.getDeleteEventEntriesUrl(aUserId, aId, aRememberToken);
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
						aListener.onEventEntryDeleted();
					} else {
						aListener.onEventEntryDeletionFailed(response);
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
