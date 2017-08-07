package com.fire.tableview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fire.tableview.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class DateAdapter extends BaseAdapter {

    private List<String> mListData;

    public DateAdapter(List<String> mListData) {
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
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, null);
            holder.tvData = (TextView) convertView.findViewById(R.id.tv_data);
            holder.linContent = (LinearLayout) convertView.findViewById(R.id.lin_content);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    static class ViewHolder {
        TextView tvData;
        LinearLayout linContent;
    }
}