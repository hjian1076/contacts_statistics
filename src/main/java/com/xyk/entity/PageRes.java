package com.xyk.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_page_res", schema = "ms", catalog = "")
public class PageRes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "res_name")
    private String resName;//资源名称
    @Basic
    @Column(name = "res_type")
    private int resType;//资源类型
    @Basic
    @Column(name = "res_url")
    private String resUrl;//资源url
    @Basic
    @Column(name = "show_menu")
    private int showMenu;//0为显示，1为不显示
    @Basic
    @Column(name = "parent_res_id")
    private Integer parentResId;//父级资源ID
    @Transient
    private List<PageRes> childList;//子资源

    public List<PageRes> getChildList() {
        return childList;
    }

    public void setChildList(List<PageRes> childList) {
        this.childList = childList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public int getResType() {
        return resType;
    }

    public void setResType(int resType) {
        this.resType = resType;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public int getShowMenu() {
        return showMenu;
    }

    public void setShowMenu(int showMenu) {
        this.showMenu = showMenu;
    }

    public Integer getParentResId() {
        return parentResId;
    }

    public void setParentResId(Integer parentResId) {
        this.parentResId = parentResId;
    }
}
