package com.fire.tableview.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/9.
 */

public abstract class BaseActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    public abstract int getLayoutId();

    public void toast(String toast) {
        if (TextUtils.isEmpty(toast)) {
            toast = "null";
        }
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}
