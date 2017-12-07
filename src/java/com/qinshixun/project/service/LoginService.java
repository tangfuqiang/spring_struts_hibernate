package com.qinshixun.project.service;

import com.qinshixun.project.dao.LoginDao;
import com.qinshixun.project.model.AdminModel;
import com.qinshixun.project.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginDao loginDao;

    public AdminModel Check(String username, String password){
        return loginDao.Check(username,password);
    }

    public List<UserModel> getUser(int startPage,int maxPage){
        return loginDao.getUser(startPage,maxPage);
    }

    public int getTotalPage(int Maxpage){
        return loginDao.getTotalPage(Maxpage);
    }
}
