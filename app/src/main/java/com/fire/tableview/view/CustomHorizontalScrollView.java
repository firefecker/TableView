package com.fire.tableview.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

import static cn.bmob.v3.b.From.S;

/**
 * Created by Administrator on 2017/8/9.
 */

public class CustomHorizontalScrollView extends HorizontalScrollView {


    private Runnable scrollerTask;
    private int intitPosition;
    private int newCheck = 100;
    private int childWidth = 0;

    private View mView;

    private OnScrollStopListner onScrollstopListner;

    public CustomHorizontalScrollView(Context context) {
        super(context);
        init();
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public CustomHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        scrollerTask = new Runnable() {
            @Override
            public void run() {
                int newPosition = getScrollX();
                if (intitPosition - newPosition == 0) {
                    if (onScrollstopListner == null) {
                        return;
                    }
                    onScrollstopListner.onScrollStoped();
                    Rect outRect = new Rect();
                    getDrawingRect(outRect);
                    if (getScrollX() == 0) {
                        onScrollstopListner.onScrollToLeftEdge();
                    } else if (childWidth + getPaddingLeft() + getPaddingRight() == outRect.right) {
                        onScrollstopListner.onScrollToRightEdge();
                    } else {
                        onScrollstopListner.onScrollToMiddle();
                    }
                } else {
                    intitPosition = getScrollX();
                    postDelayed(scrollerTask, newCheck);
                }
            }
        };

        setOnScrollStopListner(new OnScrollStopListner() {
            @Override
            public void onScrollStoped() {

            }

            @Override
            public void onScrollToLeftEdge() {
                getParent().requestDisallowInterceptTouchEvent(false);
            }

            @Override
            public void onScrollToRightEdge() {
                getParent().requestDisallowInterceptTouchEvent(false);
            }

            @Override
            public void onScrollToMiddle() {

            }
        });
    }



    public void setOnScrollStopListner(OnScrollStopListner listner) {
        onScrollstopListner = listner;
    }

    public void startScrollerTask() {
        intitPosition = getScrollX();
        postDelayed(scrollerTask, newCheck);
        checkTotalWidth();
    }

    @Override
    public boolean onTouchEvent(MotionEvent p_event) {
        if (p_event.getAction() == MotionEvent.ACTION_MOVE && getParent() != null) {
            getParent().getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(p_event);
    }

    private void checkTotalWidth() {
        if(childWidth > 0)
        {
            return;
        }
        for(int i = 0; i < getChildCount(); i++)
        {
            childWidth += getChildAt(i).getWidth();
        }
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


    public interface OnScrollStopListner {
        /**
         * scroll have stoped
         */
        void onScrollStoped();
        /**
         * scroll have stoped, and is at left edge
         */
        void onScrollToLeftEdge();
        /**
         * scroll have stoped, and is at right edge
         */
        void onScrollToRightEdge();
        /**
         * scroll have stoped, and is at middle
         */
        void onScrollToMiddle();
    }

}
