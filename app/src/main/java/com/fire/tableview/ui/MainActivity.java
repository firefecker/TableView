package com.fire.tableview.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fire.tableview.R;
import com.fire.tableview.base.BaseActivity;
import com.fire.tableview.entity.ClassSheduleCard;
import com.fire.tableview.entity.Classes;
import com.fire.tableview.entity.Teacher;
import com.fire.tableview.entity.TeacherSheduleCard;
import com.fire.tableview.mvp.contract.MainContract;
import com.fire.tableview.mvp.presenter.MainPresenter;
import com.fire.tableview.ui.fragment.ClassFragment;
import com.fire.tableview.view.SelectionLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.exception.BmobException;

public class MainActivity extends BaseActivity implements SelectionLayout.OnSelectListener, MainContract.View {

    @BindView(R.id.mToolbar)
    Toolbar mToolbar;
    @BindView(R.id.layout_selection)
    SelectionLayout layoutSelection;

    private ClassFragment classesFragment;
    private FragmentManager fragmentManager;
    private MainPresenter mainPresenter;
    private List<Teacher> teachers;
    private List<Classes> classes;
    protected List<List<String>> list2;


    @Override
    protected void initData() {
        mainPresenter.addClassesData();
        mainPresenter.addTeacherData();
        mainPresenter.addClassCursor(1,false);
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

    @Override
    public void initPresenter() {
        mainPresenter = new MainPresenter(this);
    }

    private void setData() {
        list2 = mainPresenter.addDoubleData(classes, teachers);
        layoutSelection.setData(list2.toArray(new List[list2.size()]));
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

    @Override
    public void getClassSheduleData(List<ClassSheduleCard> list, BmobException e) {

    }

    @Override
    public void getTeacherSheduleData(List<TeacherSheduleCard> list, BmobException e) {

    }

    @Override
    public void getClassesData(List<Classes> list, BmobException e) {
        classes = list;
        if (teachers != null) {
            setData();
        }

    }

    @Override
    public void getTeacherData(List<Teacher> list, BmobException e) {
        teachers = list;
        if (classes != null) {
            setData();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}