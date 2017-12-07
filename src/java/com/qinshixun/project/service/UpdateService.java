package com.qinshixun.project.service;

import com.qinshixun.project.dao.UpdateDao;
import com.qinshixun.project.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UpdateService {
    @Autowired
    private UpdateDao updateDao;
    public void updateUser(long id,String username,String hobby,char sex,String email,String occupation,Date birthday ){
        updateDao.updateUser(id,username,hobby,sex,email,occupation,birthday );
    }
}
