package com.qinshixun.project.service;

import com.qinshixun.project.dao.QueryDao;
import com.qinshixun.project.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {
    @Autowired
    private QueryDao queryDao;

    public List<UserModel> queryUser(int startPage,int maxPage,String username){
        return queryDao.queryUser(startPage,maxPage,username);
    }

    public int queryNumber(String username,int maxPage){
        return queryDao.queryNumber(username,maxPage);
    }

    public UserModel queryUsername(String username){
        return queryDao.queryUsername(username);
    }
}
