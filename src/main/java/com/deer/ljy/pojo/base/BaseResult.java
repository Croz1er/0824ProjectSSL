package com.deer.ljy.pojo.base;

import java.io.Serializable;

public class BaseResult<T> implements Serializable {

    public  final static Integer CODE_SUCCESS = 0;
    public  final static Integer CODE_FAILED = 1;
    public  final static String MSG_SUCCESS = "success";
    public  final static String MSG_FAILED = "failed";

    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 每页条数
     */

    private Integer limit;

    /**
     * 总记录数
     */
    private Integer count;

    /**
     * 当前页
     */
    private Integer page;


    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
