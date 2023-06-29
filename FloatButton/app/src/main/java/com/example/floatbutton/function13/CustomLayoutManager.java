package com.example.floatbutton.function13;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 自定义LayoutManager
 *
 * @author zwp
 */
public class CustomLayoutManager extends LinearLayoutManager {
    public CustomLayoutManager(Context context) {
        super(context);
    }

    public CustomLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CustomLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int result = super.scrollHorizontallyBy(dx, recycler, state);
        View view1 = getChildAt(0);
        View view2 = getChildAt(1);
        View view3 = getChildAt(2);
        View view4 = getChildAt(3);
        View view5 = getChildAt(4);
        if(result > 0){
            view1.setAlpha(view1.getAlpha() - 0.1F);
        }else{
//            view.setAlpha(view.getAlpha() + 0.05F);
        }
        return result;
    }
}
