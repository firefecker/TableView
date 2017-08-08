package com.fire.tableview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.fire.tableview.R;

/**
 * Created by Administrator on 2017/8/8.
 */

public class TestActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        tvTest = (TextView) findViewById(R.id.tv_test);
        setToolbar();
    }

    private void setToolbar() {
        mToolbar.setTitle("测试");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void onClick(View view) {
        if (tvTest.getVisibility() == View.VISIBLE) {
            tvTest.setVisibility(View.GONE);
        } else {
            tvTest.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
