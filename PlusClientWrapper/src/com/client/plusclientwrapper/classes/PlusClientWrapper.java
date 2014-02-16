package com.client.plusclientwrapper.classes;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;

import com.client.plusclientwrapper.listeners.PlusClientWrapperListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.PlusClient.OnAccessRevokedListener;

public enum PlusClientWrapper implements ConnectionCallbacks,
		OnConnectionFailedListener {
	INSTANCE;
	public static int REQUEST_CODE_RESOLVE_ERROR = 1001;
	private Activity mActivity;
	private PlusClient mPlusClient;
	private PlusClientWrapperListener mListener;

	public void signin(Activity aActivity, PlusClientWrapperListener aListener,
			String... aScopes) {

		this.mActivity = aActivity;
		this.mListener = aListener;
		this.mPlusClient = new PlusClient.Builder(this.mActivity, this, this)
				.setScopes(aScopes).build();
		this.mPlusClient.connect();
	}

	public void signout() {
		if (this.mPlusClient.isConnected()) {
			this.mPlusClient.disconnect();
			this.mPlusClient.clearDefaultAccount();
		}
	}

	public void signoutPermanently() {
		this.mPlusClient.clearDefaultAccount();
		this.mPlusClient
				.revokeAccessAndDisconnect(new OnAccessRevokedListener() {

					@Override
					public void onAccessRevoked(ConnectionResult result) {
						PlusClientWrapper.INSTANCE.mListener
								.onSignedOut(result);

					}
				});
	}

	public void disconnect() {
		this.mPlusClient.disconnect();
	}

	public void reconnect() {
		this.mPlusClient.connect();
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		if (result.hasResolution()) {
			try {
				result.startResolutionForResult((Activity) this.mActivity,
						PlusClientWrapper.REQUEST_CODE_RESOLVE_ERROR);
			} catch (SendIntentException e) {
				this.mPlusClient.connect();
			}
		} else {
			this.mListener.onFailedWithError(result);
		}
	}

	@Override
	public void onConnected(Bundle aBundle) {
		this.mListener.onReceivedCurrentPerson(this.mPlusClient
				.getCurrentPerson());
	}

	@Override
	public void onDisconnected() {
		this.mListener.onDisconnected();
	}

}
