package com.fire.tableview.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/8/9.
 */

public class Teacher extends BmobObject{

    private int teacherId;
    private String name;
    private int age;
    private int cursorId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCursorId() {
        return cursorId;
    }

    public void setCursorId(int cursorId) {
        this.cursorId = cursorId;
    }
}
