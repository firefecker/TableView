package com.fire.tableview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fire.tableview.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class MyStyleLayout extends LinearLayout {

    private View inflateView;
    private LinearLayout layoutTitle;

    private Context mContext;

    public MyStyleLayout(Context context) {
        super(context);

        init(context);
    }

    public MyStyleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyStyleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        inflateView = View.inflate(context, R.layout.style_layout, this);
        layoutTitle = (LinearLayout) inflateView.findViewById(R.id.lin_year_title);
    }

    public void addViews(List<String> mDatas) {
        View view = null;
        for (String data : mDatas) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_title,layoutTitle,false);
            TextView tvData = (TextView) view.findViewById(R.id.tv_data);
            tvData.setText(data);
            layoutTitle.addView(view);
        }
    }


}
