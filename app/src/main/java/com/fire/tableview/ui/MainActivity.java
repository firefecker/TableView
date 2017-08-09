package com.fire.tableview.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fire.tableview.R;
import com.fire.tableview.base.BaseActivity;
import com.fire.tableview.entity.Classes;
import com.fire.tableview.entity.Cursor;
import com.fire.tableview.entity.Person;
import com.fire.tableview.entity.Teacher;
import com.fire.tableview.ui.fragment.ClassFragment;
import com.fire.tableview.view.SelectionLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class MainActivity extends BaseActivity implements SelectionLayout.OnSelectListener {

    @BindView(R.id.mToolbar)
    Toolbar mToolbar;
    @BindView(R.id.layout_selection)
    SelectionLayout layoutSelection;

    private ClassFragment classesFragment;
    private FragmentManager fragmentManager;

    protected List<List<String>> list2 = new ArrayList<List<String>>() {{
        add(new ArrayList<String>() {{
            add("一班");
            add("二班");
            add("三班");
            add("四班");
            add("五班");
            add("六班");
            add("七班");
            add("八班");
            add("九班");
        }});
        add(new ArrayList<String>() {{
            add("老师甲");
            add("老师乙");
            add("老师丙");
            add("老师丁");
            add("老师戊");
            add("老师一");
            add("老师二");
            add("老师三");
            add("老师四");
            add("老师五");

        }});
    }};

    @Override
    protected void initData() {
        setData();
    }

    @Override
    protected void initView() {
        mToolbar.setTitle("课程表");
        setSupportActionBar(mToolbar);
        classesFragment = new ClassFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.layout_frame,classesFragment).commit();
        layoutSelection.setOnSelectListener(this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void setData() {
        layoutSelection.setData(list2.toArray(new List[list2.size()]));
        Cursor p2 = new Cursor();
        p2.setTeacherId(1);
        p2.setClassesId(1);
        p2.setClassesName("一班");
        p2.setCursorId(1);
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    toast("添加数据成功，返回objectId为："+objectId);
                }else{
                    toast("创建数据失败：" + e.getMessage());
                }
            }
        });
    }


    /**
     * 创建菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
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
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.bottom_in, R.anim.activity_stay);
    }


    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }

    @Override
    public void onSelect(int index, int position, String title) {
        toast("index = " + index + "position = " + position + "title = " + title);
    }
}