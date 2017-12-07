package com.qinshixun.project.service;

import com.qinshixun.project.dao.RemoveDao;
import com.qinshixun.project.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoveService {
    @Autowired
    private RemoveDao removeDao;
     public void removeUser(long id){
        removeDao.removeUser(id);
     }
}
