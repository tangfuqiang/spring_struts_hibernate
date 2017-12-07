package com.qinshixun.project.dao;

import com.qinshixun.project.common.BaseDao;
import com.qinshixun.project.model.AdminModel;
import com.qinshixun.project.model.UserModel;
import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class LoginDao {

    @Autowired
    private BaseDao baseDao;

    @Transactional
    public AdminModel Check(String username, String password) {
        Session session = baseDao.getSessionFactory().getCurrentSession();
        String sql = "from AdminModel where username=? and password=?";
        Query query = session.createQuery(sql);
        query.setParameter(0, username);
        query.setParameter(1, password);
        return (AdminModel) query.uniqueResult();
    }

    @Transactional
    public List<UserModel> getUser(int startPage,int maxPage){
        String sql="from UserModel";
        Query query = (Query)baseDao.getSessionFactory().getCurrentSession().createQuery(sql);
        query.setFirstResult(startPage);
        query.setMaxResults(maxPage);
        List<UserModel> list = query.list();
        return list;
    }

    @Transactional
    public int getTotalPage(int maxPage){
       String sql="select count(*) from UserModel";
       long totalPage = (long)baseDao.getSessionFactory().getCurrentSession().createQuery(sql).uniqueResult();
       if(totalPage%maxPage==0){
           return (int)totalPage/maxPage;
       }else {
           return (int)totalPage/maxPage+1;
       }
    }
}
