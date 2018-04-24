package com.xyk.bean;

import java.util.List;

/**
 * Created by hejx on 2017-5-23 10:56:46.
 */
public class Pageinfo<T>{
    /**每页显示记录数*/
    private int pageSize=10;
    /**当前页数 */
    private int pageNo=1;
    /**记录总数*/
    private int totalSize;
    /**总页数*/
    private int pageCount;
    /**分页的数据集合*/
    private List<T> dataList;
    /**类型id*/
    private int typeId;
    /**名称*/
    private String keyword;
    /**排序标记*/
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Pageinfo() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
        if((totalSize%this.pageSize)==0){
            this.pageCount=totalSize/this.pageSize;
        }else{
            this.pageCount=totalSize/this.pageSize+1;
        }

    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }


}
