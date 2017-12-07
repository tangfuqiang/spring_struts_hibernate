package com.qinshixun.project.action;

import com.qinshixun.project.chartclass.SexCount;
import com.qinshixun.project.chartclass.YearCunt;
import com.qinshixun.project.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChartAction {

    @Autowired
    private ChartService chartService;

    private List<SexCount> sexlist;

    private List<YearCunt> yearlist;

    public String toChartPage() {

        sexlist = chartService.querySexCount();
        yearlist = chartService.queryYearCount();
        return "success";
    }

    public List getSexlist() {
        return sexlist;
    }

    public void setSexlist(List<SexCount> sexlist) {
        this.sexlist = sexlist;
    }

    public List<YearCunt> getYearlist() {
        return yearlist;
    }

    public void setYearlist(List<YearCunt> YearCunt) {
        this.yearlist = yearlist;
    }

    public ChartService getChartService() {
        return chartService;
    }

    public void setChartService(ChartService chartService) {
        this.chartService = chartService;
    }


}
