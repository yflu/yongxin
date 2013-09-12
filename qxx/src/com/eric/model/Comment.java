package com.eric.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "joy_comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 3149669811575262582L;

    private Long id;
    private Long parentid;
    private Long productid;
    private int leaf;
    private int deep;
    private int status;
    private String name;
    private String email;
    private String content;
    private String createtime;
    private SimpleDateFormat format = new SimpleDateFormat("MM.dd.yyyy");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "parentid")
    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    @Column(name = "productid")
    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    @Column(name = "leaf")
    public int getLeaf() {
        return leaf;
    }

    public void setLeaf(int leaf) {
        this.leaf = leaf;
    }

    @Column(name = "deep")
    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "createtime")
    public String getCreatetime() {
        try {
            return format.format(sdf.parse(createtime));
        } catch (Exception e) {
            return createtime;
        }
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
