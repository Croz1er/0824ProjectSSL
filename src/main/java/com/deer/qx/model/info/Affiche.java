package com.deer.qx.model.info;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Affiche implements Serializable {

    private Integer id;
    //标题
    private String title;
    //内容
    private String content;
    //发布人
    private String publisher;
    //发布时间
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date publishTime;
    //生效时间
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date startTime;
    //失效时间
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
