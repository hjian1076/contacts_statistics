package com.xyk.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_user", schema = "ms", catalog = "")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Transient
    private List<PageRes> resList;//用户的权限集合,只有一级没有子级，用户主页面显示
    @Transient
    private List<PageRes> resList2;//用户的权限集合，具有父子关系

    public List<PageRes> getResList2() {
        return resList2;
    }

    public void setResList2(List<PageRes> resList2) {
        this.resList2 = resList2;
    }

    public List<PageRes> getResList() {
        return resList;
    }

    public void setResList(List<PageRes> resList) {
        this.resList = resList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
