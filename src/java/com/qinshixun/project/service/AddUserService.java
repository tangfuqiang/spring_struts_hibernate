package com.qinshixun.project.service;

import com.qinshixun.project.dao.AddUserDao;
import com.qinshixun.project.model.HobbyModel;
import com.qinshixun.project.model.OccupationModel;
import com.qinshixun.project.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddUserService {

    @Autowired
    private AddUserDao addUserDao;

    public List<HobbyModel> getHobby() {
        return addUserDao.getHobby();
    }

    public List<OccupationModel> getOccupation() {
        return addUserDao.getOccupation();
    }

//    public int addUser(String username, String password, String email, Date birthday, char sex, String occupation, String hobby) {
//
//        return addUserDao.addUser(username, password, email, birthday, sex, occupation, hobby);
//    }

    public void addUser(UserModel userModel){
        addUserDao.addUser(userModel);
    }
}
