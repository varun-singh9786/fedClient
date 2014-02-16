/**
 * 
 */
package com.client.android.fedlib.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Varun
 * @date Jan 21, 2014
 *
 */
public class User {
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private String mName;
	private String mEmail;
	private String mRememberToken;
	private long mId;

	//----------------------------------------------------------------------------------------------------
	//Getters/Setters
	//----------------------------------------------------------------------------------------------------
	/**
	 * @return the name
	 */
	@JsonProperty("name")
	public String getName() {
		return this.mName;
	}
	/**
	 * @param aName the name to set
	 */
	public void setName(String aName) {
		this.mName = aName;
	}
	/**
	 * @return the email
	 */
	@JsonProperty("email")
	public String getEmail() {
		return this.mEmail;
	}
	/**
	 * @param aEmail the email to set
	 */
	public void setEmail(String aEmail) {
		this.mEmail = aEmail;
	}
	
	/**
	 * @return the rememberToken
	 */
	@JsonProperty("remember_token")
	public String getRememberToken() {
		return mRememberToken;
	}
	/**
	 * @param aRememberToken the rememberToken to set
	 */
	public void setRememberToken(String aRememberToken) {
		this.mRememberToken = aRememberToken;
	}
	
	/**
	 * @return the id
	 */
	@JsonProperty("id")
	public long getId() {
		return mId;
	}
	/**
	 * @param aId the id to set
	 */
	public void setId(long aId) {
		this.mId = aId;
	}
	//--------------------------------------------------------------------------------
	//Constructors
	//--------------------------------------------------------------------------------
	@JsonCreator
	public User(@JsonProperty("id") long aId, @JsonProperty("name") String aName, @JsonProperty("email") String aEmail, @JsonProperty("remember_token") String aRememberToken) {
		this.mId = aId;
		this.mName = aName;
		this.mEmail = aEmail;
		this.mRememberToken = aRememberToken;
	}
	
	//--------------------------------------------------------------------------------
	//Others
	//--------------------------------------------------------------------------------
	public String toString() {
		return this.mId + " " + this.mName + " " + this.mEmail + " " + this.mRememberToken;
	}
}
