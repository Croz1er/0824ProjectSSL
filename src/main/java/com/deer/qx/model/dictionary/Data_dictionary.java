package com.deer.qx.model.dictionary;

import java.io.Serializable;

public class Data_dictionary implements Serializable {

    private Integer id;
    //类型编码
    private String typeCode;
    //类型名称
    private String typeName;
    //类型值ID
    private Integer valueId;
    //类型值Name
    private String valueName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }
}
