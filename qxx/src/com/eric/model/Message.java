package com.eric.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "joy_message")
public class Message implements Serializable {
    private static final long serialVersionUID = 3149669811575262582L;

    private Integer id;
    private Integer status;
    private String name;
    private String email;
    private String subject;
    private String content;
    private String createtime;

    public Message() {
    }

    public Message(Integer status, String name, String email, String subject, String content) {
        this.status = status;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.content = content;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
