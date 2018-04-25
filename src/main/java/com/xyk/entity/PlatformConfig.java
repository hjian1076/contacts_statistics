package com.xyk.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "tb_platform_config", schema = "ms", catalog = "")
public class PlatformConfig {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "platform_name")
    private String platformName;//品牌名称
    @Basic
    @Column(name = "website")
    private String website;//官网地址
    @Basic
    @Column(name = "create_time")
    private Date createTime;//创建时间
     @Basic
    @Column(name = "sta_id")
    private int staId;

    public int getStaId() {
        return staId;
    }

    public void setStaId(int staId) {
        this.staId = staId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
