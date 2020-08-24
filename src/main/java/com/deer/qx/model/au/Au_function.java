package com.deer.qx.model.au;

import sun.dc.pr.PRError;

import java.io.Serializable;
import java.util.Date;

public class Au_function implements Serializable {

    private Integer id;
    //功能编码
    private String funcCode;
    //功能名称
    private  String funcName;
    //功能URL
    private String funcUrl;
    private Integer parentId;
    //创建时间
    private Date creationTime;

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
