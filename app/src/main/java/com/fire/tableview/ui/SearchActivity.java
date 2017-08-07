package com.fire.tableview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fire.tableview.R;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/8/7.
 */
public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private ImageView ivBack;
    private SearchView searchView;
    private SearchView.SearchAutoComplete textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();



    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        searchView = (SearchView) findViewById(R.id.searchView);

        //设置我们的SearchView
        searchView.setIconifiedByDefault(true);//设置展开后图标的样式,这里只有两种,一种图标在搜索框外,一种在搜索框内
        // 写上此句后searchView初始是可以点击输入的状态，如果不写，那么就需要点击下放大镜，
        // 才能出现输入框,也就是设置为ToolBar的ActionView，默认展开
        searchView.onActionViewExpanded();
        //添加下面一句,防止数据两次加载
        searchView.setIconified(false);//输入框内icon不显示
        searchView.requestFocusFromTouch();//模拟焦点点击事件
        searchView.requestFocus();//输入焦点
        //将控件设置成可获取焦点状态,默认是无法获取焦点的,只有设置成true,才能获取控件的点击事件
        searchView.clearFocus();

        textView = (SearchView.SearchAutoComplete) searchView.findViewById(R.id.search_src_text);
        textView.setPadding(0,0,0,0);
        try {//修改光标的颜色（反射）
            Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
            f.setAccessible(true);
            f.set(textView, R.drawable.screen_cursor);
        } catch (Exception ignored) {
            // TODO: handle exception
            ignored.printStackTrace();
        }

        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
