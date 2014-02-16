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
public class EventEntry {
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private String mEventDescription;
	private long mEventTimestamp;
	private int mEventRating;
	private long mId;
	
	//----------------------------------------------------------------------------------------------------
	//Getters/Setters
	//----------------------------------------------------------------------------------------------------
	/**
	 * @return the eventDescription
	 */
	@JsonProperty("event_description")
	public String getEventDescription() {
		return this.mEventDescription;
	}
	/**
	 * @param aEventDescription the eventDescription to set
	 */
	public void setEventDescription(String aEventDescription) {
		this.mEventDescription = aEventDescription;
	}
	/**
	 * @return the eventTimestamp
	 */
	@JsonProperty("event_timestamp")
	public long getEventTimestamp() {
		return this.mEventTimestamp;
	}
	/**
	 * @param aEventTimestamp the eventTimestamp to set
	 */
	public void setEventTimestamp(long aEventTimestamp) {
		this.mEventTimestamp = aEventTimestamp;
	}
	/**
	 * @return the eventRating
	 */
	@JsonProperty("event_rating")
	public int getEventRating() {
		return this.mEventRating;
	}
	/**
	 * @param aEventRating the eventRating to set
	 */
	public void setEventRating(int aEventRating) {
		this.mEventRating = aEventRating;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return mId;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.mId = id;
	}
	//--------------------------------------------------------------------------------
	//Constructors
	//--------------------------------------------------------------------------------
	@JsonCreator
	public EventEntry(@JsonProperty("event_description") String aEventDescription, @JsonProperty("event_timestamp") long aEventTimestamp,@JsonProperty("event_rating") int aEventRating) {
		this.mEventDescription = aEventDescription;
		this.mEventTimestamp = aEventTimestamp;
		this.mEventRating = aEventRating;
	}
}
