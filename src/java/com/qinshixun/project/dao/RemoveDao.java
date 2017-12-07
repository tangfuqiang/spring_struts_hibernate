package com.qinshixun.project.dao;

import com.qinshixun.project.common.BaseDao;
import com.qinshixun.project.model.UserModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RemoveDao {
    @Autowired
    private BaseDao baseDao;

    @Transactional
    public void removeUser(long id) {
        String removeSql = "delete from UserModel where id =?";
        Session session = baseDao.getSessionFactory().getCurrentSession();
        Query query = session.createQuery(removeSql);
        query.setParameter(0, id);
        query.executeUpdate();

    }
}
