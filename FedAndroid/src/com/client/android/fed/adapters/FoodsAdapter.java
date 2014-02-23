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
import android.widget.TextView;

import com.client.android.fed.R;
import com.client.android.fedlib.models.Food;

/**
 * @author work
 *
 */
public class FoodsAdapter extends BaseAdapter {
	
	//--------------------------------------------------------------------------------
	//Properties
	//--------------------------------------------------------------------------------
	private static final String TAG = FoodsAdapter.class.getSimpleName();
	private Context mContext;
	private ArrayList<Food> mFoodList;
	
	//--------------------------------------------------------------------------------
	//Constructors
	//--------------------------------------------------------------------------------
	public FoodsAdapter(Context aContext, ArrayList<Food> aFoodList) {
		this.mContext = aContext;
		this.mFoodList = aFoodList;
	}
	
	//--------------------------------------------------------------------------------
	//Others
	//--------------------------------------------------------------------------------
	private static class FoodsViewHolder {
		TextView foodNameTextView;
		TextView cookedDescriptionTextView;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		Log.v(TAG, "getCount: " + mFoodList.size());
		return mFoodList.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int aPosition) {
		Log.v(TAG, "getItem: " + mFoodList.get(aPosition));
		return mFoodList.get(aPosition);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int aPosition) {
		Log.v(TAG, "getItemId: " + mFoodList.get(aPosition).getId());
		return mFoodList.get(aPosition).getId();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int aPosition, View aConvertView, ViewGroup aParent) {
		Food food = mFoodList.get(aPosition);
		Log.v(TAG, "getView#food: " + food);
		FoodsViewHolder viewHolder = new FoodsViewHolder();
		if (aConvertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			aConvertView = inflater.inflate(R.layout.list_item_food, null);
			viewHolder.foodNameTextView = (TextView) aConvertView.findViewById(R.id.list_item_food_name_text_view);
			viewHolder.cookedDescriptionTextView = (TextView) aConvertView.findViewById(R.id.list_item_food_cooked_description_text_view);
			aConvertView.setTag(viewHolder);
		} else {
			viewHolder = (FoodsViewHolder) aConvertView.getTag();
			
		}
		viewHolder.foodNameTextView.setText(food.getFoodName());
		viewHolder.cookedDescriptionTextView.setText(food.getCookedDescription());
		return aConvertView;
	}

}
