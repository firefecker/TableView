package com.fire.tableview.adapter;
import com.fire.tableview.R;
import com.yuyh.easyadapter.abslistview.LVAdapter;
import com.yuyh.easyadapter.abslistview.LVHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class LeftAdapter extends LVAdapter<String> {

    public LeftAdapter(List<String> list) {
        super(list,R.layout.item_left);
    }

    @Override
    public void convert(LVHolder holder, int position, String s) {
        holder.setText(R.id.tv_left,s);
    }

}
