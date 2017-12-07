package com.qinshixun.project.service;

import com.qinshixun.project.chartclass.SexCount;
import com.qinshixun.project.chartclass.YearCunt;
import com.qinshixun.project.dao.ChartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartService {

    @Autowired
    private ChartDao chartDao;

    public List<YearCunt> queryYearCount(){
        return chartDao.queryYearCount();
    }

    public List<SexCount> querySexCount(){
        return chartDao.querySexCount();
    }

}
