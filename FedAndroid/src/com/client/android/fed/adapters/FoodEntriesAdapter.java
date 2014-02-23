/**
 * 
 */
package com.client.android.fed.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.client.android.fed.R;
import com.client.android.fed.customviews.NonScrollableGridView;
import com.client.android.fedlib.models.Food;
import com.client.android.fedlib.models.FoodEntry;

/**
 * @author work
 * 
 */
public class FoodEntriesAdapter extends BaseAdapter {

	// --------------------------------------------------------------------------------
	// Properties
	// --------------------------------------------------------------------------------
	private static final String TAG = FoodEntriesAdapter.class.getSimpleName();
	private ArrayList<FoodEntry> mFoodEntries = new ArrayList<FoodEntry>();
	private Context mContext;

	// --------------------------------------------------------------------------------
	// Constructors
	// --------------------------------------------------------------------------------

	public FoodEntriesAdapter(ArrayList<FoodEntry> aFoodEntries,
			Context aContext) {
		this.mFoodEntries = aFoodEntries;
		this.mContext = aContext;
	}

	// --------------------------------------------------------------------------------
	// Others
	// --------------------------------------------------------------------------------
	static class FoodEntriesViewHolder {
		NonScrollableGridView foodsContainerLayout;
		TextView timestampTextView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return this.mFoodEntries.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int aPosition) {
		return this.mFoodEntries.get(aPosition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int aPosition) {
		return this.mFoodEntries.get(aPosition).getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@Override
	public View getView(int aPosition, View aConvertView, ViewGroup aParent) {
		FoodEntry foodEntry = this.mFoodEntries.get(aPosition);
		FoodEntriesViewHolder viewHolder = new FoodEntriesViewHolder();
		if (aConvertView == null) {
			LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			aConvertView = inflater.inflate(R.layout.list_item_food_entry, null);
			viewHolder.timestampTextView = (TextView) aConvertView.findViewById(R.id.list_item_food_entry_timestamp_text_view);
			viewHolder.foodsContainerLayout = (NonScrollableGridView) aConvertView.findViewById(R.id.list_item_food_entry_foods_container);
			aConvertView.setTag(viewHolder);
		} else {
			viewHolder = (FoodEntriesViewHolder) aConvertView.getTag();
		}
		FoodsAdapter foodsAdapter = new FoodsAdapter(mContext, foodEntry.getFoodList());
		viewHolder.foodsContainerLayout.setAdapter(foodsAdapter);
		viewHolder.timestampTextView.setText(String.valueOf(foodEntry.getTimestamp()));
		return aConvertView;
	}

}
