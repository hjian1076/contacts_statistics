package com.xyk.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_statistics", schema = "ms", catalog = "")
public class StatisticsUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
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
    @Column(name = "platfrom")
    private int platfrom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getPlatfrom() {
        return platfrom;
    }

    public void setPlatfrom(int platfrom) {
        this.platfrom = platfrom;
    }
}
