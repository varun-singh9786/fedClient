/**
 * 
 */
package com.client.android.fedlib.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Varun
 * @date Jan 21, 2014
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Food {
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private long mId;
	private String mFoodName;
	private String mCookedDescription;
	
	
	//----------------------------------------------------------------------------------------------------
	//Getters/Setters
	//----------------------------------------------------------------------------------------------------
	
	/**
	 * @return
	 */
	@JsonProperty("id")
	public long getId() {
		return this.mId;
	}
	
	/**
	 * @param long aId
	 */
	public void setId(long aId) {
		this.mId = aId;
	}
	
	/**
	 * 
	 * @return
	 */
	@JsonProperty("food_name")
	public String getFoodName() {
		return this.mFoodName;
	}
	
	/**
	 * 
	 * @param aFoodName
	 */
	public void setFoodName(String aFoodName) {
		this.mFoodName = aFoodName;
	}
	
	/**
	 * 
	 * @return
	 */
	@JsonProperty("cooked_description")
	public String getCookedDescription() {
		return this.mCookedDescription;
	}
	
	/**
	 * 
	 * @param aCookedDescription
	 */
	public void setCookedDescription(String aCookedDescription) {
		this.mCookedDescription = aCookedDescription;
	}
	
	//--------------------------------------------------------------------------------
	//Constructors
	//--------------------------------------------------------------------------------
	@JsonCreator
	public Food(@JsonProperty("food_name") String aFoodName, @JsonProperty("cooked_description") String aCookedDescription) {
		this.mFoodName = aFoodName;
		this.mCookedDescription = aCookedDescription;
	}
	
	//--------------------------------------------------------------------------------
	//Implemented Interfaces/Listeners
	//--------------------------------------------------------------------------------
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: " + this.mFoodName + " Cooked: " + this.mCookedDescription;
	}
	

}
