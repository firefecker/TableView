package com.fire.tableview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;

/**
 * Created by Administrator on 2017/8/7.
 */

public class SyncHorizontalScrollview extends HorizontalScrollView {


    private View mView;
    private int scrollX;
    private int mScreenHeight;

    public SyncHorizontalScrollview(Context context) {
        super(context);
        init(context);
    }

    public SyncHorizontalScrollview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SyncHorizontalScrollview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        scrollX = l;
        if (mView != null) {
            mView.scrollTo(l, t);
        }

    }

    private void init(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mScreenHeight = dm.heightPixels;
    }

    public void setScrollView(View view) {
        mView = view;
    }

    @Override
    public boolean onTouchEvent(MotionEvent p_event) {
        if (p_event.getAction() == MotionEvent.ACTION_MOVE && getParent() != null) {
            getParent().getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(p_event);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
