package com.fire.tableview.ui.fragment;

import com.fire.tableview.R;
import com.fire.tableview.adapter.DateAdapter;
import com.fire.tableview.adapter.LeftAdapter;
import com.fire.tableview.base.BaseFragment;
import com.fire.tableview.view.MyStyleLayout;
import com.fire.tableview.view.NoScrollListView;
import com.fire.tableview.view.SyncHorizontalScrollview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/8/9.
 */

public class ClassFragment extends BaseFragment {

    @BindView(R.id.layout_style)
    MyStyleLayout layoutStyle;
    @BindView(R.id.lv_left)
    NoScrollListView mLeft;
    @BindView(R.id.lv_data)
    NoScrollListView mData;
    @BindView(R.id.data_horizontal)
    SyncHorizontalScrollview mDataHorizontal;

    SyncHorizontalScrollview mHeaderHorizontal;



    private LeftAdapter mLeftAdapter;
    private DateAdapter mDataAdapter;

    private List<String> mListData = new ArrayList<>();
    private List<String> mWeeks = new ArrayList<>();



    @Override
    protected int getLayout() {
        return R.layout.fragment_classes;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void loadData() {
        if (mWeeks.size() == 0) {
            mWeeks.add("周一");
            mWeeks.add("周二");
            mWeeks.add("周三");
            mWeeks.add("周四");
            mWeeks.add("周五");
            mWeeks.add("周六");
            mWeeks.add("周末");
            layoutStyle.addViews(mWeeks);
        }


        if (mListData.size() == 0) {
            mListData.add("第一节");
            mListData.add("第二节");
            mListData.add("第三节");
            mListData.add("第四节");
            mListData.add("第五节");
            mListData.add("第六节");
            mListData.add("第七节");
            mListData.add("第八节");
            mListData.add("第九节");
            mListData.add("晚自习一");
            mListData.add("晚自习二");
            mListData.add("晚自习三");
            mLeftAdapter.notifyDataSetChanged();
            mDataAdapter.notifyDataSetChanged();
        }


    }

    @Override
    public void initViews() {
        mHeaderHorizontal = layoutStyle.getmHeaderHorizontal();
        mDataHorizontal.setScrollView(mHeaderHorizontal);
        mHeaderHorizontal.setScrollView(mDataHorizontal);

        mLeftAdapter= new LeftAdapter(mListData);
        mLeft.setAdapter(mLeftAdapter);
        mDataAdapter = new DateAdapter(mListData);
        mData.setAdapter(mDataAdapter);
        layoutStyle.addViews(mWeeks);

    }
}
