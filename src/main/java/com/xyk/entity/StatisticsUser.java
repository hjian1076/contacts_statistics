package com.xyk.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_statistics_user", schema = "ms", catalog = "")
public class StatisticsUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "person")
    private String person;
    @Basic
    @Column(name = "iphone")
    private String iphone;

    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "create_time")
    private Date createTime;
    @Basic
    @Column(name = "pf_id")
    private int pfId;//平台ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getPfId() {
        return pfId;
    }

    public void setPfId(int pfId) {
        this.pfId = pfId;
    }
}
