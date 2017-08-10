package com.fire.tableview.mvp.model;

import com.fire.tableview.entity.ClassSheduleCard;
import com.fire.tableview.entity.Classes;
import com.fire.tableview.entity.Teacher;
import com.fire.tableview.entity.TeacherSheduleCard;
import com.fire.tableview.mvp.contract.MainContract;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2017/8/10.
 */
public class MainModel implements MainContract.Model {

    //        TeacherSheduleCard p2 = new TeacherSheduleCard();
//        p2.setTeacherId(1);
//        p2.setLessonId(1);
//        p2.setMonLesson("语文");
//        p2.setTuesLesson("数学");
//        p2.setWedLesson("英语");
//        p2.setThurLesson("物理");
//        p2.setFriLesson("化学");
//        p2.setSatLesson("化学");
//        p2.setSunLesson("化学");
//        p2.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId,BmobException e) {
//                if(e==null){
//                    toast("添加数据成功，返回objectId为："+objectId);
//                }else{
//                    toast("创建数据失败：" + e.getMessage());
//                }
//            }
//        });

    /**
     * 多条查询
     */
//        BmobQuery<ClassSheduleCard> classesQuery = new BmobQuery<>();
    //添加限制条件
//        classesQuery.addWhereEqualTo("classesId",1);//查询班级id为1的班级
//        classesQuery.addWhereNotEqualTo("classesId",1);//查询班级id不为1的班级
//        classesQuery.addWhereGreaterThan("classesId", 1);//条件：班级id大于1的班级
//        classesQuery.addWhereLessThan("classesId", 50);//条件：班级id小于50的班级
//        classesQuery.addWhereLessThanOrEqualTo("classesId", 50);//条件：班级id小于等于50的班级
//        classesQuery.addWhereGreaterThanOrEqualTo("classesId", 50);//条件：班级id大于等于50的班级
//        classesQuery.setLimit(100);//限制条数

//        int[] names = {1, 2, 3};针对多个子查询
//        classesQuery.addWhereContainedIn("classesId", Arrays.asList(names));针对多个子查询限制条件
//        classesQuery.addWhereNotContainedIn("classesId", Arrays.asList(names));与上面一句相反

    //启用查询
//        classesQuery.findObjects(new FindListener<ClassSheduleCard>() {
//            @Override
//            public void done(List<ClassSheduleCard> list, BmobException e) {
//                if(e==null){
//                    toast("查询成功：共"+list.size()+"条数据。");
//                    Log.e("TAGTAG",list.toString());
//                }else{
//                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
//                }
//            }
//        });

    @Override
    public void loadClassesData(FindListener<Classes> listener) {
        BmobQuery<Classes> classesQuery = new BmobQuery<>();
        classesQuery.findObjects(listener);
    }

    @Override
    public void loadTeacherData(FindListener<Teacher> listener) {
        BmobQuery<Teacher> classesQuery = new BmobQuery<>();
        classesQuery.findObjects(listener);
    }

    @Override
    public void loadTeacherCursor(int teacherId,FindListener<TeacherSheduleCard> listener) {
        BmobQuery<TeacherSheduleCard> classesQuery = new BmobQuery<>();
        classesQuery.addWhereEqualTo("teacherId",teacherId);
        classesQuery.findObjects(listener);
    }

    @Override
    public void loadClassCursor(int classesId,FindListener<ClassSheduleCard> listener) {
        BmobQuery<ClassSheduleCard> classesQuery = new BmobQuery<>();
        classesQuery.addWhereEqualTo("classesId",classesId);
        classesQuery.findObjects(listener);
    }
}
