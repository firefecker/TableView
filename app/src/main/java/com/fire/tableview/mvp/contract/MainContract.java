package com.fire.tableview.mvp.contract;

import com.fire.tableview.base.BaseModel;
import com.fire.tableview.base.BasePresenter;
import com.fire.tableview.base.BaseView;
import com.fire.tableview.entity.ClassSheduleCard;
import com.fire.tableview.entity.Classes;
import com.fire.tableview.entity.Teacher;
import com.fire.tableview.entity.TeacherSheduleCard;

import java.util.List;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2017/8/10.
 */
public interface MainContract {

    interface Model extends BaseModel{
        void loadClassesData(FindListener<Classes> listener);

        void loadTeacherData(FindListener<Teacher> listener);

        void loadTeacherCursor(int teacherId,FindListener<TeacherSheduleCard> listener);
        void loadClassCursor(int classesId,FindListener<ClassSheduleCard> listener);
    }

    interface View extends BaseView{

        void getClassSheduleData(List<ClassSheduleCard> list,BmobException e);

        void getTeacherSheduleData(List<TeacherSheduleCard> list, BmobException e);

        void getClassesData(List<Classes> list, BmobException e);

        void getTeacherData(List<Teacher> list, BmobException e);
    }

    interface Presenter extends BasePresenter{
        void addClassesData();

        void addTeacherData();

        void addTeacherCursor(int teacherId,boolean isShow);
        void addClassCursor(int classesId,boolean isShow);
    }
}
