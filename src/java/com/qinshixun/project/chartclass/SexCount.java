package com.qinshixun.project.chartclass;


public class SexCount {

    private String sex;
    private int total;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public SexCount(String sex, int total) {
        this.sex = sex;
        this.total = total;
    }

    public SexCount(String sex) {
        this.sex = sex;
    }

    public SexCount(int total) {
        this.total = total;
    }

    public SexCount() {
    }
}
