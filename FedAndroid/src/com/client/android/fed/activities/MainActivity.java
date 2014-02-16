package com.client.android.fed.activities;

import java.util.ArrayList;

import org.apache.http.HttpResponse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.client.android.fed.R;
import com.client.android.fed.adapters.EventEntriesAdapter;
import com.client.android.fedlib.listeners.EventEntriesListingListener;
import com.client.android.fedlib.listeners.NetworkHelperListener;
import com.client.android.fedlib.managers.AppManager;
import com.client.android.fedlib.models.EventEntry;
import com.client.android.fedlib.models.Response;
import com.client.plusclientwrapper.classes.PlusClientWrapper;
import com.client.plusclientwrapper.listeners.PlusClientWrapperListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.plus.model.people.Person;

public class MainActivity extends Activity implements PlusClientWrapperListener, NetworkHelperListener{
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private static final String TAG = MainActivity.class.getSimpleName();

	//--------------------------------------------------------------------------------
	//Interfaces/Listeners
	//--------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AppManager.APP_MANAGER.getUserManager().createUser(new User(0, "Varun", "singh.varun@gslab.com", "123456"), new UserCreationListener() {
//			
//			@Override
//			public void onUserCreationFailed(Response aResponse) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onUserCreated(User aUser) {
//				Log.v(TAG, "onCreate#user: " + aUser.toString());
//				
//			}
//		});
        
//        Food food1 = new Food("apple", "raw");
//        Food food2 = new Food("banana", "raw");
//        ArrayList<Food> foodList = new ArrayList<Food>();
//        foodList.add(food1);foodList.add(food2);
//        
//        FoodEntry foodEntry = new FoodEntry(12334556, foodList);
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//			Log.v(TAG, "onCreate#foodentry: " + objectMapper.writeValueAsString(foodEntry));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
//        String jsonString = "{\"timestamp\": 1233435, \"foods\": [{ \"food_name\": \"apple\",\"cooked_description\": \"raw\"}, {\"food_name\": \"banana\",\"cooked_description\": \"cooked\"}]}";
//        
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//			FoodEntry foodEntry = objectMapper.readValue(jsonString, FoodEntry.class);
//			Log.v(TAG, "onCreate#foodEntry: " + foodEntry);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        User modUser = new User(3, "Singh", "singh.varun@gslab.com", "123456");
//        AppManager.APP_MANAGER.getUserManager().updateUser(modUser, new UserUpdationListener() {
//			
//			@Override
//			public void onUserUpdationFailed(Response aResponse) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onUserUpdated(User aUser) {
//				Log.v(TAG, "MainActivity#onCreate-> updated user: " + aUser);
//				
//			}
//		});
//        String jsonString = "{\"food_entry\":{\"timestamp\": 1233435, \"foods\": [{ \"food_name\": \"apple\",\"cooked_description\": \"raw\"}, {\"food_name\": \"banana\",\"cooked_description\": \"cooked\"}]}}";
//        ObjectMapper objectMapper = new ObjectMapper();
//        HashMap<String, FoodEntry> foodEntry = new HashMap<String, FoodEntry>();
//        try {
//			foodEntry = objectMapper.readValue(jsonString, new TypeReference<HashMap<String, FoodEntry>>() {});
//			Log.v(TAG, "onCreate#foodEntry: " + foodEntry);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        
//      Food food1 = new Food("apple", "raw");
//      Food food2 = new Food("banana", "raw");
//      ArrayList<Food> foodList = new ArrayList<Food>();
//      foodList.add(food1);foodList.add(food2);
//      
//      FoodEntry foodEntry = new FoodEntry(123456, foodList);
//      
//      Food food3 = new Food("pears", "raw");
//      Food food4 = new Food("guava", "raw");
//      ArrayList<Food> foodList1 = new ArrayList<Food>();
//      foodList1.add(food3);foodList1.add(food4);
//      
//      FoodEntry foodEntry1 = new FoodEntry(654321, foodList1);
//      
//      ArrayList<FoodEntry> foodEntries = new ArrayList<FoodEntry>();
//      foodEntries.add(foodEntry);foodEntries.add(foodEntry1);
//      HashMap<String, ArrayList<FoodEntry>> foodEntryMap = new HashMap<String, ArrayList<FoodEntry>>();
//      foodEntryMap.put("food_entries", foodEntries);
//      ObjectMapper objectMapper = new ObjectMapper();
//      try {
//		String jsonString = objectMapper.writeValueAsString(foodEntryMap);
//		Log.v(TAG, "onCreate#jsonString: " + jsonString);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			}
        
//        String jsonString = "{\"food_entries\":[{\"timestamp\":123456,\"foods\":[{\"food_name\":\"apple\",\"cooked_description\":\"raw\"},{\"food_name\":\"banana\",\"cooked_description\":\"raw\"}]},{\"timestamp\":654321,\"foods\":[{\"food_name\":\"pears\",\"cooked_description\":\"raw\"},{\"food_name\":\"guava\",\"cooked_description\":\"raw\"}]}]}";
//        HashMap<String, ArrayList<FoodEntry>> foodEntriesMap = new HashMap<String, ArrayList<FoodEntry>>();
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//        	foodEntriesMap = objectMapper.readValue(jsonString, new TypeReference<HashMap<String, ArrayList<FoodEntry>>>(){});
//        	ArrayList<FoodEntry> foodEntries = foodEntriesMap.get("food_entries");
//        	Log.v(TAG, "onCreate#foodEntries: " + foodEntries);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
//        ArrayList<EventEntry> list = new ArrayList<EventEntry>();
//        for (int i = 0; i < 1000; i++) {
//			EventEntry eventEntry = new EventEntry("abc", i, i % 10);
//			list.add(eventEntry);
//			
//		}
//        
//        ListView listView = (ListView) findViewById(R.id.list);
//		EventEntriesAdapter eventEntriesAdapter = new EventEntriesAdapter(list, MainActivity.this);
//		listView.setAdapter(eventEntriesAdapter);
        
        AppManager.APP_MANAGER.getEventEntriesManager().listEventEntries(1, "123456", new EventEntriesListingListener() {
			
			@Override
			public void onEventEntriesListReceived(
					ArrayList<EventEntry> aEventEntriesList) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onEventEntriesListFailed(Response aResponse) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        /*AppManager.APP_MANAGER.getEventEntriesManager().listEventEntries(1, "123456", new EventEntriesListingListener() {
			
			@Override
			public void onEventEntriesListReceived(
					ArrayList<EventEntry> aEventEntriesList) {
				Log.v(TAG, "onEventEntriesListReceived#called");
				ListView listView = (ListView) findViewById(R.id.list);
				EventEntriesAdapter eventEntriesAdapter = new EventEntriesAdapter(aEventEntriesList, MainActivity.this);
				listView.setAdapter(eventEntriesAdapter);
				
			}
			
			@Override
			public void onEventEntriesListFailed(Response aResponse) {
				// TODO Auto-generated method stub
				Log.v(TAG, "onEventEntriesListFailed#called");
				
			}
		});*/
    }
        
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	if (requestCode == PlusClientWrapper.REQUEST_CODE_RESOLVE_ERROR && resultCode == RESULT_OK) {
    		PlusClientWrapper.INSTANCE.reconnect();
    	}
    }


	@Override
	public void onReceivedCurrentPerson(Person aPerson) {
		Log.v(TAG, "onReceivedCurrentPerson#person: " + aPerson);
		
	}


	@Override
	public void onFailedWithError(ConnectionResult aResult) {
		Log.v(TAG, "onFailedWithError#result: " + aResult);
		
	}


	@Override
	public void onDisconnected() {
		Log.v(TAG, "onDisconnected#called");
		
	}


	@Override
	public void onSignedOut(ConnectionResult aConnectionResult) {
		Log.v(TAG, "onSignedOut#called");
		
	}

	
	@Override
	public void onReceived(HttpResponse aResponse) {
		Log.v(TAG, "onReceived#response: " + aResponse);
	}

	@Override
	public void onSuccess(String aResponseString) {
		Log.v(TAG, "onSuccess#response: " + aResponseString);
		
	}


	@Override
	public void onFailure(String aError) {
		Log.v(TAG, "onSuccess#error: " + aError);
	}


	@Override
	public void onFailure(Exception aE) {
		Log.v(TAG, "onSuccess#exception: " + aE);
	}
}
