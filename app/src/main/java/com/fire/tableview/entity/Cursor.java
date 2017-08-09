package com.fire.tableview.entity;

import cn.bmob.v3.BmobObject;

import static cn.bmob.v3.b.From.S;

/**
 * Created by Administrator on 2017/8/9.
 */

public class Cursor extends BmobObject {

    private int cursorId;

    private int teacherId;

    private String classesName;

    private int classesId;

    public int getCursorId() {
        return cursorId;
    }

    public void setCursorId(int cursorId) {
        this.cursorId = cursorId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassesName() {
        return classesName;
   }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }
}
