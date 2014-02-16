/**
 * 
 */
package com.client.android.fed.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.client.android.fedlib.models.EventEntry;

/**
 * @author work
 *
 */
public class EventEntriesAdapter extends BaseAdapter {
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private static final String TAG = EventEntriesAdapter.class.getSimpleName();
	private ArrayList<EventEntry> mEventEntries = new ArrayList<EventEntry>();
	private Context mContext;
	
	//--------------------------------------------------------------------------------
	//Constructors
	//--------------------------------------------------------------------------------
	
	public EventEntriesAdapter(ArrayList<EventEntry> aEventEntries, Context aContext) {
		this.mEventEntries = aEventEntries;
		this.mContext = aContext;
	}
	
	//--------------------------------------------------------------------------------
	//Others
	//--------------------------------------------------------------------------------
	static class EventEntriesViewHolder {
		TextView descriptionTextView;
		ProgressBar ratingProgressBar;
		TextView timestampTextView;
	}
	
	//--------------------------------------------------------------------------------
	//Implemented Interfaces/Listeners
	//--------------------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		Log.v(TAG, "getCount: " + this.mEventEntries.size());
		return this.mEventEntries.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int aPosition) {
		// TODO Auto-generated method stub
		return this.mEventEntries.get(aPosition);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int aPosition) {
		// TODO Auto-generated method stub
		return this.mEventEntries.get(aPosition).getId();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int aPosition, View aConvertView, ViewGroup aParent) {
		EventEntriesViewHolder viewHolder = new EventEntriesViewHolder();
		EventEntry eventEntry = this.mEventEntries.get(aPosition);
		if (aConvertView == null) {
			LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			aConvertView = (View) inflater.inflate(com.client.android.fed.R.layout.list_item_event_entry, null);
			viewHolder.descriptionTextView = (TextView) aConvertView.findViewById(com.client.android.fed.R.id.list_item_event_entry_description_text_view);
			viewHolder.ratingProgressBar = (ProgressBar) aConvertView.findViewById(com.client.android.fed.R.id.list_item_event_entry_feeling_progress_bar);
			viewHolder.timestampTextView = (TextView) aConvertView.findViewById(com.client.android.fed.R.id.list_item_event_entry_timestamp_text_view);
			aConvertView.setTag(viewHolder);
			
		} else {
			viewHolder = (EventEntriesViewHolder) aConvertView.getTag();
		}
		
		viewHolder.descriptionTextView.setText(eventEntry.getEventDescription());
		viewHolder.ratingProgressBar.setProgress(eventEntry.getEventRating());
		viewHolder.timestampTextView.setText(String.valueOf(eventEntry.getEventTimestamp()));
		return aConvertView;
	}

}
