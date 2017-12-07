package com.qinshixun.project.common;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao  {
    SessionFactory sessionFactory;
    @Autowired
    public void init(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
