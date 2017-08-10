package com.fire.tableview.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/9.
 */

public abstract class BaseFragment extends Fragment {
    /**
     * 控件是否初始化完成
     */
    private boolean isViewCreated;
    /**
     * 数据是否已加载完毕
     */
    private boolean isLoadDataCompleted;
    protected View view;
    protected Activity mContext;
    protected String tag;
    private AlertDialog.Builder builder;
    protected AlertDialog alertDialog;

    private Unbinder unbinder;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getActivity();
        tag = getClass().getSimpleName();
    }

    public abstract void initViews();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null != view) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (null != parent) {
                parent.removeView(view);
            }
            return view;
        }
        view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewCreated = true;
        initViews();
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getUserVisibleHint()) {
            isLoadDataCompleted = true;
            loadData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isViewCreated && !isLoadDataCompleted) {
            isLoadDataCompleted = true;
            loadData();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * 初始化View
     *
     * @return
     */
    protected abstract int getLayout();

    public abstract void initPresenter();

    /**
     * 子类实现加载数据的方法
     */
    public abstract void loadData();

    protected void toast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
