package com.xyk.bean;

/**
 * Created by 追风少年
 *
 * @email doubihah@foxmail.com
 * @create 2017-05-31 14:59
 **/
public class QueryParam {

    private String keyword; //关键词
    private String beginTime;   //开始时间
    private String endTime; //结束时间
    private Integer limit;  //页面大小
    private Integer offset; //页码
    private String selectType1; //下拉框1
    private String selectType2; //下拉框2
    private String selectType3; //下拉框3
    private String selectType4; //下拉框4
//
//    private Integer groupId;
//
//    private String entrance;    //入口,从什么地方进入的

    public String getSelectType2() {
        return selectType2;
    }

    public void setSelectType2(String selectType2) {
        this.selectType2 = selectType2;
    }

    public String getSelectType3() {
        return selectType3;
    }

    public void setSelectType3(String selectType3) {
        this.selectType3 = selectType3;
    }

//    public Integer getGroupId() {
//        return groupId;
//    }
//
//    public void setGroupId(Integer groupId) {
//        this.groupId = groupId;
//    }


    public String getSelectType1() {
        return selectType1;
    }

    public void setSelectType1(String selectType1) {
        this.selectType1 = selectType1;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

//    public String getEntrance() {
//        return entrance;
//    }
//
//    public void setEntrance(String entrance) {
//        this.entrance = entrance;
//    }

    public String getSelectType4() {
        return selectType4;
    }

    public void setSelectType4(String selectType4) {
        this.selectType4 = selectType4;
    }
}
