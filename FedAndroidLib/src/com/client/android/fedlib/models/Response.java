/**
 * 
 */
package com.client.android.fedlib.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Varun
 * @date Feb 2, 2014
 *
 */
public class Response {
	
	private boolean mSuccess;
	private int mCode;
	private String mMessage;
	
	
	/**
	 * @return the success
	 */
	@JsonProperty("success")
	public boolean isSuccess() {
		return this.mSuccess;
	}
	/**
	 * @param aSuccess the success to set
	 */
	public void setSuccess(boolean aSuccess) {
		this.mSuccess = aSuccess;
	}
	/**
	 * @return the code
	 */
	@JsonProperty("code")
	public int getCode() {
		return this.mCode;
	}
	/**
	 * @param aCode the code to set
	 */
	public void setCode(int aCode) {
		this.mCode = aCode;
	}
	/**
	 * @return the message
	 */
	@JsonProperty("message")
	public String getMessage() {
		return this.mMessage;
	}
	/**
	 * @param aMessage the message to set
	 */
	public void setMessage(String aMessage) {
		this.mMessage = aMessage;
	}

}
