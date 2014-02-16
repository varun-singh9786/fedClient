package com.client.android.fedlib.managers;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;

import com.client.android.fedlib.helpers.NetworkHelper;
import com.client.android.fedlib.helpers.StringHelper;
import com.client.android.fedlib.interfaces.UserManager;
import com.client.android.fedlib.listeners.NetworkHelperListener;
import com.client.android.fedlib.listeners.UserCreationListener;
import com.client.android.fedlib.listeners.UserDeletionListener;
import com.client.android.fedlib.listeners.UserDetailsListener;
import com.client.android.fedlib.listeners.UserUpdationListener;
import com.client.android.fedlib.models.Response;
import com.client.android.fedlib.models.User;
import com.client.android.fedlib.util.FedLibConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
/**
 * This class is used for user-related interaction with the server
 * @author Varun
 * @date Jan 26, 2014
 *
 */
public class DefaultUserManager extends Manager implements UserManager {

	private static final String TAG = DefaultUserManager.class.getSimpleName();
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private User mCurrentUser;
	//----------------------------------------------------------------------------------------------------
	//Getters/Setters
	//----------------------------------------------------------------------------------------------------
	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return this.mCurrentUser;
	}
	
	/**
	 * 
	 * @param aUser the current user to set
	 */
	public void setCurrentUser(User aUser) {
		this.mCurrentUser = aUser;
	}

	//--------------------------------------------------------------------------------
	//Interfaces/Listeners
	//--------------------------------------------------------------------------------

	@Override
	public void listUsers() {

	}

	@Override
	public void createUser(User aUser, final UserCreationListener aListener) {
		String urlString = UrlManager.getCreateUsersUrl();
		if (!StringHelper.isValid(urlString)) {
			//TODO Handle this
			return;
		}
		HashMap<String, User> requestMap = new HashMap<String, User>();
		requestMap.put(FedLibConstants.KEY_USER, aUser);
		try {
			String jsonString = this.mObjectMapper.writeValueAsString(requestMap);
			NetworkHelper.post(urlString, null, jsonString, new NetworkHelperListener() {
				
				@Override
				public void onSuccess(String aResponseString) {
					try {
						HashMap<String, User> userMap = new HashMap<String, User>();
						userMap = mObjectMapper.readValue(aResponseString, new TypeReference<HashMap<String, User>>() {});
						aListener.onUserCreated(userMap.get(FedLibConstants.KEY_USER));
						
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
	public void getUserDetails(int aId, String aRememberToken, final UserDetailsListener aListener) {
		String urlString = UrlManager.getGetUserDetailsUrl(aId, aRememberToken);
		if (!StringHelper.isValid(urlString)) {
			//TODO Handle this
			return;
		}
		NetworkHelper.get(urlString, null, new NetworkHelperListener() {
			
			@Override
			public void onSuccess(String aResponseString) {
				try {
					HashMap<String, User> userMap = new HashMap<String, User>();
					userMap = mObjectMapper.readValue(aResponseString, new TypeReference<HashMap<String, User>>() {});
					aListener.onUserDetailsReceived(userMap.get(FedLibConstants.KEY_USER));
					
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
	public void updateUser(User aUser, final UserUpdationListener aListener) {
		String urlString = UrlManager.getUpdateUsersUrl(aUser.getId());
		if (!StringHelper.isValid(urlString)) {
			//TODO Handle this
			return;
		}
		HashMap<String, User> requestMap = new HashMap<String, User>();
		requestMap.put(FedLibConstants.KEY_USER, aUser);
		try {
			String jsonString = this.mObjectMapper.writeValueAsString(requestMap);
			NetworkHelper.put(urlString, null, jsonString, new NetworkHelperListener() {
				
				@Override
				public void onSuccess(String aResponseString) {
					try {
						HashMap<String, User> userMap = new HashMap<String, User>();
						userMap = mObjectMapper.readValue(aResponseString, new TypeReference<HashMap<String, User>>() {});
						aListener.onUserUpdated(userMap.get(FedLibConstants.KEY_USER));
						
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
	public void deleteUser(int aId, String aRememberToken, final UserDeletionListener aListener) {
		String urlString = UrlManager.getDeleteUsersUrl(aId, aRememberToken);
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
						aListener.onUserDeleted();
					} else {
						aListener.onUserDeletionFailed(response);
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
