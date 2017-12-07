package com.qinshixun.project.dao;

import com.qinshixun.project.common.BaseDao;
import com.qinshixun.project.model.UserModel;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class QueryDao {

    @Autowired
    private BaseDao baseDao;

    @Transactional
    public List<UserModel> queryUser(int startPage,int maxPage,String username) {
        String sql = "from UserModel where username like ?";
        Query query = baseDao.getSessionFactory().getCurrentSession().createQuery(sql);
        query.setParameter(0, "%"+username+"%");
        query.setFirstResult(startPage);
        query.setMaxResults(maxPage);
        return query.list();
    }

    @Transactional
    public int queryNumber(String username, int maxPage) {
        String sql = "select count(*) from UserModel where username like ? ";
        Query query =  baseDao.getSessionFactory().getCurrentSession().createQuery(sql);
        query.setParameter(0, "%"+username+"%");
        long totalPage = (long)query.uniqueResult();
        if (totalPage % maxPage == 0) {
            return (int) totalPage / maxPage;
        } else {
            return (int) totalPage / maxPage + 1;
        }
    }

    @Transactional
    public UserModel queryUsername(String username){
        String sql="from UserModel where username=?";
        Query query=baseDao.getSessionFactory().getCurrentSession().createQuery(sql);
        query.setParameter(0,username);
        return (UserModel)query.uniqueResult();
    }
}
