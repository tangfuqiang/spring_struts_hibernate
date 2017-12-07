package com.qinshixun.project.dao;


import com.qinshixun.project.chartclass.SexCount;
import com.qinshixun.project.chartclass.YearCunt;
import com.qinshixun.project.common.BaseDao;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ChartDao {

    @Autowired
    private BaseDao baseDao;

    @Transactional
    public List<YearCunt> queryYearCount(){

        String sql= "SELECT YEAR(birthday) as year,COUNT(*) as total FROM t_user GROUP BY YEAR(birthday)";
        SQLQuery query = baseDao.getSessionFactory().getCurrentSession().createSQLQuery(sql);
        query.addScalar("year", StandardBasicTypes.STRING);
        query.addScalar("total",StandardBasicTypes.INTEGER);
        query.setResultTransformer(Transformers.aliasToBean(YearCunt.class));
        return query.list();
    }

    @Transactional
    public List<SexCount> querySexCount(){
        String sql="SELECT sex,count(*) as total from t_user GROUP BY sex";
        SQLQuery query = baseDao.getSessionFactory().getCurrentSession().createSQLQuery(sql);
        query.addScalar("sex", StandardBasicTypes.STRING);
        query.addScalar("total",StandardBasicTypes.INTEGER);
        query.setResultTransformer(Transformers.aliasToBean(SexCount.class));
        return query.list();
    }

}
