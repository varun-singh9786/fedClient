/**
 * 
 */
package com.client.android.fed.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * @author work
 *
 */
public class NonScrollableGridView extends GridView {

	public NonScrollableGridView(Context aContext) {
		super(aContext);
		// TODO Auto-generated constructor stub
	}
	
	public NonScrollableGridView(Context aContext, AttributeSet aAttrs) {
		super(aContext, aAttrs);
	}
	
	public NonScrollableGridView(Context aContext, AttributeSet aAttrs, int aDefStyle) {
		super(aContext, aAttrs, aDefStyle);
	}
	
	
	@Override
	protected void onMeasure(int aWidthMeasureSpec, int aHeightMeasureSpec) {
		// TODO Auto-generated method stub
		int nonscrollableSpec = MeasureSpec.makeMeasureSpec(MEASURED_SIZE_MASK, MeasureSpec.AT_MOST);
		ViewGroup.LayoutParams layoutParams = getLayoutParams();
		layoutParams.height = getMeasuredHeight();
		super.onMeasure(aWidthMeasureSpec, nonscrollableSpec);
	}

}
