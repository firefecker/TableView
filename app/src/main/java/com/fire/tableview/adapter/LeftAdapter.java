package com.fire.tableview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fire.tableview.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class LeftAdapter extends BaseAdapter {

    private List<String> mListData;

    public LeftAdapter(List<String> mListData) {
        this.mListData = mListData;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left, null);
            holder.tvLeft = (TextView) convertView.findViewById(R.id.tv_left);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String data = mListData.get(position);
        holder.tvLeft.setText(data);

        return convertView;
    }

    static class ViewHolder {
        TextView tvLeft;
    }
}
