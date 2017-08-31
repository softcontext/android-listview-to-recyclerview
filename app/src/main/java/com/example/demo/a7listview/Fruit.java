package com.example.demo.a7listview;


public class Fruit {
    private Integer resId;
    private String name;
    // 0 base index
    private Integer xmlType;

    public Fruit() {
    }

    public Fruit(Integer resId, String name) {
        this.resId = resId;
        this.name = name;
    }

    public Fruit(Integer resId, String name, Integer xmlType) {
        this.resId = resId;
        this.name = name;
        this.xmlType = xmlType;
    }

    public Integer getXmlType() {
        return xmlType;
    }

    public void setXmlType(Integer xmlType) {
        this.xmlType = xmlType;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
