package com.qinshixun.project.chartclass;



import java.util.Date;

public class YearCunt {

    private String year;
    private int total;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public YearCunt(String year, int total) {
        this.year = year;
        this.total = total;
    }

    public YearCunt() {
    }

    public YearCunt(String year) {
        this.year = year;
    }

    public YearCunt(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "YearCunt{" + "yeaer='" + year + '\'' + ", total=" + total + '}';
    }
}
