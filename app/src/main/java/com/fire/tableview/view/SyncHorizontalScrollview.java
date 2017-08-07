package com.fire.tableview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created by Administrator on 2017/8/7.
 */

public class SyncHorizontalScrollview extends HorizontalScrollView {


    private View mView;

    public SyncHorizontalScrollview(Context context) {
        super(context);
    }

    public SyncHorizontalScrollview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SyncHorizontalScrollview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mView != null) {
            mView.scrollTo(l, t);
        }
    }

    public void setScrollView(View view) {
        mView = view;
    }
}
