package com.fire.tableview.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/8/9.
 */

public class Classes extends BmobObject {

    private int classesId;

    private String classesName;

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }


}
