/**
 * 
 */
package com.client.android.fedlib.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import android.os.AsyncTask;
import android.util.Log;

import com.client.android.fedlib.listeners.NetworkHelperListener;
import com.client.android.fedlib.util.FedLibConstants;

/**
 * @author Varun
 * @date Jan 25, 2014
 * 
 */
public class NetworkHelper {

	// --------------------------------------------------------------------------------
	// Properties
	// --------------------------------------------------------------------------------
	private static final String TAG = NetworkHelper.class.getSimpleName();
	private String mUrl;
	private HashMap<String, String> mHeaders;
	private NetworkHelperListener mNetworkHelperListener;
	private HttpRequestBase mHttpRequestBase;
	private HttpResponse mHttpResponse;
	private String mResponseString;
	private byte[] mData;
	private String mStringData;

	/**
	 * @return the httpRequestBase
	 */
	public HttpRequestBase getHttpRequestBase() {
		return this.mHttpRequestBase;
	}

	// --------------------------------------------------------------------------------
	// Constructors
	// --------------------------------------------------------------------------------
	public NetworkHelper(String aUrl, HashMap<String, String> aHeaders,
			NetworkHelperListener aListener) {
		this.mUrl = aUrl;
		this.mHeaders = new HashMap<String, String>();
		this.mHeaders.put("Accept",
				FedLibConstants.HEADER_VALUE_APPLICATION_JSON);
		if (aHeaders != null) {
			this.mHeaders.putAll(aHeaders);
		}
		this.mNetworkHelperListener = aListener;

	}

	public NetworkHelper(String aUrl, HashMap<String, String> aHeaders,
			String aHttpMethod, NetworkHelperListener aListener) {
		this(aUrl, aHeaders, aListener);
		if (aHttpMethod.equalsIgnoreCase(HttpGet.METHOD_NAME)) {
			Log.v(TAG, "NetworkHelper#called. calling private get");
			this.get();
		} else if (aHttpMethod.equalsIgnoreCase(HttpDelete.METHOD_NAME)) {
			this.delete();
		} else {
			throw new IllegalStateException(
					"Wrong constructor called. Method for this constructor should be either GET or DELETE");
		}

	}

	public NetworkHelper(String aUrl, HashMap<String, String> aHeaders,
			String aHttpMethod, byte[] aData, NetworkHelperListener aListener) {
		this(aUrl, aHeaders, aListener);
		this.mHeaders.put("Content-Type",
				FedLibConstants.HEADER_VALUE_APPLICATION_JSON);
		this.mData = aData;
		if (aHttpMethod.equalsIgnoreCase(HttpPost.METHOD_NAME)) {
			this.post();
		} else if (aHttpMethod.equalsIgnoreCase(HttpPut.METHOD_NAME)) {
			this.put();
		} else {
			throw new IllegalStateException(
					"Wrong constructor called. Method for this constructor should be either post or put.");
		}
	}

	public NetworkHelper(String aUrl, HashMap<String, String> aHeaders,
			String aHttpMethod, String aStringData,
			NetworkHelperListener aListener) {
		this(aUrl, aHeaders, aListener);
		this.mHeaders.put("Content-Type",
				FedLibConstants.HEADER_VALUE_APPLICATION_JSON);
		this.mStringData = aStringData;
		if (aHttpMethod.equalsIgnoreCase(HttpPost.METHOD_NAME)) {
			this.post();
		} else if (aHttpMethod.equalsIgnoreCase(HttpPut.METHOD_NAME)) {
			this.put();
		} else {
			throw new IllegalStateException(
					"Wrong constructor called. Method for this constructor should be either post or put.");
		}

	}

	// --------------------------------------------------------------------------------
	// Others
	// --------------------------------------------------------------------------------
	public static HttpGet get(String aUrl, HashMap<String, String> aHeaders,
			NetworkHelperListener aListener) {
		Log.v(TAG, "static get#called");
		NetworkHelper networkHelper = new NetworkHelper(aUrl, aHeaders,
				HttpGet.METHOD_NAME, aListener);
		return (HttpGet) networkHelper.getHttpRequestBase();
	}

	private HttpGet get() {
		if (!StringHelper.isValid(this.mUrl)) {
			Log.v(TAG, "get#called. invalid url: " + this.mUrl);
			return null;
		}

		HttpGet get = new HttpGet(this.mUrl);
		for (String key : this.mHeaders.keySet()) {
			get.addHeader(key, this.mHeaders.get(key));
		}

		this.mHttpRequestBase = get;
		new NetworkTask().execute();
		Log.v(TAG, "get#called. initiating AsyncTask");
		return get;
	}

	public static HttpDelete delete(String aUrl,
			HashMap<String, String> aHeaders, NetworkHelperListener aListener) {
		NetworkHelper networkHelper = new NetworkHelper(aUrl, aHeaders,
				HttpDelete.METHOD_NAME, aListener);
		return (HttpDelete) networkHelper.getHttpRequestBase();
	}

	private HttpDelete delete() {
		if (!StringHelper.isValid(this.mUrl)) {
			return null;
		}

		HttpDelete delete = new HttpDelete(this.mUrl);
		for (String key : this.mHeaders.keySet()) {
			delete.addHeader(key, this.mHeaders.get(key));
		}

		this.mHttpRequestBase = delete;
		new NetworkTask().execute();
		return delete;
	}

	public static HttpPost post(String aUrl, HashMap<String, String> aHeaders,
			byte[] aData, NetworkHelperListener aListener) {
		NetworkHelper networkHelper = new NetworkHelper(aUrl, aHeaders,
				HttpPost.METHOD_NAME, aData, aListener);
		return (HttpPost) networkHelper.getHttpRequestBase();
	}

	public static HttpPost post(String aUrl, HashMap<String, String> aHeaders,
			String aStringData, NetworkHelperListener aListener) {
		NetworkHelper networkHelper = new NetworkHelper(aUrl, aHeaders,
				HttpPost.METHOD_NAME, aStringData, aListener);
		return (HttpPost) networkHelper.getHttpRequestBase();
	}

	private HttpPost post() {
		if (!StringHelper.isValid(this.mUrl)) {
			return null;
		}
		if (this.mData == null && !StringHelper.isValid(this.mStringData)) {
			return null;
		}

		HttpPost post = new HttpPost(this.mUrl);

		for (String key : this.mHeaders.keySet()) {
			post.addHeader(key, this.mHeaders.get(key));
		}
		try {
			post.setEntity(new StringEntity(this.mStringData, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			mNetworkHelperListener.onFailure(e);
		}

		this.mHttpRequestBase = post;
		new NetworkTask().execute();
		return post;
	}

	public static HttpPut put(String aUrl, HashMap<String, String> aHeaders,
			byte[] aData, NetworkHelperListener aListener) {
		NetworkHelper networkHelper = new NetworkHelper(aUrl, aHeaders,
				HttpPut.METHOD_NAME, aData, aListener);
		return (HttpPut) networkHelper.getHttpRequestBase();
	}

	public static HttpPut put(String aUrl, HashMap<String, String> aHeaders,
			String aStringData, NetworkHelperListener aListener) {
		NetworkHelper networkHelper = new NetworkHelper(aUrl, aHeaders,
				HttpPut.METHOD_NAME, aStringData, aListener);
		return (HttpPut) networkHelper.getHttpRequestBase();
	}

	private HttpPut put() {
		if (!StringHelper.isValid(this.mUrl)) {
			return null;
		}
		if (this.mData == null && !StringHelper.isValid(this.mStringData)) {
			return null;
		}

		HttpPut put = new HttpPut(this.mUrl);

		for (String key : this.mHeaders.keySet()) {
			put.addHeader(key, this.mHeaders.get(key));
		}

		try {
			put.setEntity(new StringEntity(this.mStringData, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			mNetworkHelperListener.onFailure(e);
		}

		this.mHttpRequestBase = put;
		new NetworkTask().execute();
		return put;
	}

	private class NetworkTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... aParams) {
			Log.v(TAG, "doInBackground#executing for URL: " + mUrl);
			HttpClient client = new DefaultHttpClient();
			try {
				StringBuilder responseStringBuilder = new StringBuilder();
				if (mHttpRequestBase.getMethod().equalsIgnoreCase(
						HttpGet.METHOD_NAME)) {
					mHttpResponse = client.execute((HttpGet) mHttpRequestBase);
				} else if (mHttpRequestBase.getMethod().equalsIgnoreCase(
						HttpPost.METHOD_NAME)) {
					mHttpResponse = client.execute((HttpPost) mHttpRequestBase);
				} else if (mHttpRequestBase.getMethod().equalsIgnoreCase(
						HttpPut.METHOD_NAME)) {
					mHttpResponse = client.execute((HttpPut) mHttpRequestBase);
				} else if (mHttpRequestBase.getMethod().equalsIgnoreCase(
						HttpDelete.METHOD_NAME)) {
					mHttpResponse = client
							.execute((HttpDelete) mHttpRequestBase);
				}
				if (mHttpResponse != null) {
					mNetworkHelperListener.onReceived(mHttpResponse);
					BufferedReader rd = new BufferedReader(
							new InputStreamReader(mHttpResponse.getEntity()
									.getContent()));
					String line = new String();
					while ((line = rd.readLine()) != null) {
						responseStringBuilder.append(line);
					}

					mResponseString = responseStringBuilder.toString();
					Log.v(TAG, "doInBackground#response: " + mResponseString);
				}

			} catch (ClientProtocolException e) {
				mNetworkHelperListener.onFailure(e);
			} catch (IOException e) {
				mNetworkHelperListener.onFailure(e);
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void aResult) {
			super.onPostExecute(aResult);

			StatusLine statusLine = mHttpResponse.getStatusLine();
			if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
				mNetworkHelperListener.onFailure(statusLine.getReasonPhrase());
				return;
			}
			mNetworkHelperListener.onSuccess(mResponseString);

		}
	}
}