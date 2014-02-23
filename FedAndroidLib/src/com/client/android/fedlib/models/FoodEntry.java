/**
 * 
 */
package com.client.android.fedlib.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Varun
 * @date Jan 21, 2014
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FoodEntry {
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private long mId;
	private long mTimestamp;
	private ArrayList<Food> mFoodList;
	
	//----------------------------------------------------------------------------------------------------
	//Getters/Setters
	//----------------------------------------------------------------------------------------------------
	
	/**
	 * @return the id
	 */
	@JsonProperty("id")
	public long getId() {
		return this.mId;
	}
	/**
	 * @param aId the id to set
	 */
	public void setId(long aId) {
		this.mId = aId;
	}
	/**
	 * @return the timestamp
	 */
	@JsonProperty("timestamp")
	public long getTimestamp() {
		return this.mTimestamp;
	}
	/**
	 * @param aTimestamp the timestamp to set
	 */
	public void setTimestamp(long aTimestamp) {
		this.mTimestamp = aTimestamp;
	}
	/**
	 * @return the foodList
	 */
	@JsonProperty("foods")
	public ArrayList<Food> getFoodList() {
		return this.mFoodList;
	}
	/**
	 * @param aFoodList the foodList to set
	 */
	public void setFoodList(ArrayList<Food> aFoodList) {
		this.mFoodList = aFoodList;
	}
	
	//--------------------------------------------------------------------------------
	//Constructors
	//--------------------------------------------------------------------------------
	@JsonCreator
	public FoodEntry(@JsonProperty("timestamp") long aTimestamp, @JsonProperty("foods") ArrayList<Food> aFoodList) {
		this.mTimestamp = aTimestamp;
		this.mFoodList = aFoodList;
	}
	
	//--------------------------------------------------------------------------------
	//Others
	//--------------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Timestamp: " + this.mTimestamp + " Foods: " + this.mFoodList;
	}
	

}
