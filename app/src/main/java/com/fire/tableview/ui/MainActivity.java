package com.fire.tableview.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.fire.tableview.R;
import com.fire.tableview.adapter.DateAdapter;
import com.fire.tableview.adapter.LeftAdapter;
import com.fire.tableview.view.MyStyleLayout;
import com.fire.tableview.view.NoScrollListView;
import com.fire.tableview.view.SyncHorizontalScrollview;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private MyStyleLayout layoutStyle;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;

    private NoScrollListView mLeft;
    private NoScrollListView mData;

    private SyncHorizontalScrollview mHeaderHorizontal;
    private SyncHorizontalScrollview mDataHorizontal;

    private LeftAdapter mLeftAdapter;
    private DateAdapter mDataAdapter;

    private List<String> mListData;
    private List<String> mWeeks;

    private List<String> mClasses;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setData();
    }

    private void initView(){
        mLeft = (NoScrollListView) findViewById(R.id.lv_left);
        mData = (NoScrollListView) findViewById(R.id.lv_data);
        mDataHorizontal = (SyncHorizontalScrollview) findViewById(R.id.data_horizontal);
        mHeaderHorizontal = (SyncHorizontalScrollview) findViewById(R.id.header_horizontal);
        layoutStyle = (MyStyleLayout) findViewById(R.id.layout_style);
        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);

    }

    private void setData() {
        mToolbar.setTitle("课程表");
        setSupportActionBar(mToolbar);

        mDataHorizontal.setScrollView(mHeaderHorizontal);
        mHeaderHorizontal.setScrollView(mDataHorizontal);

        initData();

        mLeftAdapter= new LeftAdapter(mListData);
        mLeft.setAdapter(mLeftAdapter);

        mDataAdapter = new DateAdapter(mListData);
        mData.setAdapter(mDataAdapter);

        layoutStyle.addViews(mWeeks);

        mTabLayout.addOnTabSelectedListener(this);
    }

    private void initData() {
        mWeeks = new ArrayList<>();
        mWeeks.add("周一");
        mWeeks.add("周二");
        mWeeks.add("周三");
        mWeeks.add("周四");
        mWeeks.add("周五");
        mWeeks.add("周六");
        mWeeks.add("周末");

        mListData = new ArrayList<>();
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

        mClasses = new ArrayList<>();
        mClasses.add("一班");
        mClasses.add("三班");
        mClasses.add("五班");
        mClasses.add("七班");
        mClasses.add("九班");

        for (String aClass : mClasses) {
            mTabLayout.addTab(mTabLayout.newTab().setText(aClass));
        }

    }


    /**
     * 创建菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        return true;
    }

    /**
     * 菜单被选中
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                stepSearch();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void stepSearch() {
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.bottom_in, R.anim.activity_stay);
    }

    /**
     * tab选中
     * @param tab
     */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Log.e("TAGTAG","onTabSelected  -->  "+tab.getText().toString());
    }

    /**
     * tab没有选中
     * @param tab
     */
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        Log.e("TAGTAG","onTabUnselected  -->  "+tab.getText().toString());
    }

    /**
     * tab再次选中
     * @param tab
     */
    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        Log.e("TAGTAG","onTabReselected  -->  "+tab.getText().toString());
    }
}