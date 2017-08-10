package com.fire.tableview.mvp.presenter;


import com.fire.tableview.entity.ClassSheduleCard;
import com.fire.tableview.entity.Classes;
import com.fire.tableview.entity.Teacher;
import com.fire.tableview.entity.TeacherSheduleCard;
import com.fire.tableview.mvp.contract.MainContract;
import com.fire.tableview.mvp.model.MainModel;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2017/8/10.
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    private MainModel mModel;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mModel = new MainModel();
    }

    @Override
    public void addClassesData() {
        if (mModel == null) {
            return;
        }
        if (mView == null) {
            return;
        }
        mModel.loadClassesData(new FindListener<Classes>() {
            @Override
            public void done(List<Classes> list, BmobException e) {
                mView.getClassesData(list,e);
            }
        });
    }

    @Override
    public void addTeacherData() {
        if (mModel == null) {
            return;
        }
        if (mView == null) {
            return;
        }
        mModel.loadTeacherData(new FindListener<Teacher>() {
            @Override
            public void done(List<Teacher> list, BmobException e) {
                mView.getTeacherData(list,e);
            }
        });
    }

    @Override
    public void addTeacherCursor(int teacherId,boolean isShow) {
        if (mView == null) {
            return;
        }
        if (isShow) {
            mView.showLoading();
        }
        if (mModel == null) {
            return;
        }
        mModel.loadTeacherCursor(teacherId, new FindListener<TeacherSheduleCard>() {
            @Override
            public void done(List<TeacherSheduleCard> list, BmobException e) {
                mView.getTeacherSheduleData(list,e);
               mView.hideLoading();
            }
        });
    }

    @Override
    public void addClassCursor(int classesId,boolean isShow) {
        if (mView == null) {
            return;
        }
        if (isShow) {
            mView.showLoading();
        }
        if (mModel == null) {
            return;
        }
        mModel.loadClassCursor(classesId, new FindListener<ClassSheduleCard>() {
            @Override
            public void done(List<ClassSheduleCard> list, BmobException e) {
                mView.getClassSheduleData(list,e);
                mView.hideLoading();
            }
        });
    }

    public List<List<String>> addDoubleData(List<Classes> classes, List<Teacher> teachers) {

        List<List<String>> lists = new ArrayList<>();
        List<String> classesStr = new ArrayList<>();
        List<String> teacherStr = new ArrayList<>();
        if (classes != null) {
            for (Classes aClass : classes) {
                classesStr.add(aClass.getClassesName());
            }
            lists.add(classesStr);
        }
        if (teachers != null) {
            for (Teacher aClass : teachers) {
                teacherStr.add(aClass.getName());
            }
            lists.add(teacherStr);
        }
        return lists;
    }
}
