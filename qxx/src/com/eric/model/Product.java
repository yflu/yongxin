package com.eric.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "joy_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 3149669811575262582L;

    private long id;//主键ID
    private String cateid;//分类ID
    private Integer type;//类型:0:public 1:private
    private String name;//名称
    private String keyword;//关键字
    private String intro;//简介
    private Integer status;//状态：1正常 0禁用 -1删除
    private Integer hot;//热门产品:0否 1是
    private Integer recommend;//推荐产品:0否 1是
    private String logo;//logo
    private String application;//用途
    private String useage;//适用年龄
    private String sex;//性别
    private String material;//材质
    private String size;//尺寸
    private String color;//颜色
    private String pro_style;//款式
    private String brand;//品牌
    private String model_num;//型号
    private String cap_pieces;//帽片数量
    private String pattern;//样式
    private String moq;//最小起订量
    private String unit;//计量单位
    private String content;//详情
    private Integer sortno;//排序
    private String createtime;//创建时间
    private String updatetime;//更新时间
    private String createname;//创建人
    private List<Media> medias = new ArrayList<Media>();//图集

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "cateid")
    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }

    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "keyword")
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Column(name = "intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "hot")
    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    @Column(name = "recommend")
    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "application")
    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Column(name = "useage")
    public String getUseage() {
        return useage;
    }

    public void setUseage(String useage) {
        this.useage = useage;
    }

    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "material")
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "pro_style")
    public String getPro_style() {
        return pro_style;
    }

    public void setPro_style(String pro_style) {
        this.pro_style = pro_style;
    }

    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "model_num")
    public String getModel_num() {
        return model_num;
    }

    public void setModel_num(String model_num) {
        this.model_num = model_num;
    }

    @Column(name = "cap_pieces")
    public String getCap_pieces() {
        return cap_pieces;
    }

    public void setCap_pieces(String cap_pieces) {
        this.cap_pieces = cap_pieces;
    }

    @Column(name = "pattern")
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Column(name = "moq")
    public String getMoq() {
        return moq;
    }

    public void setMoq(String moq) {
        this.moq = moq;
    }

    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "sortno")
    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    @Column(name = "createtime")
    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Column(name = "updatetime")
    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    @Column(name = "createname")
    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    @Transient
    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }
}
