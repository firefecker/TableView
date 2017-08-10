package com.fire.tableview.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/8/10.
 */

public class ClassSheduleCard extends BmobObject{

    private int lessonId;

    private String MonLesson;
    private String TuesLesson;
    private String WedLesson;
    private String ThurLesson;
    private String FriLesson;

    private String SatLesson;

    private String SunLesson;

    private int classesId;

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getMonLesson() {
        return MonLesson;
    }

    public void setMonLesson(String monLesson) {
        MonLesson = monLesson;
    }

    public String getTuesLesson() {
        return TuesLesson;
    }

    public void setTuesLesson(String tuesLesson) {
        TuesLesson = tuesLesson;
    }

    public String getWedLesson() {
        return WedLesson;
    }

    public void setWedLesson(String wedLesson) {
        WedLesson = wedLesson;
    }

    public String getThurLesson() {
        return ThurLesson;
    }

    public void setThurLesson(String thurLesson) {
        ThurLesson = thurLesson;
    }

    public String getFriLesson() {
        return FriLesson;
    }

    public void setFriLesson(String friLesson) {
        FriLesson = friLesson;
    }

    public String getSatLesson() {
        return SatLesson;
    }

    public void setSatLesson(String satLesson) {
        SatLesson = satLesson;
    }

    public String getSunLesson() {
        return SunLesson;
    }

    public void setSunLesson(String sunLesson) {
        SunLesson = sunLesson;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }

    @Override
    public String toString() {
        return "ClassSheduleCard{" +
                "lessonId=" + lessonId +
                ", MonLesson='" + MonLesson + '\'' +
                ", TuesLesson='" + TuesLesson + '\'' +
                ", WedLesson='" + WedLesson + '\'' +
                ", ThurLesson='" + ThurLesson + '\'' +
                ", FriLesson='" + FriLesson + '\'' +
                ", SatLesson='" + SatLesson + '\'' +
                ", SunLesson='" + SunLesson + '\'' +
                ", classesId=" + classesId +
                '}';
    }
}
