package com.xyk.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "tb_ad_space", schema = "ms", catalog = "")
public class AdSpace {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "adSpace_name")
    private String adSpaceName;//广告位名称
    @Basic
    @Column(name = "create_time")
    private Date createTime;//创建时间
    @Column(name = "image")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdSpaceName() {
        return adSpaceName;
    }

    public void setAdSpaceName(String adSpaceName) {
        this.adSpaceName = adSpaceName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
