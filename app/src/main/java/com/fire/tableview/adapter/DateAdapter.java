package com.fire.tableview.adapter;

import com.fire.tableview.R;
import com.yuyh.easyadapter.abslistview.LVAdapter;
import com.yuyh.easyadapter.abslistview.LVHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class DateAdapter extends LVAdapter<String> {

    public DateAdapter(List<String> mListData) {
        super(mListData,R.layout.item_data);
    }

    @Override
    public void convert(LVHolder holder, int position, String s) {

    }

}